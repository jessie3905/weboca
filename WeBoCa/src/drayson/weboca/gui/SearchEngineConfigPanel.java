/*
 * SearchEngineConfigPanel.java
 *
 * Created on 20 May 2006, 13:20
 */

package drayson.weboca.gui;

import java.awt.Component;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author  Andy
 */
public class SearchEngineConfigPanel extends WizardPage {
    
    /** Creates new form SearchEngineConfigPanel */
    public SearchEngineConfigPanel() {
        super("Search Engines", "Search Engines");
        initComponents();
        
    }
    
    public static String getDescription() {
        
        return "Search Engines";
    }
    
    protected String validateContents (Component component, Object o) {
        if (txtKey.getText().trim().equals("")) {
            return "Must insert your key";
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSearchEngines = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKey = new javax.swing.JTextField();

        lstSearchEngines.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Google", "Yahoo" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        CheckListManager checkListManager = new CheckListManager(lstSearchEngines);
        checkListManager.checkAll();
        jScrollPane1.setViewportView(lstSearchEngines);

        jLabel1.setText("Available Search Engines");

        jLabel2.setText("Key");

        txtKey.setText("jGwiQmNQFHIWY8rRouo0aFcconU5rERi");
        txtKey.setName("txtKey");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtKey, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                    .add(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(11, 11, 11)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel2)
                        .add(txtKey, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstSearchEngines;
    private javax.swing.JTextField txtKey;
    // End of variables declaration//GEN-END:variables
    
}
