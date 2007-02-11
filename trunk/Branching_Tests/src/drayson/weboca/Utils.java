/*
 * Utils.java
 *
 * Created on 15 May 2006, 23:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package drayson.weboca;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Andy
 */
public class Utils {
    
    private Utils() {
    }
    
    public static String loadFile(File file) throws FileNotFoundException, IOException {
        String buffer = "";
        String content = "";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        while ((buffer = reader.readLine()) != null) {
            content += buffer;
            content += "\n";
            //content += System.getProperty("line.separator");
        }
        
        reader.close();
        
        return content;
    }
    
    public static void saveFile(String content, File file) throws FileNotFoundException, IOException {
               
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        
        content = normaliseNewlines(content);
        content = content.replaceAll("\n", System.getProperty("line.separator"));
        writer.write(content);
        
        writer.close();
     
    }

    public static String normaliseNewlines(String input) {
        
        input = input.replaceAll("\r\n", "\n");
        input = input.replaceAll("\r", "\n");
        
        return input;
    }
    
    // Taken from JavaWorld tips:
    // http://www.javaworld.com/javaworld/javatips/jw-javatip62.html
    public static Component GetParent(Component component, String compType ) {
        Component  resultingComponent = null;
        while (component != null && resultingComponent == null) {
            if ( compType.equals( component.getClass().getName() ) ) {
                
                resultingComponent = component;
            } else {
                component = component.getParent();
            }
            
        }
        
        return resultingComponent;
        
    }
    
}
