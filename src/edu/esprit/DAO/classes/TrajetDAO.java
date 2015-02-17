/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.ITrajetDAO;
import edu.esprit.entities.Client;
import edu.esprit.entities.ResponsableAgence;
import edu.esprit.entities.Trajet;
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
public class TrajetDAO implements ITrajetDAO{

    private Connection conn;
    private static TrajetDAO trajetDAO;
    
    private TrajetDAO() {
        conn = MyConnection.getInstance();
    }

    public static TrajetDAO getInstance() {
        if (trajetDAO == null) {
            trajetDAO = new TrajetDAO();
        }
        return trajetDAO;
    }
    
    @Override
    public void insertTrajet(Trajet t) {
        String requete = "insert into trajet values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, t.getIdTrajet());
            ps.setInt(2, t.getClient().getIdClient());
            ps.setInt(3, t.getRespAgence().getIdResponsableAgence());
            ps.setString(4, t.getAdresseDep());
            ps.setString(5, t.getAdresseDest());
            ps.setDouble(6, t.getCout());
            ps.setBoolean(7, t.isEtat());

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion dans client " + ex.getMessage());
        }
    }

    @Override
    public void updateTrajet(Trajet t) {
        String requete = "update trajet set idClient=?, idResponsable=?, adresseDep=?, adresseDest=?, cout=?, etat=? where idTrajet=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setInt(7, t.getIdTrajet());
            ps.setInt(1, t.getClient().getIdClient());
            ps.setInt(2, t.getRespAgence().getIdResponsableAgence());
            ps.setString(3, t.getAdresseDep());
            ps.setString(4, t.getAdresseDest());
            ps.setDouble(5, t.getCout());
            ps.setBoolean(6, t.isEtat()); 
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour de trajet " + ex.getMessage());
        }

    }

    @Override
    public void confirmeTrajet(int idTrajet) {
        String requete = "update trajet set etat=? where idTrajet=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setInt(2, idTrajet);
            ps.setBoolean(1, true); 
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour de trajet " + ex.getMessage());
        }

    }

    @Override
    public void deleteTrajet(int id) {
        String requete = "delete from trajet where idTrajet=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression du trajet" + ex.getMessage());
        }
    }

    @Override
    public Trajet findTrajetById(int id) {
        String requete = "select * from trajet where idTrajet=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            Trajet trajet = new Trajet();
            ClientDAO clientDAO = ClientDAO.getInstance();
            ResponsableAgenceDAO responsableAgenceDAO = ResponsableAgenceDAO.getInstance();
            while (resultat.next()) {
                
                trajet.setIdTrajet(id);
                trajet.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                trajet.setRespAgence(responsableAgenceDAO.findRespAgenceById(resultat.getInt("idResponsable")));
                trajet.setAdresseDep(resultat.getString("adresseDep"));
                trajet.setAdresseDest(resultat.getString("adresseDest"));
                trajet.setCout(resultat.getDouble("cout"));
            }
            return trajet;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du trajet" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Trajet> DisplayAllTrajets() {

        List<Trajet> listeTrajets = new ArrayList<>();
        System.out.println("3asba");
        String requete = "select * from trajet";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Trajet trajet = new Trajet();
            ClientDAO clientDAO = ClientDAO.getInstance();
            ResponsableAgenceDAO responsableAgenceDAO = ResponsableAgenceDAO.getInstance();
            // Client non trouvé
            Client c = new Client();
            c.setIdClient(0);
            c.setCin(0);
            c.setAdresse("adresse");
            c.setLogin("login");
            c.setNom("nom");
            c.setPrenom("prenom");
            c.setPwd("123456");
            c.setEmail("email");
            c.setTelephone(715592);
            // Responsable non trouvé
            ResponsableAgence r = new ResponsableAgence();
            r.setIdResponsableAgence(0);
            r.setCin(0);
            r.setAdresse("adresse");
            r.setLogin("login");
            r.setNom("nom");
            r.setPrenom("prenom");
            r.setPwd("123456");
            r.setEmail("email");
            r.setTelephone(715592);
            
            while (resultat.next()) {
                
                trajet.setIdTrajet(resultat.getInt("idTrajet"));
                
                if(resultat.getInt("idClient")==0)
                    trajet.setClient(c);
                else 
                    trajet.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                
                if(resultat.getInt("idResponsable")==0)
                    trajet.setRespAgence(r);
                else
                    trajet.setRespAgence(responsableAgenceDAO.findRespAgenceById(resultat.getInt("idResponsable")));
                
                trajet.setAdresseDep(resultat.getString("adresseDep"));
                trajet.setAdresseDest(resultat.getString("adresseDest"));
                trajet.setCout(resultat.getDouble("cout"));
               
                listeTrajets.add(trajet);
            }
            return listeTrajets;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des trajets " + ex.getMessage());
            return null;
        }
    }
    
}
