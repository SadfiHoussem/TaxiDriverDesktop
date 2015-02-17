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
public class Agence {
    
    private int idAgence;
    private ResponsableAgence RespAgence;
    private String nomAgence;
    private String adresseAgence;
    private int telAgence;

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public ResponsableAgence getRespAgence() {
        return RespAgence;
    }

    public void setRespAgence(ResponsableAgence RespAgence) {
        this.RespAgence = RespAgence;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getAdresseAgence() {
        return adresseAgence;
    }

    public void setAdresseAgence(String adresseAgence) {
        this.adresseAgence = adresseAgence;
    }

    public int getTelAgence() {
        return telAgence;
    }

    public void setTelAgence(int telAgence) {
        this.telAgence = telAgence;
    }
    
    
    
}
