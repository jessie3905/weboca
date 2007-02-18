/*
 * DownloadUrls.java
 *
 * Created on 26 July 2006, 21:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package drayson.weboca;

import andyr.jtokeniser.BreakIteratorTokeniser;
import andyr.jtokeniser.RegexTokeniser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.jdesktop.swingworker.SwingWorker;

/**
 *
 * @author Andy Roberts
 */
public class DownloadUrls extends SwingWorker<Integer, Integer> {
    
    private static final int MAX_BUFFER_SIZE = 1024;
    
    private List<String> urls;
    private String corpusOutputFilename;
    private String format;

    private DownloadStatus downloadStatus;
    
    private int WordCount;
    private int customSize;
    
    public DownloadUrls(List<String> urls, String corpusOutputFilename, String format, int WordCount, int customSize) {
    
        this.format = format;
        this.corpusOutputFilename = corpusOutputFilename;
        this.urls = urls;
        downloadStatus = new DownloadStatus();
        this.WordCount = WordCount;
        this.customSize = customSize;
    
    }

    public float getDownloadProgress(int downloaded, int size) {
        return ((float) downloaded / size) * 100;
    }
     
    private int getWords()
    {
        int words;
                
        if (WordCount != 0)
        {
            words = WordCount;
            return words;
        }
        else
        {
            words = downloadStatus.getNumWords() + 1;
            return words;
        }
    }
    
    private int getSize()
    {
        int size;
        if (customSize != 0)
        {
            size = customSize;
            return size;
        }
        else
        {
            size = 1;
            return size;
        }    
    }
    
    protected Integer doInBackground() throws Exception {
        
        int words = getWords();
        
        // Ensure that the program stops when the defined number of words has been met
        while (downloadStatus.getNumWords() < words)
        {
        
        RandomAccessFile file = null;
        InputStream stream = null;
        
        int downloaded = 0;
        int size = -1;
        int status;
        
        File corpusOutputFile = new File(corpusOutputFilename);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(corpusOutputFile), "utf8"));
        } catch (IOException ex) {
            ex.printStackTrace();
            return Integer.valueOf(DownloadStatus.ERROR);
        }
        URL currentUrl;
        int currentUrlCount = 0;
        
        for (final String urlString: urls) {
            currentUrlCount++;
            downloaded = 0;
            size = -1;
            currentUrl = new URL(urlString);
            
            try {
                
                setProgress(0);
                downloadStatus.setStatus(DownloadStatus.CONNECTING);
                firePropertyChange("status", null, downloadStatus);
                
                // Open connection to URL.
                HttpURLConnection connection = (HttpURLConnection) currentUrl.openConnection();
                
                // Specify what portion of file to download.
                connection.setRequestProperty("Range", "bytes=" + downloaded + "-");
                
                // Connect to server.
                connection.connect();
                
                // Make sure response code is in the 200 range.
                if (connection.getResponseCode() / 100 != 2) {
                    downloadStatus.setStatus(DownloadStatus.ERROR);
                    firePropertyChange("status", null, downloadStatus);
                    downloadStatus.setNumErrors(downloadStatus.getNumErrors()+1);
                    throw new Exception("Invalid response code");
                }
                
                int customsize = getSize();
                
                // Check for valid size of the page to be downloaded - in OCTETS - (the number of bytes!)                         
                int contentLength = connection.getContentLength();
                System.out.print(connection.getURL());
                int localSize = getSize();
                if (contentLength < localSize) 
                {
                    System.out.println("Oh no! The max size of the page is:");
                    System.out.println(getSize());
                    System.out.println("And this page is:");
                    System.out.println(contentLength);
                    throw new Exception("Invalid content length");
                }
                System.out.println("This time it's:");
                System.out.println(contentLength);
                /* Set the size for this download if it hasn't been already set. */
                if (size == -1) {
                    size = contentLength;
                    
                }
                
                // used to be size
                if (!HTMLUtils.isValidSize(localSize)) {
                    downloadStatus.setNumInvalid(downloadStatus.getNumInvalid()+1);
                    continue;
                }
                
                
                downloadStatus.setStatus(DownloadStatus.DOWNLOADING);
                firePropertyChange("status", null, downloadStatus);
                
                
                // Open file and seek to the end of it.
                file = new RandomAccessFile(getFileName(currentUrl), "rw");
                file.seek(downloaded);
                
                stream = connection.getInputStream();
                while (downloadStatus.getStatus() == DownloadStatus.DOWNLOADING) {
                    /* Size buffer according to how much of the file is left to download. */
                    byte buffer[];
                    if (size - downloaded > MAX_BUFFER_SIZE) {
                        buffer = new byte[MAX_BUFFER_SIZE];
                    } else {
                        buffer = new byte[size - downloaded];
                    }
                    
                    // Read from server into buffer.
                    int read = stream.read(buffer);
                    if (read == -1)
                        break;
                    
                    // Write buffer to file.
                    file.write(buffer, 0, read);
                    downloaded += read;
                    setProgress((int)getDownloadProgress(downloaded, size));
                    firePropertyChange("overall", Integer.valueOf(0), Integer.valueOf((100*(currentUrlCount-1)) + (int)getDownloadProgress(downloaded, size)));
                    
                }
                
                /* Change status to complete if this point was reached because downloading has finished. */
                if (downloadStatus.getStatus() == DownloadStatus.DOWNLOADING) {
                    downloadStatus.setStatus(DownloadStatus.DOWNLOADED);
                    firePropertyChange("status", null, downloadStatus);
                    
                    
                }
            } catch (Exception e) {
                
                downloadStatus.setStatus(DownloadStatus.ERROR);
                
                firePropertyChange("status", null, downloadStatus);
                setProgress(100);
                firePropertyChange("overall", Integer.valueOf(0), Integer.valueOf((100*(currentUrlCount-1)) + 100));
                
            } finally {
                // Close file.
                if (file != null) {
                    try {
                        file.close();
                    } catch (Exception e) {}
                }
                
                // Close connection to server.
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Exception e) {}
                }
            }
            
            if (downloadStatus.getStatus() == DownloadStatus.DOWNLOADED) {
                
                downloadStatus.setStatus(DownloadStatus.TOKENISING);
                firePropertyChange("status", null, downloadStatus);
                // File tests
                File currentFile = new File(getFileName(currentUrl));
                System.out.println("Processing: " + currentFile.getPath());
                //if (HTMLUtils.isValidSize(currentFile)) {
                try {
                    System.out.println("Getting document...");
                    String document = HTMLUtils.getDocument(currentFile);
                    System.out.println("Done.");
                    System.out.println("Number of chars: " + document.length());
                    System.out.print("Tokenising for word count... ");
                    BreakIteratorTokeniser tokeniser = new BreakIteratorTokeniser(document);
                    System.out.println("Done.");
                    System.out.print("Setting token property change... ");
                    firePropertyChange("tokens", Integer.valueOf(0), Integer.valueOf(tokeniser.countTokens()));
                    System.out.println("Done.");
                    System.out.print("Setting downloadStatus numWords... ");
                    downloadStatus.setNumWords(downloadStatus.getNumWords()+tokeniser.countTokens());
                    System.out.println("Done.");
                    System.out.println("Format: " + format);
                    try {
                        if (format.equals("raw")) {
                            System.out.print("Writing RAW corpus... ");
                            writer.write("CURRENT URL " + currentUrl.getFile());
                            writer.newLine();
                            writer.write(document + System.getProperty("line.separator"));
                            System.out.println("Done.");
                        }
                        else if (format.equals("vertical")) {
                            System.out.print("Writing VERT corpus... ");
                            writer.write("<doc id=\"" + downloadStatus.getNumDownloads()+1 + "\" url=\"" + currentUrl.toString() + "\">");
                            writer.newLine();
                            RegexTokeniser ret = new RegexTokeniser(document, "\\w+", true);
                            String token = "";
                            while (ret.hasMoreTokens()) {
                                token = ret.nextToken();
                                if (!token.trim().equals("")) {
                                    writer.write(token);
                                    writer.newLine();
                                }
                            }
                            
                            writer.write("</doc>");
                            writer.newLine();
                            System.out.println("Done.");
                        }
                        else {
                            System.out.println("Can't determine which corpus format to use.");
                        }
                        
                        // Finished with the local copy of the downloaded webpage. Delete.
                        //currentFile.delete();
                        
                        downloadStatus.setNumDownloads(downloadStatus.getNumDownloads()+1);
                        downloadStatus.setCorpusSize(corpusOutputFile.length());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            
            downloadStatus.setStatus(DownloadStatus.COMPLETE);
            
            firePropertyChange("status", null, downloadStatus);
        } // end for loop
        writer.close();
        }
        return Integer.valueOf(DownloadStatus.COMPLETE);
    }
    

    public String getFileName(URL url) {
        String fileName = url.getFile();
        return System.getProperty("java.io.tmpdir") + fileName.substring(fileName.lastIndexOf('/') + 1);
        
    }
    
}
