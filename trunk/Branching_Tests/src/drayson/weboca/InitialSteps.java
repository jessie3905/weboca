package drayson.weboca;

import org.netbeans.spi.wizard.WizardController;
import org.netbeans.spi.wizard.WizardException;
import org.netbeans.spi.wizard.WizardPanelProvider;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

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
    private static final String STEP_0_PROBLEM = "Please agree to the disclaimer before continuing";

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

                JPanel result = new JPanel(  );
                result.setLayout( new BorderLayout(  ) );

                final JCheckBox checkbox = new JCheckBox( "Please check to agree to disclaimer" );
                
                checkbox.addActionListener( new ActionListener(  ) {
                        public void actionPerformed( ActionEvent ae ) {
                            if ( checkbox.isSelected(  ) ) {
                                controller.setProblem( null );
                            } else {
                                controller.setProblem( STEP_0_PROBLEM );
                            }
                        }
                    } );

                result.add ( checkbox );

                controller.setProblem( STEP_0_PROBLEM );
                return result;
                
            case 1 :
                return new WelcomePanel(controller,data);
                
            default :
                throw new IllegalArgumentException ( id );
        }
    }
}
