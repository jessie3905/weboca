/*
 * HTMLUtils.java
 *
 */

package drayson.weboca;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;

/**
 *
 * @author Andy Roberts
 */
public class HTMLUtils {

    
    private static long MIN_FILE_SIZE = 1024L * 2;
    private static long MAX_FILE_SIZE = 1024L * 1000 * 5;
    private static int localcount = 0;
    
    /** Creates a new instance of HTMLUtils */
    private HTMLUtils() {
    }
    
    public static String getDocument(File file) throws FileNotFoundException {
        
        System.out.println("Making a new Tidy");
        Tidy tidy = new Tidy();
        
        System.out.println("Making a buffered input stream and passing it the file:");
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
        
        System.out.println("seeing some options in tidy");
        tidy.setQuiet(true);
        tidy.setShowWarnings(false);
        
        System.out.println("tidy.parseDOM");
        org.w3c.dom.Document root = tidy.parseDOM(is, null);
        
        System.out.println("Getting the rawDoc element");
        Element rawDoc = root.getDocumentElement();
        
        System.out.println("Returning the body of the rawDoc element");
        return getBody(rawDoc);
    }
    
    private static String getBody(Element rawDoc) {
        if (rawDoc == null) {
            System.out.println("rawDoc was null!");
            return null;
        }

        
        String body = "";
        
        System.out.println("Making a nodelist and getting elements by tag name");
        NodeList children = rawDoc.getElementsByTagName("body");
        if (children.getLength() > 0) {
           
            System.out.println("The children length is: " + children.getLength());
            System.out.println("getting text from the children");
            body = getText(children.item(0));
            System.out.println("Local count is now: " + localcount);
            
        }
        return body;
    }

    private static String getText(Node node) {
        
        //System.out.println("Getting text...");
        System.out.println("Getting a node list from the child nodes");
        NodeList children = node.getChildNodes();
        
        System.out.println("Making a string buffer");
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < children.getLength(); i++) {
            System.out.println("Children's length is: " + children.getLength());
            System.out.println("Setting the node child to the item of children");
            localcount++;
            Node child = children.item(i);
            switch (child.getNodeType()) {
            case Node.ELEMENT_NODE:
                String s = getText(child);
                if (s.trim().length() > 0) {
                    sb = sb.append(getText(child));
                    //sb = sb.append(" ");
                }
                break;
                case Node.TEXT_NODE:
                    
                    String text = child.getNodeValue().trim();
                    if (text.length() > 0) {
                        
                        text = text.replace('\n', ' ');
                        
                        String space = " ";
                        
                        if (child.getParentNode().getNodeName().equalsIgnoreCase("a")) {
                            space = "";
                        }
                        
                        sb = sb.append(text + space);
                    }
                    break;
            }
        }
        return sb.toString();
    }
    
    public static boolean isValidSize(File file) {
        
        return file.length() >= MIN_FILE_SIZE && file.length() <= MAX_FILE_SIZE;
    }
    
    public static boolean isValidSize(int filesize) {
        
        return filesize >= MIN_FILE_SIZE && filesize <= MAX_FILE_SIZE;
    }
 
    public static boolean isHtmlFile(String url) {
        String lowerUrl = url.toLowerCase();
        
        String[] invalidExtensions = {".pdf", ".rtf", ".ppt", ".doc", ".xls", ".ps"};
        
        for (int i = 0; i < invalidExtensions.length; i++) {
            if (lowerUrl.endsWith(invalidExtensions[i])) {
                return false;
            }
        }
        
        return true;
    }
    
}
