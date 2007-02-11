package drayson.weboca.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
// @author Santhosh Kumar T - santhosh@in.fiorano.com
public class CheckListCellRenderer extends JPanel implements ListCellRenderer{ 
    private ListCellRenderer delegate; 
    private ListSelectionModel selectionModel; 
    private JCheckBox checkBox = new JCheckBox(); 
 
    public CheckListCellRenderer(ListCellRenderer renderer, ListSelectionModel selectionModel){ 
        this.delegate = renderer; 
        this.selectionModel = selectionModel; 
        setLayout(new BorderLayout()); 
        setOpaque(false); 
        checkBox.setOpaque(false);
        
    } 
 
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){ 
        Component renderer = delegate.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
        JPanel rendererPanel = new JPanel(new BorderLayout());
        rendererPanel.setOpaque(false);
        //rendererPanel.setBorder(BorderFactory.createEmptyBorder(0,1,0,0));
        rendererPanel.add(renderer, BorderLayout.CENTER);
        checkBox.setSelected(selectionModel.isSelectedIndex(index)); 
        checkBox.setEnabled(list.isEnabled());
        removeAll();
        JPanel tmpPanel = new JPanel(new BorderLayout());
        tmpPanel.setOpaque(false);
        
        tmpPanel.add(checkBox, BorderLayout.NORTH);
        add(tmpPanel, BorderLayout.WEST); 
        add(rendererPanel, BorderLayout.CENTER); 
        setBorder(BorderFactory.createEmptyBorder(0,0,3,0));
        return this; 
    } 
}