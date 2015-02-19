/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IAdministrateurDAO;
import edu.esprit.entities.Administrateur;
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
public class AdministrateurDAO implements IAdministrateurDAO{

    private final Connection conn;
    private static AdministrateurDAO administrateurDAO;
    
    private AdministrateurDAO() {
        conn = MyConnection.getInstance();
    }

    public static AdministrateurDAO getInstance() {
        if (administrateurDAO == null) {
            administrateurDAO = new AdministrateurDAO();
        }
        return administrateurDAO;
    }
    
    @Override
    public void insertAdministrateur(Administrateur administrateur) {
        String requete = "insert into administrateur values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, administrateur.getIdAdministrateur());
            ps.setString(2, administrateur.getLogin());
            ps.setString(3, administrateur.getPwd());
            ps.setString(4, administrateur.getNom());
            ps.setString(5, administrateur.getPrenom());
            ps.setString(6, administrateur.getEmail());
            ps.setInt(7, administrateur.getTelephone());
            ps.setString(8, administrateur.getAdresse());
            ps.setLong(9, administrateur.getCin());
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion dans Administrateur " + ex.getMessage());
        }
    }


    @Override
    public void updateAdministrateur(Administrateur administrateur) {
        String requete = "update administrateur set login=?, pwd=?, nom=?, prenom=?, email=?, telephone=?, adresse=?, cin=? where idAdministrateur=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setString(1, administrateur.getLogin());
            ps.setString(2, administrateur.getPwd());
            ps.setString(3, administrateur.getNom());
            ps.setString(4, administrateur.getPrenom());
            ps.setString(5, administrateur.getEmail());
            ps.setInt(6, administrateur.getTelephone());
            ps.setString(7, administrateur.getAdresse());
            ps.setLong(8, administrateur.getCin());
            ps.setInt(9, administrateur.getIdAdministrateur());
             
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour de administrateur " + ex.getMessage());
        }

    }

    @Override
    public void deleteAdministrateur(int id) {

        String requete = "delete from administrateur where idAdministrateur='"+id+"'";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(requete);
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression du administrateur" + ex.getMessage());
        }
    }

    @Override
    public Administrateur findAdministrateurById(String id) {
        String requete = "select * from administrateur where idAdministrateur=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1,id);
            ResultSet resultat = ps.executeQuery();
            Administrateur administrateur = new Administrateur();
            while (resultat.next()) {
                
                administrateur.setIdAdministrateur(resultat.getInt("idAdministrateur"));
                administrateur.setLogin(resultat.getString("login"));
                administrateur.setPwd(resultat.getString("pwd"));
                administrateur.setNom(resultat.getString("nom"));
                administrateur.setPrenom(resultat.getString("prenom"));
                administrateur.setEmail(resultat.getString("email"));
                administrateur.setTelephone(resultat.getInt("telephone"));
                administrateur.setAdresse(resultat.getString("adresse"));
                administrateur.setCin(resultat.getInt("cin"));
            }
            return administrateur;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du administrateur" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Administrateur> DisplayAllAdministrateurs() {
        List<Administrateur> listeAdministrateurs = new ArrayList<>();
        
        String requete = "select * from administrateur";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Administrateur administrateur = new Administrateur();

                administrateur.setIdAdministrateur(resultat.getInt("idAdministrateur"));
                administrateur.setLogin(resultat.getString("login"));
                administrateur.setPwd(resultat.getString("pwd"));
                administrateur.setNom(resultat.getString("nom"));
                administrateur.setPrenom(resultat.getString("prenom"));
                administrateur.setEmail(resultat.getString("email"));
                administrateur.setTelephone(resultat.getInt("telephone"));
                administrateur.setAdresse(resultat.getString("adresse"));
                administrateur.setCin(resultat.getInt("cin"));

                listeAdministrateurs.add(administrateur);
            }
            return listeAdministrateurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des administrateurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean findAdministrateurByLogin_PWD(String log, String pwd) {
        String requete = "select * from administrateur where login=? and pwd=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, log);
            ps.setString(2, pwd);

            ResultSet resultat = ps.executeQuery();
            
            return resultat.next();
       
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du administrateur" + ex.getMessage());
            return false;
        }
    }

    public Administrateur findAdminByLogin(String loginChauffeur) {
        String requete="select * from Administrateur where login=?";
            try {
                boolean b=false;
                PreparedStatement ps = conn.prepareStatement(requete);
                ps.setString(1, loginChauffeur);
                ResultSet resultat = ps.executeQuery();
                Administrateur administrateur = new Administrateur();

                while (resultat.next()) {
                    b=true;
                    

                administrateur.setIdAdministrateur(resultat.getInt("idAdministrateur"));
                administrateur.setLogin(resultat.getString("login"));
                administrateur.setPwd(resultat.getString("pwd"));
                administrateur.setNom(resultat.getString("nom"));
                administrateur.setPrenom(resultat.getString("prenom"));
                administrateur.setEmail(resultat.getString("email"));
                administrateur.setTelephone(resultat.getInt("telephone"));
                administrateur.setAdresse(resultat.getString("adresse"));
                administrateur.setCin(resultat.getInt("cin"));
                }
                if(b==false){
                return null;
            }
                return administrateur;
            } catch (SQLException ex) {
                System.out.println("erreur lors de la recherche de l'admin" + ex.getMessage());
                return null;
            }
        }
    
}
