/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;



import edu.esprit.entities.Client;
import edu.esprit.DAO.interfaces.IClientDAO;
import edu.esprit.DAO.classes.ClientDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterClients extends AbstractTableModel{

    String[] headers = {"Identifiant","Login" ,"Password", "CIN","Nom","Prenom", "Telephone", "Email", "Adresse"};
    List<Client>Clients = new ArrayList<>();
   ClientDAO ClientDAO;

    public ConsulterClients() {
      {
        ClientDAO=ClientDAO.getInstance();
     Clients =ClientDAO.DisplayAllClients();
    }
    }
    
    @Override
    public int getRowCount() {
        return Clients.size();
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
                return  Clients.get(rowIndex).getIdClient();
            case 1:
                return  Clients.get(rowIndex).getLogin();
            case 2:
                return  Clients.get(rowIndex).getPwd();
            case 3:
                return Clients.get(rowIndex).getCin();
            case 4:
                return  Clients.get(rowIndex).getNom();
            case 5:
                return Clients.get(rowIndex).getPrenom();
            case 6:
                return  Clients.get(rowIndex).getTelephone();
            case 7:
                return  Clients.get(rowIndex).getEmail();
            case 8:
                return Clients.get(rowIndex).getAdresse();
            
            default:
                return null;
        }
    }
    
}
