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
    void deleteTaxi(String id);
    Taxi findTaxiById(String id);
    List<Taxi> DisplayAllTaxi();
}
