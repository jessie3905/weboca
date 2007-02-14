package drayson.weboca;

import drayson.weboca.gui.WelcomePanel;
import java.util.Map;
import javax.swing.JComponent;
import org.netbeans.spi.wizard.WizardController;
import org.netbeans.spi.wizard.WizardPanelProvider;

import drayson.weboca.*;


public class SimpleSteps extends WizardPanelProvider {
    
    /** Creates a new instance of SimpleSteps */
    public SimpleSteps() {
        super (
            new String[] { "one", "two" },
            new String[] { "Choose one", "Choose two" });
    }
    
    protected JComponent createPanel(WizardController controller, String id, Map settings) {
        switch (indexOfStep(id)) {
            case 0 :
                System.out.println("Case 0 in SimpleSteps.java");
                return new WelcomePanel (controller, settings);
                
            case 1 :
                System.out.println("Case 1 in SimpleSteps.java");
                return new WelcomePanel (controller, settings);
            default :
                throw new IllegalArgumentException (id);
        }
    }
    
}