/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.ResponsableAgence;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IResponsableAgenceDAO {
    
    boolean insertRespAgence(ResponsableAgence r);
    boolean deleteRespAgence(int idRespAgence);
    boolean updateRespAgence(ResponsableAgence r);
    boolean isRespAgenceExist(ResponsableAgence ra);
    boolean isRespAgenceExistUpdate(ResponsableAgence ra);
    ResponsableAgence findRespAgenceById(int idRespAgence);
    ResponsableAgence findRespAgenceByLogin(String loginRespAgence);
    List<ResponsableAgence> DisplayAllResponsableAgence();
}
