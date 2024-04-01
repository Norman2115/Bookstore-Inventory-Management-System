/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

/**
 *
 * @author User
 */
public class Verification {
    
    public boolean sqlInjectionProtect(String target){
        String invalidCharacters = "*-#'/'";
        for (char c : target.toCharArray()){
            if (invalidCharacters.contains(String.valueOf(c)))
                return false;
        }
        return true;
    }
    
    public boolean checkInteger(String target){
        if(sqlInjectionProtect(target)){
            // \d represents numeric characters and + means match more than one time
            String regex = "\\d+";
            return target.matches(regex);
        }
        else 
            return false;
    }
    
    public boolean checkFloatNumber(String target){
        if(sqlInjectionProtect(target)){
            String regex1 = "\\d+\\.\\d{1,2}$";
            String regex2 = "\\d+\\.?";
            return target.matches(regex1)||target.matches(regex2);
        }
        else 
            return false;        
    }
    
    
    
    
}
