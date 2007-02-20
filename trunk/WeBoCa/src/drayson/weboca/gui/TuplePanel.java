/*
 * TuplePanel.java
 *
 * Created on 11 May 2006, 20:14
 */

package drayson.weboca.gui;

import drayson.weboca.TupleBuilder;
import drayson.weboca.Utils;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author Andy Roberts
 */
public class TuplePanel extends WizardPage {
    
    /** Creates new form TuplePanel */
    public TuplePanel() {
        super("Tuples", "Tuples");
        initComponents();
    }
    
    public static String getDescription() {
        
        return "Tuples";
    }
    
    protected String validateContents (Component component, Object o) {
        //Initially, no radio button is selected, so set the problem string
        if (txtTuples.getText().trim().length() == 0) {
            return "You must enter at least one seed";
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
        btnGenerate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        spnTupleSize = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        spnNumTuples = new javax.swing.JSpinner();
        btnSave = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTuples = new javax.swing.JTextArea();

        btnGenerate.setText("Generate Tuples");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        jLabel1.setText("Tuple size (n)");

        Integer tvalue = new Integer(3);
        Integer tmin = new Integer(1);
        Integer tmax = new Integer(10);
        Integer tstep = new Integer(1);
        spnTupleSize.setModel(new SpinnerNumberModel(tvalue, tmin, tmax, tstep));

        jLabel2.setText("Number of tuples (L)");

        Integer value = new Integer(10);
        Integer min = new Integer(1);
        Integer max = new Integer(10000);
        Integer step = new Integer(1);
        spnNumTuples.setModel(new SpinnerNumberModel(value, min, max, step));

        btnSave.setText("Save");

        btnLoad.setText("Load");

        txtTuples.setColumns(20);
        txtTuples.setRows(5);
        txtTuples.setName("txtTuples");
        jScrollPane1.setViewportView(txtTuples);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(spnTupleSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(spnNumTuples, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 145, Short.MAX_VALUE)
                        .add(btnGenerate))
                    .add(layout.createSequentialGroup()
                        .add(btnLoad)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(spnTupleSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(btnGenerate)
                    .add(spnNumTuples, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSave)
                    .add(btnLoad))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        
        String seedsString = (String)getWizardData("txtSeeds");
        //seedsString = seedsString.replaceAll("\r", "");
        
        List<String> seeds = new ArrayList<String>();
        String[] seedsArray = seedsString.split("\n");
        
        // Needs to iterate over the seeds in case there are any multi-word terms.
        // If so, must add quotes around.
        for (int i = 0; i < seedsArray.length; i++) {
            if (seedsArray[i].contains(" ")) {
                seeds.add("\"" + seedsArray[i] + "\"");
            }
            else {
                seeds.add(seedsArray[i]);
            }
        }
        
        List<String> tuples = new ArrayList<String>();
        
        boolean different = false;
        
        StringBuffer tupleBuffer = new StringBuffer();
        try {
            while (!different) {

                tuples = TupleBuilder.buildTuples(seeds, ((Integer)spnTupleSize.getValue()).intValue(), ((Integer)spnNumTuples.getValue()).intValue());

                Collections.sort(tuples);

                tupleBuffer = new StringBuffer();

                for (String t: tuples) {
                    tupleBuffer.append(t + '\n');
                }

                if (!txtTuples.getText().equals(tupleBuffer.toString())) {
                    different = true;
                }
            }
            txtTuples.setText(tupleBuffer.toString().trim());
        }
        catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(Utils.GetParent(this, "javax.swing.JFrame"),
                    iae.getMessage(),
                    "Tuple error",
                    JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_btnGenerateActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnNumTuples;
    private javax.swing.JSpinner spnTupleSize;
    private javax.swing.JTextArea txtTuples;
    // End of variables declaration//GEN-END:variables
    
}