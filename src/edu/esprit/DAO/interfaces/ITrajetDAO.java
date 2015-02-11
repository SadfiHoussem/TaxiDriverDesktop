/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Trajet;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface ITrajetDAO {
    
    void insertTrajet(Trajet t);
    void updateTrajet(Trajet t);
    void deleteTrajet(String id);
    Trajet findTrajetById(String id);
    List<Trajet> DisplayAllTrajets();
    
}
