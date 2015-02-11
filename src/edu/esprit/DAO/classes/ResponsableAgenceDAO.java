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
    public boolean isRespAgenceExist(Long cin) {
    String requete = "select * from responsableagence where cin=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setLong(1, cin);
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du responsable agence" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public boolean insertRespAgence(ResponsableAgence r) {
        if(!isRespAgenceExist(r.getCin()))
            return false;
        else{  
            String requete="insert into responsableagence values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
    
            ps.setString(1, r.getIdResponsableAgence());
            ps.setString(2, r.getLogin());
            ps.setString(3, r.getPwd());
            ps.setString(4, r.getNom());
            ps.setString(5, r.getPrenom());
            ps.setString(6, r.getEmail());
            ps.setInt(7, r.getTelephone());
            ps.setString(8, r.getAdresse());
            ps.setLong(9, r.getCin());
    
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des données du responsable agence" + ex.getMessage());
            return false;
            }
        }
    }
    @Override
    public boolean deleteRespAgence(String idRespAgence) {
    
        ResponsableAgenceDAO respAgenceDAO = new ResponsableAgenceDAO();
        ResponsableAgence r = respAgenceDAO.findRespAgenceById(idRespAgence);
        if(!isRespAgenceExist(r.getCin()))
            return false;
        else{
            String requete="delete from responsableagence where idRespAgence=?";
            try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, idRespAgence);
            
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
        
        if(!isRespAgenceExist(r.getCin()))
            return false;
        else{
        
        String requete = "update responsableagence set login=?, pwd=?, nom=?, prenom=?, email=?, telephone=?, adresse=?, cin=? where idRespAgence=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
           
            ps.setString(1, r.getLogin());
            ps.setString(2, r.getPwd());
            ps.setString(3, r.getNom());
            ps.setString(4, r.getPrenom());
            ps.setString(5, r.getEmail());
            ps.setInt(6, r.getTelephone());
            ps.setString(7, r.getAdresse());
            ps.setLong(8, r.getCin());
            ps.setString(9, r.getIdResponsableAgence());
             
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
    public ResponsableAgence findRespAgenceById(String idRespAgence) {
        String requete="select * from responsableagence where idRespAgence=?";
            try {
                PreparedStatement ps = conn.prepareStatement(requete);
                ps.setString(1, idRespAgence);
                ResultSet resultat = ps.executeQuery();
                if(resultat.next()){
                    return null;
                }
                ResponsableAgence respAgence = new ResponsableAgence();

                while (resultat.next()) {
                    respAgence.setIdResponsableAgence(resultat.getString("idRespAgence"));
                    respAgence.setLogin(resultat.getString("login"));
                    respAgence.setPwd(resultat.getString("pwd"));
                    respAgence.setNom(resultat.getString("nom"));
                    respAgence.setPrenom(resultat.getString("prenom"));
                    respAgence.setEmail(resultat.getString("email"));
                    respAgence.setTelephone(resultat.getInt("telephone"));
                    respAgence.setAdresse(resultat.getString("adresse"));
                    respAgence.setCin(resultat.getInt("cin"));
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
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
            if(resultat.next()){
                return null;
            }            
            while (resultat.next()) {
                ResponsableAgence respAgence = new ResponsableAgence();

                respAgence.setIdResponsableAgence(resultat.getString("idRespAgence"));
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
            return listeRespAgence;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des données du responsable agence " + ex.getMessage());
            return null;
        }
    }
}
