/*
 * SearchEngine.java
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
 * @author Andy Roberts
 */
public interface SearchEngine {
    public List<SearchResult> doSearch(String query);
}
