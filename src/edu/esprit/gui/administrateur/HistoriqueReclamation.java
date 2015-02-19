/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui.administrateur;

import edu.esprit.DAO.classes.ReclamationDAO;
import edu.esprit.adapters.ConsulterReclamations;
import edu.esprit.entities.Reclamation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Houssem
 */
public class HistoriqueReclamation extends javax.swing.JFrame {

    /**
     * Creates new form HistoriqueReclamation
     */
    private List<Reclamation> listeReclamations;
    
    public HistoriqueReclamation() {
        initComponents();
        
        refresh();
    }

    private void refresh(){
        listeReclamations=ReclamationDAO.getInstance().DisplayReclamationsConfirme(true);

        jTable1.setModel(new ConsulterReclamations(listeReclamations));
    }
    
    private Reclamation searchReclamationById(int id){
        for (Reclamation r : listeReclamations) {
            if(r.getIdReclamation()==id)
                return r;
        }
        return null;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        contenuReclamation = new javax.swing.JTextArea();
        retourButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        rechercheButton = new javax.swing.JButton();
        recherche = new javax.swing.JTextField();
        critereRecherche = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        contenuReclamation.setColumns(20);
        contenuReclamation.setRows(5);
        contenuReclamation.setEnabled(false);
        jScrollPane2.setViewportView(contenuReclamation);

        retourButton.setText("Retour");
        retourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        rechercheButton.setText("Recherche");
        rechercheButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheButtonActionPerformed(evt);
            }
        });

        critereRecherche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Client", "Sujet", "Date" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(retourButton)
                                .addGap(286, 286, 286)
                                .addComponent(refreshButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(critereRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rechercheButton)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rechercheButton)
                    .addComponent(recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(critereRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(retourButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(refreshButton)))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int idRec=Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString());
        Reclamation r=searchReclamationById(idRec);
        contenuReclamation.setText(r.getcontenu());
        
        switch (critereRecherche.getSelectedItem()+"") {
                case "Client":
                    recherche.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                    break;
                case "Sujet":
                    recherche.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
                    break;
                case "Date":
                    recherche.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
                    break;
                default:
                    recherche.setText("Erreur");
                    break;
            }
    }//GEN-LAST:event_jTable1MouseClicked

    private void retourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourButtonActionPerformed
        GestionReclamation.getGestionReclamationGUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_retourButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refresh();
    }//GEN-LAST:event_formWindowOpened

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refresh();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void rechercheButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheButtonActionPerformed
        List<Reclamation> auxListe =new ArrayList<>();
        switch (critereRecherche.getSelectedItem()+"") {
                case "Client":
                    for (Reclamation listeReclamation1 : listeReclamations) {
                        if(listeReclamation1.getClient().getNom().equals(recherche.getText()))
                            auxListe.add(listeReclamation1);
                    }
                    jTable1.setModel(new ConsulterReclamations(auxListe));                    
                    break;
                case "Sujet":
                    for (Reclamation listeReclamation1 : listeReclamations) {
                        if(listeReclamation1.getsujetReclamation().equals(recherche.getText()))
                            auxListe.add(listeReclamation1);
                    }
                    jTable1.setModel(new ConsulterReclamations(auxListe));                    
                    break;
                case "Date":
                    for (Reclamation listeReclamation1 : listeReclamations) {
                        if(listeReclamation1.getDate().equals(recherche.getText()))
                            auxListe.add(listeReclamation1);
                    }
                    jTable1.setModel(new ConsulterReclamations(auxListe));                    
                    break;
                default:
                    recherche.setText("Erreur");
                    break;
            }
    }//GEN-LAST:event_rechercheButtonActionPerformed

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
            java.util.logging.Logger.getLogger(HistoriqueReclamation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoriqueReclamation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoriqueReclamation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoriqueReclamation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoriqueReclamation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea contenuReclamation;
    private javax.swing.JComboBox critereRecherche;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField recherche;
    private javax.swing.JButton rechercheButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton retourButton;
    // End of variables declaration//GEN-END:variables
}
