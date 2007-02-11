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
    
    /** Creates a new instance of HTMLUtils */
    private HTMLUtils() {
    }
    
    public static String getDocument(File file) throws FileNotFoundException {
        
        Tidy tidy = new Tidy();
        
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
        
        tidy.setQuiet(true);
        tidy.setShowWarnings(false);
        org.w3c.dom.Document root = tidy.parseDOM(is, null);
        Element rawDoc = root.getDocumentElement();
        
        return getBody(rawDoc);
    }
    
    private static String getBody(Element rawDoc) {
        if (rawDoc == null) {
            return null;
        }

        String body = "";
        NodeList children = rawDoc.getElementsByTagName("body");
        if (children.getLength() > 0) {
            body = getText(children.item(0));
        }
        return body;
    }

    private static String getText(Node node) {
        
        System.out.println("Getting text...");
        
        NodeList children = node.getChildNodes();
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < children.getLength(); i++) {
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
