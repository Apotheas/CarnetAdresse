/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingInterface;

import dataBase.DataManagement;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Apotheas
 */
public class TableauContacts extends javax.swing.JFrame {

    DefaultTableModel monModel = new DefaultTableModel();
    DataManagement maBase = new DataManagement();

    public TableauContacts() {
        initComponents();
        monModel.addColumn("ID");
        monModel.addColumn("Nom");
        monModel.addColumn("Prenom");
        monModel.addColumn("Tel");
        monModel.addColumn("Adresse");
        monModel.addColumn("Code Postal");
        monModel.addColumn("Ville");
        monModel.addColumn("Email");
        monModel.addColumn("Tel 2");
        monModel.addColumn("Date de Naissance");
        monModel.addColumn("Type");
        tableau.setModel(monModel);
        rbTous.doClick();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        rbConnaissances = new javax.swing.JRadioButton();
        rbAmis = new javax.swing.JRadioButton();
        rbFamille = new javax.swing.JRadioButton();
        rbTous = new javax.swing.JRadioButton();

        setTitle("Mes Contacts");
        setLocation(new java.awt.Point(500, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new java.awt.BorderLayout());

        tableau.setAutoCreateRowSorter(true);
        tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom", "Prenom", "Tel", "Adresse", "Code Postal", "Ville", "Email", "Tel 2 ", "Date de naissance"
            }
        ));
        tableau.setPreferredSize(new java.awt.Dimension(500, 500));
        jScrollPane1.setViewportView(tableau);
        tableau.getAccessibleContext().setAccessibleName("tableau");

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Affichage spécifique"));

        buttonGroup1.add(rbConnaissances);
        rbConnaissances.setText("Connaissances");
        rbConnaissances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbConnaissancesActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbAmis);
        rbAmis.setText("Amis");
        rbAmis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAmisActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbFamille);
        rbFamille.setText("Famille");
        rbFamille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFamilleActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTous);
        rbTous.setText("Tous");
        rbTous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(rbTous)
                .addGap(44, 44, 44)
                .addComponent(rbConnaissances)
                .addGap(53, 53, 53)
                .addComponent(rbAmis)
                .addGap(102, 102, 102)
                .addComponent(rbFamille)
                .addGap(127, 127, 127))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbConnaissances)
                    .addComponent(rbAmis)
                    .addComponent(rbFamille)
                    .addComponent(rbTous))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbConnaissancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbConnaissancesActionPerformed
        vidange();
        maBase.affichageTableauSpec(monModel, "0");
    }//GEN-LAST:event_rbConnaissancesActionPerformed

    private void rbAmisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAmisActionPerformed
        vidange();
        maBase.affichageTableauSpec(monModel, "1");
    }//GEN-LAST:event_rbAmisActionPerformed

    private void rbFamilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFamilleActionPerformed
        vidange();
        maBase.affichageTableauSpec(monModel, "2");
    }//GEN-LAST:event_rbFamilleActionPerformed

    private void rbTousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTousActionPerformed
        vidange();
        maBase.affichageTableau(monModel);
    }//GEN-LAST:event_rbTousActionPerformed
    private void vidange() {
        int lignes = monModel.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            monModel.removeRow(i);
        }

    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAmis;
    private javax.swing.JRadioButton rbConnaissances;
    private javax.swing.JRadioButton rbFamille;
    private javax.swing.JRadioButton rbTous;
    private javax.swing.JTable tableau;
    // End of variables declaration//GEN-END:variables
}
