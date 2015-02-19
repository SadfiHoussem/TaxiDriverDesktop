/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Administrateur;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IAdministrateurDAO {
    
    void insertAdministrateur(Administrateur administrateur);
    void updateAdministrateur(Administrateur administrateur);
    void deleteAdministrateur(int id);
    Administrateur findAdministrateurById(String id);
    Administrateur findAdminByLogin(String loginChauffeur);
    boolean findAdministrateurByLogin_PWD(String log, String pwd);
    List<Administrateur> DisplayAllAdministrateurs();
    
    
}
