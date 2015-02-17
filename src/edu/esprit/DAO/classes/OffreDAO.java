/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IOffreDAO;
import edu.esprit.entities.Offre;
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
public class OffreDAO implements IOffreDAO{
    
    private final Connection conn;
    private static OffreDAO offreDAO;
    
    public OffreDAO() {
        conn = MyConnection.getInstance();
    }

    public static OffreDAO getInstance() {
        if (offreDAO == null) {
            offreDAO = new OffreDAO();
        }
        return offreDAO;
    }
    
    @Override
    public boolean isOffreExist(int id) {
    String requete = "select * from offre where idOffre=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du offre" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public boolean insertOffre(Offre o) {
        if(isOffreExist(o.getIdOffre())){
            return false;
        }
            
        else{
            String requete="insert into offre values (?,?,?,?)";
            try {
                PreparedStatement ps = conn.prepareStatement(requete);
                
                ps.setInt(1, o.getIdOffre());
                ps.setInt(2, o.getAgence().getIdAgence());
                ps.setString(3, o.getSujetOffre());
                ps.setString(4, o.getContenu());
                
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                System.out.println("erreur lors du chargement des offres" + ex.getMessage());
                return false;
            }
    }
    }
    @Override
    public boolean deleteOffre(int idOffre) {
        if(!isOffreExist(idOffre))
            return false;
        else{
        String requete="delete from offre where idOffre=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, idOffre);
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des offres" + ex.getMessage());
            return false;
            }
    }
    }
    @Override
    public boolean updateOffre(Offre o) {
        if(!isOffreExist(o.getIdOffre()))
            return false;
        else{
        String requete="update offre set sujetOffre=? , contenu=? where idOffre=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, o.getSujetOffre());
            ps.setString(2, o.getContenu());
            ps.setInt(3, o.getIdOffre());
          
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des offres" + ex.getMessage());
            return false;
            }
    }
    }

    @Override
    public boolean updateSujetOffre(int idOffre, String sujetOffre) {
        if(!isOffreExist(idOffre))
            return false;
        else{
        String requete="update offre set sujetOffre=? where idOffre=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, sujetOffre);
            ps.setInt(2, idOffre);
          
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des offres" + ex.getMessage());
            return false;
            }
    }
    }
    @Override
    public boolean updateContenuOffre(int idOffre, String contenu) {
        if(!isOffreExist(idOffre))
            return false;
        else{
        String requete="update offre set contenu=? where idOffre=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, contenu);
            ps.setInt(2, idOffre);
          
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des offress" + ex.getMessage());
            return false;
            }
    }
    }
        @Override
    public Offre findOffreById(int id) {
        
        String requete="select * from offre where idOffre=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            if(resultat.next())
                return null;
            Offre offre = new Offre();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            
            while (resultat.next()) {
                offre.setIdOffre(id);
                offre.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                offre.setSujetOffre(resultat.getString("sujetOffre"));
                offre.setContenu(resultat.getString("contenu"));
            }
            return offre;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des offres" + ex.getMessage());
            return null;
            }
    }

    @Override
    public List<Offre> DisplayAllOffres() {
        List<Offre> listeOffres = new ArrayList<>();

        String requete = "select * from stock";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            if (resultat.next())
                return null;
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            while (resultat.next()) {
                Offre offre = new Offre();
                offre.setIdOffre(resultat.getInt("idOffre"));
                offre.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                offre.setSujetOffre(resultat.getString("sujetOffre"));
                offre.setContenu(resultat.getString("contenu"));

                listeOffres.add(offre);
            }
            return listeOffres;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des offres " + ex.getMessage());
            return null;
        }
    }

}
