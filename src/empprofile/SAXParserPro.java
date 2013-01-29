package empprofile;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserPro {


    public static void main(String[] args) {

        try {
            // Create Parser
            SAXParserFactory saxpf = SAXParserFactory.newInstance();
            SAXParser saxp = saxpf.newSAXParser();
            
                        
            //saxp.setProperty("http://xml.org/sax/features/validation", true);
            // Ensure namespace processing is on (the default)
            //saxp.setProperty("http://xml.org/sax/features/namespaces", true);
                  
            saxp.parse("src/empprofile/transcript.xml", new MyParser());
            saxp.parse("src/empprofile/cv.xml", new MyParser());
            saxp.parse("src/empprofile/empRecord.xml", new MyParser());
            saxp.parse("src/empprofile/companyInfo.xml", new MyParser());
            saxp.parse("src/empprofile/transcript.xml", new MyParser());
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
        }
    }


    static class MyParser extends DefaultHandler {

        
        public MyParser() {
        
        }

        @Override
        public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {

            System.out.println("startElement:<" + arg2 + ">"); 
        }

        @Override
        public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
        	System.out.println("characters: " + new String(arg0, arg1, arg2) + " ");
        }

        @Override
        public void endElement(String arg0, String arg1, String arg2) throws SAXException {
           
        	System.out.println("endElement:<" + arg2 + ">");
        }
        
        @Override
        public void startDocument() throws SAXException {
        	System.out.println("<startDocument>");
        }
        @Override
        public void endDocument() throws SAXException {
        	System.out.println("<endDocument>");
        }
    }

}