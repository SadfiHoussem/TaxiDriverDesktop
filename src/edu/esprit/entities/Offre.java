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
public class Offre {
    
    private int idOffre;
    private Agence agence;
    private String sujetOffre;
    private String contenu;
    private Date date;

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
