package drayson.weboca;

import java.util.Map;
import org.netbeans.spi.wizard.WizardBranchController;
import org.netbeans.spi.wizard.WizardPanelProvider;
import drayson.weboca.gui.WelcomePanel;
import javax.swing.SwingUtilities;
import org.netbeans.api.wizard.WizardDisplayer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * This is the main entry point, from which the wizard is created.
 *
 * @author Timothy Boudreau
 */
public class NewWeBoCaWizard extends WizardBranchController {

    NewWeBoCaWizard(  ) {
        
        super( new InitialSteps(  ) );
        
        // Get the native look and feel class name
        String nativeLF = UIManager.getSystemLookAndFeelClassName();
        
        // Motif is ugly. Use the cross-platform instead.
        if (nativeLF.equals("com.sun.java.swing.plaf.motif.MotifLookAndFeel")) {
            nativeLF = UIManager.getCrossPlatformLookAndFeelClassName();
        }
    
        // Install the look and feel and catch any errors
        try {
            UIManager.setLookAndFeel(nativeLF);
        } catch (InstantiationException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println(e);
        } catch (IllegalAccessException e) {
            System.err.println(e);
        }
        
    }
   
    protected WizardPanelProvider getPanelProviderForStep(String step, Map collectedData) 
    {
        Object userType = collectedData.get(WelcomePanel.userType);
        
        if (WelcomePanel.VALUE_CURRENT == "simple") {
            return getSimpleSteps();
        } else if (WelcomePanel.VALUE_CURRENT == "advanced") {
            return getAdvancedSteps();
        } else {
            return null;
        }
    }

    private WizardPanelProvider getSimpleSteps() {
        if (simpleSteps == null) {
            simpleSteps = new SimpleSteps();
        }
        return simpleSteps;
    }

    private WizardPanelProvider getAdvancedSteps() {
        if (advancedSteps == null) {
            advancedSteps = new AdvancedSteps();
        }
        return advancedSteps;
    }
    
    private SimpleSteps simpleSteps = null;
    private AdvancedSteps advancedSteps = null;
    
    
    
   public static void main(String[] args) {

   SwingUtilities.invokeLater(new Runnable(){ public void run() {

   WizardDisplayer.showWizard (new NewWeBoCaWizard().createWizard()) ;

    }});

}
    
}