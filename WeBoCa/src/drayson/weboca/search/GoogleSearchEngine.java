/*
 * GoogleSearch.java
 *
 * Created on 08 May 2006, 20:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package drayson.weboca.search;

import com.google.soap.search.GoogleSearch;
import com.google.soap.search.GoogleSearchFault;
import com.google.soap.search.GoogleSearchResult;
import com.google.soap.search.GoogleSearchResultElement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Andy
 */
public class GoogleSearchEngine implements SearchEngine {
    
    protected GoogleSearch googleSearch;
    protected String key;
    protected String additionalParams;
    
    /** Creates a new instance of GoogleSearch */
    public GoogleSearchEngine() {
        googleSearch = new GoogleSearch();
    }
    
    public GoogleSearchEngine(String key, String addParams) {
        googleSearch = new GoogleSearch();
        setKey(key);
        this.additionalParams = addParams;
        // Pad out the additional params
        additionalParams = " " + additionalParams + " ";
        System.out.println("Set Params Within GoogleSearchEngine as " + additionalParams);
    }
    
    public void setKey(String key) {
        this.key = key;
        googleSearch.setKey(this.key);
    }
    

    public List<SearchResult> doSearch(String query) {

        
        String filetypeExclusion = "-filetype:doc -filetype:pdf -filetype:ps -filetype:rtf -filetype:ppt -filetype:xls ";
       
        // Ensure that the filetypeExclusions, the additional Params and the query are queried!
        googleSearch.setQueryString(filetypeExclusion + additionalParams + query);
        GoogleSearchResult googleResult = null;
        try {
            googleResult = googleSearch.doSearch();
        } catch (GoogleSearchFault gsf) {
            System.err.println("Google Search Engine fault:");
            System.err.println(gsf);
        }
        
        List<SearchResult> resultList = new ArrayList<SearchResult>();
        
        GoogleSearchResultElement[] googleResults = googleResult.getResultElements();
        
        for (int i = 0; i < googleResults.length; i++) {
            resultList.add(new SearchResult(googleResults[i].getTitle(), googleResults[i].getURL()));
        }
        
        return resultList;
    }
    
}
