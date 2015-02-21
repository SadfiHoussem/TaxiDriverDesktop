/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;

import edu.esprit.DAO.classes.ChauffeurDAO;
import edu.esprit.entities.Chauffeur;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterChauffeurs extends AbstractTableModel{

    String[] headers = {"Identifiant","Login" , "CIN", "Numéro Permis", "Nom", "Prenom", "Telephone", "Email", "Adresse", "Etat"};
    List<Chauffeur> chauffeurs = new ArrayList<>();
    ChauffeurDAO chauffeurDAO;

    public ConsulterChauffeurs() {
        chauffeurDAO = ChauffeurDAO.getInstance();
        chauffeurs = chauffeurDAO.DisplayAllChauffeur();
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
                return chauffeurs.get(rowIndex).getLogin();
            case 2:
                return chauffeurs.get(rowIndex).getCin();
            case 3:
                return chauffeurs.get(rowIndex).getNumPermis();
            case 4:
                return chauffeurs.get(rowIndex).getNom();
            case 5:
                return chauffeurs.get(rowIndex).getPrenom();
            case 6:
                return chauffeurs.get(rowIndex).getTelephone();
            case 7:
                return chauffeurs.get(rowIndex).getEmail();
            case 8:
                return chauffeurs.get(rowIndex).getAdresse();
            case 9:
                return chauffeurs.get(rowIndex).isConge();
            default:
                return null;
        }
    }
    
}
