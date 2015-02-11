/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Offre;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IOffreDAO {
    
    boolean isOffreExist(String id);
    boolean insertOffre(Offre o);
    boolean deleteOffre(String idOffre);
    boolean updateOffre(Offre o);
    boolean updateSujetOffre(String idOffre,String sujetOffre);
    boolean updateContenuOffre(String idOffre,String contenu);
    Offre findOffreById(String id);
    List<Offre> DisplayAllOffres();
}
