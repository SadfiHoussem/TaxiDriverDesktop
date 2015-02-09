/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import edu.esprit.entities.Voiture;
import edu.esprit.dao.classes.VoitureDAO;
import edu.esprit.dao.interfaces.IVoitureDAO;

/**
 *
 * @author chaimaBrini
 */
public class Pidev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Voiture v=new Voiture();
        v.setMatricule("00001tn");
      
     VoitureDAO.getInstance().deleteVoiture("00001tn");
      
    }
    
}
