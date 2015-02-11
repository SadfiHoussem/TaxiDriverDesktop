/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IChauffeurDAO;
import edu.esprit.entities.Chauffeur;
import edu.esprit.entities.Reservation;
import edu.esprit.technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Houssem
 */

public class ChauffeurDAO implements IChauffeurDAO{

    private Connection conn;
    private static ChauffeurDAO chauffeurDAO;
    
    private ChauffeurDAO() {
        conn = MyConnection.getInstance();
    }

    public static ChauffeurDAO getInstance() {
        if (chauffeurDAO == null) {
            chauffeurDAO = new ChauffeurDAO();
        }
        return chauffeurDAO;
    }

    @Override
    public boolean isChauffeurExist(String id,Long cin,String numPermis,String login,String email,int telephone) {
    String requete = "select * from chauffeur where idChauffeur=? and telephone=? and numPermis=? and login=? and email=? and cin=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, id);
            ps.setInt(2, telephone);
            ps.setString(3, numPermis);
            ps.setString(4, login);
            ps.setString(5, email);
            ps.setLong(6, cin);
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du chauffeur" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public boolean insertChauffeur(Chauffeur c) {
        if(isChauffeurExist(c.getIdChauffeur(),c.getCin(), c.getNumPermis(), c.getLogin(), c.getEmail(),c.getTelephone()))
            return false;
            
            String requete = "insert into chauffeur values (?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = conn.prepareStatement(requete);
                ps.setString(1, c.getIdChauffeur());
                ps.setString(2, c.getNumPermis());
                ps.setBoolean(3, c.isEtat());
                ps.setString(4, c.getLogin());
                ps.setString(5, c.getPwd());
                ps.setString(6, c.getNom());
                ps.setString(7, c.getPrenom());
                ps.setString(8, c.getEmail());
                ps.setInt(9, c.getTelephone());
                ps.setString(10, c.getAdresse());
                ps.setLong(11, c.getCin());
                ps.executeUpdate();
                System.out.println("Ajout effectuée avec succès");
                return true;
                } catch (SQLException ex) {
                //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur lors de l'insertion " + ex.getMessage());
                return false;
                }
        
    }
    
    @Override
    public boolean updateChauffeur(Chauffeur c) {
        if(isChauffeurExist(c.getIdChauffeur(),c.getCin(), c.getNumPermis(), c.getLogin(), c.getEmail(),c.getTelephone()))
            return false;
        String requete = "update chauffeur set numPermis=?, login=?, pwd=?, nom=?, prenom=?, email=?, telephone=?, adresse=?, cin=?,etat=? where idChauffeur=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setString(1, c.getNumPermis());
            ps.setString(2, c.getLogin());
            ps.setString(3, c.getPwd());
            ps.setString(4, c.getNom());
            ps.setString(5, c.getPrenom());
            ps.setString(6, c.getEmail());
            ps.setInt(7, c.getTelephone());
            ps.setString(8, c.getAdresse());
            ps.setLong(9, c.getCin());
            ps.setBoolean(10, c.isEtat());
            ps.setString(11, c.getIdChauffeur());
             
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            return true;
        }

    }

    @Override
    public boolean deleteChauffeur(String id) {
        Chauffeur c = findChauffeurById(id);
        if(!isChauffeurExist(c.getIdChauffeur(),c.getCin(), c.getNumPermis(), c.getLogin(), c.getEmail(),c.getTelephone()))
            return false;
        String requete = "delete from chauffeur where idChauffeur=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
            return false;
        }
    }
    
    @Override
    public Chauffeur findChauffeurById(String id) {

        String requete = "select * from chauffeur where idChauffeur=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, id);
            ResultSet resultat = ps.executeQuery();
            if (!resultat.next())
                return null;
            Chauffeur chauffeur = new Chauffeur();
            while (resultat.next()) {
                
                chauffeur.setIdChauffeur(resultat.getString("idChauffeur"));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
            }
            return chauffeur;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du chauffeur" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Chauffeur> DisplayAllChauffeur() {
        
        List<Chauffeur> listeChauffeurs = new ArrayList<>();
        
        String requete = "select * from chauffeur";
        try {
            boolean b=false;
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
                
            while (resultat.next()) {
                b=true;
                Chauffeur chauffeur = new Chauffeur();

                chauffeur.setIdChauffeur(resultat.getString("idChauffeur"));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));

                listeChauffeurs.add(chauffeur);
            }
            if(b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Reservation> consulterPlanning(Chauffeur c) {
        
        String requete="select * from reservation r,taxi t where t.idChauffeur=?";
        try {
            boolean b=false;
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, c.getIdChauffeur());
            ResultSet resultat = ps.executeQuery();
            List<Reservation> listeReservations=new ArrayList<>();
            ClientDAO clientDAO = ClientDAO.getInstance();
            TaxiDAO taxiDAO = TaxiDAO.getInstance();
            TrajetDAO trajetDAO = TrajetDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            while (resultat.next()) {
                b=true;
                Reservation reservation = new Reservation();
                reservation.setIdReservation(resultat.getString("idReservation"));
                reservation.setClient(clientDAO.findClientById(resultat.getString("idClient")));
                System.out.println(clientDAO.findClientById(resultat.getString("idClient")).getPrenom());
                reservation.setTaxi(taxiDAO.findTaxiById(resultat.getString("idTaxi")));
                reservation.setTrajet(trajetDAO.findTrajetById(resultat.getString("idTrajet")));
                reservation.setAgence(agenceDAO.findAgenceById(resultat.getString("idAgence")));
                reservation.setConfirme(resultat.getBoolean("confirme"));
                reservation.setNote(resultat.getInt("note"));
                listeReservations.add(reservation);
            }
            if(b==false)
                return null;
            return listeReservations;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du planning" + ex.getMessage());
            return null;
            }
    }
    
    @Override
    public List<Reservation> consulterfeedbackClients(Chauffeur c) {
        
        String requete="select * from reservation r , taxi t where idChauffeur=?";
        try {
            boolean b=false;
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, c.getIdChauffeur());
            ResultSet resultat = ps.executeQuery();
            List<Reservation> listeReservations=new ArrayList<>();
            ClientDAO clientDAO = ClientDAO.getInstance();
            TaxiDAO taxiDAO = TaxiDAO.getInstance();
            TrajetDAO trajetDAO = TrajetDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            while (resultat.next()) {
                b=true;
                Reservation reservation = new Reservation();
                reservation.setIdReservation(resultat.getString("idReservation"));
                reservation.setClient(clientDAO.findClientById(resultat.getString("idClient")));
                reservation.setTaxi(taxiDAO.findTaxiById(resultat.getString("idTaxi")));
                reservation.setTrajet(trajetDAO.findTrajetById(resultat.getString("idTrajet")));
                reservation.setAgence(agenceDAO.findAgenceById(resultat.getString("idAgence")));
                reservation.setConfirme(resultat.getBoolean("confirme"));
                reservation.setNote(resultat.getInt("note"));
                
                listeReservations.add(reservation);
            }
            if(b==false)
                return null;
            return listeReservations;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des données" + ex.getMessage());
            return null;
            }
    }
    
}
