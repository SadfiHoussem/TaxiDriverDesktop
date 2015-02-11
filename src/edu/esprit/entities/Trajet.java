/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;

/**
 *
 * @author Houssem
 */
public class Trajet {
    
    private String idTrajet;
    private Client client;
    private ResponsableAgence respAgence;
    private String adresseDep;
    private String adresseDest;
    private double cout;

    public String getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(String idTrajet) {
        this.idTrajet = idTrajet;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ResponsableAgence getRespAgence() {
        return respAgence;
    }

    public void setRespAgence(ResponsableAgence respAgence) {
        this.respAgence = respAgence;
    }

    
    public String getAdresseDep() {
        return adresseDep;
    }

    public void setAdresseDep(String adresseDep) {
        this.adresseDep = adresseDep;
    }

    public String getAdresseDest() {
        return adresseDest;
    }

    public void setAdresseDest(String adresseDest) {
        this.adresseDest = adresseDest;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    
}
