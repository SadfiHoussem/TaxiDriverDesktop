/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.adapters;


import edu.esprit.DAO.classes.ReservationDAO;
import edu.esprit.entities.Reservation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem
 */
public class ConsulterReservations extends AbstractTableModel{

    String[] headers = {"Identifiant", "Client", "Chauffeur", "Voiture","Adresse Départ","Adresse Destination", "Date", "Etat"};
    List<Reservation> reservations = new ArrayList<>();
    ReservationDAO reservationDAO;

    public ConsulterReservations() {
        reservationDAO = ReservationDAO.getInstance();
        reservations = reservationDAO.DisplayReservationsNonConfirme();
    }
    
    @Override
    public int getRowCount() {
        return reservations.size();
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
                return reservations.get(rowIndex).getIdReservation();
            case 1:
                return reservations.get(rowIndex).getClient().getNom();
            case 2:
                return reservations.get(rowIndex).getTaxi().getChauffeur().getNom();
            case 3:
                return reservations.get(rowIndex).getTaxi().getVoiture().getTypeVoiture();
            case 4:
                return reservations.get(rowIndex).getTrajet().getAdresseDep();
            case 5:
                return reservations.get(rowIndex).getTrajet().getAdresseDest();
            case 6:
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.format(reservations.get(rowIndex).getDate());
            case 7:
                if(reservations.get(rowIndex).isConfirme())
                    return "Confirmée";
                else if(!reservations.get(rowIndex).isConfirme())
                    return "En attente";
            default:
                return null;
        }
    }
    
}
