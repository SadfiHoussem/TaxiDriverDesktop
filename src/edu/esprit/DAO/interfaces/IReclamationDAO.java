/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Reclamation;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IReclamationDAO {
    
    void insertReclamation(Reclamation reclamation);
    void updateReclamation(Reclamation reclamation);
    void deleteReclamation(String id);
    Reclamation findReclamationById(String id);
    List<Reclamation> DisplayAllReclamations();
    
}
