package drayson.weboca;

import drayson.weboca.gui.WelcomePanel;
import java.util.Map;
import javax.swing.JComponent;
import org.netbeans.spi.wizard.WizardController;
import org.netbeans.spi.wizard.WizardPanelProvider;

import drayson.weboca.*;


public class SimpleSteps extends WizardPanelProvider {
    
    /** Creates a new instance of CatLoversSteps */
    public SimpleSteps() {
        super (
            new String[] { "hairLength", "breed" }, 
            new String[] { "Select hair length", "Choose breed" });
    }
    
    protected JComponent createPanel(WizardController controller, String id, Map settings) {
        switch (indexOfStep(id)) {
            case 0 :
                return new WelcomePanel (controller, settings);
            case 1 :
                return new WelcomePanel (controller, settings);
            default :
                throw new IllegalArgumentException (id);
        }
    }
    
}