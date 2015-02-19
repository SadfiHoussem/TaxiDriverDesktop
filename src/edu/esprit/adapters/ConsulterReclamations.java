/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;

import edu.esprit.entities.Reclamation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterReclamations extends AbstractTableModel{

    private final String[] headers = {"Identifiant","ID Client" ,"Client" , "Sujet", "Date", "Etat"};
    private List<Reclamation> reclamations;

    public ConsulterReclamations(List<Reclamation> reclamation) {
        reclamations=reclamation;
    }

    public List<Reclamation> getListeReclamations() {
        return reclamations;
    }
        
    @Override
    public int getRowCount() {
        return reclamations.size();
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
                return reclamations.get(rowIndex).getIdReclamation();
            case 1:
                return reclamations.get(rowIndex).getClient().getIdClient();
            case 2:
                return reclamations.get(rowIndex).getClient().getNom();
            case 3:
                return reclamations.get(rowIndex).getsujetReclamation();
            case 4:
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.format(reclamations.get(rowIndex).getDate());
            case 5:
                if(reclamations.get(rowIndex).isEtat())
                    return "Confirmée";
                else if(!reclamations.get(rowIndex).isEtat())
                    return "En attente";
            default:
                return null;
        }
    }
    
}
