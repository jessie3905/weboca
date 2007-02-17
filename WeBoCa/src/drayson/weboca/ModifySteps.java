
package drayson.weboca;

import drayson.weboca.gui.*;
import java.util.Map;
import javax.swing.JComponent;
import org.netbeans.spi.wizard.WizardController;
import org.netbeans.spi.wizard.WizardPanelProvider;


public class ModifySteps extends WizardPanelProvider {
    
    /** Creates a new instance of CatLoversSteps */
    public ModifySteps() {
        super (
            new String[] { "Summary" },
            new String[] { "Summary" });
    }
    
    protected JComponent createPanel(WizardController controller, String id, Map settings) {
        switch (indexOfStep(id)) {
            case 0 :
                return new SummaryPanel();
                
            default :
                throw new IllegalArgumentException (id);
        }
    }
    
}
