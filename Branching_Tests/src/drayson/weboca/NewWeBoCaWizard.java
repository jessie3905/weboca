package drayson.weboca;

import java.util.Map;
import org.netbeans.spi.wizard.WizardBranchController;
import org.netbeans.spi.wizard.WizardPanelProvider;
import drayson.weboca.gui.WelcomePanel;
import javax.swing.SwingUtilities;


/**
 * This is the main entry point, from which the wizard is created.
 *
 * @author Timothy Boudreau
 */
public class NewWeBoCaWizard extends WizardBranchController {

    NewWeBoCaWizard(  ) {
        super( new InitialSteps(  ) );
    }
   
    protected WizardPanelProvider getPanelProviderForStep(String step, Map collectedData) {
        //There's only one branch point, so we don't need to test the
        //value of step
        Object userType = collectedData.get(WelcomePanel.userType);
        
        if (WelcomePanel.VALUE_SIMPLE.equals("simple")) {
            return getSimpleSteps();
        } else if (WelcomePanel.VALUE_ADVANCED.equals("advanced")) {
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
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new NewWeBoCaWizard();
            }});
        
    }
    
}