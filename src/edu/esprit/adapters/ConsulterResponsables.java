/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;

import edu.esprit.DAO.classes.ResponsableAgenceDAO;
import edu.esprit.entities.ResponsableAgence;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterResponsables extends AbstractTableModel{

    String[] headers = {"Identifiant","Login" ,"Password", "CIN","Nom","Prenom", "Telephone", "Email", "Adresse"};
    List<ResponsableAgence> Responsables = new ArrayList<>();
    ResponsableAgenceDAO   ResponsableAgenceDAO;

    public ConsulterResponsables() {
          ResponsableAgenceDAO =   ResponsableAgenceDAO.getInstance();
       Responsables =   ResponsableAgenceDAO.DisplayAllResponsableAgence();
    }
    
    @Override
    public int getRowCount() {
        return Responsables.size();
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
                return  Responsables.get(rowIndex).getIdResponsableAgence();
            case 1:
                return  Responsables.get(rowIndex).getLogin();
            case 2:
                return  Responsables.get(rowIndex).getPwd();
            case 3:
                return  Responsables.get(rowIndex).getCin();
            case 4:
                return  Responsables.get(rowIndex).getNom();
            case 5:
                return  Responsables.get(rowIndex).getPrenom();
            case 6:
                return  Responsables.get(rowIndex).getTelephone();
            case 7:
                return  Responsables.get(rowIndex).getEmail();
            case 8:
                return  Responsables.get(rowIndex).getAdresse();
            
            default:
                return null;
        }
    }
    
}
