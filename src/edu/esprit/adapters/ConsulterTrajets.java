/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;



import edu.esprit.DAO.classes.TrajetDAO;
import edu.esprit.entities.Trajet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterTrajets extends AbstractTableModel{

    String[] headers = {"Identifiant", "Client", "Responsable Agence", "Adresse Départ", "Adresse Destination", "Cout", "Fonctionnel"};
    List<Trajet> trajets = new ArrayList<>();
    TrajetDAO trajetDAO;

    public ConsulterTrajets() {
        trajetDAO = TrajetDAO.getInstance();
        trajets = trajetDAO.DisplayAllTrajets();
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
                return trajets.get(rowIndex).getClient().getNom();
            case 2:
                return trajets.get(rowIndex).getRespAgence().getNom();
            case 3:
                return trajets.get(rowIndex).getAdresseDep();
            case 4:
                return trajets.get(rowIndex).getAdresseDest();
            case 5:
                return trajets.get(rowIndex).getCout();
            case 6:
                return trajets.get(rowIndex).isEtat();
            default:
                return null;
        }
    }
    
}

