/*
 * TupleBuilder.java
 *
 * Created on 07 May 2006, 23:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package drayson.weboca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Andy Roberts
 */
public class TupleBuilder {
    
    public static List<String> buildTuples(List<String> terms, int n, int l) {
        
        if (n > terms.size()) {
            throw new IllegalArgumentException("Tuple size is greater than the number of available seeds!");
        }
       
        int combinations = factorial(terms.size())/(factorial(terms.size()-n)*factorial(n));
        
        if (l > combinations) {
            throw new IllegalArgumentException("Too many tuples requested for the number of items!");
        }
        
        List<String> tuples = new ArrayList<String>();
        
        Random rand = new Random();
        List<String> currentTuple;
        while (tuples.size() < l) {
            currentTuple = new ArrayList<String>();
            while (currentTuple.size() < n) {
                int currentIndex = rand.nextInt(terms.size());
                if (!currentTuple.contains(terms.get(currentIndex))) {
                    currentTuple.add(terms.get(currentIndex));
                }
            }
            
            Collections.sort(currentTuple);
            String stringTuple = "";
            for (int i = 0; i < currentTuple.size(); i++) {
                if (i == currentTuple.size()-1) {
                    stringTuple += currentTuple.get(i);
                }
                else {
                    stringTuple += currentTuple.get(i) + " ";
                }
            }
            
            if (!tuples.contains(stringTuple)) {
                tuples.add(stringTuple);
            }
            
        }
        
        return tuples;
    }
    
    private static int factorial(int n) {
	if (n < 2) return 1;
	else return n * factorial(n - 1);
    }
}
