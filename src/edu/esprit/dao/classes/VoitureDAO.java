/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.esprit.dao.interfaces.IVoitureDAO;
import edu.esprit.technique.MyConnection;
import edu.esprit.entities.Voiture;




public class VoitureDAO implements IVoitureDAO {
    
    private static Connection connection;


    private VoitureDAO() {
                connection =  MyConnection.getInstance();

    }

  
    @Override
    public void updateVoiture(Voiture voiture) {
        
         String requete = "update voiture set idAgence=? where matricule=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, voiture.getIdAgence());
            ps.setString(2, voiture.getMatricule());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    
        
           }

    @Override
    public void deleteVoiture(String mat) {
        
        String requete = "delete from voiture where matricule=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, mat);
            ps.executeUpdate();
            
            System.out.println("voiture supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
        
            
    }
    @Override
    public Voiture selectVoiture(String mat) {

         String requete = "select * from voiture";
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Voiture voiture = new Voiture();
                voiture.setMatricule(resultat.getString(1));
                voiture.setNbrPlace(resultat.getInt(2));
            return voiture;

            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
        return null;
    }
        
            
    

    @Override
    public void insertVoiture(Voiture voiture) {
       
        
        String requete = "insert into voiture (matricule) values (?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, voiture.getMatricule());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    private static IVoitureDAO iVoitureDAO;

     public static IVoitureDAO getInstance() {
        if (iVoitureDAO == null) {
       iVoitureDAO=   new VoitureDAO();
        }
        return iVoitureDAO;
    }
}

    
