/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author Houssem
 */
public class Trajet {
    
    private int idTrajet;
    private Agence agence;
    private String adresseDep;
    private String adresseDest;
    private double cout;
    private boolean etat;
    
    public int getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(int idTrajet) {
        this.idTrajet = idTrajet;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
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

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    
}
