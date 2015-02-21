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
public class Chauffeur extends User{
    
    private int idChauffeur;
    private String numPermis;
    private boolean conge;
    
    public int getIdChauffeur() {
        return idChauffeur;
    }

    public void setIdChauffeur(int idChauffeur) {
        this.idChauffeur = idChauffeur;
    }

    public String getNumPermis() {
        return numPermis;
    }

    public void setNumPermis(String numPermis) {
        this.numPermis = numPermis;
    }

    public boolean isConge() {
        return conge;
    }

    public void setConge(boolean conge) {
        this.conge = conge;
    }
    
    
}
