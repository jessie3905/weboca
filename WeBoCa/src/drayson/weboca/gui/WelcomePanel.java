/*
 * WelcomePanel.java
 */

package drayson.weboca.gui;

import java.awt.Component;
import org.netbeans.spi.wizard.WizardPage;

import java.util.Map;
import javax.swing.JRadioButton;
import org.netbeans.spi.wizard.WizardController;

/** 
 *
 * The second GUI, presenting the user with different application routes of WeBoCa
 *
 * @author Michael Drayson
 * @version 1.0
 */
public class WelcomePanel extends WizardPage {
    
    public static final String userType = "userType";
    public static final String VALUE_SIMPLE = "simple";
    public static final String VALUE_ADVANCED = "advanced";
    public static final String VALUE_MODIFY = "modify";
    public static String VALUE_CURRENT = null;
    
    private final WizardController controller;
    private final Map wizardData;
    
    /**
     * Creates new form WelcomePanel used to present the user with the three application routes
     * 
     * @param step The step choosen
     * @param map The map of the possible application routes
     */
    public WelcomePanel(WizardController controller, Map wizardData) {
       
        initComponents();                          // Initialises all components on the page
        System.out.println("running WelcomePanel");
        this.controller = controller;
        this.wizardData = wizardData;
        
        //By default, nothing is selected
        controller.setProblem("Nothing selected");
        

        rdoSimple.putClientProperty (userType, VALUE_SIMPLE);
        rdoAdvanced.putClientProperty (userType, VALUE_ADVANCED);
        rdoModify.putClientProperty(userType, VALUE_MODIFY);
        
        // Set up this variable early on
        putWizardData("LoadedCorpus", " ");
        
    }
    
    /**
     * Returns the description of this GUI form
     *
     * @return The description of this form
     */
    public static String getDescription() {
        
        return "Welcome";
    }
    
         
   /**
     * Validates the JTextBox confirmBox to ensure that the user has agreed to the disclaimer
     *
     * @param component The component
     * @param o The object
     * @return The error presented by the Wizard framework if the condition isn't met
     */
    protected String validateContents (Component component, Object o) {
    
        if (!rdoSimple.isSelected() && !rdoAdvanced.isSelected() && !rdoModify.isSelected() ) {
            return "Please choose an application method before continuing.";
        }
        
        return null;
    }
    
    
    /**
     * A method that updates Wizard data storage variables to denote the application path choosen
     *
     * @param evt The event of clicking a radio button choice
     */
    private void typeSelect(java.awt.event.ActionEvent evt) {
        JRadioButton button = (JRadioButton) evt.getSource();
        System.out.println("button currently set to " + button.getClientProperty("userType"));
        putWizardData("userType", button.getClientProperty("userType"));
        VALUE_CURRENT = button.getClientProperty("userType").toString();
        System.out.println("set userType to " + button.getClientProperty("userType"));       
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        grpBuildType = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdoSimple = new javax.swing.JRadioButton();
        rdoAdvanced = new javax.swing.JRadioButton();
        rdoModify = new javax.swing.JRadioButton();

        jLabel1.setText("Welcome to WeBoCa v1.2...");

        jLabel2.setText("I would like to...  ");

        grpBuildType.add(rdoSimple);
        rdoSimple.setText("Create a corpus");
        rdoSimple.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoSimple.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdoSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSimpleActionPerformed(evt);
            }
        });

        grpBuildType.add(rdoAdvanced);
        rdoAdvanced.setText("Create a corpus and process it");
        rdoAdvanced.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoAdvanced.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdoAdvanced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAdvancedActionPerformed(evt);
            }
        });

        grpBuildType.add(rdoModify);
        rdoModify.setText("Process an existing corpus");
        rdoModify.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoModify.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdoModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoModifyActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(rdoAdvanced)
                            .add(rdoSimple)
                            .add(rdoModify))))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(29, 29, 29)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(rdoSimple)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(rdoAdvanced)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(rdoModify)
                .addContainerGap(189, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

  /**
     * A method that updates Wizard data storage variables to denote the application path choosen
     *
     * @param evt The event of clicking the modift radio button
     */
    private void rdoModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoModifyActionPerformed
        System.out.println("Setting Action Event to MODIFY");
        typeSelect(evt);
        System.out.println("MODIFY SET, testing...");
        System.out.println((String)getWizardData("userType"));
    }//GEN-LAST:event_rdoModifyActionPerformed

    /**
     * A method that updates Wizard data storage variables to denote the application path choosen
     *
     * @param evt The event of clicking the advanced radio button
     */
    private void rdoAdvancedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAdvancedActionPerformed
        System.out.println("Setting Action Event to ADVANCED");
        typeSelect(evt);
        System.out.println("ADVANCED SET, testing...");
        System.out.println((String)getWizardData("userType"));
        
        // Code to enable Advanced features goes below:
        //CorpusDestinationPanel.rdoFormatRaw.setEnabled(false);
        
    }//GEN-LAST:event_rdoAdvancedActionPerformed

    /**
     * A method that updates Wizard data storage variables to denote the application path choosen
     *
     * @param evt The event of clicking the simple radio button
     */
    private void rdoSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSimpleActionPerformed
        System.out.println("Setting Action Event to SIMPLE");
        typeSelect(evt);
        
        System.out.println("SIMPLE SET, testing...");
        System.out.println((String)getWizardData("userType"));
    }//GEN-LAST:event_rdoSimpleActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grpBuildType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rdoAdvanced;
    public javax.swing.JRadioButton rdoModify;
    public javax.swing.JRadioButton rdoSimple;
    // End of variables declaration//GEN-END:variables
    
}
