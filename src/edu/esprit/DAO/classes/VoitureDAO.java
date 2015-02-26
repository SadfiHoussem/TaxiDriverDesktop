/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IVoitureDAO;
import edu.esprit.entities.Agence;
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
public class VoitureDAO implements IVoitureDAO{

        private Connection conn;
    private static VoitureDAO voitureDAO;
    
    private VoitureDAO() {
        conn = MyConnection.getInstance();
    }

    public static VoitureDAO getInstance() {
        if (voitureDAO == null) {
            voitureDAO = new VoitureDAO();
        }
        return voitureDAO;
    }
    
    
    @Override
    public boolean isVoitureExist(Voiture v) {
    String requete = "select * from voiture where matricule=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, v.getMatricule());
            
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du responsable agence" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public boolean insertVoiture(Voiture voiture) {
        if(isVoitureExist(voiture))
            return false;
        else{
            String requete = "insert into voiture values (?,?,?,?,?)";
            try {
                PreparedStatement ps = conn.prepareStatement(requete);
                ps.setString(1, voiture.getMatricule());
                ps.setInt(2, voiture.getAgence().getIdAgence());
                ps.setInt(3, voiture.getNbrPlace());
                ps.setString(4, voiture.getTypeVoiture());
                ps.setBoolean(5, voiture.isEtat());

                ps.executeUpdate();
                System.out.println("Ajout effectuée avec succès");
                return true;
            } catch (SQLException ex) {
                //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur lors de l'insertion de la voiture " + ex.getMessage());
                return false;
            }
        }
    }

    @Override
    public boolean updateVoiture(Voiture voiture) {
        if(!isVoitureExist(voiture))
            return false;
        else{        
            String requete = "update voiture set idAgence=?, nbrPlace=?, typeVoiture=?, etat=? where matricule=?";
            try {
                PreparedStatement ps = conn.prepareStatement(requete);
                
                ps.setInt(1, voiture.getAgence().getIdAgence());
                ps.setInt(2, voiture.getNbrPlace());
                ps.setString(3, voiture.getTypeVoiture());
                ps.setBoolean(4, voiture.isEtat());
                ps.setString(5, voiture.getMatricule());
  
                ps.executeUpdate();
                System.out.println("Mise à jour effectuée avec succès");
                return true;
            } catch (SQLException ex) {
                System.out.println("erreur lors de la modification de la voiture" + ex.getMessage());
                return false;
            }
        }
    }

    @Override
    public boolean deleteVoiture(String matricule) {
        if(!isVoitureExist(voitureDAO.findVoitureByMatricule(matricule)))
            return false;
        else{
        String requete = "delete from voiture where matricule=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, matricule);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression de la voiture " + ex.getMessage());
            return false;
        }
    }
    }
    
    @Override
    public Voiture findVoitureByMatricule(String matricule) {
        String requete = "select * from voiture where matricule=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, matricule);
            ResultSet resultat = ps.executeQuery();
            Voiture voiture = new Voiture();
            AgenceDAO agenceDAO=AgenceDAO.getInstance();
            while (resultat.next()) {
                
                voiture.setMatricule(resultat.getString("matricule"));
                voiture.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                voiture.setNbrPlace(resultat.getInt("nbrPlace"));
                voiture.setTypeVoiture(resultat.getString("typeVoiture"));
                voiture.setEtat(resultat.getBoolean("etat"));
               
            }
            return voiture;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de la voiture" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Voiture> DisplayAllVoitures() {
        List<Voiture> listeVoitures = new ArrayList<>();
        
        String requete = "select * from voiture";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
            AgenceDAO agenceDAO=AgenceDAO.getInstance();
            
            while (resultat.next()) {
                Voiture voiture = new Voiture();

                voiture.setMatricule(resultat.getString("matricule"));
                voiture.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                voiture.setNbrPlace(resultat.getInt("nbrPlace"));
                voiture.setTypeVoiture(resultat.getString("typeVoiture"));
                voiture.setEtat(resultat.getBoolean("etat"));

                listeVoitures.add(voiture);
            }
            return listeVoitures;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des voitures " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Voiture> DisplayAllVoituresByAgence(int idAgence) {
        List<Voiture> listeVoitures = new ArrayList<>();
        
        String requete = "select * from voiture where idAgence='"+idAgence+"'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
            AgenceDAO agenceDAO=AgenceDAO.getInstance();
            
            while (resultat.next()) {
                Voiture voiture = new Voiture();

                voiture.setMatricule(resultat.getString("matricule"));
                voiture.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                voiture.setNbrPlace(resultat.getInt("nbrPlace"));
                voiture.setTypeVoiture(resultat.getString("typeVoiture"));
                voiture.setEtat(resultat.getBoolean("etat"));

                listeVoitures.add(voiture);
            }
            return listeVoitures;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des voitures " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Voiture> DisplayVoitureNAByAgence(Agence agence) {
        
        List<Voiture> listeVoitures = new ArrayList<>();
        
        String requete="SELECT DISTINCT(v1.matricule) FROM voiture v1 LEFT JOIN taxi v2 on v1.matricule = v2.matricule WHERE v2.matricule IS NULL and v1.idAgence="+agence.getIdAgence();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Voiture voiture;
                
                voiture=VoitureDAO.getInstance().findVoitureByMatricule(resultat.getString("matricule"));
                
                listeVoitures.add(voiture);
            }
            return listeVoitures;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des voitures " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Voiture> FindByMatriculeLike(String matricule) {
        List<Voiture> listeVoitures = new ArrayList<>();

        String requete = "select * from voiture where matricule LIKE '"+matricule+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Voiture voiture = new Voiture();
                
                voiture.setMatricule(resultat.getString("matricule"));
                voiture.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                voiture.setNbrPlace(resultat.getInt("nbrPlace"));
                voiture.setTypeVoiture(resultat.getString("typeVoiture"));
                voiture.setEtat(resultat.getBoolean("etat"));
                
                listeVoitures.add(voiture);
            }
            if (b==false)
                return null;
            return listeVoitures;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des voitures " + ex.getMessage());
            return null;
    
        }
    }
    
    @Override
    public List<Voiture> FindByNbrPlaceLike(int nbrPlace) {
        List<Voiture> listeVoitures = new ArrayList<>();

        String requete = "select * from voiture where nbrPlace LIKE '"+nbrPlace+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Voiture voiture = new Voiture();
                
                voiture.setMatricule(resultat.getString("matricule"));
                voiture.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                voiture.setNbrPlace(resultat.getInt("nbrPlace"));
                voiture.setTypeVoiture(resultat.getString("typeVoiture"));
                voiture.setEtat(resultat.getBoolean("etat"));
                
                listeVoitures.add(voiture);
            }
            if (b==false)
                return null;
            return listeVoitures;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des voitures " + ex.getMessage());
            return null;
    
        }
    }
    
    @Override
    public List<Voiture> FindByMarqueLike(String marque) {
        List<Voiture> listeVoitures = new ArrayList<>();

        String requete = "select * from voiture where typeVoiture LIKE '"+marque+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Voiture voiture = new Voiture();
                
                voiture.setMatricule(resultat.getString("matricule"));
                voiture.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                voiture.setNbrPlace(resultat.getInt("nbrPlace"));
                voiture.setTypeVoiture(resultat.getString("typeVoiture"));
                voiture.setEtat(resultat.getBoolean("etat"));
                
                listeVoitures.add(voiture);
            }
            if (b==false)
                return null;
            return listeVoitures;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des voitures " + ex.getMessage());
            return null;
    
        }
    }
    
}
