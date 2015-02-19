/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.ICommentaireDAO;
import edu.esprit.entities.Commentaire;
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
public class CommentaireDAO implements ICommentaireDAO{

    private Connection conn;
    private static CommentaireDAO commentaireDAO;
    
    private CommentaireDAO() {
        conn = MyConnection.getInstance();
    }

    public static CommentaireDAO getInstance() {
        if (commentaireDAO == null) {
            commentaireDAO = new CommentaireDAO();
        }
        return commentaireDAO;
    }
    
    @Override
    public void insertCommentaire(Commentaire commentaire) {
        String requete = "insert into commentaire values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, commentaire.getIdCommentaire());
            ps.setInt(2, commentaire.getClient().getIdClient());
            ps.setInt(3, commentaire.getOffre().getIdOffre());
            ps.setString(5, commentaire.getContenu());

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion dans reclamation " + ex.getMessage());
        }
    }

    @Override
    public void updateCommentaire(Commentaire commentaire) {
        String requete = "update reclamation set idClient=?, idOffre=?, contenu=? where idCommentaire=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setInt(5, commentaire.getIdCommentaire());
            ps.setInt(1, commentaire.getClient().getIdClient());
            ps.setInt(2, commentaire.getOffre().getIdOffre());
            ps.setString(4, commentaire.getContenu());
            
             
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour de réclamation " + ex.getMessage());
        }

    }

    @Override
    public void deleteCommentaire(int id) {
        String requete = "delete from commentaire where idCommentaire=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression du Commentaire" + ex.getMessage());
        }
    }

    @Override
    public Commentaire findCommentaireById(int id) {
        String requete = "select * from commentaire where idCommentaire=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            Commentaire commentaire = new Commentaire();
            ClientDAO clientDAO = ClientDAO.getInstance();
            OffreDAO offreDAO = OffreDAO.getInstance();
            while (resultat.next()) {
                
                commentaire.setIdCommentaire(id);
                commentaire.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                commentaire.setOffre(offreDAO.findOffreById(resultat.getInt("idOffre")));
                commentaire.setContenu(resultat.getString("contenu"));
            }
            return commentaire;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du reclamation" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Commentaire> DisplayAllCommentaires() {
        List<Commentaire> listeCommentaires = new ArrayList<>();

        String requete = "select * from reclamation";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Commentaire commentaire = new Commentaire();
            ClientDAO clientDAO = ClientDAO.getInstance();
            OffreDAO offreDAO = OffreDAO.getInstance();
            while (resultat.next()) {
                
                commentaire.setIdCommentaire(resultat.getInt("idTrajet"));
                commentaire.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                commentaire.setOffre(offreDAO.findOffreById(resultat.getInt("idOffre")));
                commentaire.setContenu(resultat.getString("contenu"));
               
                listeCommentaires.add(commentaire);
            }
            return listeCommentaires;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des reclamations " + ex.getMessage());
            return null;
        }
    }
    public ResultSet DisplayAllCommentaires2(int id ) {


        String requete = " select idCommentaire, login, contenu from commentaire,client where client.idClient=commentaire.idClient and idOffre="+id;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
       
            return resultat;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des commentaires " + ex.getMessage());
            return null;
        }
    
    }
}
