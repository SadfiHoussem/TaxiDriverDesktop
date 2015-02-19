/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Reservation;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IReservationDAO {
    

    void insertReservation(Reservation r);
    void deleteReservation(int idReservation);
    void updateTrajetReservation(Reservation r);
    void updateChauffeurReservation(Reservation r);
    void confirmerReservation(Reservation r);
    Reservation findReservationById(int idReservation);

    List<Reservation> DisplayAllReservation();
    List<Reservation> DisplayReservationsConfirme(boolean b);
    ResultSet DisplayFeedbackByChauffeur(String login);
    ResultSet DisplayAllReservationByChauffeur(String login);
}
