
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Agence;
import java.util.List;

public interface IAgenceDAO {
    
    boolean isAgenceExist(Agence a);
    
    boolean isAgenceExistUpdate(Agence a);
    
    boolean insertAgence(Agence a);

    boolean updateAgence(Agence a);

    boolean deleteAgence(Agence a);
    
    Agence findAgenceById(int id);
    
    Agence findAgenceByRespAgence(int id);

    List<Agence> DisplayAllAgences();
    
}
