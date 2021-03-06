/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui.responsableagence;

import edu.esprit.DAO.classes.VoitureDAO;
import edu.esprit.adapters.ConsulterVoitures;
import edu.esprit.entities.Voiture;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Houssem
 */
public class GestionVoiture extends javax.swing.JFrame {

    /**
     * Creates new form GestionVoiture
     */
    
    private List<Voiture> listeVoitures;
    
    public GestionVoiture() {
        initComponents();
        listeVoitures=VoitureDAO.getInstance().DisplayAllVoituresByAgence(AccueilRespAgence.getAgence().getIdAgence());
        jTable1.setModel(new ConsulterVoitures(listeVoitures));
        
    }
    
    private void refresh(){
        listeVoitures=VoitureDAO.getInstance().DisplayAllVoituresByAgence(AccueilRespAgence.getAgence().getIdAgence());
        jTable1.setModel(new ConsulterVoitures(listeVoitures));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonAjouter = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        typeVoiture = new javax.swing.JTextField();
        nbrPlace = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        matricule = new javax.swing.JTextField();
        idChauffeur = new javax.swing.JLabel();
        etatDispo = new javax.swing.JRadioButton();
        labelPrenom = new javax.swing.JLabel();
        etatNDispo = new javax.swing.JRadioButton();
        labelNom = new javax.swing.JLabel();
        ButtonUpdate = new javax.swing.JButton();
        ButtonSupprimer = new javax.swing.JButton();
        ButtonReset = new javax.swing.JButton();
        retourButton = new javax.swing.JButton();
        recherche = new javax.swing.JTextField();
        critereRecherche = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        ButtonAjouter.setText("Ajouter");
        ButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAjouterActionPerformed(evt);
            }
        });

        jLabel2.setText("Etat");

        matricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculeActionPerformed(evt);
            }
        });

        idChauffeur.setText("Matricule");

        etatDispo.setText("Disponible");
        etatDispo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etatDispoActionPerformed(evt);
            }
        });

        labelPrenom.setText("Type Voiture");

        etatNDispo.setText("Non Disponible");
        etatNDispo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etatNDispoActionPerformed(evt);
            }
        });

        labelNom.setText("Nombre de Place");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelNom)
                                .addGap(34, 34, 34)
                                .addComponent(nbrPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(typeVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(339, 339, 339)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etatNDispo)
                                    .addComponent(etatDispo)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPrenom)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(idChauffeur)
                                .addGap(30, 30, 30)
                                .addComponent(matricule, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idChauffeur)
                    .addComponent(matricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etatDispo)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etatNDispo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPrenom)
                        .addComponent(typeVoiture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNom)
                    .addComponent(nbrPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        ButtonUpdate.setText("Modifier");
        ButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateActionPerformed(evt);
            }
        });

        ButtonSupprimer.setText("Supprimer");
        ButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSupprimerActionPerformed(evt);
            }
        });

        ButtonReset.setText("Reset");

        retourButton.setText("Retour");
        retourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourButtonActionPerformed(evt);
            }
        });

        //"Matricule", "Nombre de place", "Marque"
        recherche.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                rech();
            }
            public void removeUpdate(DocumentEvent e) {
                rech();
            }
            public void insertUpdate(DocumentEvent e) {
                rech();
            }

            public void rech() {
                List<Voiture> listeVoiture;
                switch(critereRecherche.getSelectedItem()+""){
                    case "Nombre de place":
                    if (Pattern.matches("[0-9]*", recherche.getText())&&(!recherche.getText().equals(""))){
                        listeVoiture=VoitureDAO.getInstance().FindByNbrPlaceLike(Integer.parseInt(recherche.getText()));
                        jTable1.setModel(new ConsulterVoitures(listeVoiture));
                    }
                    else
                    refresh();
                    break;
                    case "Matricule":
                    listeVoiture=VoitureDAO.getInstance().FindByMatriculeLike(recherche.getText());
                    jTable1.setModel(new ConsulterVoitures(listeVoiture));
                    break;
                    case "Marque":
                    listeVoiture =VoitureDAO.getInstance().FindByMarqueLike(recherche.getText());
                    jTable1.setModel(new ConsulterVoitures(listeVoiture));
                    break;
                }
            }
        });

        critereRecherche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matricule", "Nombre de place", "Marque" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(retourButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonSupprimer)
                .addGap(18, 18, 18)
                .addComponent(ButtonUpdate)
                .addGap(18, 18, 18)
                .addComponent(ButtonAjouter)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(critereRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(critereRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAjouter)
                    .addComponent(ButtonUpdate)
                    .addComponent(ButtonSupprimer)
                    .addComponent(ButtonReset)
                    .addComponent(retourButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        matricule.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString());
        nbrPlace.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),2).toString());
        typeVoiture.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),3).toString());
        
        if ("false".equals(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),4).toString())){
            etatNDispo.setSelected(true);
            etatDispo.setSelected(false);
        }            
        else if ("true".equals(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),4).toString())){
            etatDispo.setSelected(true);
            etatNDispo.setSelected(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void ButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAjouterActionPerformed

        Voiture v=new Voiture();
        
        v.setAgence(AccueilRespAgence.getAgence());
        v.setMatricule(matricule.getText());
        
        if (etatDispo.isSelected())
            v.setEtat(true);
        else if (etatNDispo.isSelected())
            v.setEtat(false);
        
        v.setNbrPlace(Integer.parseInt(nbrPlace.getText()));
        v.setTypeVoiture(typeVoiture.getText());

        VoitureDAO vDAO =VoitureDAO.getInstance();
        vDAO.insertVoiture(v);

        refresh();
    }//GEN-LAST:event_ButtonAjouterActionPerformed

    private void matriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculeActionPerformed

    private void ButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateActionPerformed

        Voiture v=new Voiture();
        
        v.setAgence(AccueilRespAgence.getAgence());
        v.setMatricule(matricule.getText());
               
        if (etatDispo.isSelected())
            v.setEtat(true);
        else if (etatNDispo.isSelected())
            v.setEtat(false);
        v.setNbrPlace(Integer.parseInt(nbrPlace.getText()));
        v.setTypeVoiture(typeVoiture.getText());

        VoitureDAO.getInstance().updateVoiture(v);
        refresh();
    }//GEN-LAST:event_ButtonUpdateActionPerformed

    private void ButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSupprimerActionPerformed

        String id= jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString();
        VoitureDAO.getInstance().deleteVoiture(id);
        refresh();
    }//GEN-LAST:event_ButtonSupprimerActionPerformed

    private void etatNDispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etatNDispoActionPerformed
        if (etatDispo.isSelected())
            etatDispo.setSelected(false);
    }//GEN-LAST:event_etatNDispoActionPerformed

    private void etatDispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etatDispoActionPerformed
        if (etatNDispo.isSelected())
            etatNDispo.setSelected(false);
    }//GEN-LAST:event_etatDispoActionPerformed

    private void retourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourButtonActionPerformed
        AccueilRespAgence.getAccueilGUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_retourButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GestionVoiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionVoiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionVoiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionVoiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionVoiture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAjouter;
    private javax.swing.JButton ButtonReset;
    private javax.swing.JButton ButtonSupprimer;
    private javax.swing.JButton ButtonUpdate;
    private javax.swing.JComboBox critereRecherche;
    private javax.swing.JRadioButton etatDispo;
    private javax.swing.JRadioButton etatNDispo;
    private javax.swing.JLabel idChauffeur;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPrenom;
    private javax.swing.JTextField matricule;
    private javax.swing.JTextField nbrPlace;
    private javax.swing.JTextField recherche;
    private javax.swing.JButton retourButton;
    private javax.swing.JTextField typeVoiture;
    // End of variables declaration//GEN-END:variables
}
