/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

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
}
