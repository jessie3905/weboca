/*
 * SeedPanel.java
 *
 * Created on 11 May 2006, 19:33
 */

package drayson.weboca.gui;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import javax.swing.JFileChooser;
import org.netbeans.spi.wizard.WizardPage;



/**
 *
 * @author  Andy Roberts
 */
public class ProcessPanel extends WizardPage {
    
    private JFileChooser inChooser;
    private JFileChooser outChooser;
    private String new_corp = "";                // Used to store the processed corpus
    private String old_corp = "";                // The variable used to store whatever corpus was loaded
    private CharSequence[] cs = new CharSequence[50];

    
          
    
    /** Creates new form SeedPanel */
    public ProcessPanel() {
        super("Seeds", "Seeds");
        initComponents();
        
        // Set up some defaults
        putWizardData("whiteWords", " ");
    }
    
    public static String getDescription() {
        
        return "Seeds";
    }
    
    protected String validateContents (Component component, Object o) {
                

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

    private void removeAlpha()
    {
        System.out.println("Hello");
            
        CharSequence[] cs = { "!", "\"", "£", "$", "%", "^", "&", "*", "(", ")", "`", "¬", "¦", "\\", "|", ",", "<", ">", ".", "/", "?", ";", ":", "'", "@", "[", "{", "}", "]", "#", "~", "=", "+", "-", "_" };
        
        System.out.println("Now removing all non-alpha numerical terms");
        
        // First collect the corpus being used and put it into a local string variable
        if (getWizardData("LoadedCorpus") != " ")
        {
            System.out.println("Getting the loaded corpus");
            
            // Save the old corpus incase the user wants to undo
            old_corp = (String)getWizardData("LoadedCorpus");
            
            // First we need to split the corpus into an array of strings - one per line (therefore \n as a seperator)
            String[] x = Pattern.compile("\n").split(old_corp);
            String[] cleaned = {};
            
            boolean clean = true;
            boolean exists_an = false;
            
            for (int i=0; i<x.length; i++) 
            {
                System.out.println("Now processing word: " + x[i]);

                // Now, for each word (x[i]) we need to check it against our array of char sequences
                for (int j=0; j<cs.length; j++)
                {
                    System.out.println("Now processing: " + cs[j] + " for word " + x[i]);
                        
                    if (x[i].contains(cs[j]))
                    {
                         System.out.println(x[i] + " contains a non-alpha-numeric " + cs[j]);
                         exists_an = true;
                            
                         // Now need to stop it processing this word any further if it's already found to be unclean
                         break;
                     }  
                     System.out.println("Finished processing: " + cs[j] + " for word " + x[i]);  
                 } 
                 System.out.println("Finished processing word: " + x[i]); 
                 if (exists_an == false)
                 {
                    System.out.println("Adding word: " + x[i] + " to the new corpus");
                    new_corp = new_corp + x[i] + "\n";
                 }   
                 exists_an = false;
            }
            System.out.println("Successfully iterated over length of the corpus");     
        }
        
        
        // If a corpus has just been downloaded however, this needs to be processed
        else
        {  
           try { 

	   FileReader fr     = new FileReader((String)getWizardData("txtFilename"));
           BufferedReader br = new BufferedReader(fr);
           String temp_corp = "";
           boolean exists_an = false;
                      
           while ((temp_corp = br.readLine()) != null) 
           {
              
              System.out.println("Now processing line: " + temp_corp);

              // Incase they want to undo later, the previous corpus must be generated first
              old_corp = old_corp + temp_corp + "\n"; 
               
              // Code to remove the non alphanumericals
              if (!temp_corp.contains("something"))
              { 
                  
                for (int j=0; j<cs.length; j++)
                {
                    System.out.println("Now processing: " + cs[j] + " for word " + temp_corp);
                        
                    if (temp_corp.contains(cs[j]))
                    {
                         System.out.println(temp_corp + " contains a non-alpha-numeric " + cs[j]);
                         exists_an = true;
                            
                         // Now need to stop it processing this word any further if it's already found to be unclean
                         break;
                     }  
                     System.out.println("Finished processing: " + cs[j] + " for word " + temp_corp);  
                 } 
                 System.out.println("Finished processing word: " + temp_corp); 
                 if (exists_an == false)
                 {
                    System.out.println("Adding word: " + temp_corp + " to the new corpus");
                    new_corp = new_corp + temp_corp + "\n";
                 }   
                 exists_an = false;

              }

              
           } 

        } 
        catch (IOException e) 
        { 
           // catch possible io errors from readLine()
           System.out.println("Uh oh, got an IOException error!");
           e.printStackTrace();
        }
    }
        
        // The corpus has now been loaded into the old local variable
        System.out.println(old_corp);
        System.out.println("VERSES");
        System.out.println(new_corp);
        
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jSeparator2 = new javax.swing.JSeparator();
        viewCorpusButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        methodList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saveCorpusButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        saveCorpusButton2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        saveCorpusButton3 = new javax.swing.JButton();
        applyButton1 = new javax.swing.JButton();

        viewCorpusButton.setText("View Current Corpus");

        methodList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Copy URLs to Notepad", "Remove URLs from corpus", "Remove all non-alpha numeric terms", "Remove non-English characters", "Other processing option goes here", "Other processing option goes here", "Other processing option goes here", "Other processing option goes here" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(methodList);

        jLabel1.setText("Please select which processing methods you would like to apply to the current");

        jLabel2.setText("corpus.  Please note that you may select more than one at a time by holding");

        jLabel3.setText("the control button while clicking on methods with the left hand mouse button.");

        saveCorpusButton.setText("Save Corpus As...");

        applyButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        applyButton.setText("Apply Changes");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        saveCorpusButton2.setText("Undo All");

        saveCorpusButton3.setText("Select All");

        applyButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
        applyButton1.setText("Write Changes");
        applyButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(viewCorpusButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 120, Short.MAX_VALUE)
                        .add(saveCorpusButton))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2)
                            .add(jLabel3))))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jSeparator3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(35, 35, 35)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 203, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, saveCorpusButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, saveCorpusButton3))
                    .add(applyButton)
                    .add(applyButton1))
                .add(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(11, 11, 11)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(saveCorpusButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(viewCorpusButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .add(3, 3, 3)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .add(14, 14, 14)
                .add(jSeparator3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(saveCorpusButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(saveCorpusButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(applyButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(applyButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void applyButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButton1ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_applyButton1ActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        Object[] choices = methodList.getSelectedValues();
        
        int num_choices = choices.length;
            
        for (int i = 0; i < num_choices; i++ )
        {
            if (choices[i] == "Remove all non-alpha numeric terms")
            {
                removeAlpha();
            }
            if (choices[i] == "Other processing option goes here")
            {
                System.out.println("A dummy option was also selected");
            }
        }
        
    }//GEN-LAST:event_applyButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton applyButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JList methodList;
    private javax.swing.JButton saveCorpusButton;
    private javax.swing.JButton saveCorpusButton2;
    private javax.swing.JButton saveCorpusButton3;
    private javax.swing.JButton viewCorpusButton;
    // End of variables declaration//GEN-END:variables
    
}
