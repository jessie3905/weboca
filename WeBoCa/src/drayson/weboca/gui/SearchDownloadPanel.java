/*
 * SearchDownloadPanel.java
 *
 * Created on 25 July 2006, 21:17
 */

package drayson.weboca.gui;

import drayson.weboca.DownloadStatus;
import drayson.weboca.DownloadUrls;
import drayson.weboca.Utils;
import drayson.weboca.search.SearchResult;
import java.awt.Component;
import java.awt.Cursor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.spi.wizard.WizardController;
import org.netbeans.spi.wizard.WizardPage;
import java.lang.Object;

/**
 *
 * @author  Andy Roberts
 */
public class SearchDownloadPanel extends WizardPage {
    boolean downloadComplete = false;
    /** Creates new form SearchDownloadPanel */
    public SearchDownloadPanel() {
        super("Download Corpus", "Download Corpus");
        initComponents();
    }
    
    public static String getDescription() {
        
        return "Download Corpus";
    }
    
    protected String validateContents (Component component, Object o) {
        
        if (prgOverall.getValue() != prgOverall.getMaximum()) {
            return "Must select Download to proceed.";
        } else {
            return null;
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnDownload = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        prgOverall = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        lblWordCount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        prgCurrent = new javax.swing.JProgressBar();
        lblStatus = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNumUrlsDownloaded = new javax.swing.JLabel();
        lblNumUrlErrors = new javax.swing.JLabel();
        lblNumInvalidSize = new javax.swing.JLabel();
        lblCurrentCorpusSize = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        btnDownload.setText("Download");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        jLabel1.setText("Overall Progress");

        lblWordCount.setText("0");
        lblWordCount.setName("lblWordCount");

        jLabel3.setText("Current word count:");

        jLabel4.setText("Current URL Progress");

        lblStatus.setText("status");
        lblStatus.setText("");

        jLabel6.setText("Details");

        jLabel2.setText("URLs downloaded:");

        jLabel5.setText("No response:");

        jLabel7.setText("Invalid size:");

        jLabel8.setText("Current corpus size:");

        lblNumUrlsDownloaded.setText("0");
        lblNumUrlsDownloaded.setName("lblNumUrlsDownloaded");

        lblNumUrlErrors.setText("0");

        lblNumInvalidSize.setText("0");

        lblCurrentCorpusSize.setText("0");
        lblCurrentCorpusSize.setName("lblCurrentCorpusSize");

        jLabel9.setText("Click button to start downloading the corpus:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(prgCurrent, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .add(jLabel1)
                    .add(layout.createSequentialGroup()
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 253, Short.MAX_VALUE)
                        .add(lblStatus))
                    .add(jLabel6)
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(jLabel2)
                            .add(jLabel5)
                            .add(jLabel7)
                            .add(jLabel8))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblNumUrlsDownloaded, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .add(lblNumUrlErrors, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .add(lblNumInvalidSize, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .add(lblWordCount, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .add(lblCurrentCorpusSize, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
                    .add(prgOverall, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel9)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 92, Short.MAX_VALUE)
                        .add(btnDownload)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnDownload)
                    .add(jLabel9))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(prgOverall, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(lblStatus))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(prgCurrent, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(lblNumUrlsDownloaded))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(lblNumUrlErrors))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(lblNumInvalidSize))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(lblWordCount))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(lblCurrentCorpusSize))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
  
    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        
        final JFrame parentFrame = (JFrame)Utils.GetParent(this, "javax.swing.JFrame");
        parentFrame.setCursor(Cursor.WAIT_CURSOR);
        
        btnDownload.setEnabled(false);
        // Get the results from the previous page
        List<String> selectedFiles = new ArrayList<String>();
        Set<SearchResult> searchResultsSet = (Set) this.getWizardData("searchResults");
        
        List<SearchResult> searchResultsList = new ArrayList<SearchResult>(searchResultsSet);
        
        JList resultsList = (JList) this.getWizardData("listResults");
        CheckListManager manager = (CheckListManager) this.getWizardData("checkManager");
        DefaultListSelectionModel listModel = (DefaultListSelectionModel) manager.getSelectionModel();
        
        // Run through the list of search results and add any URLS that were selected to the "selectedFiles" String list
        for (int idex=0; idex < resultsList.getModel().getSize(); idex++) {
            if (listModel.isSelectedIndex(idex)) {
                selectedFiles.add(searchResultsList.get(idex).getUrl());
                
            }
        }
        
        
        // not sure what this does - something to do with increasing the overall progress bar when user input is recieved
        prgOverall.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                
                userInputReceived(prgOverall, e);
            }
            
        });
        
        // set the maximum of the overall progress bar to the length of the selected files
        prgOverall.setMaximum(selectedFiles.size() * 100);
        
        final StringBuffer sb = new StringBuffer();
        
        String corpusFilename = (String)this.getWizardData("txtFilename");
        
        String corpusFormat = (String)this.getWizardData("corpusFormat");
        
        System.out.println("Format: " + corpusFormat);
        
        int WordCount = Integer.parseInt(getWizardData("WordLimit").toString());      
        System.out.println("WordCount in SearchDownloadPanel has been set to:");
        System.out.println(WordCount);
        
        int customSize = Integer.parseInt(getWizardData("PageSize").toString());
        System.out.println("PageSize in SearchDownloadPanel has been set to:");
        System.out.println(customSize);
        
        // This class downloads the content from the URLs
        final DownloadUrls worker = new DownloadUrls(selectedFiles, corpusFilename, corpusFormat, WordCount, customSize) 
        {
            protected void done() {
         
                downloadComplete = true;
                btnDownload.setEnabled(true);
                SearchDownloadPanel.this.setForwardNavigationMode(WizardController.MODE_CAN_CONTINUE);
                
                putWizardData("lblWordCount", lblWordCount.getText());
                putWizardData("lblCurrentCorpusSize", lblCurrentCorpusSize.getText());
                putWizardData("lblNumUrlsDownloaded", lblNumUrlsDownloaded.getText());
                
                parentFrame.setCursor(Cursor.DEFAULT_CURSOR);
                
            }
        };
        worker.addPropertyChangeListener(
                new PropertyChangeListener() {
            public void propertyChange(final PropertyChangeEvent evt) {
                if ("progress".equals(evt.getPropertyName())) {
                    prgCurrent.setIndeterminate(false);
                    prgCurrent.setValue((Integer)evt.getNewValue());                    
                } else if ("status".equals(evt.getPropertyName())) {
                    DownloadStatus downloadStatus = (DownloadStatus)evt.getNewValue();
                    
                    // Set the status
                    switch (downloadStatus.getStatus()) {
                        case DownloadStatus.INITIALISING: lblStatus.setText("Initialising"); break;
                        case DownloadStatus.CONNECTING: lblStatus.setText("Connecting"); break;
                        case DownloadStatus.DOWNLOADING: lblStatus.setText("Downloading"); break;
                        case DownloadStatus.COMPLETE: lblStatus.setText("Complete"); break;
                        case DownloadStatus.TOKENISING: lblStatus.setText("Tokenising"); break;
                        case DownloadStatus.ERROR: lblStatus.setText("Error"); break;
                    }
                    
                    // Set the token count
                    lblWordCount.setText(String.valueOf(downloadStatus.getNumWords()));
                    
                    // Set number of downloads
                    lblNumUrlsDownloaded.setText(String.valueOf(downloadStatus.getNumDownloads()));
                    
                    // Set corpus size
                    lblCurrentCorpusSize.setText(String.valueOf(downloadStatus.getCorpusSize()));
                    
                    // Set number of errors
                    lblNumUrlErrors.setText(String.valueOf(downloadStatus.getNumErrors()));
                    
                    // Set number of invalid range downloads
                    lblNumInvalidSize.setText(String.valueOf(downloadStatus.getNumInvalid()));
                    
                } else if ("overall".equals(evt.getPropertyName())) {
                    prgOverall.setIndeterminate(false);
                    prgOverall.setValue((Integer)evt.getNewValue());
                }
                
            }
        });
        
        
        worker.execute();
        
    }//GEN-LAST:event_btnDownloadActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDownload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCurrentCorpusSize;
    private javax.swing.JLabel lblNumInvalidSize;
    private javax.swing.JLabel lblNumUrlErrors;
    private javax.swing.JLabel lblNumUrlsDownloaded;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblWordCount;
    private javax.swing.JProgressBar prgCurrent;
    private javax.swing.JProgressBar prgOverall;
    // End of variables declaration//GEN-END:variables
    
}
