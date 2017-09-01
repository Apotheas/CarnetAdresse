
package trisVectror;

import typesContacts.Connaissances;
import java.util.Comparator;


public class CompareCP implements Comparator<Connaissances>{

    @Override
    public int compare(Connaissances o1, Connaissances o2) {
        
        return o1.getCodePostal().compareToIgnoreCase(o2.getCodePostal());
    }


    

}
