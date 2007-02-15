/*
 * SearchResultCellRenderer.java
 *
 * Created on 29 May 2006, 20:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package drayson.weboca.gui;

import drayson.weboca.search.SearchResult;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

/**
 *
 * @author Andy
 */
public class SearchResultCellRenderer implements ListCellRenderer {
    
    private final String htmlPrefix = "<html>";
    /** Creates a new instance of SearchResultCellRenderer */
    public SearchResultCellRenderer() {
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        JPanel panel = new JPanel();
        
        panel.setBorder(BorderFactory.createEmptyBorder(0,2,0,0));
        
        SearchResult sr = (SearchResult)value;
        
        java.awt.GridBagConstraints gridBagConstraints;

        JLabel lblTitle = new javax.swing.JLabel();
        lblTitle.setFont(UIManager.getFont("List.font"));
        lblTitle.setText(htmlPrefix+sr.getTitle());
        JLabel lblUrl = new javax.swing.JLabel(sr.getUrl());
        lblUrl.setFont(UIManager.getFont("List.font"));
        

        panel.setLayout(new java.awt.GridBagLayout());

        
        if (isSelected) {
            panel.setBackground(UIManager.getColor("List.selectionBackground"));
            lblTitle.setForeground(UIManager.getColor("List.selectionForeground"));
            lblUrl.setForeground(UIManager.getColor("List.selectionForeground"));
        }
        else {
            panel.setBackground(UIManager.getColor("List.background"));
            lblTitle.setForeground(UIManager.getColor("List.Foreground"));
            lblUrl.setForeground(UIManager.getColor("List.Foreground"));
        }
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(lblTitle, gridBagConstraints);

        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(lblUrl, gridBagConstraints);
        
        return panel;
    }
    
}
