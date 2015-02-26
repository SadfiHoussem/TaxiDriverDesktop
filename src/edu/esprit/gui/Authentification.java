/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;



import edu.esprit.DAO.classes.AdministrateurDAO;
import edu.esprit.DAO.classes.ChauffeurDAO;
import edu.esprit.DAO.classes.ClientDAO;
import edu.esprit.DAO.classes.ResponsableAgenceDAO;
import edu.esprit.gui.administrateur.AccueilA;
import edu.esprit.gui.chauffeur.AccueilChauffeur;
import edu.esprit.gui.client.AccueilClient;
import edu.esprit.gui.responsableagence.AccueilRespAgence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author hela
 */
public class Authentification extends javax.swing.JFrame {

    /**
     * Creates new form Authentification
     */
    private AdministrateurDAO aDAO;
    private ResponsableAgenceDAO rDAO;
    private ChauffeurDAO chDAO;
    private ClientDAO cDAO;
    
    private static AccueilChauffeur accueilChauffeurGUI;
    private static AccueilRespAgence accueilRespAgenceGUI;
    private static AccueilA accueilAdmin;
    private static AccueilClient accueilClient;
    
    public Authentification() {
        initComponents();
        
        aDAO=AdministrateurDAO.getInstance();
        rDAO=ResponsableAgenceDAO.getInstance();
        chDAO=ChauffeurDAO.getInstance();
        cDAO=ClientDAO.getInstance();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        connexion = new javax.swing.JButton();
        login = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 80, 30));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 100, -1));
        getContentPane().add(pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 140, 30));

        connexion.setFont(new java.awt.Font("Tw Cen MT", 3, 18)); // NOI18N
        connexion.setText("Connexion");
        connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connexionActionPerformed(evt);
            }
        });
        getContentPane().add(connexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 120, 30));

        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 140, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 440));

        user.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrateur", "Responsable Agence", "Chauffeur", "Client" }));
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 140, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connexionActionPerformed
        switch(user.getSelectedItem()+""){
            case "Administrateur":
                if(aDAO.findAdministrateurByLogin_PWD(login.getText(), pwd.getText())){
                    accueilAdmin=new AccueilA(login.getText());
                    accueilAdmin.setVisible(true);
                    
                    this.setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Combinaison de login et mot de passe non trouvée" );
            break;
            case "Responsable Agence":
                if(rDAO.findRespAgenceByLogin_PWD(login.getText(), pwd.getText())){
                    accueilRespAgenceGUI=new AccueilRespAgence(login.getText());
                    accueilRespAgenceGUI.setVisible(true);
                    
                    this.setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Combinaison de login et mot de passe non trouvée" );
            break;
            case "Chauffeur":
                if(chDAO.findChauffeurByLogin_PWD(login.getText(), pwd.getText())){
                    accueilChauffeurGUI=new AccueilChauffeur(login.getText());
                    accueilChauffeurGUI.setVisible(true);
                    
                    this.setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Combinaison de login et mot de passe non trouvée" );
            break;
            case "Client":
                if(cDAO.findClientByLogin_PWD(login.getText(), pwd.getText())){
                    accueilClient =new AccueilClient(login.getText(),pwd.getText());
                    accueilClient.setVisible(true);
                    this.setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Combinaison de login et mot de passe non trouvée" );
            break;
            default:
                JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données" );
            break;
        }

    }//GEN-LAST:event_connexionActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authentification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField login;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JComboBox user;
    // End of variables declaration//GEN-END:variables
}
