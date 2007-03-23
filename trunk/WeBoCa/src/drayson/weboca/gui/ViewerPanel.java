/*
 * ViewerPanel.java
 *
 * Created on 11 May 2006, 19:33
 */

package drayson.weboca.gui;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author  Andy Roberts
 */
public class ViewerPanel extends JFrame {
    
    private JFileChooser inChooser;
    private JFileChooser outChooser;

    
    public void Go() {
        JFrame jf = new JFrame();
        
        
        jf.pack();
        jf.setVisible(true);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSeeds = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        txtSeeds.setColumns(20);
        txtSeeds.setRows(5);
        txtSeeds.setName("txtSeeds");
        //txtSeeds.setText("arabic\nconcordance\nlanguage\nlearning\ncluster");
        jScrollPane1.setViewportView(txtSeeds);

        jButton1.setText("Close");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton1)
                    .add(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTextArea txtSeeds;
    // End of variables declaration//GEN-END:variables
    
}