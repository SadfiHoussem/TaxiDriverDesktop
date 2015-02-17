/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;

import edu.esprit.DAO.classes.ReclamationDAO;
import edu.esprit.entities.Reclamation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterReclamations extends AbstractTableModel{

    private final String[] headers = {"Identifiant","Client" , "Sujet", "Etat"};
    private List<Reclamation> reclamations = new ArrayList<>();
    ReclamationDAO reclamationDAO;

    public ConsulterReclamations() {
        reclamationDAO = ReclamationDAO.getInstance();
        reclamations = reclamationDAO.DisplayAllReclamations();
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
                return reclamations.get(rowIndex).getClient().getNom();
            case 2:
                return reclamations.get(rowIndex).getsujetReclamation();
            case 3:
                return reclamations.get(rowIndex).isEtat();
            default:
                return null;
        }
    }
    
}
