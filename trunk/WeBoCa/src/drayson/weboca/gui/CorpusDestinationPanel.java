/*
 * CorpusDestinationPanel.java
 *
 * Created on 06 August 2006, 19:14
 */

package drayson.weboca.gui;

import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author  Andy Roberts
 */
public class CorpusDestinationPanel extends WizardPage {
    
    private JFileChooser fc;
    
    /** Creates new form CorpusDestinationPanel */
    public CorpusDestinationPanel() {
        super("Corpus Destination", "Corpus Destination");
        setupFileChooserDialog();

                
        initComponents();
        
        rdoFormatRaw.putClientProperty ("corpusFormat", "raw");
        rdoFormatVertical.putClientProperty ("corpusFormat", "vertical");
        
        // Set default (which is raw)
        putWizardData("corpusFormat", "raw");
        System.out.println((String)getWizardData("corpusFormat"));
        
    }
    
    // The following code stops the page from continuing until a condition is met!
    protected String validateContents (Component component, Object o) {
    
        if (txtFilename.getText().trim().equals("")) {
            return "Specify a location to save the corpus.";
        }
        // The below code ensures that the location can be written to, however currently doesn't work
        /*else if (!new File(txtFilename.getText().trim()).canWrite()) {
                return "Can't save to this location.";
        }*/
        return null;
    }
    
    public static String getDescription() {
        
        return "Corpus Destination";
    }
    
    
    
    private void setupFileChooserDialog() {
        
        
            fc = new JFileChooser();
        
    }
    
    private void formatSelect(java.awt.event.ActionEvent evt) {
        JRadioButton button = (JRadioButton) evt.getSource();
        putWizardData("corpusFormat", button.getClientProperty("corpusFormat"));
               
    }
    

  
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btngrCorpusFormat = new javax.swing.ButtonGroup();
        lblFilename = new javax.swing.JLabel();
        txtFilename = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        lblInstruction = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        rdoFormatRaw = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        rdoFormatVertical = new javax.swing.JRadioButton();
        testBox = new javax.swing.JCheckBox();

        lblFilename.setText("Filename");

        txtFilename.setName("txtFilename");

        btnBrowse.setText("Browse...");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        lblInstruction.setText("Select a location to save the new corpus");

        jLabel1.setText("Encoding");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UTF8" }));
        jComboBox1.setEnabled(false);

        btngrCorpusFormat.add(rdoFormatRaw);
        rdoFormatRaw.setSelected(true);
        rdoFormatRaw.setText("Raw");
        rdoFormatRaw.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoFormatRaw.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdoFormatRaw.setName("rdoFormatRaw");
        rdoFormatRaw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFormatRawActionPerformed(evt);
            }
        });

        jLabel2.setText("Corpus format");

        btngrCorpusFormat.add(rdoFormatVertical);
        rdoFormatVertical.setText("Vertical");
        rdoFormatVertical.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdoFormatVertical.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdoFormatVertical.setName("rdoFormatVertical");
        rdoFormatVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFormatVerticalActionPerformed(evt);
            }
        });

        testBox.setSelected(true);
        testBox.setText("Some Advanced Settings");
        testBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        testBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblInstruction)
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblFilename)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jComboBox1, 0, 251, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtFilename, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnBrowse))
                    .add(jLabel2)
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(rdoFormatVertical)
                            .add(rdoFormatRaw)))
                    .add(testBox))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblInstruction)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnBrowse)
                    .add(lblFilename)
                    .add(txtFilename, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(19, 19, 19)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(rdoFormatRaw)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(rdoFormatVertical)
                .add(23, 23, 23)
                .add(testBox)
                .addContainerGap(107, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoFormatVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFormatVerticalActionPerformed
        formatSelect(evt);
    }//GEN-LAST:event_rdoFormatVerticalActionPerformed

    private void rdoFormatRawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFormatRawActionPerformed
        formatSelect(evt);
    }//GEN-LAST:event_rdoFormatRawActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        int returnVal = fc.showSaveDialog(this);

	if (returnVal == JFileChooser.APPROVE_OPTION) {
            String oldText = txtFilename.getText();
            txtFilename.setText(fc.getSelectedFile().getAbsolutePath());
            
        }
        
    }//GEN-LAST:event_btnBrowseActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.ButtonGroup btngrCorpusFormat;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFilename;
    private javax.swing.JLabel lblInstruction;
    private javax.swing.JRadioButton rdoFormatRaw;
    private javax.swing.JRadioButton rdoFormatVertical;
    private javax.swing.JCheckBox testBox;
    private javax.swing.JTextField txtFilename;
    // End of variables declaration//GEN-END:variables
    
}
