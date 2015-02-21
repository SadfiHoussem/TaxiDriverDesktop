
package edu.esprit.entities;

import java.util.Date;


public class Reclamation {
    
    private int idReclamation;
    private Client client;
    private Agence agence;
    private String sujetReclamation;
    private String contenu;
    private boolean etat;
    private Date date;

    
    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getsujetReclamation() {
        return sujetReclamation;
    }

    public void setsujetReclamation(String sujetReclamation) {
        this.sujetReclamation = sujetReclamation;
    }

    public String getcontenu() {
        return contenu;
    }

    public void setcontenu(String contenue) {
        this.contenu = contenue;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
