/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui.administrateur;



import edu.esprit.DAO.classes.ResponsableAgenceDAO;
import edu.esprit.adapters.ConsulterResponsables;
import edu.esprit.entities.ResponsableAgence;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.JOptionPane;


/**
 *
 * @author Houssem
 */
public class GestionRespAgence extends javax.swing.JFrame {

    /**
     * Creates new form GestionChauffeur
     */
    public GestionRespAgence() {
        initComponents();
        jTable1.setModel(new ConsulterResponsables());
    }
    
    private void updateModel(){
        jTable1.setModel(new ConsulterResponsables());       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelEmail = new javax.swing.JLabel();
        prenom = new javax.swing.JTextField();
        adresse = new javax.swing.JTextField();
        labelCin = new javax.swing.JLabel();
        cin = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        labelTelephone = new javax.swing.JLabel();
        labelPwd = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        telephone = new javax.swing.JTextField();
        labelAdresse = new javax.swing.JLabel();
        labelPrenom = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        labelNom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonAjouter = new javax.swing.JButton();
        ButtonUpdate = new javax.swing.JButton();
        ButtonSupprimer = new javax.swing.JButton();
        ButtonReset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        confirmer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        labelEmail.setText("Email");

        labelCin.setText("CIN");

        labelTelephone.setText("Telephone");

        labelPwd.setText("Password");

        labelLogin.setText("Login");

        labelAdresse.setText("Adresse");

        labelPrenom.setText("Prenom");

        labelNom.setText("Nom");

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Gestion d'un Responsable Agence");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelNom)
                        .addGap(18, 18, 18)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelPrenom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEmail)
                            .addComponent(labelCin))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPwd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTelephone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelAdresse, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(telephone, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(adresse, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(password)
                    .addComponent(login))
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNom)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrenom)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPwd)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail)
                    .addComponent(labelTelephone)
                    .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCin)
                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAdresse))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(255, 255, 102));
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
        ButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetActionPerformed(evt);
            }
        });

        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Envoyer un mail au responsable");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        confirmer.setText("confirmer");
        confirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(confirmer)
                        .addGap(63, 63, 63))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(ButtonReset)
                .addGap(53, 53, 53)
                .addComponent(ButtonSupprimer)
                .addGap(46, 46, 46)
                .addComponent(ButtonUpdate)
                .addGap(41, 41, 41)
                .addComponent(ButtonAjouter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(confirmer)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAjouter)
                    .addComponent(ButtonUpdate)
                    .addComponent(ButtonSupprimer)
                    .addComponent(ButtonReset)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAjouterActionPerformed

        ResponsableAgence resp =new ResponsableAgence();
   
        String nomParent = nom.getText();
	if (!Pattern.matches("[a-zA-Z]*", nomParent))
	{
		JOptionPane.showMessageDialog(null, "Rentrez un nom valide" );
		return;
        }
        
        String prenomParent = prenom.getText();
        if (!Pattern.matches("[a-zA-Z]*", prenomParent))
	{
		JOptionPane.showMessageDialog(null, "Rentrez un prenom valide" );
		return;
        }
        
        
            
            try {

                int acin = Integer.parseInt(this.cin.getText());
                
                 if ( !(cin.getText().length() == 8 )){{
                            JOptionPane.showMessageDialog(null, "Rentrer une CIN de 8 chiffres" );
		return;
        }
                        }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Le champ CIN n'accepte que les chiffres ", "Alert", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                int numtel = Integer.parseInt(this.telephone.getText());
                 
                        if ( !(telephone.getText().length() == 8 )){{
                            JOptionPane.showMessageDialog(null, "Rentrer un numero de telephone de 8 chiffres" );
		return;
        }
                        }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Le champ Numero de telephone n'accepte que les chiffres ", "Alert", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String mail = email.getText();
         if ((!mail.contains("@"))&&(!mail.contains("."))) {
         {
		JOptionPane.showMessageDialog(null, "Rentrez un mail valide" );
		return;
        }}
       
         resp.setLogin(login.getText());
         resp.setPwd(password.getText());
         resp.setCin(Long.parseLong(cin.getText()));
         resp.setNom(nom.getText());
         resp.setPrenom(prenom.getText());
         resp.setTelephone(Integer.parseInt(telephone.getText()));
         resp.setEmail(email.getText());
         resp.setAdresse(adresse.getText());
      

      ResponsableAgenceDAO respDAO =ResponsableAgenceDAO.getInstance();
        respDAO.insertRespAgence(resp);
        
        updateModel();
        
        // Envoye du Mail
        
              final String username = "samar.abdelkhalek@esprit.tn";
		final String password = "samarab222//";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("samar.abdelkhalek@esprit.tn"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email.getText()));
			message.setSubject("Confirmation");
			message.setText("Votre Demande a été accepté, Bienvenue "+nom.getText());
 
			Transport.send(message);
 
			System.out.println("Votre email a ete envoyé avec succes");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        

    }//GEN-LAST:event_ButtonAjouterActionPerformed

    private void ButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateActionPerformed
      ResponsableAgence  resp =new ResponsableAgence();
        
       String nomParent = nom.getText();
	if (!Pattern.matches("[a-zA-Z]*", nomParent))
	{
		JOptionPane.showMessageDialog(null, "Rentrez un nom valide" );
		return;
        }
        
        String prenomParent = prenom.getText();
        if (!Pattern.matches("[a-zA-Z]*", prenomParent))
	{
		JOptionPane.showMessageDialog(null, "Rentrez un prenom valide" );
		return;
        }
        
        
            
            try {

                int acin = Integer.parseInt(this.cin.getText());
                
                 if ( !(cin.getText().length() == 8 )){{
                            JOptionPane.showMessageDialog(null, "Rentrer une CIN de 8 chiffres" );
		return;
        }
                        }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Le champ CIN n'accepte que les chiffres ", "Alert", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                int numtel = Integer.parseInt(this.telephone.getText());
                 
                        if ( !(telephone.getText().length() == 8 )){{
                            JOptionPane.showMessageDialog(null, "Rentrer un numero de telephone de 8 chiffres" );
		return;
        }
                        }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Le champ Numero de telephone n'accepte que les chiffres ", "Alert", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String mail = email.getText();
         if ((!mail.contains("@"))&&(!mail.contains("."))) {
         {
		JOptionPane.showMessageDialog(null, "Rentrez un mail valide" );
		return;
        }}
        
        resp.setIdResponsableAgence(Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString()));
        resp.setLogin(login.getText());
        resp.setPwd(password.getText());
        resp.setNom(nom.getText());
        resp.setPrenom(prenom.getText());
        resp.setEmail(email.getText());
        resp.setTelephone(Integer.parseInt(telephone.getText()));
        resp.setAdresse(adresse.getText());
        resp.setCin(Long.parseLong(cin.getText()));
        
        ResponsableAgenceDAO.getInstance().updateRespAgence(resp);
        updateModel();
    }//GEN-LAST:event_ButtonUpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
          
        
        login.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),1).toString());
            password.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),2).toString());
             cin.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),3).toString());
            nom.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),4).toString());
            prenom.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),5).toString());
            telephone.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),6).toString());
            email.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),7).toString());
            adresse.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(),8).toString());
           
    }//GEN-LAST:event_jTable1MouseClicked

    private void ButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSupprimerActionPerformed


         String id= jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString();
           ResponsableAgenceDAO.getInstance().deleteRespAgence(Integer.parseInt(id));
           updateModel();
    }//GEN-LAST:event_ButtonSupprimerActionPerformed

    private void ButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetActionPerformed
        // TODO add your handling code here:
         login.setText(" ");
         password.setText("");
        nom.setText(" ");
        prenom.setText(" ");
            email.setText(" ");
         telephone.setText("");
        cin.setText(" ");
        adresse.setText(" ");
     
    }//GEN-LAST:event_ButtonResetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       accueilA a  =new accueilA();
    this.setVisible(false);
    a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void confirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmerActionPerformed
        
    }//GEN-LAST:event_confirmerActionPerformed

    
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
            java.util.logging.Logger.getLogger(GestionRespAgence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionRespAgence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionRespAgence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionRespAgence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionRespAgence().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAjouter;
    private javax.swing.JButton ButtonReset;
    private javax.swing.JButton ButtonSupprimer;
    private javax.swing.JButton ButtonUpdate;
    private javax.swing.JTextField adresse;
    private javax.swing.JTextField cin;
    private javax.swing.JButton confirmer;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelAdresse;
    private javax.swing.JLabel labelCin;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPrenom;
    private javax.swing.JLabel labelPwd;
    private javax.swing.JLabel labelTelephone;
    private javax.swing.JTextField login;
    private javax.swing.JTextField nom;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField prenom;
    private javax.swing.JTextField telephone;
    // End of variables declaration//GEN-END:variables
}