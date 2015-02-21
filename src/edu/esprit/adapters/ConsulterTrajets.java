/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;



import edu.esprit.entities.Trajet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterTrajets extends AbstractTableModel{

    String[] headers = {"Identifiant", "Agence", "Adresse Départ", "Adresse Destination", "Cout"};
    List<Trajet> trajets = new ArrayList<>();

    public ConsulterTrajets(List<Trajet> listeTrajet) {
        trajets = listeTrajet;  
    }
    
    @Override
    public int getRowCount() {
        return trajets.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int i) {
        return headers[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return trajets.get(rowIndex).getIdTrajet();
            case 1:
                return trajets.get(rowIndex).getAgence().getNomAgence();
            case 3:
                return trajets.get(rowIndex).getAdresseDep();
            case 4:
                return trajets.get(rowIndex).getAdresseDest();
            case 5:
                if (trajets.get(rowIndex).getCout()==0)
                    return "None";
                return trajets.get(rowIndex).getCout();
            default:
                return null;
        }
    }
    
}

