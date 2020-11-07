import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Parser {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";

    public void Parse(String name) throws ParserConfigurationException, SAXException, MalformedURLException {
        File f = new File(name);
        Handler c = new Handler();
        String toParse = f.toURI().toURL().toString();

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(true);


        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("src/main/resources/securityspace.xsd"));

        spf.setSchema(schema);
        SAXParser saxParser = spf.newSAXParser();
        try {
            System.out.println("Начало парсинга: ");
            XMLReader reader = saxParser.getXMLReader();

            reader.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    System.out.println(ANSI_RED + exception.getMessage() + ANSI_RESET);
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    System.out.println(ANSI_RED + exception.getMessage() + ANSI_RESET);
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    System.out.println(ANSI_RED + exception.getMessage() + ANSI_RESET);
                }
            });

            reader.setContentHandler(c);

            reader.parse(toParse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
