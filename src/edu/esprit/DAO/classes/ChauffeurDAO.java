/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IChauffeurDAO;
import edu.esprit.entities.Agence;
import edu.esprit.entities.Chauffeur;
import edu.esprit.entities.Reservation;
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

public class ChauffeurDAO implements IChauffeurDAO{

    private Connection conn;
    private static ChauffeurDAO chauffeurDAO;
    
    private ChauffeurDAO() {
        conn = MyConnection.getInstance();
    }

    public static ChauffeurDAO getInstance() {
        if (chauffeurDAO == null) {
            chauffeurDAO = new ChauffeurDAO();
        }
        return chauffeurDAO;
    }

    @Override
    public boolean isChauffeurExist(Chauffeur c) {
    String requete = "select * from chauffeur where telephone=? and numPermis=? and login=? and email=? and cin=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);

            ps.setInt(1, c.getTelephone());
            ps.setString(2, c.getNumPermis());
            ps.setString(3, c.getLogin());
            ps.setString(4, c.getEmail());
            ps.setLong(5, c.getCin());
            
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du chauffeur" + ex.getMessage());
            return false;
        }
                
    }
    
       @Override
    public boolean isChauffeurExistUpdate(Chauffeur c) {
    String requete = "select * from chauffeur where login=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);

            ps.setString(1, c.getLogin());
            
            ResultSet resultat = ps.executeQuery();
            return resultat.next();
        }
        catch (SQLException ex) {
            System.out.println("erreur lors du chargement du chauffeur" + ex.getMessage());
            return false;
        }
                
    }
    
    @Override
    public boolean insertChauffeur(Chauffeur c) {
        if(isChauffeurExist(c))
            return false;
            
            String requete = "insert into chauffeur (numPermis,etat,login,pwd,nom,prenom,email,telephone,adresse,cin,idAgence) values (?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = conn.prepareStatement(requete);
                
                ps.setString(1, c.getNumPermis());
                ps.setBoolean(2, c.isConge());
                ps.setString(3, c.getLogin());
                ps.setString(4, c.getPwd());
                ps.setString(5, c.getNom());
                ps.setString(6, c.getPrenom());
                ps.setString(7, c.getEmail());
                ps.setInt(8, c.getTelephone());
                ps.setString(9, c.getAdresse());
                ps.setLong(10, c.getCin());
                ps.setInt(11, c.getAgence().getIdAgence());
                ps.executeUpdate();
                System.out.println("Ajout effectuée avec succès");
                return true;
                } catch (SQLException ex) {
                //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erreur lors de l'insertion chauffeur" + ex.getMessage());
                return false;
                }
    }
    
    @Override
    public boolean updateChauffeur(Chauffeur c) {
        
        if(!isChauffeurExistUpdate(c))
            return false;
        String requete = "update chauffeur set numPermis=?, nom=?, prenom=?, email=?, telephone=?, adresse=?, cin=?,etat=?,idAgence=? where login=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
            ps.setString(1, c.getNumPermis());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getPrenom());
            ps.setString(4, c.getEmail());
            ps.setInt(5, c.getTelephone());
            ps.setString(6, c.getAdresse());
            ps.setLong(7, c.getCin());
            ps.setBoolean(8, c.isConge());
            ps.setInt(9, c.getAgence().getIdAgence());
            ps.setString(10, c.getLogin());
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            return true;
        }
    }

    @Override
    public boolean deleteChauffeur(int id) {
        Chauffeur c = findChauffeurById(id);
        if(!isChauffeurExist(c)){
            return false;
        }
            
        String requete = "delete from chauffeur where idChauffeur=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression chauffeur" + ex.getMessage());
            return false;
        }
    }
    
    @Override
    public Chauffeur findChauffeurById(int id) {

        String requete = "select * from chauffeur where idChauffeur=?";

        try {
            boolean b=false;
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
     
            Chauffeur chauffeur = new Chauffeur();
            while (resultat.next()) {
                b=true;
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));
                
            }
            if (b==false)
                return null;
            return chauffeur;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du chauffeur" + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public Chauffeur findChauffeurByLogin(String loginChauffeur) {
        String requete="select * from chauffeur where login=?";
            try {
                boolean b=false;
                PreparedStatement ps = conn.prepareStatement(requete);
                ps.setString(1, loginChauffeur);
                ResultSet resultat = ps.executeQuery();
                Chauffeur chauffeur = new Chauffeur();

                while (resultat.next()) {
                    b=true;
                    chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                    chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                    chauffeur.setNumPermis(resultat.getString("numPermis"));
                    chauffeur.setConge(resultat.getBoolean("etat"));
                    chauffeur.setLogin(resultat.getString("login"));
                    chauffeur.setPwd(resultat.getString("pwd"));
                    chauffeur.setNom(resultat.getString("nom"));
                    chauffeur.setPrenom(resultat.getString("prenom"));
                    chauffeur.setEmail(resultat.getString("email"));
                    chauffeur.setTelephone(resultat.getInt("telephone"));
                    chauffeur.setAdresse(resultat.getString("adresse"));
                    chauffeur.setCin(resultat.getInt("cin"));
                }
                if(b==false){
                return null;
            }
                return chauffeur;
            } catch (SQLException ex) {
                System.out.println("erreur lors de la recherche du chauffeur" + ex.getMessage());
                return null;
            }
        }
   

    @Override
    public List<Chauffeur> DisplayAllChauffeur() {
        
        List<Chauffeur> listeChauffeurs = new ArrayList<>();
        
        String requete = "select * from chauffeur";
        try {
            boolean b=false;
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
                
            while (resultat.next()) {
                b=true;
                Chauffeur chauffeur = new Chauffeur();

                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));

                listeChauffeurs.add(chauffeur);
            }
            if(b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Chauffeur> DisplayAllChauffeurByAgence(Agence agence) {
        
        List<Chauffeur> listeChauffeurs = new ArrayList<>();
        
        String requete = "select * from chauffeur where idAgence='"+agence.getIdAgence()+"'";
        try {
            boolean b=false;
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                b=true;
                Chauffeur chauffeur = new Chauffeur();
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(agence);
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));
                
                
                listeChauffeurs.add(chauffeur);
            }
            if(b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    }

//    @Override
//    public List<Chauffeur> DisplayChauffeurByAgenceNA(int idAgence) {
//        
//        List<Chauffeur> listeChauffeurs = new ArrayList<>();
//        
//        String requete = "select * from taxi t,voiture v where idAgence='"+idAgence+"' and not(t.matricule=v.matricule)";
//        try {
//            boolean b=false;
//            Statement statement = conn.createStatement();
//            ResultSet resultat;
//            resultat = statement.executeQuery(requete);
//                
//            while (resultat.next()) {
//                b=true;
//                Chauffeur chauffeur =ChauffeurDAO.getInstance().findChauffeurById(resultat.getInt("idChauffeur"));
//                
//                /*
//                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
//                chauffeur.setNumPermis(resultat.getString("numPermis"));
//                chauffeur.setLogin(resultat.getString("login"));
//                chauffeur.setPwd(resultat.getString("pwd"));
//                chauffeur.setNom(resultat.getString("nom"));
//                chauffeur.setPrenom(resultat.getString("prenom"));
//                chauffeur.setEmail(resultat.getString("email"));
//                chauffeur.setTelephone(resultat.getInt("telephone"));
//                chauffeur.setAdresse(resultat.getString("adresse"));
//                chauffeur.setCin(resultat.getInt("cin"));
//                chauffeur.setConge(resultat.getBoolean("etat"));
//                */
//                
//                listeChauffeurs.add(chauffeur);
//            }
//            if(b==false)
//                return null;
//            return listeChauffeurs;
//        } catch (SQLException ex) {
//            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
//            return null;
//        }
//    }
    
    @Override
    public List<Chauffeur> DisplayChauffeurNAByAgence(Agence agence) {
        
        List<Chauffeur> listeChauffeurs = new ArrayList<>();
        
        String requete="SELECT DISTINCT(c1.idChauffeur) FROM chauffeur c1 LEFT JOIN taxi t2 on c1.idChauffeur = t2.idChauffeur WHERE t2.idChauffeur IS NULL and c1.idAgence="+agence.getIdAgence();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Chauffeur chauffeur;
                
                chauffeur=ChauffeurDAO.getInstance().findChauffeurById(resultat.getInt("idChauffeur"));
                
                listeChauffeurs.add(chauffeur);
            }
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Chauffeurs " + ex.getMessage());
            return null;
        }
    }

    
    @Override
    public List<Reservation> consulterPlanning(Chauffeur c) {
        
        String requete="select * from reservation r,taxi t where t.idChauffeur=?";
        try {
            boolean b=false;
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, c.getIdChauffeur());
            ResultSet resultat = ps.executeQuery();
            List<Reservation> listeReservations=new ArrayList<>();
            ClientDAO clientDAO = ClientDAO.getInstance();
            TaxiDAO taxiDAO = TaxiDAO.getInstance();
            TrajetDAO trajetDAO = TrajetDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            while (resultat.next()) {
                b=true;
                Reservation reservation = new Reservation();
                reservation.setIdReservation(resultat.getInt("idReservation"));
                reservation.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                reservation.setTaxi(taxiDAO.findTaxiById(resultat.getInt("idTaxi")));
                reservation.setTrajet(trajetDAO.findTrajetById(resultat.getInt("idTrajet")));
                reservation.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                reservation.setConfirme(resultat.getBoolean("confirme"));
                reservation.setNote(resultat.getInt("note"));
                listeReservations.add(reservation);
            }
            if(b==false)
                return null;
            return listeReservations;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du planning" + ex.getMessage());
            return null;
            }
    }
    
    @Override
    public List<Reservation> consulterfeedbackClients(Chauffeur c) {
        
        String requete="select * from reservation r , taxi t where idChauffeur=?";
        try {
            boolean b=false;
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, c.getIdChauffeur());
            ResultSet resultat = ps.executeQuery();
            List<Reservation> listeReservations=new ArrayList<>();
            ClientDAO clientDAO = ClientDAO.getInstance();
            TaxiDAO taxiDAO = TaxiDAO.getInstance();
            TrajetDAO trajetDAO = TrajetDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            while (resultat.next()) {
                b=true;
                Reservation reservation = new Reservation();
                reservation.setIdReservation(resultat.getInt("idReservation"));
                reservation.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                reservation.setTaxi(taxiDAO.findTaxiById(resultat.getInt("idTaxi")));
                reservation.setTrajet(trajetDAO.findTrajetById(resultat.getInt("idTrajet")));
                reservation.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                reservation.setConfirme(resultat.getBoolean("confirme"));
                reservation.setNote(resultat.getInt("note"));
                
                listeReservations.add(reservation);
            }
            if(b==false)
                return null;
            return listeReservations;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des données " + ex.getMessage());
            return null;
            }
    }

    @Override
    public boolean findChauffeurByLogin_PWD(String login, String pwd) {
        String requete = "select * from chauffeur where login=? and pwd=?";

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
    
    public ResultSet DisplayAllChauffeurTypeResultSet() {
    
    
        String requete = "select nom, prenom, email, adresse, telephone from chauffeur";
        try {
            boolean b=false;
            Statement statement = conn.createStatement();
            ResultSet resultat;
            resultat = statement.executeQuery(requete);
                
           
          
            return resultat;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    
    
    }

    @Override
    public List<Chauffeur> FindByIdLike(int id) {
        List<Chauffeur> listeChauffeurs = new ArrayList<>();

        String requete = "select * from chauffeur where idChauffeur LIKE '"+id+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Chauffeur chauffeur = new Chauffeur();
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));

                listeChauffeurs.add(chauffeur);
            }
            if (b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Chauffeur> FindByCinLike(int cin) {
        List<Chauffeur> listeChauffeurs = new ArrayList<>();

        String requete = "select * from chauffeur where cin LIKE '"+cin+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Chauffeur chauffeur = new Chauffeur();
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));

                listeChauffeurs.add(chauffeur);
            }
            if (b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Chauffeur> FindByNomLike(String nom) {
        List<Chauffeur> listeChauffeurs = new ArrayList<>();

        String requete = "select * from chauffeur where nom  LIKE '"+nom+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Chauffeur chauffeur = new Chauffeur();
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));

                listeChauffeurs.add(chauffeur);
            }
            if (b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Chauffeur> FindByPrenomLike(String prenom) {
        List<Chauffeur> listeChauffeurs = new ArrayList<>();

        String requete = "select * from chauffeur where prenom LIKE '"+prenom+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Chauffeur chauffeur = new Chauffeur();
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));

                listeChauffeurs.add(chauffeur);
            }
            if (b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Chauffeur> FindByNPermisLike(int num) {
        List<Chauffeur> listeChauffeurs = new ArrayList<>();

        String requete = "select * from chauffeur where numPermis LIKE '"+num+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Chauffeur chauffeur = new Chauffeur();
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));

                listeChauffeurs.add(chauffeur);
            }
            if (b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Chauffeur> FindByEmailLike(String email) {
        List<Chauffeur> listeChauffeurs = new ArrayList<>();

        String requete = "select * from chauffeur where email LIKE '"+email+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Chauffeur chauffeur = new Chauffeur();
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));

                listeChauffeurs.add(chauffeur);
            }
            if (b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Chauffeur> FindByTelLike(int tel) {
        List<Chauffeur> listeChauffeurs = new ArrayList<>();

        String requete = "select * from chauffeur where telephone LIKE '"+tel+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Chauffeur chauffeur = new Chauffeur();
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));

                listeChauffeurs.add(chauffeur);
            }
            if (b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Chauffeur> FindByAdresseLike(String adresse) {
        List<Chauffeur> listeChauffeurs = new ArrayList<>();

        String requete = "select * from chauffeur where adresse LIKE '"+adresse+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Chauffeur chauffeur = new Chauffeur();
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));

                listeChauffeurs.add(chauffeur);
            }
            if (b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Chauffeur> FindByLoginLike(String login) {
        List<Chauffeur> listeChauffeurs = new ArrayList<>();

        String requete = "select * from chauffeur where login LIKE '"+login+"%'";
        
        boolean b=false;
        try {
            b=true;
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Chauffeur chauffeur = new Chauffeur();
                
                chauffeur.setIdChauffeur(resultat.getInt("idChauffeur"));
                chauffeur.setAgence(AgenceDAO.getInstance().findAgenceById(resultat.getInt("idAgence")));
                chauffeur.setNumPermis(resultat.getString("numPermis"));
                chauffeur.setLogin(resultat.getString("login"));
                chauffeur.setPwd(resultat.getString("pwd"));
                chauffeur.setNom(resultat.getString("nom"));
                chauffeur.setPrenom(resultat.getString("prenom"));
                chauffeur.setEmail(resultat.getString("email"));
                chauffeur.setTelephone(resultat.getInt("telephone"));
                chauffeur.setAdresse(resultat.getString("adresse"));
                chauffeur.setCin(resultat.getInt("cin"));
                chauffeur.setConge(resultat.getBoolean("etat"));

                listeChauffeurs.add(chauffeur);
            }
            if (b==false)
                return null;
            return listeChauffeurs;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des chauffeurs " + ex.getMessage());
            return null;
    
        }
    }
    
    
}
