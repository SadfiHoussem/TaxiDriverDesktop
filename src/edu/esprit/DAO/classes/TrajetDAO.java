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
    public boolean isTrajetExist(Trajet t) {
    String requete = "select * from trajet where adresseDep=? and adresseDest=? ";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);

            ps.setString(1, t.getAdresseDep());
            ps.setString(2, t.getAdresseDest());
            
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du chauffeur" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public boolean insertTrajet(Trajet t) {
        if(isTrajetExist(t))
            return false;
        
        String requete = "insert into trajet (idAgence,adresseDep,adresseDest,cout,etat) values (?,?,?,?,?)";
        try {

            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setInt(1, t.getAgence().getIdAgence());
            ps.setString(2, t.getAdresseDep());
            ps.setString(3, t.getAdresseDest());
            ps.setDouble(4, t.getCout());
            ps.setBoolean(5, t.isEtat());
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion dans client " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateTrajet(Trajet t) {
        if(!isTrajetExist(t))
            return false;
        
        String requete = "update trajet set idAgence, adresseDep=?, adresseDest=?, cout=?, etat=? where idTrajet=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setInt(6, t.getIdTrajet());
            ps.setInt(1, t.getAgence().getIdAgence());
            ps.setString(2, t.getAdresseDep());
            ps.setString(3, t.getAdresseDest());
            ps.setDouble(4, t.getCout());
            ps.setBoolean(5, t.isEtat()); 
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour de trajet " + ex.getMessage());
            return false;
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

            while (resultat.next()) {
                
                trajet.setIdTrajet(id);
                trajet.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
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
        String requete = "select * from trajet";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Trajet trajet = new Trajet();
                
                trajet.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                trajet.setAdresseDep(resultat.getString("adresseDep"));
                trajet.setAdresseDest(resultat.getString("adresseDest"));
                trajet.setCout(resultat.getDouble("cout"));
                trajet.setEtat(resultat.getBoolean("etat"));

                listeTrajets.add(trajet);
            }
            return listeTrajets;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des trajets " + ex.getMessage());
            return null;
        }
    }
    
    public void insertTrajet2(Trajet t) {
        String requete = "insert into trajet (adresseDep,adresseDest) values (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setString(1, t.getAdresseDep());
            ps.setString(2, t.getAdresseDest());

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion dans trajet " + ex.getMessage());
        }
    }
    
      public int findIdTrajet(String destination,String depart) {


        String requete = "select * from trajet where adresseDest ='"+destination+"' and adresseDep='"+depart+"' " ;

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
         
            ResultSet resultat = ps.executeQuery();
             while(resultat.next())
           {
            return resultat.getInt("idTrajet");
           }
            return resultat.getInt("idTrajet");

        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du trajet" + ex.getMessage());
            return -1;
        }
        } 
}
