/*
 * YahooSearchEngine.java
 *
 * Created on 08 May 2006, 22:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package drayson.weboca.search;

import com.yahoo.search.SearchClient;
import com.yahoo.search.SearchException;
import com.yahoo.search.WebSearchRequest;
import com.yahoo.search.WebSearchResult;
import com.yahoo.search.WebSearchResults;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andy
 */
public class YahooSearchEngine implements SearchEngine {
    
    protected SearchClient client;
    protected String key;
    
    /** Creates a new instance of YahooSearchEngine */
    public YahooSearchEngine(String key) {
        setKey(key);
        client = new SearchClient(getKey());
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }

    public List<SearchResult> doSearch(String query) {
        
        WebSearchRequest request = new WebSearchRequest(query);
        
        List<SearchResult> resultsList = new ArrayList<SearchResult>();
        
         try {
            // Execute the search.
            WebSearchResults results = client.webSearch(request);

            
            for (int i = 0; i < results.listResults().length; i++) {
                WebSearchResult result = results.listResults()[i];
                resultsList.add(new SearchResult(result.getTitle(), result.getUrl()));
                
            }
        }
        catch (IOException e) {
            // Most likely a network exception of some sort.
            System.err.println("Error calling Yahoo! Search Service: " +
                    e.toString());
            e.printStackTrace(System.err);
        }
        catch (SearchException e) {
            // An issue with the XML or with the service.
            System.err.println("Error calling Yahoo! Search Service: " +
                    e.toString());
            e.printStackTrace(System.err);
        }
        
        return resultsList;
    }
    
}
