
package edu.esprit.entities;


public class Reclamation {
    
    private String idReclamation;
    private Client client;
    private Agence agence;
    private String sujetReclamation;
    private String contenu;

    
     public String getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(String idReclamation) {
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
    
    
}
