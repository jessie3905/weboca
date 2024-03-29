/*
 * DisclaimerPanel.java
 *
 * The initial GUI ensuring the user has read and agreed to any terms.
 *
 * @author Michael Drayson
 * @version 1.0
 */

package drayson.weboca.gui;

import org.netbeans.spi.wizard.WizardPage;
import java.awt.Component;

public class PreAdvancedPanel extends WizardPage {
    
    /**
     * Creates new form DisclaimerPanel using the Wizard framework
     */
    public PreAdvancedPanel() {
        super("PreAdvancedPanel", "PreAdvancedPanel");         // Passes parameters to the super class
        initComponents();                          // Initialises all components on the page
        
        // Set the state "PreAdvancedChosen" in the wizard to false
        putWizardData("PreAdvancedChosen", "false");
                
        // Set the state "saved" in the wizard to false
        putWizardData("saved", "false");
        
        // Set the state "AdditionalParam" in the wizard to empty
        putWizardData("AdditionalParam", "");
        
        // Set the other states
        putWizardData("WordLimit", "0");
        putWizardData("PageSize", "0");
        putWizardData("Advanced", "false");
    }
    
    /**
     * Returns the description of this GUI form
     *
     * @return The description of this form
     */
    public static String getDescription() {
        
        return "Pre Advanced Panel";
    }
    
    
   /**
     * A class to enable or disable all advanced features on the page when the
     * advanced box is ticked / unticked.
     */
    public void advancedClicked()
    {
        if (advancedBox.isSelected() == false)
        {
            putWizardData("PreAdvancedChosen", "false");
            saveButton.setEnabled(false);
            searchParams.setEnabled(false);
            corpusSize.setEnabled(false);
            pageSize.setEnabled(false);
            corpusSizeLabel.setEnabled(false);
            corpusSizeLabel2.setEnabled(false);
            pageSizeLabel.setEnabled(false);
            pageSizeLabel2.setEnabled(false);
            paramLabel.setEnabled(false);
            putWizardData("Advanced", "false");
        }
        
        if (advancedBox.isSelected() == true)
        {
            putWizardData("PreAdvancedChosen", "true");
            
            // Reset the state "saved" in the wizard to false
            putWizardData("saved", "false");
            saveButton.setEnabled(true);
            searchParams.setEnabled(true);
            corpusSize.setEnabled(true);
            pageSize.setEnabled(true);
            corpusSizeLabel.setEnabled(true);
            corpusSizeLabel2.setEnabled(true);
            pageSizeLabel.setEnabled(true);
            pageSizeLabel2.setEnabled(true);
            paramLabel.setEnabled(true);
            putWizardData("Advanced", "true");
        }
    }

    
    // The following code stops the page from continuing until a condition is met!
    protected String validateContents (Component component, Object o) 
    {
    
        if (advancedBox.isSelected())
        {
            if (getWizardData("saved") == "false")
            {
                return "You must save the advanced settings before continuing... ";
            }
        }
        
        return null;

    }
    


    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        advancedBox = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        paramLabel = new javax.swing.JLabel();
        searchParams = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        corpusSizeLabel2 = new javax.swing.JLabel();
        corpusSize = new javax.swing.JTextField();
        corpusSizeLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        pageSizeLabel2 = new javax.swing.JLabel();
        pageSize = new javax.swing.JTextField();
        pageSizeLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();

        advancedBox.setText("Enable Advanced Options");
        advancedBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        advancedBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        advancedBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreAdvancedPanel.this.actionPerformed(evt);
            }
        });

        paramLabel.setText("Additional search parameters");
        paramLabel.setEnabled(false);

        searchParams.setEnabled(false);
        searchParams.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchParamsFocusLost(evt);
            }
        });

        saveButton.setText("Save Settings!");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        corpusSizeLabel2.setText("Limit the corpus size to ");
        corpusSizeLabel2.setEnabled(false);

        corpusSize.setEnabled(false);
        corpusSize.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                corpusSizeFocusLost(evt);
            }
        });

        corpusSizeLabel.setText(" words                         (blank = unlimited)");
        corpusSizeLabel.setEnabled(false);

        pageSizeLabel2.setText("Limit the page size to ");
        pageSizeLabel2.setEnabled(false);

        pageSize.setEnabled(false);
        pageSize.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pageSizeFocusLost(evt);
            }
        });

        pageSizeLabel.setText(" bytes                     (blank = unlimited)");
        pageSizeLabel.setEnabled(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(paramLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 28, Short.MAX_VALUE)
                        .add(searchParams, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 219, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jSeparator1)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jSeparator2)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                            .add(corpusSizeLabel2)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(corpusSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(corpusSizeLabel)))
                    .add(layout.createSequentialGroup()
                        .add(advancedBox)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 143, Short.MAX_VALUE)
                        .add(saveButton))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jSeparator3)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                            .add(pageSizeLabel2)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(pageSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(pageSizeLabel)))
                    .add(jSeparator5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(advancedBox)
                    .add(saveButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(paramLabel)
                    .add(searchParams, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(14, 14, 14)
                .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(corpusSizeLabel2)
                    .add(corpusSizeLabel)
                    .add(corpusSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(14, 14, 14)
                .add(jSeparator3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(pageSizeLabel2)
                    .add(pageSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pageSizeLabel))
                .add(14, 14, 14)
                .add(jSeparator5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(59, 59, 59)
                .add(jSeparator4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pageSizeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pageSizeFocusLost
       // Reset the state "saved" in the wizard to false
       putWizardData("saved", "false");
    }//GEN-LAST:event_pageSizeFocusLost

    private void corpusSizeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_corpusSizeFocusLost
       // Reset the state "saved" in the wizard to false
       putWizardData("saved", "false");
    }//GEN-LAST:event_corpusSizeFocusLost

    private void searchParamsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchParamsFocusLost
       // Reset the state "saved" in the wizard to false
       putWizardData("saved", "false");
    }//GEN-LAST:event_searchParamsFocusLost

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // Set the state "saved" in the wizard to true as it's now been saved
        putWizardData("saved", "true");
        
        // Additional commands to save the state of all the additional options
        
        if (searchParams.getText().length() !=0)
        {
             putWizardData("AdditionalParam", searchParams.getText());
             System.out.println("Saved " + getWizardData("AdditionalParam") + " to AdditionalParam");
        }

        if (searchParams.getText().length() == 0)
        {
            putWizardData("AdditionalParam", " ");
            System.out.println("Saved an empty space to AdditionalParam");
        }
        
        if (corpusSize.getText().length() != 0)
        {
            putWizardData("WordLimit", corpusSize.getText());
            System.out.println("Saved " + getWizardData("WordLimit") + " to WordLimit");
        }
        else
        {
            System.out.println("Saved 0 to WordLimit");
            putWizardData("WordLimit", "0");
        }
        
        if (pageSize.getText().length() != 0)
        {
            putWizardData("PageSize", pageSize.getText());
            System.out.println("Saved " + getWizardData("PageSize") + " to PageSize");
        }
        else
        {
            putWizardData("PageSize", "0");
            System.out.println("Saved " + getWizardData("PageSize") + " to PageSize");
        }
        
        

    }//GEN-LAST:event_saveButtonActionPerformed

    private void actionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionPerformed
        advancedClicked();
    }//GEN-LAST:event_actionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox advancedBox;
    private javax.swing.JTextField corpusSize;
    private javax.swing.JLabel corpusSizeLabel;
    private javax.swing.JLabel corpusSizeLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField pageSize;
    private javax.swing.JLabel pageSizeLabel;
    private javax.swing.JLabel pageSizeLabel2;
    private javax.swing.JLabel paramLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField searchParams;
    // End of variables declaration//GEN-END:variables
    
}
