/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;

import edu.esprit.DAO.classes.AgenceDAO;
import edu.esprit.entities.Agence;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterAgences extends AbstractTableModel{

    String[] headers = {"ID Agence","Nom Agence","ID Responsable","Nom Responsable","Telephone","Adresse"};
    List<Agence> Agences = new ArrayList<>();
    AgenceDAO AgenceDAO;

    public ConsulterAgences() {
    AgenceDAO = AgenceDAO.getInstance();
        Agences = AgenceDAO.DisplayAllAgences();
    }
    
    @Override
    public int getRowCount() {
        return Agences.size();
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
                return Agences.get(rowIndex).getIdAgence();
            case 1:
                return Agences.get(rowIndex).getNomAgence();
            case 2:
                return Agences.get(rowIndex).getRespAgence().getIdResponsableAgence();
            case 3:
                return Agences.get(rowIndex).getRespAgence().getNom();
            case 4:
                return Agences.get(rowIndex).getTelAgence();
            case 5:
                return Agences.get(rowIndex).getAdresseAgence();
          
            default:
                return null;
        }
    }
    
}
