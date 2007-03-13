/*
 * SeedPanel.java
 *
 * Created on 11 May 2006, 19:33
 */

package drayson.weboca.gui;

import drayson.weboca.Utils;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.netbeans.spi.wizard.WizardPage;



/**
 *
 * @author  Andy Roberts
 */
public class BlackPanel extends WizardPage {
    
    private JFileChooser inChooser;
    private JFileChooser outChooser;
    
    /** Creates new form SeedPanel */
    public BlackPanel() {
        super("Seeds", "Seeds");
        initComponents();
        
        // Set up some defaults
        putWizardData("blackWords", " ");
    }
    
    public static String getDescription() {
        
        return "Seeds";
    }
    
    protected String validateContents (Component component, Object o) {
                
        if (advancedBox.isSelected())
        {
            if (getWizardData("blacksaved") == "false")
            {
                return "You must save the black list before continuing... ";
            }
        }
        
        return null;
    }
    
    private JFileChooser getInChooser() {
    
        if (inChooser == null) {
            inChooser = new JFileChooser();
        }
        
        return inChooser;
    }
    
    private JFileChooser getOutChooser() {
    
        if (outChooser == null) {
            outChooser = new JFileChooser();
        }
        
        return outChooser;
    }
    
    private void advancedClicked()
    {
         if (advancedBox.isSelected() == false)
        {
            putWizardData("UsingBlackList", "false");
            saveButton.setEnabled(false);
            whiteLabel.setEnabled(false);
            blackWords.setEnabled(false);
            blackWords.setOpaque(false);
            btnLoad.setEnabled(false);
            btnSave.setEnabled(false);
            
            
            
        }
        
        if (advancedBox.isSelected() == true)
        {
            putWizardData("UsingBlackList", "true");
            
            // Reset the state "saved" in the wizard to false
            putWizardData("blacksaved", "false");
            saveButton.setEnabled(true);
            whiteLabel.setEnabled(true);
            blackWords.setEnabled(true);
            blackWords.setOpaque(true);
            btnLoad.setEnabled(true);
            btnSave.setEnabled(true);
            
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnLoad = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        whiteLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        blackWords = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        advancedBox = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        btnLoad.setText("Load custom");
        btnLoad.setEnabled(false);
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnSave.setText("Save custom");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        whiteLabel.setText("Enter all black listed words, one word per line");
        whiteLabel.setEnabled(false);

        blackWords.setColumns(20);
        blackWords.setRows(20);
        blackWords.setEnabled(false);
        blackWords.setName("blackWords");
        blackWords.setOpaque(false);
        //txtSeeds.setText("arabic\nconcordance\nlanguage\nlearning\ncluster");
        blackWords.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                blackWordsFocusLost(evt);
            }
        });

        jScrollPane1.setViewportView(blackWords);

        advancedBox.setText("Enable Black List");
        advancedBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        advancedBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        advancedBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedBoxactionPerformed(evt);
            }
        });

        saveButton.setText("Save List!");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 275, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 16, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(btnSave)
                            .add(btnLoad)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(advancedBox)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 210, Short.MAX_VALUE)
                        .add(saveButton))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(whiteLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(saveButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(advancedBox))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(whiteLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(btnLoad)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btnSave)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
                    .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void blackWordsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_blackWordsFocusLost
           putWizardData("blacksaved", "false");
    }//GEN-LAST:event_blackWordsFocusLost

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
// Set the state "saved" in the wizard to true as it's now been saved
        putWizardData("blacksaved", "true");
        
        if (blackWords.getText().length() == 0)
        {
            putWizardData("blackWords", " ");
        }
        else
        {
            putWizardData("blackWords", blackWords.getText());
        }
        
        
      
    }//GEN-LAST:event_saveButtonActionPerformed

    private void advancedBoxactionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedBoxactionPerformed
      advancedClicked();
      
    }//GEN-LAST:event_advancedBoxactionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        int returnVal = getOutChooser().showOpenDialog(this);
    
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                Utils.saveFile(blackWords.getText(), getOutChooser().getSelectedFile());
                
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
                   putWizardData("blacksaved", "false");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed

        int returnVal = getInChooser().showOpenDialog(this);
    
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                blackWords.setText(Utils.loadFile(getInChooser().getSelectedFile()).trim());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
                   putWizardData("blacksaved", "false");
    }//GEN-LAST:event_btnLoadActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox advancedBox;
    protected javax.swing.JTextArea blackWords;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel whiteLabel;
    // End of variables declaration//GEN-END:variables
    
}