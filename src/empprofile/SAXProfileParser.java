package empprofile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXProfileParser {

    public static void main(String[] args) {

        try {
            // Create Parser
            SAXParserFactory saxpf = SAXParserFactory.newInstance();
            SAXParser saxp = saxpf.newSAXParser();


            //saxp.setProperty("http://xml.org/sax/features/validation", true);
            // Ensure namespace processing is on (the default)
            //saxp.setProperty("http://xml.org/sax/features/namespaces", true);


            DefaultHandler handler = new DefaultHandler() {
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
            };

            File file = new File("src/empprofile/profile.xml");
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            saxp.parse(is, handler);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
        }
    }
}