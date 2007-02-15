package drayson.weboca;

import drayson.weboca.gui.DisclaimerPanel;
import org.netbeans.spi.wizard.WizardController;
import org.netbeans.spi.wizard.WizardPanelProvider;

import java.util.Map;
import javax.swing.JComponent;

import drayson.weboca.gui.WelcomePanel;



/**
 * Defines the first two panes of the wizard.  The second one is where the
 * user decides what comes next.
 *
 * @author Timothy Boudreau
 */
public class InitialSteps extends WizardPanelProvider {
    private static final String APP_METHOD = "appMethod";
    private static final String DISCLAIMER = "disclaimer";


    /**
     * Creates a new instance of InitialSteps
     */
    InitialSteps () {
        super( "Welcome to WeBoca", new String[] { DISCLAIMER, APP_METHOD },
            new String[] { "Disclaimer", "Select application method" } );
    }

    protected JComponent createPanel (final WizardController controller,
        final String id, final Map data) {
        
        switch ( indexOfStep( id ) ) {
            
            case 0 :
                return new DisclaimerPanel();
                
            case 1 :
                return new WelcomePanel(controller,data);
                
            default :
                throw new IllegalArgumentException ( id );
        }
    }
}
