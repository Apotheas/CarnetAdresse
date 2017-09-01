
package carnetadresse;


import SwingInterface.InterfaceGlobale;
import dataBase.DataManagement;
import consoleInterface.Console;
import java.io.IOException;

public class Main {

    
    public static void main(String[] args) throws IOException {
         
        
        DataManagement base = new DataManagement();
        
        InterfaceGlobale interfaceAjout = new InterfaceGlobale();

        base.loadingDrivers();        
           
        
        interfaceAjout.setVisible(true); 
           
       
    
    }
    
}
