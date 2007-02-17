/*
 * SearchResults.java
 *
 * Created on 20 May 2006, 21:02
 */

package drayson.weboca.gui;

import drayson.weboca.HTMLUtils;
import drayson.weboca.Utils;
import drayson.weboca.search.GoogleSearchEngine;
import drayson.weboca.search.SearchResult;
import drayson.weboca.search.WebSearch;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.swingworker.SwingWorker;
import org.netbeans.spi.wizard.WizardController;
import org.netbeans.spi.wizard.WizardPage;

/**
 *
 * @author  Andy Roberts
 */
public class SearchResultsPanel extends WizardPage {
    
    private CheckListManager checkListManager;
    
    /** Creates new form SearchResults */
    public SearchResultsPanel() {
        super("Search Results", "Search Results");
        initComponents();
        checkListManager = new CheckListManager(lstResults);
    }
    

    public static String getDescription() {
        
        return "Search Results";
    }
    
    protected String validateContents (Component component, Object o) {
        
        if (lstResults.getModel().getSize() == 0) {
            return "Must perform search";
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
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstResults = new javax.swing.JList();
        lblSearchInstruction = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblReview = new javax.swing.JLabel();
        btnSelectAll = new javax.swing.JButton();
        btnDeselectAll = new javax.swing.JButton();

        btnSearch.setText("Start search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lstResults.setModel(new DefaultListModel());
        lstResults.setCellRenderer(new SearchResultCellRenderer());
        lstResults.setName("");
        jScrollPane1.setViewportView(lstResults);

        lblSearchInstruction.setText("Click the button to start the search. This can take a while.");

        lblReview.setText("Review search results:");

        btnSelectAll.setText("Select all");
        btnSelectAll.setEnabled(false);
        btnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllActionPerformed(evt);
            }
        });

        btnDeselectAll.setText("Deselect all");
        btnDeselectAll.setEnabled(false);
        btnDeselectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectAllActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(lblSearchInstruction)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 55, Short.MAX_VALUE)
                        .add(btnSearch))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lblReview)
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(btnSelectAll)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnDeselectAll)))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {btnDeselectAll, btnSelectAll}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSearch)
                    .add(lblSearchInstruction))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblReview)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSelectAll)
                    .add(btnDeselectAll))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAllActionPerformed
        checkListManager.checkAll();
    }//GEN-LAST:event_btnSelectAllActionPerformed

    private void btnDeselectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectAllActionPerformed
        checkListManager.uncheckAll();
    }//GEN-LAST:event_btnDeselectAllActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        final JFrame parentFrame = (JFrame)Utils.GetParent(this, "javax.swing.JFrame");
        parentFrame.setCursor(Cursor.WAIT_CURSOR);
        btnSearch.setEnabled(false);
        btnSelectAll.setEnabled(false);
        btnDeselectAll.setEnabled(false);
        ((DefaultListModel)lstResults.getModel()).clear();
        
        final Set<SearchResult> allResultsSet = new HashSet<SearchResult>();
        
        SwingWorker worker = new SwingWorker() {
            protected ListModel doInBackground() throws Exception {
                DefaultListModel model = new DefaultListModel();
                
                
                List<String> tuples = new ArrayList<String>();
                String tupleString = (String)getWizardData("txtTuples");
                
                //tupleString = tupleString.replaceAll("\r", "");
                
                tuples = Arrays.asList(tupleString.split("\n"));
                
                WebSearch search = new WebSearch(new GoogleSearchEngine((String)getWizardData("txtKey"), (String)getWizardData("AdditionalParam")));
                
                for (String t: tuples) {
                    //System.out.println("Searching for tuple: \"" + t + "\"...");
                    List<SearchResult> currentResults = new ArrayList<SearchResult>();
                    currentResults = search.search(t);
                    //System.out.println("   Found " + currentResults.size() + " results.");
                    
                    allResultsSet.addAll(currentResults);
                    
                }
                
                for (SearchResult sr: allResultsSet) {
                    if (HTMLUtils.isHtmlFile(sr.getUrl())) {
                        model.addElement(sr);
                    }
                }
                
                return model;
            }
            
            protected void done() {
                try {
                    lstResults.setModel((ListModel)get());
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
        
                btnSelectAll.setEnabled(true);
                btnDeselectAll.setEnabled(true);
                btnSearch.setEnabled(true);
                checkListManager.checkAll();
                
                setForwardNavigationMode(WizardController.MODE_CAN_CONTINUE);
                
                putWizardData("searchResults", allResultsSet);
                putWizardData("checkManager", checkListManager);
                putWizardData("listResults", lstResults);
                
                parentFrame.setCursor(Cursor.DEFAULT_CURSOR);
            }
            
        };
        
        worker.execute();

    }//GEN-LAST:event_btnSearchActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeselectAll;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSelectAll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblReview;
    private javax.swing.JLabel lblSearchInstruction;
    private javax.swing.JList lstResults;
    // End of variables declaration//GEN-END:variables
    
}
