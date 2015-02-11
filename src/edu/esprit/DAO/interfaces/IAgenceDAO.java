
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Agence;
import java.util.List;

public interface IAgenceDAO {
    
    boolean isAgenceExist(String idAgence);
    
    boolean insertAgence(Agence a);

    boolean updateAgence(Agence a);

    boolean deleteAgence(String id);
    
    Agence findAgenceById(String id);

    List<Agence> DisplayAllAgences();
    
}
