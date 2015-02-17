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
    
    boolean isTrajetExist(Trajet t);
    boolean insertTrajet(Trajet t);
    boolean updateTrajet(Trajet t);
    void confirmeTrajet(int idTrajet);
    void deleteTrajet(int id);
    Trajet findTrajetById(int id);
    List<Trajet> DisplayAllTrajets();
    
}
