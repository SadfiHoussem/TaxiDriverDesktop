/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IReservationDAO;
import edu.esprit.entities.Reservation;
import edu.esprit.technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Houssem
 */
public class ReservationDAO implements IReservationDAO{

     private final Connection conn;
     private static ReservationDAO reservationDAO;

    private ReservationDAO() {
        conn = MyConnection.getInstance();
    }

    public static ReservationDAO getInstance() {
        if (reservationDAO == null) {
            reservationDAO = new ReservationDAO();
        }
        return reservationDAO;
    }
    
    @Override
    public void insertReservation(Reservation r) {
          String requete="insert into reservation (idClient,idTaxi,idTrajet,idAgence,confirme,note,date) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);

            ps.setInt(1, r.getClient().getIdClient());
            ps.setInt(2, r.getTaxi().getIdTaxi());
            ps.setInt(3, r.getTrajet().getIdTrajet());
            ps.setInt(4, r.getAgence().getIdAgence());
            ps.setBoolean(5, r.isConfirme());
            ps.setInt(6, r.getNote());
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(r.getDate().getTime());
            ps.setTimestamp(7, sqlTimestamp );
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'ajout de la réservation" + ex.getMessage());
          
            }
    }

    @Override
    public void deleteReservation(int idReservation) {
            String requete="delete from reservation where idReservation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, idReservation);
            
            ps.executeUpdate();
          
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de la réservation" + ex.getMessage());
            }
    }

    @Override
    public void updateTrajetReservation(Reservation r) {
            String requete="update offre set idTrajet=? where idReservation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, r.getTrajet().getIdTrajet());
            ps.setInt(2, r.getIdReservation());
          
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour de réservation" + ex.getMessage());
            }
    }

    @Override
    public void updateChauffeurReservation(Reservation r) {
            String requete="update offre set idChauffeur=? where idReservation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, r.getChauffeur().getIdChauffeur());
            ps.setInt(2, r.getIdReservation());
          
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour de réservation" + ex.getMessage());
            }
    }
    
    @Override
    public void confirmerReservation(Reservation r) {
            String requete="update reservation set confirme=? where idReservation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setBoolean(1, true);
            ps.setInt(2, r.getIdReservation());
          
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour de réservation" + ex.getMessage());
            }
    }

    @Override
    public Reservation findReservationById(int idReservation) {
        String requete = "select * from reservation where idReservation=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, idReservation);
            ResultSet resultat = ps.executeQuery();
            ClientDAO clientDAO = ClientDAO.getInstance();
            TaxiDAO taxiDAO = TaxiDAO.getInstance();
            TrajetDAO trajetDAO = TrajetDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            Reservation reservation = new Reservation();
            while (resultat.next()) {

                reservation.setIdReservation(resultat.getInt("idReservation"));
                reservation.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                reservation.setTaxi(taxiDAO.findTaxiById(resultat.getInt("idTaxi")));
                reservation.setTrajet(trajetDAO.findTrajetById(resultat.getInt("idTrajet")));
                reservation.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                reservation.setConfirme(resultat.getBoolean("confirme"));
                reservation.setNote(resultat.getInt("note"));
            }
            return reservation;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de reservation" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Reservation> DisplayAllReservation() {
        List<Reservation> listeReservations = new ArrayList<>();

        String requete = "select * from reservation";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            ClientDAO clientDAO = ClientDAO.getInstance();
            TaxiDAO taxiDAO = TaxiDAO.getInstance();
            TrajetDAO trajetDAO = TrajetDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            
            while (resultat.next()) {
                Reservation reservation = new Reservation();
                
                reservation.setIdReservation(resultat.getInt("idReservation"));
                reservation.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                reservation.setTaxi(taxiDAO.findTaxiById(resultat.getInt("idTaxi")));
                reservation.setTrajet(trajetDAO.findTrajetById(resultat.getInt("idTrajet")));
                reservation.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                reservation.setConfirme(resultat.getBoolean("confirme"));
                reservation.setNote(resultat.getInt("note"));
                reservation.setDate(resultat.getDate("date"));
                
                listeReservations.add(reservation);
            }
            return listeReservations;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Reservation> DisplayReservationsConfirme(boolean b) {
        List<Reservation> listeReservations = new ArrayList<>();

        String requete = "select * from reservation where confirme=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setBoolean(1, b);
            ResultSet resultat = ps.executeQuery();
            ClientDAO clientDAO = ClientDAO.getInstance();
            TaxiDAO taxiDAO = TaxiDAO.getInstance();
            TrajetDAO trajetDAO = TrajetDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            
            while (resultat.next()) {
                Reservation reservation = new Reservation();
                
                reservation.setIdReservation(resultat.getInt("idReservation"));
                reservation.setClient(clientDAO.findClientById(resultat.getInt("idClient")));
                reservation.setTaxi(taxiDAO.findTaxiById(resultat.getInt("idTaxi")));
                reservation.setTrajet(trajetDAO.findTrajetById(resultat.getInt("idTrajet")));
                reservation.setAgence(agenceDAO.findAgenceById(resultat.getInt("idAgence")));
                reservation.setConfirme(resultat.getBoolean("confirme"));
                reservation.setNote(resultat.getInt("note"));
                reservation.setDate(resultat.getDate("date"));
                
                listeReservations.add(reservation);
            }
            return listeReservations;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }
    
     @Override
    public ResultSet DisplayAllReservationByChauffeur(String login) {

        String requete = "select adresseDep as 'Adresse de départ', adresseDest as 'Adresse de destination' , cout as 'Coût', Date, chauffeur.login from reservation, taxi, chauffeur, trajet where reservation.idTrajet=trajet.idTrajet and taxi.idChauffeur=chauffeur.idChauffeur and taxi.idTaxi=reservation.idTaxi and Date >= CURRENT_DATE and chauffeur.login='"+login+"' ";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
           
            return resultat;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    
    }

     @Override
    public ResultSet DisplayFeedbackByChauffeur(String login) {

    
        String requete = "select note, client.prenom, chauffeur.login from reservation, taxi, client, chauffeur, trajet where reservation.idClient=client.idClient and reservation.idTrajet=trajet.idTrajet and taxi.idChauffeur=chauffeur.idChauffeur and taxi.idTaxi=reservation.idTaxi and chauffeur.login='"+login+"' ";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
           
            return resultat;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }
    
//     public void insertReservation2(Reservation r) {
//          String requete="insert into reservation (idClient,idTaxi,idTrajet,idAgence,confirme,note,date) values (?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement ps = conn.prepareStatement(requete);
//    
//            ps.setInt(1, r.getClient().getIdClient());
//            ps.setInt(2, r.getTaxi().getIdTaxi());
//
//            ps.setInt(3, r.getTrajet().getIdTrajet());
//            ps.setInt(4, r.getAgence().getIdAgence());
//            ps.setInt(5, 0);
//            ps.setInt(6, r.getNote());
//            
//            
//            ps.executeUpdate();
//            
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de l'ajout de la réservation" + ex.getMessage());
//          
//            }
//    }
     
     public ResultSet DisplayReservationByIdClient(int id) {

        String requete = "select r.idReservation as 'numéro de la réservation', a.nomAgence as 'nom de lagence', t.adresseDep as 'adresse de depart', t.adresseDest as 'adresse de destination', c.nom as 'nom du chauffeur' , c.prenom as 'prénom du chauffeur' , r.date as 'date de la réservation' , r.confirme as ' confirmation' from reservation r,trajet t,agence a,taxi ta,chauffeur c  where r.idTrajet=t.idTrajet and a.idAgence=r.idAgence and ta.idTaxi=r.idTaxi and ta.idChauffeur=c.idChauffeur and idClient="+id;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
        
          
            return resultat;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des réservations " + ex.getMessage());
            return null;
        } 
        }
    
}
