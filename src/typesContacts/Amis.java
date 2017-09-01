package typesContacts;

public class Amis extends Connaissances {

    private String tel2;

    public Amis() {
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    @Override
    public int getType() {
        return 1;
    }

    public String getTel2() {
        return tel2;
    }

//    @Override
//    public String toString() {
//        return super.toString() + "\ntel2 : " + tel2;
//    }

}
