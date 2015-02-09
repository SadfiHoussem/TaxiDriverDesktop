/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;


public class Commentaire {
    private String idCommentaire ;
        private String idClient ;
    private String idOffre ;
        private int sujetCommentaire ;
    private String contenu ;

    
    public String getIdCommentaire() {
        return idCommentaire;
    }

    /**
     * @param idCommentaire the idCommentaire to set
     */
    public void setIdCommentaire(String idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    /**
     * @return the idClient
     */
    public String getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    /**
     * @return the idOffre
     */
    public String getIdOffre() {
        return idOffre;
    }

    /**
     * @param idOffre the idOffre to set
     */
    public void setIdOffre(String idOffre) {
        this.idOffre = idOffre;
    }

    /**
     * @return the sujetCommentaire
     */
    public int getSujetCommentaire() {
        return sujetCommentaire;
    }

    /**
     * @param sujetCommentaire the sujetCommentaire to set
     */
    public void setSujetCommentaire(int sujetCommentaire) {
        this.sujetCommentaire = sujetCommentaire;
    }

    /**
     * @return the contenu
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * @param contenu the contenu to set
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


}
