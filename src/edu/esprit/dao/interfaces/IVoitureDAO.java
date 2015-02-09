/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.entities.Voiture;

/**
 *
 * @author amina jebari
 */
public interface IVoitureDAO {
 



  void insertVoiture(Voiture voiture);

    void updateVoiture(Voiture voiture);

    void deleteVoiture(String matricule);

    Voiture selectVoiture(String matricule);

}

   
