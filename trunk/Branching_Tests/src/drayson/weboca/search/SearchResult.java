/*
 * SearchResults.java
 *
 * Created on 20 May 2006, 21:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package drayson.weboca.search;

/**
 *
 * @author Andy Roberts
 */
public class SearchResult implements Comparable {

    private String url;
    private String title;
    
    /** Creates a new instance of SearchResults */
    public SearchResult() {
        this("","");
    }
    
    public SearchResult(String title, String url) {
        setTitle(title);
        setUrl(url);
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url.trim();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url.trim();
    }

    public String toString() {
        
        return "[TITLE: " + getTitle() + "] [URL: " + getUrl()+"]";
    }
    
    public boolean equals(Object o) {
        
        if (this == o) {
            return true;
        }
        
        if (!(o instanceof SearchResult)) {
            return false;
        }
        
        SearchResult searchResult = (SearchResult)o;
        
        return this.getUrl().equals(searchResult.getUrl());
        
    }
    
    public int compareTo(Object o) {
        
        SearchResult searchResult = (SearchResult)o;
        
        return this.getUrl().compareTo(searchResult.getUrl());
        
    } 

    public int hashCode() {
        
        return this.getUrl().hashCode();
    }
}
