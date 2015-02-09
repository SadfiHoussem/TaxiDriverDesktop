/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;

/**
 *
 * @author amina jebari
 */
public class Voiture {
    
      private String matricule;
     private String idAgence;

    private int nbrPlace;
    private String typeVoiture;
    private int climatise;
private Date datePremiereCirculation;

public Voiture(String mat,String id,int nb,String type,int clim ) {
      this.setMatricule(mat);
      this.climatise=clim;
      this.idAgence=id;
      this.nbrPlace=nb;
      this.typeVoiture=type;
              
    }
public Voiture(String mat) {
    
      this.setMatricule(mat);
              
    }
public Voiture () {
    }
    /**
     * @return the matricule
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * @param matricule the matricule to set
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * @return the idAgence
     */
    public String getIdAgence() {
        return idAgence;
    }

    /**
     * @param idAgence the idAgence to set
     */
    public void setIdAgence(String idAgence) {
        this.idAgence = idAgence;
    }

    /**
     * @return the nbrPlace
     */
    public int getNbrPlace() {
        return nbrPlace;
    }

    /**
     * @param nbrPlace the nbrPlace to set
     */
    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    /**
     * @return the typeVoiture
     */
    public String getTypeVoiture() {
        return typeVoiture;
    }

    /**
     * @param typeVoiture the typeVoiture to set
     */
    public void setTypeVoiture(String typeVoiture) {
        this.typeVoiture = typeVoiture;
    }

    /**
     * @return the climatise
     */
    public int getClimatise() {
        return climatise;
    }

    /**
     * @param climatise the climatise to set
     */
    public void setClimatise(int climatise) {
        this.climatise = climatise;
    }

    /**
     * @return the datePremiereCirculation
     */
    public Date getDatePremiereCirculation() {
        return datePremiereCirculation;
    }

    /**
     * @param datePremiereCirculation the datePremiereCirculation to set
     */
    public void setDatePremiereCirculation(Date datePremiereCirculation) {
        this.datePremiereCirculation = datePremiereCirculation;
    }


    
}
