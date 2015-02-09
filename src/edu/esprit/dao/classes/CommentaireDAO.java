/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.classes;

import edu.esprit.dao.interfaces.ICommentaireDAO;
import edu.esprit.dao.interfaces.IVoitureDAO;
import edu.esprit.entities.Commentaire;
import edu.esprit.entities.Voiture;
import edu.esprit.technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amina jebari
 */
public class CommentaireDAO implements ICommentaireDAO {
    
     private Connection connection;


    private CommentaireDAO() {
                connection =  MyConnection.getInstance();

    }

  
    @Override
    public void updateCommentaire(Commentaire commentaire) {
        
         String requete = "update voiture set idAgence=? where matricule=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, commentaire.getIdClient());
            ps.setString(2, commentaire.getIdCommentaire());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    
        
           }

    @Override
    public void deleteCommentaire(String idCom) {
        
        String requete = "delete from commentaire where matricule=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, idCom);
            ps.executeUpdate();
            System.out.println("commentaire supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
        
            
    }
    @Override
    public Commentaire selectCommentaire(String idCom) {

         String requete = "select * from commentaire";
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Commentaire commentaire = new Commentaire();
                commentaire.setIdCommentaire(resultat.getString(1));

                commentaire.setIdClient(resultat.getString(2));
            return commentaire;

            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Commentaires " + ex.getMessage());
            return null;
        }
        return null;
    }
        
            
    

    @Override
    public void insertCommentaire(Commentaire commentaire) {
       
        
        String requete = "insert into voiture (matricule) values (?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, commentaire.getIdCommentaire());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    private static ICommentaireDAO iCommentaireDAO;

     public static ICommentaireDAO getInstance() {
        if (iCommentaireDAO == null) {
            iCommentaireDAO = new CommentaireDAO();
        }
        return iCommentaireDAO;
    }
    
    
}
