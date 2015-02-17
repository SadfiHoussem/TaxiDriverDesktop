/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Chauffeur;
import edu.esprit.entities.Reservation;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IChauffeurDAO {
    
    boolean isChauffeurExist(Chauffeur c);
    boolean isChauffeurExistUpdate(Chauffeur c);
    boolean insertChauffeur(Chauffeur c);
    boolean updateChauffeur(Chauffeur c);
    boolean deleteChauffeur(int id);
    Chauffeur findChauffeurById(int id);
    List<Chauffeur> DisplayAllChauffeur();
    
    List<Reservation> consulterPlanning(Chauffeur c);
    public List<Reservation> consulterfeedbackClients(Chauffeur c);
    
}
