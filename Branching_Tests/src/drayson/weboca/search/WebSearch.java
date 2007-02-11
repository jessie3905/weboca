/*
 * WebSearch.java
 *
 * Created on 08 May 2006, 20:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package drayson.weboca.search;

import java.util.List;

/**
 *
 * @author Andy
 */
public class WebSearch {
    
    private SearchEngine searchEngine;
    
    /** Creates a new instance of WebSearch */
    public WebSearch() {
    }
    
    public WebSearch(SearchEngine searchEngine) {
        setSearchEngine(searchEngine);
    }
    
    public void setSearchEngine(SearchEngine searchEngine) {
        
        this.searchEngine = searchEngine;
    }

    public SearchEngine getSearchEngine() {
        return searchEngine;
    }
    
    public List<SearchResult> search(String query) {
        return searchEngine.doSearch(query);
    }

    
}
