
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IAgenceDAO;
import edu.esprit.entities.Agence;
import edu.esprit.entities.ResponsableAgence;
import edu.esprit.technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AgenceDAO implements IAgenceDAO{
    
      private Connection connection;
      private static AgenceDAO agenceDAO;
      
      private AgenceDAO() {
        connection = MyConnection.getInstance();
    }

    public static AgenceDAO getInstance() {
        if (agenceDAO == null) {
            agenceDAO = new AgenceDAO();
        }
        return agenceDAO;
    }
          
    @Override
    public boolean isAgenceExist(Agence a) {
    String requete = "select * from agence where idAgence=? and nomAgence=? and telAgence=? and idRespAgence=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, a.getIdAgence());
            ps.setString(2, a.getNomAgence());
            ps.setInt(3, a.getTelAgence());
            ps.setInt(4, a.getRespAgence().getIdResponsableAgence());
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du responsable agence" + ex.getMessage());
            return false;
        }
                
    }
    
      @Override
        public boolean isAgenceExistUpdate(Agence a) {
    String requete = "select * from agence where idAgence=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, a.getIdAgence());
            
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du responsable agence" + ex.getMessage());
            return false;
        }
                
    }
    
    //ajouter agence(insert)
      @Override
   public boolean insertAgence(Agence a){
        if(isAgenceExist(a))
            return false;
        else{
            String requete = "insert into agence values (?,?,?,?,?)";
            try {
                PreparedStatement ps = connection.prepareStatement(requete);
                ps.setInt(1, a.getIdAgence());
                ps.setInt(2, a.getRespAgence().getIdResponsableAgence());
                ps.setString(3, a.getNomAgence());
                ps.setInt(4, a.getTelAgence());
                ps.setString(5, a.getAdresseAgence());
                ps.executeUpdate();
                System.out.println("Ajout effectuée avec succés");
                return true;
            } catch (SQLException ex) {
                //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur lors de l'insertion " + ex.getMessage());
                return false;
            }
    }
   }   
   
     //modifier agence
      @Override
    public boolean updateAgence(Agence a){
        if(!isAgenceExistUpdate(a))
            return false;
        else{
            String requete = "update agence set idRespAgence=?, nomAgence=?, telAgence=?, adresseAgence=? where idAgence=?";
            try {
                PreparedStatement ps = connection.prepareStatement(requete);
                
                ps.setInt(1, a.getRespAgence().getIdResponsableAgence());
                ps.setString(2, a.getNomAgence());
                ps.setInt(3, a.getTelAgence());
                ps.setString(4, a.getAdresseAgence());
                ps.setInt(5, a.getIdAgence());

                ps.executeUpdate();
                System.out.println("Mise à  jour effectuée avec succés");
                return true;
            } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            return false;
            }
    }
   }
    
    //supprimer une agence
      @Override
   public boolean deleteAgence(Agence a){
        if(!isAgenceExist(a))
            return false;
        else{
            String requete = "delete from agence where idAgence=?";
            try {
                PreparedStatement ps = connection.prepareStatement(requete);
                ps.setInt(1, a.getIdAgence());
                ps.executeUpdate();
                System.out.println("Suppression effectuée avec succés");
                return true;
            } catch (SQLException ex) {
                //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur lors de la suppression " + ex.getMessage());
                return false;
            }
       }
   }

    @Override
    public Agence findAgenceById(int id) {
        String requete="select * from agence where idAgence=?";
        try {
            boolean b=false;
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            Agence agence = new Agence();
            while (resultat.next()) {
                b=true;
                ResponsableAgenceDAO respAgenceDAO=ResponsableAgenceDAO.getInstance();
                ResponsableAgence respAgence;
                
                agence.setIdAgence(id);
                respAgence=respAgenceDAO.findRespAgenceById(resultat.getInt("idRespAgence"));
                agence.setRespAgence(respAgence);
                agence.setNomAgence(resultat.getString("nomAgence"));
                agence.setTelAgence(resultat.getInt("telAgence"));
                agence.setAdresseAgence(resultat.getString("adresseAgence"));
                
            }
            if(b==false)
                return null;            
            return agence;
        }catch (SQLException ex) {
                //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur lors du chargement des agences " + ex.getMessage());
                return null;
            }
        }
    
    @Override
    public Agence findAgenceByRespAgence(int id) {
        
        String requete="select * from agence where idRespAgence=?";
        try {
            boolean b=false;
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            Agence agence = new Agence();
            while (resultat.next()) {
                b=true;
                
                ResponsableAgenceDAO respAgenceDAO=ResponsableAgenceDAO.getInstance();
                ResponsableAgence respAgence;
                
                agence.setIdAgence(resultat.getInt("idAgence"));
                respAgence=respAgenceDAO.findRespAgenceById(resultat.getInt("idRespAgence"));
                agence.setRespAgence(respAgence);
                agence.setNomAgence(resultat.getString("nomAgence"));
                agence.setTelAgence(resultat.getInt("telAgence"));
                agence.setAdresseAgence(resultat.getString("adresseAgence"));
                
            }
            if(b==false)
                return null;            
            return agence;
        }catch (SQLException ex) {
                //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur lors du chargement des agences " + ex.getMessage());
                return null;
            }
        }
    
    @Override
    public List<Agence> DisplayAllAgences() {
        List<Agence> listeAgences = new ArrayList<>();
        
        String requete = "select * from agence";
        try {
            boolean b=false;
            Statement statement = connection.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
            ResponsableAgenceDAO respAgenceDAO=ResponsableAgenceDAO.getInstance();
            ResponsableAgence respAgence;
            
            while (resultat.next()) {
                b=true;
                Agence agence = new Agence();

                agence.setIdAgence(Integer.parseInt(resultat.getString("idAgence")));
                respAgence=respAgenceDAO.findRespAgenceById(resultat.getInt("idRespAgence"));
                agence.setRespAgence(respAgence);
                agence.setNomAgence(resultat.getString("nomAgence"));
                agence.setTelAgence(resultat.getInt("telAgence"));
                agence.setAdresseAgence(resultat.getString("adresseAgence"));

                listeAgences.add(agence);
            }
            if(b==false)
                return null;
            return listeAgences;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des agences " + ex.getMessage());
            return null;
        }
    }
    
    public ResultSet DisplayAllAgencesTypeResultSet() {
        
        String requete = "select * from agence";
        try {
            boolean b=false;
            Statement statement = connection.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
        
          
            return resultat;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des agences " + ex.getMessage());
            return null;
        }
    }
}
