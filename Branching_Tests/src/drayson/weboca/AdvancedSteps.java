package drayson.weboca;

import drayson.weboca.gui.WelcomePanel;
import java.util.Map;
import javax.swing.JComponent;
import org.netbeans.spi.wizard.WizardController;
import org.netbeans.spi.wizard.WizardPanelProvider;


public class AdvancedSteps extends WizardPanelProvider {
    
    /** Creates a new instance of CatLoversSteps */
    public AdvancedSteps() {
        super (
            new String[] { "a", "b" }, 
            new String[] { "c", "d" });
    }
    
    protected JComponent createPanel(WizardController controller, String id, Map settings) {
        switch (indexOfStep(id)) {
            case 0 :
                System.out.println("Case 0 in AdvancedSteps.java");
                return new WelcomePanel (controller, settings);
            case 1 :
                System.out.println("Case 1 in AdvancedSteps.java");
                return new WelcomePanel (controller, settings);
            default :
                throw new IllegalArgumentException (id);
        }
    }
    
}
