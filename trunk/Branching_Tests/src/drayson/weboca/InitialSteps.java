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
    private static final String CORPUS_LOVER = "corpusLover";
    private static final String WHICH_CORPUS = "whichCorpus";
    private static final String STEP_0_PROBLEM = "Only people who select the box can complete this wizard";

    /**
     * Creates a new instance of InitialSteps
     */
    InitialSteps () {
        super( "New WeBoCa", new String[] { CORPUS_LOVER, WHICH_CORPUS },
            new String[] { "Select basic preferences", "Choose something" } );
    }

    protected JComponent createPanel (final WizardController controller,
        final String id, final Map data) {
        
        switch ( indexOfStep( id ) ) {
            
            case 0 :

                JPanel result = new JPanel(  );
                result.setLayout( new BorderLayout(  ) );

                final JCheckBox checkbox = new JCheckBox( "Please click the box" );
                
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
