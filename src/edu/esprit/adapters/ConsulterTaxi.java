/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;



import edu.esprit.entities.Taxi;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterTaxi extends AbstractTableModel{

    String[] headers = {"Identifiant", "CIN", "Nom", "Prenom", "Numéro Permis","Matricule","Marque", "Nombre Places"};
    List<Taxi> taxis;
    
    public ConsulterTaxi(List<Taxi> listeTaxi) {
        taxis=listeTaxi;
    }
    
    @Override
    public int getRowCount() {
        return taxis.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int i) {
        return headers[i];
    }
    // "Identifiant", "CIN", "Nom Chauffeur", "Prenom Chauffeur", "Numéro Permis","Matricule","Marque", "Nombre Places"
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return taxis.get(rowIndex).getIdTaxi();
                case 1:
                    return taxis.get(rowIndex).getChauffeur().getCin();
                case 2:
                    return taxis.get(rowIndex).getChauffeur().getNom();
                case 3:
                    return taxis.get(rowIndex).getChauffeur().getPrenom();
                case 4:
                    return taxis.get(rowIndex).getChauffeur().getNumPermis();
                case 5:
                    return taxis.get(rowIndex).getVoiture().getMatricule();
                case 6:
                    return taxis.get(rowIndex).getVoiture().getTypeVoiture();
                case 7:
                    return taxis.get(rowIndex).getVoiture().getNbrPlace();
                default:
                    return null;
            }
    }
    
}
