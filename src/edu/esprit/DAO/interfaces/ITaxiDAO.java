/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Taxi;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface ITaxiDAO {
    
    void insertTaxi(Taxi taxi);
    void updateTaxi(Taxi taxi);
    void deleteTaxi(int id);
    Taxi findTaxiById(int id);
    List<Taxi> DisplayAllTaxi();
    List<Taxi> DisplayAllTaxiByAgence(int idAgence);
}
