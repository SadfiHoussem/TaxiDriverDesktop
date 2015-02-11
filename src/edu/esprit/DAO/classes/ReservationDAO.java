/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.classes;

import edu.esprit.DAO.interfaces.IReservationDAO;
import edu.esprit.entities.Chauffeur;
import edu.esprit.entities.Reservation;
import edu.esprit.entities.Trajet;
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
          String requete="insert into reservation (idReservation,idClient,idTrajet,idChauffeur,idAgence) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
    
            ps.setString(1, r.getIdReservation());
            ps.setString(2, r.getClient().getIdClient());
            ps.setString(3, r.getTrajet().getIdTrajet());
            ps.setString(4, r.getChauffeur().getIdChauffeur());
            ps.setString(5, r.getAgence().getIdAgence());
    
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des réservations" + ex.getMessage());
          
            }
    }

    @Override
    public void deleteReservation(String idReservation) {
            String requete="delete from reservation where idReservation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, idReservation);
            
            ps.executeUpdate();
          
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de la réservation" + ex.getMessage());
            
            }
    }

    @Override
    public void updateTrajetReservation(String idReservation,Trajet trajet) {
            String requete="update offre set idTrajet=? where idReservation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, trajet.getIdTrajet());
            ps.setString(2, idReservation);
          
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour de réservation" + ex.getMessage());
            }
    }

    @Override
    public void updateChauffeurReservation(String idReservation,Chauffeur chauffeur) {
            String requete="update offre set idChauffeur=? where idReservation=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, chauffeur.getIdChauffeur());
            ps.setString(2, idReservation);
          
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour de réservation" + ex.getMessage());
            }
    }

    @Override
    public Reservation findReservationById(String idReservation) {
        String requete = "select * from reservation where idReservation=?";

        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            ClientDAO clientDAO = ClientDAO.getInstance();
            TaxiDAO taxiDAO = TaxiDAO.getInstance();
            TrajetDAO trajetDAO = TrajetDAO.getInstance();
            AgenceDAO agenceDAO = AgenceDAO.getInstance();
            Reservation reservation = new Reservation();
            while (resultat.next()) {

                reservation.setIdReservation(resultat.getString("idReservation"));
                reservation.setClient(clientDAO.findClientById(resultat.getString("idClient")));
                reservation.setTaxi(taxiDAO.findTaxiById(resultat.getString("idTaxi")));
                reservation.setTrajet(trajetDAO.findTrajetById(resultat.getString("idTrajet")));
                reservation.setAgence(agenceDAO.findAgenceById(resultat.getString("idAgence")));
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
                
                reservation.setIdReservation(resultat.getString("idReservation"));
                reservation.setClient(clientDAO.findClientById(resultat.getString("idClient")));
                reservation.setTaxi(taxiDAO.findTaxiById(resultat.getString("idTaxi")));
                reservation.setTrajet(trajetDAO.findTrajetById(resultat.getString("idTrajet")));
                reservation.setAgence(agenceDAO.findAgenceById(resultat.getString("idAgence")));
                reservation.setConfirme(resultat.getBoolean("confirme"));
                reservation.setNote(resultat.getInt("note"));
                
                listeReservations.add(reservation);
            }
            return listeReservations;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }
    
}
