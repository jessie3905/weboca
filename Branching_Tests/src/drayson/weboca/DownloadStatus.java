/*
 * DownloadStatus.java
 *
 * Created on 07 August 2006, 20:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package drayson.weboca;

/**
 *
 * @author Andy Roberts
 */
public class DownloadStatus {
    
    // These are the status codes.
    public static final int DOWNLOADING = 0;
    public static final int PAUSED = 1;
    public static final int COMPLETE = 2;
    public static final int CANCELLED = 3;
    public static final int ERROR = 4;
    public static final int CONNECTING = 5;
    public static final int INITIALISING = 6;
    public static final int TOKENISING = 7;
    public static final int DOWNLOADED = 8;
    
    private int numDownloads = 0;
    private int numErrors = 0;
    private int numInvalid = 0;
    private int numWords = 0;
    private long corpusSize = 0L;
    private int status = INITIALISING;
    
    
    /** Creates a new instance of DownloadState */
    public DownloadStatus() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public long getCorpusSize() {
        return corpusSize;
    }

    public int getNumDownloads() {
        return numDownloads;
    }

    public int getNumErrors() {
        return numErrors;
    }

    public int getNumInvalid() {
        return numInvalid;
    }

    public int getNumWords() {
        return numWords;
    }

    public void setCorpusSize(long corpusSize) {
        this.corpusSize = corpusSize;
    }

    public void setNumDownloads(int numDownloads) {
        this.numDownloads = numDownloads;
    }

    public void setNumErrors(int numErrors) {
        this.numErrors = numErrors;
    }

    public void setNumInvalid(int numInvalid) {
        this.numInvalid = numInvalid;
    }

    public void setNumWords(int numWords) {
        this.numWords = numWords;
    }
    
}
