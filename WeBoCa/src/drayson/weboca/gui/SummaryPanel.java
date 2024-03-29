/*
 * SummaryPanel.java
 *
 * Created on 15 August 2006, 02:56
 */

package drayson.weboca.gui;

import drayson.weboca.Utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import org.netbeans.spi.wizard.WizardPage;


/**
 *
 * @author  Andy Roberts
 */
public class SummaryPanel extends WizardPage {
    
    private JFileChooser outChooser;
    
    /**
     * Creates new form SummaryPanel
     */
    public SummaryPanel() {
        super("Summary", "Summary");
        initComponents();
        updateDetails();
    }
    
     protected void renderingPage() {
        updateDetails();
    }
    
    private JFileChooser getOutChooser() {
        
        if (outChooser == null) {
            outChooser = new JFileChooser();
        }
        
        return outChooser;
    }
    
    private void updateDetails() {
        
        String corpusFilename = (String)this.getWizardData("txtFilename");
        
        lblCorpusFilename.setText(corpusFilename);
        
        lblSearchEngineUsed.setText((String)getWizardData("SearchEngine"));
        
        lblNumWords.setText((String)this.getWizardData("lblWordCount"));
        
        lblFilesize.setText((String)this.getWizardData("lblCurrentCorpusSize"));
        
        lblUrlsIncluded.setText((String)this.getWizardData("lblNumUrlsDownloaded"));
    }
    
    
    private String getUrls()
    {
        String corp = "";
        StringBuffer sb = new StringBuffer();
        
        // Code to get the corpus from the newly created file
        try {
                FileReader fr     = new FileReader((String)getWizardData("txtFilename"));
                BufferedReader br = new BufferedReader(fr);
                String temp_corp = "";
                
                
                
                while ((temp_corp = br.readLine()) != null) 
                {
                    sb.append(temp_corp).append("\n");
                }
            }
        catch (IOException e) {            
                // catch possible io errors from readLine()
                System.out.println("Uh oh, got an IOException error!");
                e.printStackTrace();
                return "Internal Program Error - WeBoCa was unable to get the saved corpus";
            }
        
        corp = sb.toString();
        
        // Code to remove the URLs from the file and put them into a new string
        String urls = "";                    // Used to store the URLs
        
        CharSequence url = "doc id";
        
        System.out.println("Now saving URLs used.");
        
        // First we need to split the corpus into an array of strings - one per line (therefore \n as a seperator)
        String[] x = Pattern.compile("\n").split(corp);
        String[] cleaned = {};
        
        boolean clean = true;
        boolean exists_an = false;
        StringBuffer sbtwo = new StringBuffer();
        
        for (int i=0; i<x.length; i++) {
            if (x[i].contains(url)) {
                exists_an = true;
            }
            
            if (exists_an == true) {
                // Add the clean word to the corpus
                sbtwo.append(x[i]).append("\n");
            }
            exists_an = false;
        }
        urls = sbtwo.toString();
        
        return urls;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        lblCorpusFilename = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFilesize = new javax.swing.JLabel();
        lblNumWords = new javax.swing.JLabel();
        lblUrlsIncluded = new javax.swing.JLabel();
        viewCorpusButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        saveURLsButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblSearchEngineUsed = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("New corpus has been created and saved:");

        lblCorpusFilename.setText("corpus location");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Details");

        jLabel6.setText("Corpus file size:");

        jLabel5.setText("Number of words:");

        jLabel4.setText("URLs included:");

        lblFilesize.setText("jLabel7");

        lblNumWords.setText("jLabel7");

        lblUrlsIncluded.setText("jLabel7");

        viewCorpusButton.setText("View Corpus in Notepad");
        viewCorpusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCorpusButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("Additional Options");

        saveURLsButton.setText("Save URLs used to text file");
        saveURLsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveURLsButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Search Engine used:");

        lblSearchEngineUsed.setText("jLabel2");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(lblCorpusFilename))
                            .add(jLabel3)))
                    .add(layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel5)
                            .add(jLabel4)
                            .add(jLabel6)
                            .add(jLabel8))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblSearchEngineUsed)
                            .add(lblFilesize)
                            .add(lblUrlsIncluded)
                            .add(lblNumWords)))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel7)
                            .add(layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(viewCorpusButton)
                                    .add(saveURLsButton))))))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblCorpusFilename)
                .add(28, 28, 28)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel6))
                    .add(layout.createSequentialGroup()
                        .add(lblSearchEngineUsed)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblUrlsIncluded)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblNumWords)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblFilesize)))
                .add(24, 24, 24)
                .add(jLabel7)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(viewCorpusButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(saveURLsButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveURLsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveURLsButtonActionPerformed
        
        int returnVal = getOutChooser().showSaveDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                Utils.saveFile(getUrls(), getOutChooser().getSelectedFile());
                
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
    }//GEN-LAST:event_saveURLsButtonActionPerformed

    private void viewCorpusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCorpusButtonActionPerformed
        try 
        {
           Runtime.getRuntime().exec("notepad.exe \"" + (String)this.getWizardData("txtFilename") + "\"");
        } 
        catch (IOException ex) {
            System.out.println("Issue opening file:");
            System.out.println(ex);
        }

    }//GEN-LAST:event_viewCorpusButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCorpusFilename;
    private javax.swing.JLabel lblFilesize;
    private javax.swing.JLabel lblNumWords;
    private javax.swing.JLabel lblSearchEngineUsed;
    private javax.swing.JLabel lblUrlsIncluded;
    private javax.swing.JButton saveURLsButton;
    private javax.swing.JButton viewCorpusButton;
    // End of variables declaration//GEN-END:variables
    
}
