/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author leonardo
 */
public class LocaleUtil {
    
    public static ResourceBundle getBundle(String file, String language, String country){
        return ResourceBundle.getBundle("properties/" + file, new Locale(language,country));
    }
    
}
