/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresse;

import dataBase.DataManagement;
import typesContacts.Connaissances;
import trisVectror.CompareClass;
import trisVectror.CompareCP;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author cdi317
 */
public class CarnetAdresse {

    private static Vector<Connaissances> mesContacts = new Vector();
    

    
    

    public Vector<Connaissances> getMesContacts() {
        
        return mesContacts;
    }

    public void setMesContacts(Vector<Connaissances> mesContacts) {
        this.mesContacts = mesContacts;
    }

    public void ajouter(Connaissances unContact) {
        mesContacts.add(unContact);
    }

    public void supprimerAll() {
        mesContacts.removeAllElements();

    }

    public void supprimer(Connaissances unContact) {
        mesContacts.remove(unContact);
    }

    public void triNom() {
        Collections.sort(mesContacts);
    }

    public void triType() {
        CompareClass classCompare = new CompareClass();
        Collections.sort(mesContacts, classCompare);
    }

    public void triCodePostal() {
        CompareCP codeCompare = new CompareCP();
        Collections.sort(mesContacts, codeCompare);
    }
    
    

}
