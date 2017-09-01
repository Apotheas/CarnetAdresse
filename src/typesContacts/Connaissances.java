package typesContacts;



public class Connaissances implements Comparable<Connaissances> {

    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String email;
    private String tel;

    public Connaissances() {

    }

    @Override
    public int compareTo(Connaissances o) {

        return this.nom.compareToIgnoreCase(o.nom);

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getType() {
        return 0;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return /*"nom : " + */ nom + " | " + prenom; /*+ "\nadresse : " + adresse + "\ncodePostal : " + codePostal + "\nville : " + ville + "\nemail : " + email + "\ntel : " + tel;*/
    }

}
