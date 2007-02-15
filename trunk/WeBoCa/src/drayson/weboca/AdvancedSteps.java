package drayson.weboca;

import drayson.weboca.gui.*;
import java.util.Map;
import javax.swing.JComponent;
import org.netbeans.spi.wizard.WizardController;
import org.netbeans.spi.wizard.WizardPanelProvider;


public class AdvancedSteps extends WizardPanelProvider {
    
    /** Creates a new instance of CatLoversSteps */
    public AdvancedSteps() {
        super (
            new String[] { "Corpus Destination", "Seeds", "Tuples", "Search Engines", "Search Results", "Download Corpus", "Summary" },
            new String[] { "Choose Corpus Destination", "Specify seed terms", "Generate tuples", "Search Engines", "Search Results", "Download Corpus", "Summary" });
    }
    
    protected JComponent createPanel(WizardController controller, String id, Map settings) {
        switch (indexOfStep(id)) {
            case 0 :
                return new CorpusDestinationPanel();
                
            case 1 :
                return new SeedPanel();
                
            case 2 :
                return new TuplePanel();
                
            case 3 :
                return new SearchEngineConfigPanel();
                
            case 4 :
                return new SearchResultsPanel();
                
            case 5 :
                return new SearchDownloadPanel();
                
            case 6 :
                return new SummaryPanel();
                
            default :
                throw new IllegalArgumentException (id);
        }
    }
    
}
