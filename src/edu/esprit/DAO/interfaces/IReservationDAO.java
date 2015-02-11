/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Chauffeur;
import edu.esprit.entities.Client;
import edu.esprit.entities.Agence;
import edu.esprit.entities.Reservation;
import edu.esprit.entities.Trajet;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IReservationDAO {
    

    void insertReservation(Reservation r);
    void deleteReservation(String idReservation);
    void updateTrajetReservation(String idReservation,Trajet trajet);
    void updateChauffeurReservation(String idReservation,Chauffeur chauffeur);
    Reservation findReservationById(String idReservation);

    List<Reservation> DisplayAllReservation();

}
