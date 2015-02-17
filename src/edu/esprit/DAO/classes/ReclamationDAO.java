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
    public boolean isReclamationExist(Reclamation r) {
    String requete = "select * from reclamation where idReclamation=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
 
            ps.setInt(1, r.getIdReclamation());
            
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du reclamation" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public Boolean insertReclamation(Reclamation reclamation) {
        if(isReclamationExist(reclamation))
            return false;
        String requete = "insert into reclamation values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setInt(1, reclamation.getIdReclamation());
            ps.setInt(2, reclamation.getClient().getIdClient());
            ps.setInt(3, reclamation.getAgence().getIdAgence());
            ps.setString(4, reclamation.getsujetReclamation());
            ps.setString(5, reclamation.getcontenu());
            ps.setBoolean(6, reclamation.isEtat());

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion dans reclamation " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Boolean updateReclamation(Reclamation reclamation) {
        if(!isReclamationExist(reclamation))
            return false;
        String requete = "update reclamation set sujetReclamation=?, contenu=?, etat=? where idReclamation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setInt(4, reclamation.getIdReclamation());
            ps.setString(1, reclamation.getsujetReclamation());
            ps.setString(2, reclamation.getcontenu());
            ps.setBoolean(3, reclamation.isEtat());
             
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour de réclamation " + ex.getMessage());
            return false;
        }
    }
    
    @Override
    public Boolean updateReclamationRespAgence(Reclamation reclamation) {
        if(!isReclamationExist(reclamation))
            return false;
        String requete = "update reclamation set etat=? where idReclamation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setInt(2, reclamation.getIdReclamation());
            ps.setBoolean(1, reclamation.isEtat());
             
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour de réclamation " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Boolean deleteReclamation(Reclamation reclamation) {
        if(isReclamationExist(reclamation))
            return false;
        String requete = "delete from reclamation where idReclamation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, reclamation.getIdReclamation());
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression du reclamation" + ex.getMessage());
            return false;
        }
    }

    @Override
    public Reclamation findReclamationById(int id) {
        String requete = "select * from reclamation where idReclamation=?";
        boolean b=false;
        try {
            b=true;
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1,id);
            ResultSet resultat = ps.executeQuery();
            Reclamation reclamation = new Reclamation();
            ClientDAO clientDAO = ClientDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            while (resultat.next()) {
                
                reclamation.setIdReclamation(id);
                reclamation.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                reclamation.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                reclamation.setsujetReclamation(resultat.getString("sujetReclamation"));
                reclamation.setcontenu(resultat.getString("contenu"));
            }
            if(b==false)
                return null;
            return reclamation;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du reclamation" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Reclamation> DisplayAllReclamations() {
        List<Reclamation> listeReclamations = new ArrayList<>();
        boolean b=false;
        String requete = "select * from reclamation";
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Reclamation reclamation = new Reclamation();
            ClientDAO clientDAO = ClientDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            while (resultat.next()) {
                
                reclamation.setIdReclamation(resultat.getInt("idReclamation"));
                reclamation.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                reclamation.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                reclamation.setsujetReclamation(resultat.getString("sujetReclamation"));
                reclamation.setcontenu(resultat.getString("contenu"));
                reclamation.setEtat(resultat.getBoolean("etat"));
               
                listeReclamations.add(reclamation);
            }
            if(b==false)
                return null;
            return listeReclamations;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des reclamations " + ex.getMessage());
            return null;
        }
    }
    
}
