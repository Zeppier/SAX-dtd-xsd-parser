import java.util.Hashtable;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        //Create data structure.

    }

    @Override
    public void startElement(String URI, String localName, String qName, Attributes attr) throws SAXException {
        //Handle elements.
        System.out.println("Start Element: " + localName + " / " + qName);
        //Create components.
        if(qName.matches("component")) {
            String id = attr.getValue("id");
            System.out.println("id: " + id + " URI: " + URI);
        }

    }

    @Override
    public void endElement(String URI, String localName, String qName) throws SAXException {
        //End of an element.
        System.out.println("End Element: " + localName + " " + qName);
    }

    @Override
    public void endDocument() throws SAXException {
        //End of document.

    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e);
        e.printStackTrace();
    }
}