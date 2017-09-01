
package trisVectror;

import typesContacts.Connaissances;
import java.util.Comparator;


public class CompareClass implements Comparator<Connaissances>{

    @Override
    public int compare(Connaissances o1, Connaissances o2) {
        return o1.getClass().getName().compareToIgnoreCase(o2.getClass().getName());
    }
    
    

}
