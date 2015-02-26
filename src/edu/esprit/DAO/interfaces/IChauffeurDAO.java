/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Agence;
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
    Chauffeur findChauffeurByLogin(String loginChauffeur);
    
    List<Chauffeur> FindByIdLike(int id);
    List<Chauffeur> FindByCinLike(int cin);
    List<Chauffeur> FindByNomLike(String nom);
    List<Chauffeur> FindByPrenomLike(String prenom);
    List<Chauffeur> FindByNPermisLike(int num);
    List<Chauffeur> FindByEmailLike(String email);
    List<Chauffeur> FindByTelLike(int tel);
    List<Chauffeur> FindByAdresseLike(String adresse);
    List<Chauffeur> FindByLoginLike(String login);
    
    boolean findChauffeurByLogin_PWD(String login,String pwd);
    
    List<Chauffeur> DisplayAllChauffeur();
    List<Chauffeur> DisplayAllChauffeurByAgence(Agence agence);
    List<Chauffeur> DisplayChauffeurNAByAgence(Agence agence);
    
    List<Reservation> consulterPlanning(Chauffeur c);
    public List<Reservation> consulterfeedbackClients(Chauffeur c);
    
}
