/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;

import edu.esprit.entities.Offre;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterOffres extends AbstractTableModel{

    String[] headers = {"Identifiant","Sujet","Date"};
    List<Offre> offres;

    public ConsulterOffres(List<Offre> offres) {
        this.offres=offres;
    }
    
    @Override
    public int getRowCount() {
        return offres.size();
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
                return offres.get(rowIndex).getIdOffre();
            case 1:
                return offres.get(rowIndex).getSujetOffre();
            case 2:
                return offres.get(rowIndex).getDate();
            default:
                return null;
        }
    }
    
}
