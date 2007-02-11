/*
 * WeBoCa.java
 *
 * The initial super class that executes the WeBoCa application
 *
 * @author Michael Drayson
 * @version 1.0
 */

package drayson.weboca;

import drayson.weboca.gui.CorpusDestinationPanel;
import drayson.weboca.gui.SearchDownloadPanel;
import drayson.weboca.gui.SearchEngineConfigPanel;
import drayson.weboca.gui.SearchResultsPanel;
import drayson.weboca.gui.SeedPanel;
import drayson.weboca.gui.SummaryPanel;
import drayson.weboca.gui.TuplePanel;
import drayson.weboca.gui.DisclaimerPanel;
import drayson.weboca.gui.WelcomePanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.netbeans.api.wizard.WizardDisplayer;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPage.WizardResultProducer;

import java.util.Map;
import org.netbeans.spi.wizard.WizardController;


public class WeBoCa {
    
    private final WizardController controller;
    private final Map wizardData;
    
    /**
     * Creates a new instance of WeBoCa
     */
    public WeBoCa(WizardController controller, Map wizardData) {
        
        //initComponents();
        this.controller = controller;
        this.wizardData = wizardData;
        
        controller.setProblem("No Option Selected");
        
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
        
        // Create a list of Wizard Pages in the order they are to exist within the Wizard
        WizardPage[] wpages = new WizardPage[] {
                new DisclaimerPanel(),
                //new WelcomePanel(),
                new CorpusDestinationPanel(),
                new SeedPanel(),
                new TuplePanel(),
                new SearchEngineConfigPanel(),
                new SearchResultsPanel(),
                new SearchDownloadPanel(),
                new SummaryPanel()
       };
            
        // Create the Wizard itself
        Wizard wizard = WizardPage.createWizard("WeBoCa v0.1", wpages, WizardResultProducer.NO_OP);
        
        //And show it onscreen
        WizardDisplayer.showWizard (wizard);
           
    }
}
