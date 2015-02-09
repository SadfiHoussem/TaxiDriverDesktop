/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.entities.Commentaire;

public interface ICommentaireDAO {
    
    
    void insertCommentaire(Commentaire voiture);

    void updateCommentaire(Commentaire voiture);

    void deleteCommentaire(String idCommentaire);

    Commentaire selectCommentaire(String idCommentaire);

}
