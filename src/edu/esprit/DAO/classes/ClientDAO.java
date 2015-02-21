/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IClientDAO;
import edu.esprit.entities.Client;
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
public class ClientDAO implements IClientDAO{

    private Connection conn;
    private static ClientDAO clientDAO;
    
    private ClientDAO() {
        conn = MyConnection.getInstance();
    }

    public static ClientDAO getInstance() {
        if (clientDAO == null) {
            clientDAO = new ClientDAO();
        }
        return clientDAO;
    }
    
    @Override
    public boolean isClientExist(Client c) {
    String requete = "select * from client where cin=? and login=? and email=? and telephone=?";
    
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setLong(1, c.getCin());
            ps.setString(2, c.getLogin());
            ps.setString(3, c.getEmail());
            ps.setInt(4, c.getTelephone());
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du client" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public boolean isClientExistUpdate(Client c) {
    String requete = "select * from client where login=?";
    
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, c.getLogin());
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du client" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public boolean insertClient(Client client) {
        if(!isClientExist(client))
            return false;
        else{
            String requete = "insert into client values (?,?,?,?,?,?,?,?,?)";
            try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, client.getIdClient());
            ps.setString(2, client.getLogin());
            ps.setString(3, client.getPwd());
            ps.setString(4, client.getNom());
            ps.setString(5, client.getPrenom());
            ps.setString(6, client.getEmail());
            ps.setInt(7, client.getTelephone());
            ps.setString(8, client.getAdresse());
            ps.setLong(9, client.getCin());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion dans client " + ex.getMessage());
            return false;
        }
        }
        
    }

    @Override
    public boolean updateClient(Client client) {
        if(!isClientExist(client))
            return false;
        else{
            String requete = "update client set login=?, pwd=?, nom=?, prenom=?, email=?, telephone=?, adresse=?, cin=? where idClient=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setString(1, client.getLogin());
            ps.setString(2, client.getPwd());
            ps.setString(3, client.getNom());
            ps.setString(4, client.getPrenom());
            ps.setString(5, client.getEmail());
            ps.setInt(6, client.getTelephone());
            ps.setString(7, client.getAdresse());
            ps.setLong(8, client.getCin());
            ps.setInt(9, client.getIdClient());
             
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
            } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour de client " + ex.getMessage());
            return false;
            }
        }

    }

    @Override
    public boolean deleteClient(int id) {
        ClientDAO cDAO =getInstance();
        Client client = cDAO.findClientById(id);
        if(isClientExist(client))
            return false;
        else{
        String requete = "delete from client where idClient=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression du client" + ex.getMessage());
            return false;
        }
    }
    }
    @Override
    public Client findClientById(int id) {
        String requete = "select * from client where idClient=?";

        try {
            boolean b=false;
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            Client client = new Client();
            while (resultat.next()) {
                b=true;
                client.setIdClient(resultat.getInt("idClient"));
                client.setLogin(resultat.getString("login"));
                client.setPwd(resultat.getString("pwd"));
                client.setNom(resultat.getString("nom"));
                client.setPrenom(resultat.getString("prenom"));
                client.setEmail(resultat.getString("email"));
                client.setTelephone(resultat.getInt("telephone"));
                client.setAdresse(resultat.getString("adresse"));
                client.setCin(resultat.getInt("cin"));
            }
            if(b==false)
                return null;
            return client;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du client" + ex.getMessage());
            return null;
        }
    }

        @Override
    public Client findClientByCin(Long cin) {
        String requete = "select * from client where cin=?";

        try {
            boolean b=false;
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setLong(1, cin);
            ResultSet resultat = ps.executeQuery();
            Client client = new Client();
            while (resultat.next()) {
                b=true;
                client.setIdClient(resultat.getInt("idClient"));
                client.setLogin(resultat.getString("login"));
                client.setPwd(resultat.getString("pwd"));
                client.setNom(resultat.getString("nom"));
                client.setPrenom(resultat.getString("prenom"));
                client.setEmail(resultat.getString("email"));
                client.setTelephone(resultat.getInt("telephone"));
                client.setAdresse(resultat.getString("adresse"));
                client.setCin(resultat.getInt("cin"));
            }
            if(b==false)
                return null;
            return client;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du client" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Client> DisplayAllClients() {
        List<Client> listeClients = new ArrayList<>();
        
        String requete = "select * from client";
        try {
            boolean b=false;
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                b=true;
                Client client = new Client();

                client.setIdClient(resultat.getInt("idClient"));
                client.setLogin(resultat.getString("login"));
                client.setPwd(resultat.getString("pwd"));
                client.setNom(resultat.getString("nom"));
                client.setPrenom(resultat.getString("prenom"));
                client.setEmail(resultat.getString("email"));
                client.setTelephone(resultat.getInt("telephone"));
                client.setAdresse(resultat.getString("adresse"));
                client.setCin(resultat.getInt("cin"));

                listeClients.add(client);
            }
            if(b==false)
                return null;
            return listeClients;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des clients " + ex.getMessage());
            return null;
        }
    }    

    @Override
    public boolean findClientByLogin_PWD(String login, String pwd) {
        String requete = "select * from client where login=? and pwd=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, login);
            ps.setString(2, pwd);

            ResultSet resultat = ps.executeQuery();
            
            return resultat.next();
       
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du administrateur" + ex.getMessage());
            return false;
        }
    }
    
    public int findIdClientByLogin_PWD(String log, String pwd) {
        
           String requete = "select * from client where login=? and pwd=?";
             int idClient=-1;
        try {
            boolean b=false;
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, log);
            ps.setString(2, pwd);

            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                b=true;
             idClient=resultat.getInt("idClient");

            }

                return idClient;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du client" + ex.getMessage());
            return -1;
        }
    }
}
