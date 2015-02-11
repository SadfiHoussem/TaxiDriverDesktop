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
public class Offre {
    
    private String idOffre;
    private Agence agence;
    private String sujetOffre;
    private String contenu;

    public String getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(String idOffre) {
        this.idOffre = idOffre;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    
    public String getSujetOffre() {
        return sujetOffre;
    }

    public void setSujetOffre(String sujetOffre) {
        this.sujetOffre = sujetOffre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenue) {
        this.contenu = contenue;
    }
    
    
}
