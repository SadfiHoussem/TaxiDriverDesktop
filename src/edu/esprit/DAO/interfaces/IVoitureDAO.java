/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Agence;
import edu.esprit.entities.Voiture;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IVoitureDAO {

    boolean isVoitureExist(Voiture v);
    boolean insertVoiture(Voiture voiture);
    boolean updateVoiture(Voiture voiture);
    boolean deleteVoiture(String matricule);
    Voiture findVoitureByMatricule(String matricule);
    List<Voiture> DisplayAllVoitures();
    List<Voiture> DisplayAllVoituresByAgence(int idAgence);
    List<Voiture> DisplayVoitureNAByAgence(Agence agence);
    List<Voiture> FindByMatriculeLike(String matricule);
    List<Voiture> FindByNbrPlaceLike(int nbrPlace);
    List<Voiture> FindByMarqueLike(String matricule);
}
