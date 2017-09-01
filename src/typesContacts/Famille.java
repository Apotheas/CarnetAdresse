package typesContacts;

import typesContacts.Amis;

public class Famille extends Amis {

    private String dateNaissance;

    public Famille() {
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public int getType() {
        return 2;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

//    @Override
//    public String toString() {
//        return super.toString() + "\ndateNaissance : " + dateNaissance;
//    }

}
