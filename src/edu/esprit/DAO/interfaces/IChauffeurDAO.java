/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Chauffeur;
import edu.esprit.entities.Client;
import edu.esprit.entities.Reservation;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IChauffeurDAO {
    
    boolean isChauffeurExist(String id,Long cin,String numPermis,String login,String email,int telephone);
    boolean insertChauffeur(Chauffeur c);
    boolean updateChauffeur(Chauffeur c);
    boolean deleteChauffeur(String id);
    Chauffeur findChauffeurById(String id);
    List<Chauffeur> DisplayAllChauffeur();
    
    List<Reservation> consulterPlanning(Chauffeur c);
    public List<Reservation> consulterfeedbackClients(Chauffeur c);
    
}
