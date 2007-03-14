
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
            new String[] { "Load Corpus", "Process Corpus" },
            new String[] { "Load Corpus", "Process Corpus" });
    }
    
    protected JComponent createPanel(WizardController controller, String id, Map settings) {
        switch (indexOfStep(id)) {
            case 0 :
                return new LoadCorpusPanel();
                
            case 1 :
                return new ProcessPanel();

            default :
                throw new IllegalArgumentException (id);
        }
    }
    
}
