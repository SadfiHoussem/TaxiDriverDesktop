/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;

import edu.esprit.DAO.classes.ChauffeurDAO;
import edu.esprit.entities.Chauffeur;
import edu.esprit.entities.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class PlanningChauffeur extends AbstractTableModel{
    
    String[] headers = {"Identifiant", "Agence", "Prenom Client", "Départ", "Destination", "Confirmation"};
    List<Reservation> reservations = new ArrayList<>();
    ChauffeurDAO chauffeurDAO;
    
        public PlanningChauffeur(Chauffeur c) {
        chauffeurDAO = ChauffeurDAO.getInstance();
        reservations = chauffeurDAO.consulterPlanning(c);
    }

    @Override
    public int getRowCount() {
        return reservations.size();
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
                return reservations.get(rowIndex).getIdReservation();
            case 1:
                return reservations.get(rowIndex).getAgence().getNomAgence();
            case 2:
                return reservations.get(rowIndex).getClient().getPrenom();
            case 3:
                return reservations.get(rowIndex).getTrajet().getAdresseDep();
            case 4:
                return reservations.get(rowIndex).getTrajet().getAdresseDest();
            case 5:
                return reservations.get(rowIndex).isConfirme();
            default:
                return null;
        }
    }
    
}
