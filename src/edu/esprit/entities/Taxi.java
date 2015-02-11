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
public class Taxi {
    
    private String idTaxi;
    private Chauffeur chauffeur;
    private Voiture voiture;
    private boolean etat;

    public Taxi(String idTaxi,Chauffeur chauffeur, Voiture voiture) {
        this.idTaxi=idTaxi;
        this.chauffeur = chauffeur;
        this.voiture = voiture;
        this.etat=(this.chauffeur.isEtat())&&(this.voiture.isEtat());
    }

    public String getIdTaxi() {
        return idTaxi;
    }

    public void setIdTaxi(String idTaxi) {
        this.idTaxi = idTaxi;
    }
    
    
    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public boolean isEtat() {
        return etat;
    }    

    public void setEtat() {
        this.etat=(this.chauffeur.isEtat())&&(this.voiture.isEtat());
    }
    
}
