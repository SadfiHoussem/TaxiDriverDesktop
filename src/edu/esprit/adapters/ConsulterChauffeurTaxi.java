/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;

import edu.esprit.entities.Chauffeur;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterChauffeurTaxi extends AbstractTableModel{

    String[] headers = {"Identifiant", "CIN", "Numéro Permis", "Nom", "Prenom","En Congé"};
    List<Chauffeur> chauffeurs;


    public ConsulterChauffeurTaxi(List<Chauffeur> listeChauffeur) {
        chauffeurs = listeChauffeur;
    }
    
    @Override
    public int getRowCount() {
        return chauffeurs.size();
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
                return chauffeurs.get(rowIndex).getIdChauffeur();
            case 1:
                return chauffeurs.get(rowIndex).getCin();
            case 2:
                return chauffeurs.get(rowIndex).getNumPermis();
            case 3:
                return chauffeurs.get(rowIndex).getNom();
            case 4:
                return chauffeurs.get(rowIndex).getPrenom();
            case 5:
                return chauffeurs.get(rowIndex).isConge();
            default:
                return null;
        }
    }
    
}
