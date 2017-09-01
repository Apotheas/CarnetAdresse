package consoleInterface;

import carnetadresse.CarnetAdresse;
import dataBase.DataManagement;
import typesContacts.Connaissances;
import typesContacts.Famille;
import typesContacts.Amis;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    private int index;
    private CarnetAdresse monCarnet = new CarnetAdresse();

    public CarnetAdresse getMonCarnet() {
        return monCarnet;
    }

    public void start() throws IOException {

        System.out.println("Bienvenue dans votre carnet d'adresse");
        boolean ouvert = true;

        while (ouvert) {

            System.out.println("\n1) Afficher les contacts ");
            System.out.println("2) Ajouter un nouveau contact ");
            System.out.println("3) Modifier un contact ");
            System.out.println("4) supprimer un contact ");
            System.out.println("5) Quitter");

            String choix = br.readLine();

            switch (choix) {
                case "1":
                    affichage();
                    break;
                case "2":
                    ajout();
                    break;
                case "3":
                    modifier();
                    break;
                case "4":
                    supprimer();
                    break;
                case "5":
                    ouvert = false;
                    break;
                default:
                    System.out.println("--ERREUR CETTE OPTION N'EST PAS DISPONIBLE--\n");
                    break;
            }
        }

    }

    private void ajout() throws IOException {

        System.out.println("Selectionnez un type de contact : ");
        System.out.println("1) Connaissance");
        System.out.println("2) Amis");
        System.out.println("3) Famille");

        String choix = br.readLine();

        switch (choix) {
            case "1":
                Connaissances uneConnaissance = new Connaissances();
                insertContact(uneConnaissance);
                break;
            case "2":
                Amis unAmis = new Amis();
                insertContact(unAmis);
                break;
            case "3":
                Famille maFamille = new Famille();
                insertContact(maFamille);
                break;
            default:
                System.out.println("--ERREUR CETTE OPTION N'EST PAS DISPONIBLE--\n");
                break;
        }

    }

    private Connaissances insertContact(Connaissances unContact) throws IOException {
        String nom;
        String prenom;
        String tel;
        DataManagement maBase = new DataManagement();
        do {
            System.out.println("Entrez le Nom");
            nom = br.readLine();
            if (nom.isEmpty()) {
                System.out.println("--LE NOM EST OBLIGATOIRE--");
            }
        } while (nom.isEmpty());
        do {
            System.out.println("Entrez le Prenom");
            prenom = br.readLine();
            if (prenom.isEmpty()) {
                System.out.println("--LE PRENOM EST OBLIGATOIRE--");
            }
        } while (prenom.isEmpty());
        do {
            System.out.println("Entrez le Numéro de téléphone");
            tel = br.readLine();
            if (tel.isEmpty()) {
                System.out.println("--LE NUMERO DE TELEPHONE EST OBLIGATOIRE--");
            }
        } while (tel.isEmpty());

        System.out.println("Entrez une adresse");
        String adresse = br.readLine();
        System.out.println("Entrez le code postal ");
        String cp = br.readLine();
        System.out.println("Entrez la ville");
        String ville = br.readLine();
        System.out.println("Entrez votre adresse Email");
        String email = br.readLine();

        unContact.setTel(tel);
        unContact.setNom(nom);
        unContact.setPrenom(prenom);
        unContact.setAdresse(adresse);
        unContact.setCodePostal(cp);
        unContact.setVille(ville);
        unContact.setEmail(email);

        if (unContact.getType() == 1 || unContact.getType() == 2) {
            System.out.println("Entrez un second numéro de telephone");
            String tel2 = br.readLine();
            ((Amis) unContact).setTel2(tel2);

        }
        if (unContact.getType() == 2) {
            System.out.println("Entrez une date de naissance");
            String date = br.readLine();
            ((Famille) unContact).setDateNaissance(date);
        }
        maBase.ajout(unContact);
        monCarnet.ajouter(unContact);
        return unContact;
    }

    private void modifier() throws IOException {
        synchro();

        System.out.println("Entrez le numero du contact à modifier : ");
        String indexS = br.readLine();
        index = Integer.valueOf(indexS);
        for (Connaissances unContact : monCarnet.getMesContacts()) {
            if (unContact.getId() == index) {
                updateContact(unContact);
            }
        }

    }

    private void updateContact(Connaissances unContact) throws IOException {

        DataManagement maBase = new DataManagement();

        String commune = "1) Nom\n2) Prenom\n3) Tel\n4) Adresse\n5) Ville\n6) Code Postal\n7) Email";
        System.out.println("Quels champs voulez vous modifier ?");
        if (unContact.getType() == 2) {
            System.out.println(commune + "\n8) Tel2\n9) Date de naissance");
        } else if (unContact.getType() == 1) {
            System.out.println(commune + "\n8) Tel2");
        } else {
            System.out.println(commune);
        }

        String choixS = br.readLine();
        int choix = Integer.valueOf(choixS);

        String colonne = "?";

        switch (choix) {
            case 1:
                colonne = "nom";
                System.out.println("Entrez nouveau Nom");
                String nom = br.readLine();
                unContact.setNom(nom);
                maBase.update(colonne, nom, index);
                break;
            case 2:
                colonne = "prenom";
                System.out.println("Entrez nouveau Prenom");
                String prenom = br.readLine();
                unContact.setPrenom(prenom);
                maBase.update(colonne, prenom, index);
                break;
            case 3:
                colonne = "tel";
                System.out.println("Entrez nouveau Tel");
                String tel = br.readLine();
                unContact.setTel(tel);
                maBase.update(colonne, tel, index);
                break;
            case 4:
                colonne = "adresse";
                System.out.println("Entrez nouvelle Adresse");
                String adresse = br.readLine();
                unContact.setAdresse(adresse);
                maBase.update(colonne, adresse, index);
                break;
            case 5:
                colonne = "ville";
                System.out.println("Entrez nouvelle Ville");
                String ville = br.readLine();
                unContact.setVille(ville);
                maBase.update(colonne, ville, index);
                break;
            case 6:
                colonne = "codePostal";
                System.out.println("Entrez nouveau Code Postal");
                String cp = br.readLine();
                unContact.setCodePostal(cp);
                maBase.update(colonne, cp, index);
                break;
            case 7:
                colonne = "email";
                System.out.println("Entrez nouvelle adresse Email");
                String email = br.readLine();
                unContact.setEmail(email);
                maBase.update(colonne, email, index);
                break;
            case 8:
                colonne = "tel2";
                if (unContact.getType() == 1 || unContact.getType() == 2) {
                    System.out.println("Entrez nouveau Tel2");
                    String tel2 = br.readLine();
                    ((Amis) unContact).setTel2(tel2);
                    maBase.update(colonne, tel2, index);
                } else {
                    System.out.println("ERREUR, MAUVAIS TYPE DE CONTACT");
                }
                break;
            case 9:
                colonne = "date";
                if (unContact.getType() == 2) {
                    System.out.println("Entrez nouvelle date de naissance");
                    String dateNaissance = br.readLine();
                    ((Famille) unContact).setDateNaissance(dateNaissance);
                    maBase.update(colonne, dateNaissance, index);
                } else {
                    System.out.println("ERREUR, MAUVAIS TYPE DE CONTACT");
                }
                break;
            default:
                System.out.println("--ERREUR CETTE OPTION N'EST PAS DISPONIBLE--\n");
                break;
        }

    }

    private void supprimer() throws IOException {
        DataManagement maBase = new DataManagement();
        System.out.println("Entrez le numero du contact à supprimer : ");
        String indexS = br.readLine();
        index = Integer.valueOf(indexS);

        maBase.suppression(index);

    }

    private void affichage() throws IOException {

        synchro();

        System.out.println("Choix du mode d'affichage :");
        System.out.println("1) Ordre actuel");
        System.out.println("2) Tris Par Noms ");
        System.out.println("3) Tris Par Types");
        System.out.println("4) Tris Par Code Postal");
        System.out.println("5) Un Type uniquement");

        String choix = br.readLine();

        switch (choix) {
            case "1":
                affichageVector();
                break;
            case "2":
                monCarnet.triNom();
                affichageVector();
                break;
            case "3":
                monCarnet.triType();
                affichageVector();
                break;
            case "4":
                monCarnet.triCodePostal();
                affichageVector();
                break;
            case "5":
                System.out.println("Choissisez Votre Type");
                System.out.println("0) Connaissance");
                System.out.println("1) Amis");
                System.out.println("2) Famille");

                String choix2 = br.readLine();
                int type = Integer.valueOf(choix2);

                switch (choix2) {
                    case "0":
                        triTypeUnique(type);
                        break;
                    case "1":
                        triTypeUnique(type);
                        break;
                    case "2":
                        triTypeUnique(type);
                        break;
                    default:
                        System.out.println("--ERREUR CETTE OPTION N'EST PAS DISPONIBLE--\n");
                        break;

                }

        }
    }

    public void triTypeUnique(int type) {
        for (Connaissances Contact : monCarnet.getMesContacts()) {
            if (Contact.getType() == type) {
                System.out.println("\n--Contact numéro : " + Contact.getId()
                        + "\n--Type : " + Contact.getClass().getSimpleName() + "\n" + Contact);
            }
        }

    }

    private void affichageVector() {
        for (Connaissances unContact : monCarnet.getMesContacts()) {
            System.out.println("\n--Contact numéro : " + unContact.getId()
                    + "\n--Type : " + unContact.getClass().getSimpleName() + "\n" + unContact);
        }
    }

    private void synchro() {
        monCarnet.supprimerAll();
        DataManagement maBase = new DataManagement();
        monCarnet.setMesContacts(maBase.synchroVectorR());
    }

}
