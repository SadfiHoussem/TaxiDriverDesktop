/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IReclamationDAO;
import edu.esprit.entities.Reclamation;
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
public class ReclamationDAO implements IReclamationDAO{

    private Connection conn;
    private static ReclamationDAO reclamationDAO;
    
    private ReclamationDAO() {
        conn = MyConnection.getInstance();
    }

    public static ReclamationDAO getInstance() {
        if (reclamationDAO == null) {
            reclamationDAO = new ReclamationDAO();
        }
        return reclamationDAO;
    }
    
    @Override
    public void insertReclamation(Reclamation reclamation) {
        String requete = "insert into reclamation values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, reclamation.getIdReclamation());
            ps.setString(2, reclamation.getClient().getIdClient());
            ps.setString(3, reclamation.getAgence().getIdAgence());
            ps.setString(4, reclamation.getsujetReclamation());
            ps.setString(5, reclamation.getcontenu());

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion dans reclamation " + ex.getMessage());
        }
    }

    @Override
    public void updateReclamation(Reclamation reclamation) {
        String requete = "update reclamation set idClient=?, idAgence=?, sujetReclamation=?, contenu=? where idReclamation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setString(5, reclamation.getIdReclamation());
            ps.setString(1, reclamation.getClient().getIdClient());
            ps.setString(2, reclamation.getAgence().getIdAgence());
            ps.setString(3, reclamation.getsujetReclamation());
            ps.setString(4, reclamation.getcontenu());
            
             
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour de réclamation " + ex.getMessage());
        }

    }

    @Override
    public void deleteReclamation(String id) {
        String requete = "delete from reclamation where idReclamation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression du reclamation" + ex.getMessage());
        }
    }

    @Override
    public Reclamation findReclamationById(String id) {
        String requete = "select * from trajet where idReclamation=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            Reclamation reclamation = new Reclamation();
            ClientDAO clientDAO = ClientDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            while (resultat.next()) {
                
                reclamation.setIdReclamation(id);
                reclamation.setClient(clientDAO.findClientById(resultat.getString("idClient")));
                reclamation.setAgence(agenceDAO.findAgenceById(resultat.getString("idAgence")));
                reclamation.setsujetReclamation(resultat.getString("sujetReclamation"));
                reclamation.setcontenu(resultat.getString("contenu"));
            }
            return reclamation;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du reclamation" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Reclamation> DisplayAllReclamations() {
        List<Reclamation> listeReclamations = new ArrayList<>();

        String requete = "select * from reclamation";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Reclamation reclamation = new Reclamation();
            ClientDAO clientDAO = ClientDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            while (resultat.next()) {
                
                reclamation.setIdReclamation(resultat.getString("idTrajet"));
                reclamation.setClient(clientDAO.findClientById(resultat.getString("idClient")));
                reclamation.setAgence(agenceDAO.findAgenceById(resultat.getString("idAgence")));
                reclamation.setsujetReclamation(resultat.getString("sujetReclamation"));
                reclamation.setcontenu(resultat.getString("contenu"));
               
                listeReclamations.add(reclamation);
            }
            return listeReclamations;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des reclamations " + ex.getMessage());
            return null;
        }
    }
    
}