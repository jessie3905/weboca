/**
 * NewWeBoCaWizard.java
 */

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
 *<p>
 * The class extends WizardBranchController and sets the GUI look and feel of the wizard.
 *
 * @author Michael Drayson
 * @exception e Unable to load the default GUI skin
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
   
    /**
     * This method outlines the branching options and returns a map dependant on what is chosen
     *
     * @param step The step choosen
     * @param map The map of the possible application routes
     * @return A wizard panel provider for constructing the correct panel on the left hand side of the wizard
     */
    protected WizardPanelProvider getPanelProviderForStep(String step, Map collectedData) 
    {
        Object userType = collectedData.get(WelcomePanel.userType);
        
        if (WelcomePanel.VALUE_CURRENT == "simple") {
            return getSimpleSteps();
        } 
        else if (WelcomePanel.VALUE_CURRENT == "advanced") {
            return getAdvancedSteps();
        } 
        else if (WelcomePanel.VALUE_CURRENT == "modify") {
            return getModifySteps();
        } 
        else {
            return null;
        }
    }

    /**
     * Returns a WizardPanelProvider for the simple steps
     */
    private WizardPanelProvider getSimpleSteps() {
        if (simpleSteps == null) {
            simpleSteps = new SimpleSteps();
        }
        return simpleSteps;
    }

    /**
     * Returns a WizardPanelProvider for the advanced steps
     */
    private WizardPanelProvider getAdvancedSteps() {
        if (advancedSteps == null) {
            advancedSteps = new AdvancedSteps();
        }
        return advancedSteps;
    }
    
    /**
     * Returns a WizardPanelProvider for the modify steps
     */
   private WizardPanelProvider getModifySteps() {
        if (modifySteps == null) {
            modifySteps = new ModifySteps();
        }
        return modifySteps;
    }
    
    private SimpleSteps simpleSteps = null;
    private AdvancedSteps advancedSteps = null;
    private ModifySteps modifySteps = null;
    
    
    /**
     * Main application entry point for WeBoCa
     */
   public static void main(String[] args) {

   SwingUtilities.invokeLater(new Runnable(){ public void run() {

   WizardDisplayer.showWizard (new NewWeBoCaWizard().createWizard()) ;

    }});
   }
}