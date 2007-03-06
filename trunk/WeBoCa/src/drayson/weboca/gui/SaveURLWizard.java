package drayson.weboca.gui;

import org.netbeans.spi.wizard.WizardPage;
        
public class SaveURLWizard extends WizardPage 
{
    
    String[] urls;
    int counter = -1;
    
    public void SaveURLWizard(String url)
    {
        counter = counter + 1;
        urls[counter] = url;
        System.out.println("The counter is now: " + counter);
        System.out.println("The url just saved to it was: " + url);
    }
}
    
   