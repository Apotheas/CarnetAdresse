/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import SwingInterface.InterfaceGlobale;
import carnetadresse.CarnetAdresse;
import typesContacts.Connaissances;
import typesContacts.Famille;
import typesContacts.Amis;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DataManagement {

    private static final String drivers = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=monCarnet;"
            + "user=sa;password=sa";
    public CarnetAdresse monCarnet = new CarnetAdresse();

    public void loadingDrivers() {

        try {
            Class.forName(drivers);
        } catch (ClassNotFoundException ex) {            
            JOptionPane.showMessageDialog(null, "Oops: ClassNotFoundException : " + ex.getMessage());
        }

    }

    public Vector synchroVectorR() {
        monCarnet.supprimerAll();
        ResultSet result = null;

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement();) {

            result = stmt.executeQuery("SELECT * FROM mesContacts");

            while (result.next()) {
                Connaissances unContact = null;
                if (result.getInt("type") == 2) {
                    unContact = new Famille();
                } else if (result.getInt("type") == 1) {
                    unContact = new Amis();
                } else {
                    unContact = new Connaissances();
                }
                unContact.setId(result.getInt("id"));
                unContact.setNom(result.getString("nom"));
                unContact.setPrenom(result.getString("prenom"));
                unContact.setTel(result.getString("tel"));
                unContact.setEmail(result.getString("email"));
                unContact.setAdresse(result.getString("adresse"));
                unContact.setCodePostal(result.getString("codePostal"));
                unContact.setVille(result.getString("ville"));
                if (result.getInt("type") == 1 || result.getInt("type") == 2) {
                    ((Amis) unContact).setTel2(result.getString("tel2"));
                }
                if (result.getInt("type") == 2) {
                    ((Famille) unContact).setDateNaissance(result.getString("date"));
                }
                monCarnet.ajouter(unContact);
            }
            result.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Oops: Erreur de synchro : " + e.getMessage());
        }
        return monCarnet.getMesContacts();
    }

    public void update(String colonne, String entreeU, int index) {

        String query = "UPDATE mesContacts SET " + colonne + "='" + entreeU + "'  WHERE id = '" + (index) + "'";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement();) {
            stmt.execute(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Oops: Erreur d'Update : " + e.getMessage());
        }
    }

    public void suppression(int index) {
        String query = "DELETE FROM mesContacts WHERE id = '" + index + "'";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement();) {
            stmt.execute(query);
            System.out.println("well ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Oops: Erreur de supression : " + e.getMessage());
        }
    }

    public void ajout(Connaissances unContact) {

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement();) {

            String nom = unContact.getNom();
            String prenom = unContact.getPrenom();
            String adresse = unContact.getAdresse();
            String tel = unContact.getTel();
            String email = unContact.getEmail();
            String ville = unContact.getVille();
            String codePostal = unContact.getCodePostal();
            String tel2 = "";
            String date = "";
            int type = unContact.getType();

            if (unContact.getType() == 1 || unContact.getType() == 2) {
                tel2 = ((Amis) unContact).getTel2();
            }
            if (unContact.getType() == 2) {
                date = ((Famille) unContact).getDateNaissance();
            }

            String query = "INSERT INTO mesContacts VALUES"
                    + " ('" + nom + "','" + prenom + "','" + tel + "','" + adresse + "','" + codePostal + "','" + ville
                    + "','" + email + "','" + tel2 + "','" + date + "','" + type + "')";

            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Oops: Erreur d'insertion : " + ex.getMessage());
        }

    }

    public void affichageTableauSpec(DefaultTableModel leModel, String type) {
        String query;
        query = "SELECT * FROM mesContacts Where type = " + type + " ";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement();) {
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                leModel.addRow(new Object[]{result.getString("id"), result.getString("nom"), result.getString("prenom"), result.getString("tel"),
                    result.getString("adresse"), result.getString("codePostal"), result.getString("ville"), result.getString("email"),
                    result.getString("tel2"), result.getString("Date"), result.getString("type")});

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Oops: Erreur d'Update : " + e.getMessage());;
        }
    }

    public void affichageTableau(DefaultTableModel leModel) {
        String query;
        query = "SELECT * FROM mesContacts  ";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement();) {
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                leModel.addRow(new Object[]{result.getString("id"), result.getString("nom"), result.getString("prenom"), result.getString("tel"),
                    result.getString("adresse"), result.getString("codePostal"), result.getString("ville"), result.getString("email"),
                    result.getString("tel2"), result.getString("Date"), result.getString("type")});

            }

        } catch (SQLException e) {
            System.out.println("Erreur d'update " + e.getMessage());
        }
    }

    public void swingModifer(String nom, String prenom, String tel, String email, String adresse,
            String cp, String ville, String tel2, String date, String type, String id) {

        String query = "UPDATE mesContacts SET " + nom + prenom + tel + email + adresse + cp + ville + tel2 + date + type + "  WHERE id = '" + id + "'";
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement();) {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Erreur de modification :  " + ex.getMessage());
        }

    }

}
