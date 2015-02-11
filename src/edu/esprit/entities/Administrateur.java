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
public class Administrateur extends User{
    
    private String idAdministrateur;

    public String getIdAdministrateur() {
        return idAdministrateur;
    }

    public void setIdAdministrateur(String idAdministrateur) {
        this.idAdministrateur = idAdministrateur;
    }
    
}
