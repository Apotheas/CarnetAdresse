/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Apotheas
 */
public class Utilitaires {
    
    
    public boolean regexTel(String text){
    
        return text.matches( "(0|0033)[1-9][0-9]{8}");
    
    }
    
    public boolean regexEmail(String text){
        return text.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }
    public boolean regexNom(String text){
        if(text.isEmpty()){
            return false;
        }else
        return text.matches("[a-zA-Z]*");
    }
    
    public boolean regexDate(String text){
        return text.matches("\\d{2}-\\d{2}-\\d{4}");
    }
    public boolean regexCp(String text){
        return text.matches("((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}");
    }
    public boolean regexAdresse(String text){
        return text.matches("[0-9]{1,3}(?:(?:[,. ]){1}[-a-zA-Zàâäéèêëïîôöùûüç]+)+");
    }
}
