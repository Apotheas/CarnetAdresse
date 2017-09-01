/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingInterface;

import Utils.Utilitaires;
import carnetadresse.CarnetAdresse;

import dataBase.DataManagement;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import typesContacts.Amis;
import typesContacts.Connaissances;
import typesContacts.Famille;

/**
 *
 * @author Apotheas
 */
public class InterfaceGlobale extends javax.swing.JFrame {

    private Vector<Connaissances> monCarnet = new Vector<>();
    private DataManagement maBase = new DataManagement();
    private Utilitaires utils = new Utilitaires();
    private boolean Action = true;
    

    /**
     * Creates new form interfaceGlobale
     */
    public InterfaceGlobale() {
        initComponents();
        buttonModifier.setVisible(false);
        buttonSupprimer.setVisible(false);
        panneau.setVisible(false);
        comboContacts.setModel(initContactsModel());
        jTree1.setModel(initTreeModel());
        Sync();
        rbConnaissance.doClick();
    }

    private DefaultTreeModel initTreeModel() {

        return new DefaultTreeModel(initTree());
    }

    private void Sync() {
        comboContacts.setModel(initContactsModel());
        jTree1.setModel(initTreeModel());
        monCarnet.removeAllElements();
        monCarnet = maBase.synchroVectorR();

    }

    private boolean controles() {

        if (!utils.regexNom(fieldNom.getText())) {
            if (fieldNom.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le nom est obligatoire ", "Attention", JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Le nom est non valide ", "Attention", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        if (!utils.regexNom(fieldPrenom.getText())) {
            if (fieldPrenom.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le prenom est obligatoire ", "Attention", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Le prenom est non valide ", "Attention", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        if (!utils.regexTel(fieldTel.getText())) {
            if (fieldTel.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le numero de Tel est obligatoire ", "Attention", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Le numero de Tel est non valide ", "Attention", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        if (!fieldEmail.getText().isEmpty()) {
            if (!utils.regexEmail(fieldEmail.getText())) {
                JOptionPane.showMessageDialog(this, "L'Email est non valide ", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (!fieldTel2.getText().isEmpty()) {
            if (!utils.regexTel(fieldTel2.getText())) {
                JOptionPane.showMessageDialog(this, "Le numero de Tel2  est non valide ", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }
        if (!fieldDate.getText().isEmpty()) {
            if (!utils.regexDate(fieldDate.getText())) {
                JOptionPane.showMessageDialog(this, "date non valide (format DD-MM-YYYY)", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }
        if (!fieldAdresse.getText().isEmpty()) {
            if (!utils.regexAdresse(fieldAdresse.getText())) {
                JOptionPane.showMessageDialog(this, "le Code Postal est non valide ", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (!fieldCp.getText().isEmpty()) {
            if (!utils.regexCp(fieldCp.getText())) {
                JOptionPane.showMessageDialog(this, "le Code Postal est non valide ", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }
        if (!fieldVille.getText().isEmpty()) {
            if (!utils.regexNom(fieldVille.getText())) {
                JOptionPane.showMessageDialog(this, "la ville est non valide ", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }
        return true;
    }

    private void clear() {

        fieldAdresse.setText("");
        fieldNom.setText("");
        fieldPrenom.setText("");
        fieldCp.setText("");
        fieldVille.setText("");
        fieldTel.setText("");
        fieldEmail.setText("");
        fieldTel2.setText("");
        fieldDate.setText("");
        fieldId.setText("");
        Sync();
    }

    private DefaultMutableTreeNode initTree() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("mes Contacts");
        DefaultMutableTreeNode tnConnaissance = new DefaultMutableTreeNode("Connaissance");
        DefaultMutableTreeNode tnAmis = new DefaultMutableTreeNode("Amis");
        DefaultMutableTreeNode tnFamille = new DefaultMutableTreeNode("Famille");
        DefaultMutableTreeNode tnContact = null;
        root.add(tnConnaissance);
        root.add(tnAmis);
        root.add(tnFamille);

        for (Connaissances unContact : monCarnet) {

            if (unContact.getType() == 0) {
                tnContact = new DefaultMutableTreeNode(unContact);
                tnConnaissance.add(tnContact);
            }
            if (unContact.getType() == 1) {
                tnContact = new DefaultMutableTreeNode(unContact);
                tnAmis.add(tnContact);
            }
            if (unContact.getType() == 2) {
                tnContact = new DefaultMutableTreeNode(unContact);
                tnFamille.add(tnContact);
            }

        }
        return root;
    }

    private DefaultComboBoxModel initContactsModel() {
        return new DefaultComboBoxModel(initContactsVector());
    }

    private Vector initContactsVector() {

        monCarnet = maBase.synchroVectorR();
        return monCarnet;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelCreation = new javax.swing.JPanel();
        panelCreationContact = new javax.swing.JPanel();
        labelNom = new javax.swing.JLabel();
        labelPrenom = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelTel2 = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        labelTel = new javax.swing.JLabel();
        panelAdresse = new javax.swing.JPanel();
        labelAdresse = new javax.swing.JLabel();
        labelCp = new javax.swing.JLabel();
        fieldAdresse = new javax.swing.JTextField();
        fieldCp = new javax.swing.JTextField();
        fieldVille = new javax.swing.JTextField();
        labelVille = new javax.swing.JLabel();
        fieldNom = new javax.swing.JTextField();
        fieldEmail = new javax.swing.JTextField();
        fieldPrenom = new javax.swing.JTextField();
        fieldDate = new javax.swing.JTextField();
        fieldTel = new javax.swing.JTextField();
        fieldTel2 = new javax.swing.JTextField();
        panelType = new javax.swing.JPanel();
        rbAmi = new javax.swing.JRadioButton();
        rbFamille = new javax.swing.JRadioButton();
        rbConnaissance = new javax.swing.JRadioButton();
        PanelCombo = new javax.swing.JPanel();
        comboContacts = new javax.swing.JComboBox();
        PanelRecherche = new javax.swing.JPanel();
        fieldId = new javax.swing.JTextField();
        buttonRechercher = new javax.swing.JButton();
        buttonSupprimer = new javax.swing.JButton();
        buttonAffichage = new javax.swing.JButton();
        buttonModifier = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        buttonEnregistrer = new javax.swing.JButton();
        panneau = new javax.swing.JLabel();
        PanelTree = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mon Carnet ");
        setLocation(new java.awt.Point(500, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelCreation.setLayout(null);

        panelCreationContact.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des Contacts"));
        panelCreationContact.setLayout(null);

        labelNom.setText("Nom  : ");
        panelCreationContact.add(labelNom);
        labelNom.setBounds(215, 48, 38, 16);

        labelPrenom.setText("Prenom  :");
        panelCreationContact.add(labelPrenom);
        labelPrenom.setBounds(199, 90, 54, 16);

        labelEmail.setText("Email  :");
        panelCreationContact.add(labelEmail);
        labelEmail.setBounds(213, 174, 40, 16);

        labelTel2.setText("Telephone 2   :");
        panelCreationContact.add(labelTel2);
        labelTel2.setBounds(187, 216, 81, 16);

        labelDate.setText("Date de Naissance  : ");
        panelCreationContact.add(labelDate);
        labelDate.setBounds(478, 216, 118, 16);

        labelTel.setText("Telephone  :");
        panelCreationContact.add(labelTel);
        labelTel.setBounds(185, 132, 68, 16);

        panelAdresse.setBorder(javax.swing.BorderFactory.createTitledBorder("Adresse  "));

        labelAdresse.setText("Nom de voie   :");

        labelCp.setText("Code Postal  :");

        fieldAdresse.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldAdresseFocusLost(evt);
            }
        });
        fieldAdresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAdresseActionPerformed(evt);
            }
        });

        fieldCp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldCpFocusLost(evt);
            }
        });
        fieldCp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCpActionPerformed(evt);
            }
        });

        fieldVille.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldVilleFocusLost(evt);
            }
        });
        fieldVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldVilleActionPerformed(evt);
            }
        });

        labelVille.setText("Ville  :");

        javax.swing.GroupLayout panelAdresseLayout = new javax.swing.GroupLayout(panelAdresse);
        panelAdresse.setLayout(panelAdresseLayout);
        panelAdresseLayout.setHorizontalGroup(
            panelAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdresseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelAdresse)
                        .addComponent(labelCp, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(labelVille))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fieldVille, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addComponent(fieldCp))
                    .addComponent(fieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelAdresseLayout.setVerticalGroup(
            panelAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdresseLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAdresse)
                    .addComponent(fieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCp))
                .addGap(18, 18, 18)
                .addGroup(panelAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelVille))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelCreationContact.add(panelAdresse);
        panelAdresse.setBounds(478, 38, 331, 156);

        fieldNom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNomFocusLost(evt);
            }
        });
        fieldNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomActionPerformed(evt);
            }
        });
        panelCreationContact.add(fieldNom);
        fieldNom.setBounds(271, 44, 161, 24);

        fieldEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldEmailFocusLost(evt);
            }
        });
        fieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldEmailActionPerformed(evt);
            }
        });
        panelCreationContact.add(fieldEmail);
        fieldEmail.setBounds(271, 170, 161, 24);

        fieldPrenom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldPrenomFocusLost(evt);
            }
        });
        fieldPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPrenomActionPerformed(evt);
            }
        });
        panelCreationContact.add(fieldPrenom);
        fieldPrenom.setBounds(271, 86, 161, 24);

        fieldDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldDateFocusLost(evt);
            }
        });
        fieldDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDateActionPerformed(evt);
            }
        });
        panelCreationContact.add(fieldDate);
        fieldDate.setBounds(602, 212, 140, 24);

        fieldTel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldTelFocusLost(evt);
            }
        });
        fieldTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTelActionPerformed(evt);
            }
        });
        panelCreationContact.add(fieldTel);
        fieldTel.setBounds(271, 128, 161, 24);

        fieldTel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTel2ActionPerformed(evt);
            }
        });
        fieldTel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTel2KeyTyped(evt);
            }
        });
        panelCreationContact.add(fieldTel2);
        fieldTel2.setBounds(271, 212, 161, 24);

        panelType.setBorder(javax.swing.BorderFactory.createTitledBorder("Type de contacts "));
        panelType.setLayout(new java.awt.BorderLayout());

        buttonGroup1.add(rbAmi);
        rbAmi.setText("Ami");
        rbAmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAmiActionPerformed(evt);
            }
        });
        panelType.add(rbAmi, java.awt.BorderLayout.CENTER);

        buttonGroup1.add(rbFamille);
        rbFamille.setText("Famille");
        rbFamille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFamilleActionPerformed(evt);
            }
        });
        panelType.add(rbFamille, java.awt.BorderLayout.PAGE_START);

        buttonGroup1.add(rbConnaissance);
        rbConnaissance.setText("Connaissance");
        rbConnaissance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbConnaissanceActionPerformed(evt);
            }
        });
        panelType.add(rbConnaissance, java.awt.BorderLayout.PAGE_END);

        panelCreationContact.add(panelType);
        panelType.setBounds(11, 24, 135, 107);

        PanelCombo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Contacts")));

        comboContacts.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboContacts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboContactsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelComboLayout = new javax.swing.GroupLayout(PanelCombo);
        PanelCombo.setLayout(PanelComboLayout);
        PanelComboLayout.setHorizontalGroup(
            PanelComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComboLayout.createSequentialGroup()
                .addComponent(comboContacts, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        PanelComboLayout.setVerticalGroup(
            PanelComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelComboLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboContacts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        panelCreationContact.add(PanelCombo);
        PanelCombo.setBounds(11, 268, 150, 71);

        PanelRecherche.setBorder(javax.swing.BorderFactory.createTitledBorder("Recherche par id"));

        fieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdActionPerformed(evt);
            }
        });

        buttonRechercher.setText("Rechercher");
        buttonRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRechercherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRechercheLayout = new javax.swing.GroupLayout(PanelRecherche);
        PanelRecherche.setLayout(PanelRechercheLayout);
        PanelRechercheLayout.setHorizontalGroup(
            PanelRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRechercheLayout.createSequentialGroup()
                .addGroup(PanelRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRechercheLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(buttonRechercher))
                    .addGroup(PanelRechercheLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        PanelRechercheLayout.setVerticalGroup(
            PanelRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRechercheLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRechercher)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCreationContact.add(PanelRecherche);
        PanelRecherche.setBounds(11, 143, 143, 109);

        buttonSupprimer.setText("Supprimer");
        buttonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupprimerActionPerformed(evt);
            }
        });
        panelCreationContact.add(buttonSupprimer);
        buttonSupprimer.setBounds(450, 310, 109, 32);

        buttonAffichage.setText("Afficher mes contacts");
        buttonAffichage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAffichageActionPerformed(evt);
            }
        });
        panelCreationContact.add(buttonAffichage);
        buttonAffichage.setBounds(187, 307, 190, 32);

        buttonModifier.setText("Modifier");
        buttonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifierActionPerformed(evt);
            }
        });
        panelCreationContact.add(buttonModifier);
        buttonModifier.setBounds(570, 310, 115, 32);

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelCreationContact.add(jButton1);
        jButton1.setBounds(190, 270, 80, 32);

        buttonEnregistrer.setText("Creer");
        buttonEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnregistrerActionPerformed(evt);
            }
        });
        panelCreationContact.add(buttonEnregistrer);
        buttonEnregistrer.setBounds(660, 310, 115, 32);

        panneau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SwingInterface/panneau2.png"))); // NOI18N
        panneau.setText("   ATTENTION   LE CHAMP    NOM    EST    INVALIDE  ");
        panelCreationContact.add(panneau);
        panneau.setBounds(340, 250, 348, 40);

        panelCreation.add(panelCreationContact);
        panelCreationContact.setBounds(180, 0, 820, 350);

        PanelTree.setBorder(javax.swing.BorderFactory.createTitledBorder("Parcourir"));

        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout PanelTreeLayout = new javax.swing.GroupLayout(PanelTree);
        PanelTree.setLayout(PanelTreeLayout);
        PanelTreeLayout.setHorizontalGroup(
            PanelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        PanelTreeLayout.setVerticalGroup(
            PanelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
        );

        panelCreation.add(PanelTree);
        PanelTree.setBounds(10, 0, 170, 350);

        getContentPane().add(panelCreation, "card2");

        setSize(new java.awt.Dimension(1017, 391));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnregistrerActionPerformed

        Action = controles();

        if (Action) {
            CarnetAdresse monCarnet = new CarnetAdresse();
            DataManagement maBase = new DataManagement();

            Connaissances unContact = null;
            if (rbConnaissance.isSelected()) {
                unContact = new Connaissances();
            } else if (rbAmi.isSelected()) {
                unContact = new Amis();
                ((Amis) unContact).setTel2(fieldTel2.getText());
            } else if (rbFamille.isSelected()) {
                unContact = new Famille();
                ((Amis) unContact).setTel2(fieldTel2.getText());
                ((Famille) unContact).setDateNaissance(fieldDate.getText());
            }
            unContact.setNom(fieldNom.getText());
            unContact.setPrenom(fieldPrenom.getText());
            unContact.setTel(fieldTel.getText());
            unContact.setAdresse(fieldAdresse.getText());
            unContact.setCodePostal(fieldCp.getText());
            unContact.setVille(fieldVille.getText());
            unContact.setEmail(fieldEmail.getText());

            monCarnet.ajouter(unContact);
            maBase.ajout(unContact);
            JOptionPane.showMessageDialog(this, " le Contact a été créé ");
            clear();
            Sync();

        }
    }//GEN-LAST:event_buttonEnregistrerActionPerformed

    private void rbConnaissanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbConnaissanceActionPerformed
        labelTel2.setVisible(false);
        fieldTel2.setVisible(false);
        labelDate.setVisible(false);
        fieldDate.setVisible(false);
    }//GEN-LAST:event_rbConnaissanceActionPerformed

    private void rbFamilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFamilleActionPerformed
        labelTel2.setVisible(true);
        fieldTel2.setVisible(true);
        labelDate.setVisible(true);
        fieldDate.setVisible(true);
    }//GEN-LAST:event_rbFamilleActionPerformed

    private void rbAmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAmiActionPerformed
        labelTel2.setVisible(true);
        fieldTel2.setVisible(true);
        labelDate.setVisible(false);
        fieldDate.setVisible(false);
    }//GEN-LAST:event_rbAmiActionPerformed

    private void fieldTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTelActionPerformed


    }//GEN-LAST:event_fieldTelActionPerformed

    private void fieldDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDateActionPerformed

    private void fieldPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPrenomActionPerformed

    private void fieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldEmailActionPerformed

    private void fieldNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomActionPerformed

    private void fieldVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldVilleActionPerformed

    private void fieldCpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCpActionPerformed

    private void fieldAdresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAdresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAdresseActionPerformed

    private void fieldTel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTel2ActionPerformed

    }//GEN-LAST:event_fieldTel2ActionPerformed

    private void fieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdActionPerformed

    private void buttonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupprimerActionPerformed
        int retour = JOptionPane.showConfirmDialog(this,
                "Etes-Vous Sure  ?",
                "Supression",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (retour == JOptionPane.CLOSED_OPTION || retour == JOptionPane.NO_OPTION) {
            clear();
        } else {

            maBase.suppression(Integer.valueOf(fieldId.getText()));
            clear();
            JOptionPane.showMessageDialog(this, " le Contact a bien été supprimé ");
            Sync();
        }
        buttonSupprimer.setVisible(false);
        buttonModifier.setVisible(false);
        buttonEnregistrer.setVisible(true);
    }//GEN-LAST:event_buttonSupprimerActionPerformed

    private void buttonRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRechercherActionPerformed
        boolean present = false;
        int id = Integer.valueOf(fieldId.getText());
        for (Connaissances unContact : monCarnet) {
            if (unContact.getId() == id) {
                present = true;
                buttonEnregistrer.setVisible(false);
                buttonModifier.setVisible(true);
                buttonSupprimer.setVisible(true);
                fieldNom.setText(unContact.getNom());
                fieldPrenom.setText(unContact.getPrenom());
                fieldTel.setText(unContact.getTel());
                fieldEmail.setText(unContact.getEmail());
                fieldAdresse.setText(unContact.getAdresse());
                fieldCp.setText(unContact.getCodePostal());
                fieldVille.setText(unContact.getVille());
                if (unContact.getType() == 2) {
                    fieldTel2.setText(((Amis) unContact).getTel2());
                    fieldDate.setText(((Famille) unContact).getDateNaissance());
                    rbFamille.doClick();
                } else if (unContact.getType() == 1) {
                    fieldTel2.setText(((Amis) unContact).getTel2());
                    rbAmi.doClick();
                } else if (unContact.getType() == 0) {
                    rbConnaissance.doClick();
                }
            }
        }
        if (!present) {

            JOptionPane.showMessageDialog(this, " Ce Contact n'existe pas !");
            buttonModifier.setVisible(false);
            buttonEnregistrer.setVisible(true);
            buttonSupprimer.setVisible(false);
            clear();
        }

    }//GEN-LAST:event_buttonRechercherActionPerformed

    private void buttonAffichageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAffichageActionPerformed
        TableauContacts monTableau = new TableauContacts();
        monTableau.setVisible(true);
    }//GEN-LAST:event_buttonAffichageActionPerformed

    private void buttonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifierActionPerformed
        Action = controles();

        if (Action) {
            DataManagement maBase = new DataManagement();
            String nom = "nom = '" + fieldNom.getText() + "',";
            String prenom = "prenom= '" + fieldPrenom.getText() + "',";
            String tel = "tel = '" + fieldTel.getText() + "',";
            String email = "email = '" + fieldEmail.getText() + "',";
            String adresse = "adresse = '" + fieldAdresse.getText() + "',";
            String cp = "CodePostal = '" + fieldCp.getText() + "',";
            String ville = "ville = '" + fieldNom.getText() + "',";
            String tel2 = "tel2 = '" + fieldTel2.getText() + "',";
            String date = "date = '" + fieldDate.getText() + "',";
            String type = "type = '" + typeChoisi() + "'";
            String id = fieldId.getText();
            maBase.swingModifer(nom, prenom, tel, email, adresse, cp, ville, tel2, date, type, id);
            buttonSupprimer.setVisible(false);
            buttonModifier.setVisible(false);
            buttonEnregistrer.setVisible(true);
            clear();
            JOptionPane.showMessageDialog(this, "Le Contact à été modifié avec succès");
        }


    }//GEN-LAST:event_buttonModifierActionPerformed

    private void comboContactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboContactsActionPerformed

        Connaissances unContact = ((Connaissances) comboContacts.getSelectedItem());
        fieldNom.setText(unContact.getNom());
        fieldPrenom.setText(unContact.getPrenom());
        fieldTel.setText(unContact.getTel());
        fieldEmail.setText(unContact.getEmail());
        fieldAdresse.setText(unContact.getAdresse());
        fieldCp.setText(unContact.getCodePostal());
        fieldVille.setText(unContact.getVille());
        String id = String.valueOf(unContact.getId());
        fieldId.setText(id);
        if (unContact.getType() == 1) {
            fieldTel2.setText(((Amis) unContact).getTel2());
            rbAmi.doClick();
        } else if (unContact.getType() == 2) {
            fieldDate.setText(((Famille) unContact).getDateNaissance());
            fieldTel2.setText(((Amis) unContact).getTel2());
            rbFamille.doClick();
        } else {
            rbConnaissance.doClick();
        }
        buttonEnregistrer.setVisible(false);
        buttonModifier.setVisible(true);
        buttonSupprimer.setVisible(true);


    }//GEN-LAST:event_comboContactsActionPerformed

    private void fieldNomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNomFocusLost
        if (!utils.regexNom(fieldNom.getText())) {
            fieldNom.setBackground(Color.LIGHT_GRAY);
            panneau.setText("Le champ Nom est invalide");
            panneau.setVisible(true);
        } else {
            fieldNom.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
        if (fieldNom.getText().isEmpty()) {
            fieldNom.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
    }//GEN-LAST:event_fieldNomFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fieldAdresse.setText("");
        fieldNom.setText("");
        fieldPrenom.setText("");
        fieldCp.setText("");
        fieldVille.setText("");
        fieldTel.setText("");
        fieldEmail.setText("");
        fieldTel2.setText("");
        fieldDate.setText("");
        fieldId.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        DefaultMutableTreeNode tn = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        if (tn != null) {
            if (tn.getUserObject() instanceof Connaissances) {
                Connaissances unContact = ((Connaissances) tn.getUserObject());
                fieldNom.setText(unContact.getNom());
                fieldPrenom.setText(unContact.getPrenom());
                fieldTel.setText(unContact.getTel());
                fieldEmail.setText(unContact.getEmail());
                fieldAdresse.setText(unContact.getAdresse());
                fieldCp.setText(unContact.getCodePostal());
                fieldVille.setText(unContact.getVille());
                String id = String.valueOf(unContact.getId());
                fieldId.setText(id);
                if (unContact.getType() == 1) {
                    fieldTel2.setText(((Amis) unContact).getTel2());
                    rbAmi.doClick();
                } else if (unContact.getType() == 2) {
                    fieldDate.setText(((Famille) unContact).getDateNaissance());
                    fieldTel2.setText(((Amis) unContact).getTel2());
                    rbFamille.doClick();
                } else {
                    rbConnaissance.doClick();
                }
                buttonEnregistrer.setVisible(false);
                buttonModifier.setVisible(true);
                buttonSupprimer.setVisible(true);
            }
        }


    }//GEN-LAST:event_jTree1MouseClicked

    private void fieldTel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTel2KeyTyped

    }//GEN-LAST:event_fieldTel2KeyTyped

    private void fieldPrenomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldPrenomFocusLost
        if (!utils.regexNom(fieldPrenom.getText())) {
            fieldPrenom.setBackground(Color.LIGHT_GRAY);
            panneau.setText("Le champ Prenom est invalide");
            panneau.setVisible(true);
        } else {
            fieldPrenom.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
        if (fieldPrenom.getText().isEmpty()) {
            fieldPrenom.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
    }//GEN-LAST:event_fieldPrenomFocusLost

    private void fieldTelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldTelFocusLost
        if (!utils.regexTel(fieldTel.getText())) {
            fieldTel.setBackground(Color.LIGHT_GRAY);
            panneau.setText("Le numéro de Tel est invalide");
            panneau.setVisible(true);
        } else {
            fieldTel.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
        if (fieldTel.getText().isEmpty()) {
            fieldTel.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
    }//GEN-LAST:event_fieldTelFocusLost

    private void fieldEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldEmailFocusLost
        if (!utils.regexEmail(fieldEmail.getText())) {
            fieldEmail.setBackground(Color.LIGHT_GRAY);
            panneau.setText("L'Email est invalide");
            panneau.setVisible(true);
        } else {
            fieldEmail.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
        if (fieldEmail.getText().isEmpty()) {
            fieldEmail.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
    }//GEN-LAST:event_fieldEmailFocusLost

    private void fieldAdresseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldAdresseFocusLost
        if (!utils.regexAdresse(fieldAdresse.getText())) {
            fieldAdresse.setBackground(Color.LIGHT_GRAY);
            panneau.setText("L'Adresse est invalide");
            panneau.setVisible(true);
        } else {
            fieldAdresse.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
        if (fieldAdresse.getText().isEmpty()) {
            fieldAdresse.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
    }//GEN-LAST:event_fieldAdresseFocusLost

    private void fieldCpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCpFocusLost
        if (!utils.regexCp(fieldCp.getText())) {
            fieldCp.setBackground(Color.LIGHT_GRAY);
            panneau.setText("Le Code Postal est invalide");
            panneau.setVisible(true);
        } else {
            fieldCp.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
        if (fieldCp.getText().isEmpty()) {
            fieldCp.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
    }//GEN-LAST:event_fieldCpFocusLost

    private void fieldVilleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldVilleFocusLost
        if (!utils.regexNom(fieldVille.getText())) {
            fieldVille.setBackground(Color.LIGHT_GRAY);
            panneau.setText("La Ville est invalide");
            panneau.setVisible(true);
        } else {
            fieldVille.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
        if (fieldVille.getText().isEmpty()) {
            fieldVille.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
    }//GEN-LAST:event_fieldVilleFocusLost

    private void fieldDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldDateFocusLost
        if (!utils.regexDate(fieldDate.getText())) {
            fieldDate.setBackground(Color.LIGHT_GRAY);
            panneau.setText("format requis : DD-MM-YYYY");
            panneau.setVisible(true);
        } else {
            fieldDate.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
        if (fieldDate.getText().isEmpty()) {
            fieldDate.setBackground(Color.WHITE);
            panneau.setVisible(false);
        }
    }//GEN-LAST:event_fieldDateFocusLost
    private String typeChoisi() {
        if (rbConnaissance.isSelected()) {
            return "0";
        } else if (rbAmi.isSelected()) {
            return "1";
        } else if (rbFamille.isSelected()) {
            return "2";
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCombo;
    private javax.swing.JPanel PanelRecherche;
    private javax.swing.JPanel PanelTree;
    private javax.swing.JButton buttonAffichage;
    private javax.swing.JButton buttonEnregistrer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonModifier;
    private javax.swing.JButton buttonRechercher;
    private javax.swing.JButton buttonSupprimer;
    private javax.swing.JComboBox comboContacts;
    private javax.swing.JTextField fieldAdresse;
    private javax.swing.JTextField fieldCp;
    private javax.swing.JTextField fieldDate;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldNom;
    private javax.swing.JTextField fieldPrenom;
    private javax.swing.JTextField fieldTel;
    private javax.swing.JTextField fieldTel2;
    private javax.swing.JTextField fieldVille;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel labelAdresse;
    private javax.swing.JLabel labelCp;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPrenom;
    private javax.swing.JLabel labelTel;
    private javax.swing.JLabel labelTel2;
    private javax.swing.JLabel labelVille;
    private javax.swing.JPanel panelAdresse;
    private javax.swing.JPanel panelCreation;
    private javax.swing.JPanel panelCreationContact;
    private javax.swing.JPanel panelType;
    private javax.swing.JLabel panneau;
    private javax.swing.JRadioButton rbAmi;
    private javax.swing.JRadioButton rbConnaissance;
    private javax.swing.JRadioButton rbFamille;
    // End of variables declaration//GEN-END:variables
}
