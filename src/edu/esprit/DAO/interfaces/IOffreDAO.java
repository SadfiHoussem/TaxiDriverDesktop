/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Offre;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IOffreDAO {
    
    boolean isOffreExist(int id);
    boolean insertOffre(Offre o);
    boolean deleteOffre(int idOffre);
    boolean updateOffre(Offre o);
    boolean updateSujetOffre(int idOffre,String sujetOffre);
    boolean updateContenuOffre(int idOffre,String contenu);
    Offre findOffreById(int id);
    List<Offre> DisplayAllOffres();
    ResultSet DisplayAllOffres2();
}
