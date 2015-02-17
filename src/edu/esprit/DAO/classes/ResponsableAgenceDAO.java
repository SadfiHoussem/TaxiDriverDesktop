/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IResponsableAgenceDAO;
import edu.esprit.entities.ResponsableAgence;
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
public class ResponsableAgenceDAO implements IResponsableAgenceDAO{
    
    private final Connection conn;
    private static ResponsableAgenceDAO RespAgenceDAO; 
    
    private ResponsableAgenceDAO() {
        conn = MyConnection.getInstance();
    }
    
    public static ResponsableAgenceDAO getInstance(){
        if (RespAgenceDAO==null)
            RespAgenceDAO= new ResponsableAgenceDAO();
        return RespAgenceDAO;
    }
    
    @Override
    public boolean isRespAgenceExist(ResponsableAgence ra) {
    String requete = "select * from responsableagence where idRespAgence=? and telephone=? and login=? and email=? and cin=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, ra.getIdResponsableAgence());
            ps.setInt(2, ra.getTelephone());
            ps.setString(3, ra.getLogin());
            ps.setString(4, ra.getEmail());
            ps.setLong(5, ra.getCin());
            
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du Responsable Agence" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public boolean isRespAgenceExistUpdate(ResponsableAgence ra) {
    String requete = "select * from responsableagence where login=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
           
            ps.setString(1, ra.getLogin());
            
            
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du Responsable Agence" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public boolean insertRespAgence(ResponsableAgence ra) {
        if(!isRespAgenceExist(ra))
            return false;
        else{  
            String requete="insert into responsableagence values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
    
            ps.setInt(1, ra.getIdResponsableAgence());
            ps.setString(2, ra.getLogin());
            ps.setString(3, ra.getPwd());
            ps.setString(4, ra.getNom());
            ps.setString(5, ra.getPrenom());
            ps.setString(6, ra.getEmail());
            ps.setInt(7, ra.getTelephone());
            ps.setString(8, ra.getAdresse());
            ps.setLong(9, ra.getCin());
    
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des données du responsable agence" + ex.getMessage());
            return false;
            }
        }
    }
    @Override
    public boolean deleteRespAgence(int idRespAgence) {
    
        ResponsableAgenceDAO respAgenceDAO = new ResponsableAgenceDAO();
        ResponsableAgence r = respAgenceDAO.findRespAgenceById(idRespAgence);
        if(!isRespAgenceExist(r))
            return false;
        else{
            String requete="delete from responsableagence where idRespAgence=?";
            try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, idRespAgence);
            
            ps.executeUpdate();
            return true;
            } catch (SQLException ex) {
                System.out.println("erreur lors de la suppression du responsable agence" + ex.getMessage());
                return false;
            }
    }
    }
    
    @Override 
    public boolean updateRespAgence(ResponsableAgence r) {
        
        if(!isRespAgenceExistUpdate(r))
            return false;
        else{
        
        String requete = "update responsableagence set pwd=?, nom=?, prenom=?, email=?, telephone=?, adresse=?, cin=? where idRespAgence=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
           
            ps.setString(1, r.getPwd());
            ps.setString(2, r.getNom());
            ps.setString(3, r.getPrenom());
            ps.setString(4, r.getEmail());
            ps.setInt(5, r.getTelephone());
            ps.setString(6, r.getAdresse());
            ps.setLong(7, r.getCin());
            ps.setInt(8, r.getIdResponsableAgence());
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la modification du responsable agence" + ex.getMessage());
            return false;
        }
    }
}
    
    @Override
    public ResponsableAgence findRespAgenceById(int idRespAgence) {
        String requete="select * from responsableagence where idRespAgence=?";
            try {
                boolean b=false;
                PreparedStatement ps = conn.prepareStatement(requete);
                ps.setInt(1, idRespAgence);
                ResultSet resultat = ps.executeQuery();
                ResponsableAgence respAgence = new ResponsableAgence();

                while (resultat.next()) {
                    b=true;
                    respAgence.setIdResponsableAgence(resultat.getInt("idRespAgence"));
                    respAgence.setLogin(resultat.getString("login"));
                    respAgence.setPwd(resultat.getString("pwd"));
                    respAgence.setNom(resultat.getString("nom"));
                    respAgence.setPrenom(resultat.getString("prenom"));
                    respAgence.setEmail(resultat.getString("email"));
                    respAgence.setTelephone(resultat.getInt("telephone"));
                    respAgence.setAdresse(resultat.getString("adresse"));
                    respAgence.setCin(resultat.getInt("cin"));
                }
                if(b==false){
                return null;
            }
                return respAgence;
            } catch (SQLException ex) {
                System.out.println("erreur lors de la recherche du Responsable agence" + ex.getMessage());
                return null;
            }
        }
    
    @Override
    public ResponsableAgence findRespAgenceByLogin(String loginRespAgence) {
        String requete="select * from responsableagence where login=?";
            try {
                boolean b=false;
                PreparedStatement ps = conn.prepareStatement(requete);
                ps.setString(1, loginRespAgence);
                ResultSet resultat = ps.executeQuery();
                ResponsableAgence respAgence = new ResponsableAgence();

                while (resultat.next()) {
                    b=true;
                    respAgence.setIdResponsableAgence(resultat.getInt("idRespAgence"));
                    respAgence.setLogin(resultat.getString("login"));
                    respAgence.setPwd(resultat.getString("pwd"));
                    respAgence.setNom(resultat.getString("nom"));
                    respAgence.setPrenom(resultat.getString("prenom"));
                    respAgence.setEmail(resultat.getString("email"));
                    respAgence.setTelephone(resultat.getInt("telephone"));
                    respAgence.setAdresse(resultat.getString("adresse"));
                    respAgence.setCin(resultat.getInt("cin"));
                }
                if(b==false){
                return null;
            }
                return respAgence;
            } catch (SQLException ex) {
                System.out.println("erreur lors de la recherche du Responsable agence" + ex.getMessage());
                return null;
            }
        }
    

    @Override
    public List<ResponsableAgence> DisplayAllResponsableAgence() {
        List<ResponsableAgence> listeRespAgence = new ArrayList<>();
        
        String requete = "select * from responsableagence";
        try {
            boolean b=false;
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
                        
            while (resultat.next()) {
                b=true;
                ResponsableAgence respAgence = new ResponsableAgence();

                respAgence.setIdResponsableAgence(resultat.getInt("idRespAgence"));
                respAgence.setLogin(resultat.getString("login"));
                respAgence.setPwd(resultat.getString("pwd"));
                respAgence.setNom(resultat.getString("nom"));
                respAgence.setPrenom(resultat.getString("prenom"));
                respAgence.setEmail(resultat.getString("email"));
                respAgence.setTelephone(resultat.getInt("telephone"));
                respAgence.setAdresse(resultat.getString("adresse"));
                respAgence.setCin(resultat.getInt("cin"));

                listeRespAgence.add(respAgence);
            }
            if(b==false){
                return null;
            }
            return listeRespAgence;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des données du responsable agence " + ex.getMessage());
            return null;
        }
    }
}
