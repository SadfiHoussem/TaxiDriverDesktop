/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Commentaire;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface ICommentaireDAO {
    
    void insertCommentaire(Commentaire commentaire);
    void updateCommentaire(Commentaire commentaire);
    void deleteCommentaire(int id);
    Commentaire findCommentaireById(int id);
    List<Commentaire> DisplayAllCommentaires();
}
