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
    
    boolean isReclamationExist(Reclamation r);
    Boolean insertReclamation(Reclamation reclamation);
    Boolean updateReclamation(Reclamation reclamation);
    Boolean updateReclamationRespAgence(Reclamation reclamation);
    Boolean deleteReclamation(Reclamation reclamation);
    Reclamation findReclamationById(int id);
    List<Reclamation> DisplayAllReclamations();
    
}
