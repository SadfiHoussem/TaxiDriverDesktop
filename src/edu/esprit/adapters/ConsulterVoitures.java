/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;


import edu.esprit.DAO.classes.VoitureDAO;
import edu.esprit.entities.Voiture;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterVoitures extends AbstractTableModel{

    String[] headers = {"Matricule", "Agence", "Nombre Places", "Marque", "Disponibilité"};
    List<Voiture> voitures = new ArrayList<>();
    VoitureDAO voitureDAO;

    public ConsulterVoitures() {
        voitureDAO = VoitureDAO.getInstance();
        voitures = voitureDAO.DisplayAllVoitures();
    }
    
    @Override
    public int getRowCount() {
        return voitures.size();
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
                return voitures.get(rowIndex).getMatricule();
            case 1:
                return voitures.get(rowIndex).getAgence().getNomAgence();
            case 2:
                return voitures.get(rowIndex).getNbrPlace();
            case 3:
                return voitures.get(rowIndex).getTypeVoiture();
            case 4:
                return voitures.get(rowIndex).isEtat();
            default:
                return null;
        }
    }
    
}
