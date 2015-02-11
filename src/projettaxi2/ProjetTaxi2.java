/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettaxi2;

import edu.esprit.DAO.classes.AdministrateurDAO;
import edu.esprit.DAO.classes.ChauffeurDAO;
import edu.esprit.DAO.interfaces.IAdministrateurDAO;
import edu.esprit.entities.Administrateur;
import edu.esprit.entities.Chauffeur;
import java.util.List;

/**
 *
 * @author Houssem
 */
public class ProjetTaxi2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //--Administrateur--
        /*AdministrateurDAO a=AdministrateurDAO.getInstance();
        
        Administrateur administrateur=new Administrateur();
        administrateur.setIdAdministrateur("administrateur1");
        administrateur.setLogin("admin1");
        administrateur.setPwd("pwd1");
        administrateur.setNom("Nom1");
        administrateur.setPrenom("Prenom1");
        administrateur.setEmail("email1");
        administrateur.setTelephone(123456789);
        administrateur.setAdresse("adresse1");
        administrateur.setCin(7814441);*/
        
        //--Insertion
        //a.insertAdministrateur(administrateur);
        
        //--Delete
        //a.deleteAdministrateur("administrateur1");
        
        //--Update
        //a.updateAdministrateur(administrateur);
        
        //--FindById
        /*Administrateur admin=a.findAdministrateurById("administrateur2");
        System.out.println(admin.getIdAdministrateur());
        System.out.println(admin.getLogin());
        System.out.println(admin.getPwd());
        System.out.println(admin.getNom());
        System.out.println(admin.getPrenom());
        System.out.println(admin.getEmail());
        System.out.println(admin.getTelephone());
        System.out.println(admin.getCin());*/
        
        //--Display
        /*List<Administrateur> admins=a.DisplayAllAdministrateurs();
        for (Administrateur admin : admins) {
            System.out.println(admin.getIdAdministrateur());
            System.out.println(admin.getLogin());
            System.out.println(admin.getPwd());
            System.out.println(admin.getNom());
            System.out.println(admin.getPrenom());
            System.out.println(admin.getEmail());
            System.out.println(admin.getTelephone());
            System.out.println(admin.getCin());
        }*/
        
        //--Chauffeur--
        
        /*Chauffeur chauffeur=new Chauffeur();
        chauffeur.setIdChauffeur("chauffeur1");
        ChauffeurDAO c1=ChauffeurDAO.getInstance();*/
        
    }
    
}
