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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
    private CharSequence[] cs = new CharSequence[50];
    private int nacount = 0;
    private int urlcount = 0;
    
    private String unsaved = "";
    private String backup = "";              // Used to store the original corpus
    private String frequency_string = "";    // Used to store the frequencies
    
    
    
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
    
    protected String validateContents(Component component, Object o) {
        
        
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
    
    private String saveOldCorpus() {
        String old_corp = "";
        
        if (getWizardData("LoadedCorpus") != " ") {
            old_corp = (String)getWizardData("LoadedCorpus");
        } else {
            try {
                FileReader fr     = new FileReader((String)getWizardData("txtFilename"));
                BufferedReader br = new BufferedReader(fr);
                String temp_corp = "";
                
                while ((temp_corp = br.readLine()) != null) {
                    old_corp = old_corp + temp_corp + "\n";
                }
            } catch (IOException e) {
                // catch possible io errors from readLine()
                System.out.println("Uh oh, got an IOException error!");
                e.printStackTrace();
            }
        }
        
        System.out.println("Backup corpus has been saved.");
        return old_corp;
    }
    
    
    private String removeUn(String local_corp)
    {
        // The corpus needs to have been sorted for this to be successful
        
        String new_corp = "";         // Used to store the processed corpus
        String old_corp = "";      // The variable used to store whatever corpus was loaded
        
        System.out.println("Now removing ununique terms from the corpus");
        
        String[] x = Pattern.compile("\n").split(local_corp);
        String[] cleaned = {};
        
        for (int i=0; i<x.length; i++) 
        {
            if (i == x.length-1)
            {
                System.out.println("Inside the last condition (processing " + x[i] + ")");
                new_corp = new_corp + x[i];
            }
            else 
            {
                if (!x[i].matches(x[i+1]))
                {
                    System.out.println("Inside the else condition (processing " + x[i] + ")");
                    System.out.println(x[i] + " is not the same as " + x[i+1]);
                    new_corp = new_corp + x[i] + "\n";
                }
            }
        }
        
        return new_corp;
    }
    
    private String getFrequency(String local_corp)
    {
        String frequency_list = "";         // Used to store the freq list
        String old_corp = "";      // The variable used to store whatever corpus was loaded
        
        System.out.println("Now generating a frequency list...");
        
        String[] entire_corpus = Pattern.compile("\n").split(local_corp);
        
        // Convert the array of words into a list
        List entire_list = Arrays.asList(entire_corpus);
        
        // Get a list of the unique words in the corpus:
        String unique_words = removeUn(local_corp);
        
        String[] unique_corpus = Pattern.compile("\n").split(unique_words);
        System.out.println(unique_corpus);
        
        // Iterate over the list of unique words and find the frequency in entire_list for each element
        for (int i = 0; i < unique_corpus.length; i++) 
        {
            // Count the frequency of this unique word in the entire corpus
            int local_count = Collections.frequency(entire_list, unique_corpus[i]);
            frequency_list = frequency_list + local_count + " " + unique_corpus[i] + "\n";
        }

        return orderZA(frequency_list);
    }
    
    private String orderAZ(String local_corp) {
        String new_corp = "";         // Used to store the processed corpus
        String old_corp = "";      // The variable used to store whatever corpus was loaded
        
        System.out.println("Now sorting corpus A-Z");
        
        String[] x = Pattern.compile("\n").split(local_corp);
        String[] sorted = {};
        
        // Convert the array of words into a list
        List list = Arrays.asList(x);

        // Sort the list so that it is in alphabetical order, with case insensitive.
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        
        // Sort the list and put it back into an array varable called sorted
        for (int i = 0; i < list.size(); i++) 
        {
            //System.out.println("Now adding the word: " + (String)list.get(i) + " to the array!");
            String temp = (String)list.get(i);
            new_corp = new_corp + temp.toLowerCase() + "\n";
        }
        
        return new_corp;
        
    }
    
    private String orderZA(String local_corp) {
        String new_corp = "";         // Used to store the processed corpus
        String old_corp = "";      // The variable used to store whatever corpus was loaded
        
        System.out.println("Now sorting corpus Z-A");
        
        String[] x = Pattern.compile("\n").split(local_corp);
        String[] sorted = {};
        
        // Convert the array of words into a list
        List list = Arrays.asList(x);

        
        // Sort the list so that it is in alphabetical order, with case insensitive.
        Collections.sort(list, new Comparator() {
	public int compare(Object o1, Object o2) {
		
                String temp1 = (String)o1;
                String temp2 = (String)o2;
                
                int loc1 = temp1.indexOf(" ");
                int loc2 = temp2.indexOf(" ");
                
                Integer v1 = Integer.parseInt(temp1.substring(0, loc1));
		Integer v2 = Integer.parseInt(temp2.substring(0, loc2)); 
                
                if (v1 < v2) {
			return -1;
		} else if (v2 < v1) {
			return 1;
		} else {
			return 0;
		}
	}
});
                
                
                
                
                
                
                
                
                
                                
        Collections.reverse(list);
        
        // Sort the list and put it back into an array varable called sorted
        for (int i = 0; i < list.size(); i++) 
        {
            //System.out.println("Now adding the word: " + (String)list.get(i) + " to the array!");
            String temp = (String)list.get(i);
            new_corp = new_corp + temp.toLowerCase() + "\n";
        }
      
        
        return new_corp;
        
    }

    private String removeUnder4(String local_corp) {
        String new_corp = "";                // Used to store the processed corpus
        String    old_corp = "";                // The variable used to store whatever corpus was loaded
        int count = 0;
        int charfield = 3;
        try{
            charfield = Integer.parseInt(charField.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("Now removing all terms with under " + charfield + " characters ");
        
        // First we need to split the corpus into an array of strings - one per line (therefore \n as a seperator)
        String[] x = Pattern.compile("\n").split(local_corp);
        String[] cleaned = {};
        
        for (int i=0; i<x.length; i++) {
            boolean valid = true;
            
            if (x[i].length() < charfield) {
                count++;
                //System.out.println("Word: " + x[i] + " is shorter than " + charfield);
                valid = false;
            }
            
            if (valid) {
                new_corp = new_corp + x[i] + "\n";
            }
        }
        System.out.println("Successfully removed " + count + " words under the length of " + charfield + " from the corpus!");
        count = 0;
        return new_corp;
    }
    
    private String removeURLs(String local_corp) {
        String new_corp = "";                // Used to store the processed corpus
        String old_corp = "";                // The variable used to store whatever corpus was loaded
        
        CharSequence url = "doc id";
        
        System.out.println("Now removing all stored URLs from corpus.");
        
        // First we need to split the corpus into an array of strings - one per line (therefore \n as a seperator)
        String[] x = Pattern.compile("\n").split(local_corp);
        String[] cleaned = {};
        
        boolean clean = true;
        boolean exists_an = false;
        
        for (int i=0; i<x.length; i++) {
            if (x[i].contains(url)) {
                urlcount++;
                exists_an = true;
                
                // Now need to stop it processing this word any further if it's already found to be unclean
                //continue;
            }
            
            if (exists_an == false) {
                // Add the clean word to the corpus
                new_corp = new_corp + x[i] + "\n";
            }
            exists_an = false;
        }
        
        System.out.println("Successfully removed all URLs.");
        
        // The corpus has now been loaded into the old local variable
        //System.out.println(new_corp);
        System.out.println("Removed " + urlcount + " URLs from the corpus.");
        urlcount = 0;
        return new_corp;
    }
    
    private String removeAlpha(String local_corp) {
        String new_corp = "";                // Used to store the processed corpus
        String old_corp = "";                // The variable used to store whatever corpus was loaded
        
        CharSequence[] cs = { "!", "\"", "£", "$", "%", "^", "&", "*", "(", ")", "`", "¬", "¦", "\\", "|", ",", "<", ">", ".", "/", "?", ";", ":", "'", "@", "[", "{", "}", "]", "#", "~", "=", "+", "-", "_" };
        
        System.out.println("Now removing all non-alpha numerical terms.");
        
        // First we need to split the corpus into an array of strings - one per line (therefore \n as a seperator)
        String[] x = Pattern.compile("\n").split(local_corp);
        String[] cleaned = {};
        
        boolean clean = true;
        boolean exists_an = false;
        
        for (int i=0; i<x.length; i++) {
            // Now, for each word (x[i]) we need to check it against our array of char sequences
            for (int j=0; j<cs.length; j++) {
                if (x[i].contains(cs[j])) {
                    nacount++;
                    exists_an = true;
                    
                    // Now need to stop it processing this word any further if it's already found to be unclean
                    break;
                }
            }
            if (exists_an == false) {
                // Add the clean word to the corpus
                new_corp = new_corp + x[i] + "\n";
            }
            exists_an = false;
        }
        System.out.println("Successfully removed all non alpha-numerics.");
        
        // The corpus has now been loaded into the old local variable
        System.out.println("Removed " + nacount + " non alpha-numerics from the corpus.");
        nacount = 0;
        return new_corp;
    }
   
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jSeparator2 = new javax.swing.JSeparator();
        viewButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        urlButton = new javax.swing.JButton();
        alphaButton = new javax.swing.JButton();
        under4Button = new javax.swing.JButton();
        getCorpusButton = new javax.swing.JButton();
        sortButton = new javax.swing.JButton();
        charField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ununiqueButton = new javax.swing.JButton();
        freqButton = new javax.swing.JButton();

        viewButton.setText("View Current Corpus");
        viewButton.setEnabled(false);

        jLabel1.setText("Please select which processing methods you would like to apply to the corpus.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11));
        jLabel2.setText("You must use the Get Corpus For Processing button before processing.");

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        saveButton.setText("Save New Corpus As...");
        saveButton.setEnabled(false);

        undoButton.setText("Undo All");
        undoButton.setEnabled(false);
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        urlButton.setText("Remove URLs from corpus");
        urlButton.setEnabled(false);
        urlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlButtonActionPerformed(evt);
            }
        });

        alphaButton.setText("Remove all non-alpha numerics");
        alphaButton.setEnabled(false);
        alphaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alphaButtonActionPerformed(evt);
            }
        });

        under4Button.setText("Remove words with less than x characters");
        under4Button.setEnabled(false);
        under4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                under4ButtonActionPerformed(evt);
            }
        });

        getCorpusButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        getCorpusButton.setText("Get Corpus For Processing!");
        getCorpusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCorpusButtonActionPerformed(evt);
            }
        });

        sortButton.setText("Convert to lower case and sort corpus A-Z");
        sortButton.setEnabled(false);
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        charField.setText("4");
        charField.setEnabled(false);

        jLabel3.setText("chars");

        ununiqueButton.setText("Remove ununique terms from corpus");
        ununiqueButton.setEnabled(false);
        ununiqueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ununiqueButtonActionPerformed(evt);
            }
        });

        freqButton.setText("View Frequency Count");
        freqButton.setEnabled(false);
        freqButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freqButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(30, 30, 30)
                .add(jLabel2)
                .addContainerGap(30, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jSeparator3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(viewButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(freqButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 32, Short.MAX_VALUE)
                        .add(undoButton))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(getCorpusButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 43, Short.MAX_VALUE)
                        .add(saveButton)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(sortButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(urlButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .add(alphaButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .add(under4Button, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(ununiqueButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(charField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .add(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(11, 11, 11)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(viewButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(undoButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(freqButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .add(3, 3, 3)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(21, 21, 21)
                .add(urlButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(alphaButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(under4Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(charField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sortButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ununiqueButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 36, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(saveButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(getCorpusButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void freqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freqButtonActionPerformed
        
        frequency_string = getFrequency(unsaved);
        System.out.println(frequency_string);
    
    }//GEN-LAST:event_freqButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        
        System.out.println("Now undoing all processing changes"); 
        unsaved = backup;
        urlButton.setEnabled(true);
        alphaButton.setEnabled(true);
        under4Button.setEnabled(true);
        charField.setEnabled(true);
        sortButton.setEnabled(true);
        ununiqueButton.setEnabled(true);
        
    }//GEN-LAST:event_undoButtonActionPerformed

    private void ununiqueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ununiqueButtonActionPerformed
        undoButton.setEnabled(true);
        saveButton.setEnabled(true);
        
        String local_corp;
        
        local_corp = removeUn(unsaved);
        
        unsaved = local_corp;
        
        //System.out.println(unsaved);
        ununiqueButton.setEnabled(false);        
    }//GEN-LAST:event_ununiqueButtonActionPerformed
    
    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        undoButton.setEnabled(true);
        saveButton.setEnabled(true);
        ununiqueButton.setEnabled(true);
        freqButton.setEnabled(true);
        
        String local_corp;
        
        local_corp = orderAZ(unsaved);
        
        unsaved = local_corp;
        
        //System.out.println(unsaved);
        sortButton.setEnabled(false);
    }//GEN-LAST:event_sortButtonActionPerformed
    
    private void under4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_under4ButtonActionPerformed
        undoButton.setEnabled(true);
        saveButton.setEnabled(true);
        
        String local_corp;
        
        local_corp = removeUnder4(unsaved);
        
        unsaved = local_corp;
        
        //System.out.println(unsaved);
    }//GEN-LAST:event_under4ButtonActionPerformed
    
    private void alphaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alphaButtonActionPerformed
        undoButton.setEnabled(true);
        saveButton.setEnabled(true);
        
        String local_corp;
        
        local_corp = removeAlpha(unsaved);
        
        unsaved = local_corp;
        
        //System.out.println(unsaved);
        alphaButton.setEnabled(false);
    }//GEN-LAST:event_alphaButtonActionPerformed
    
    private void getCorpusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCorpusButtonActionPerformed
        viewButton.setEnabled(true);
        urlButton.setEnabled(true);
        alphaButton.setEnabled(true);
        under4Button.setEnabled(true);
        sortButton.setEnabled(true);
        charField.setEnabled(true);
        getCorpusButton.setEnabled(false);
        
        backup = saveOldCorpus();
        unsaved = backup;
    }//GEN-LAST:event_getCorpusButtonActionPerformed
    
    private void urlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlButtonActionPerformed
        undoButton.setEnabled(true);
        saveButton.setEnabled(true);
        
        String local_corp;
        
        local_corp = removeURLs(unsaved);
        
        unsaved = local_corp;
        
        //System.out.println(unsaved);
        urlButton.setEnabled(false);
    }//GEN-LAST:event_urlButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alphaButton;
    private javax.swing.JTextField charField;
    private javax.swing.JButton freqButton;
    private javax.swing.JButton getCorpusButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton sortButton;
    private javax.swing.JButton under4Button;
    private javax.swing.JButton undoButton;
    private javax.swing.JButton ununiqueButton;
    private javax.swing.JButton urlButton;
    private javax.swing.JButton viewButton;
    private javax.swing.JButton viewCorpusButton;
    // End of variables declaration//GEN-END:variables
    
}
