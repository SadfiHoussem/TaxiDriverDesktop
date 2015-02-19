/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.ITaxiDAO;
import edu.esprit.entities.Chauffeur;
import edu.esprit.entities.Taxi;
import edu.esprit.entities.Voiture;
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
public class TaxiDAO implements ITaxiDAO{

    private Connection conn;
    private static TaxiDAO taxiDAO;
    
    private TaxiDAO() {
        conn = MyConnection.getInstance();
    }

    public static TaxiDAO getInstance() {
        if (taxiDAO == null) {
            taxiDAO = new TaxiDAO();
        }
        return taxiDAO;
    }
    @Override
    public void insertTaxi(Taxi taxi) {
        String requete = "insert into taxi values (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, taxi.getIdTaxi());
            ps.setInt(2, taxi.getChauffeur().getIdChauffeur());
            ps.setString(3, taxi.getVoiture().getMatricule());
            ps.setBoolean(4, taxi.isEtat());
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion du taxi " + ex.getMessage());
        }
    }

    @Override
    public void updateTaxi(Taxi taxi) {
        String requete = "update taxi set idChauffeur=?, idVoiture=?, etat=? where idTaxi=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setInt(1, taxi.getChauffeur().getIdChauffeur());
            ps.setString(2, taxi.getVoiture().getMatricule());
            ps.setBoolean(3, taxi.isEtat());
            ps.setInt(4, taxi.getIdTaxi());
             
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour de taxi " + ex.getMessage());
        }

    }
    @Override
    public void deleteTaxi(int id) {
        String requete = "delete from taxi where idTaxi=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression du taxi" + ex.getMessage());
        }
    }

    @Override
    public Taxi findTaxiById(int id) {
        String requete = "select * from taxi where idTaxi=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            Taxi taxi=null;
            
            while (resultat.next()) {
                ChauffeurDAO chauffeurDAO = ChauffeurDAO.getInstance(); 
                Chauffeur chauffeur;
                chauffeur=chauffeurDAO.findChauffeurById(resultat.getInt("idChauffeur"));
                
                VoitureDAO voitureDAO = VoitureDAO.getInstance();
                Voiture voiture;
                voiture=voitureDAO.findVoitureByMatricule(resultat.getString("matricule"));
                taxi = new Taxi(id,chauffeur, voiture);
            }
            return taxi;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du taxi " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Taxi> DisplayAllTaxi() {
        List<Taxi> listeTaxi = new ArrayList<>();
        
        String requete = "select * from taxi";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
            Taxi taxi;
            
            while (resultat.next()) {
                ChauffeurDAO chauffeurDAO = ChauffeurDAO.getInstance(); 
                Chauffeur chauffeur;
                chauffeur=chauffeurDAO.findChauffeurById(resultat.getInt("idChauffeur"));
                
                VoitureDAO voitureDAO = VoitureDAO.getInstance();
                Voiture voiture;
                voiture=voitureDAO.findVoitureByMatricule(resultat.getString("idVoiture"));
                taxi = new Taxi(resultat.getInt("idTaxi"),chauffeur, voiture);

                listeTaxi.add(taxi);
            }
            return listeTaxi;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des taxis " + ex.getMessage());
            return null;
        }
    }
    
}
