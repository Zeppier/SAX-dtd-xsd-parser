import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args)  {
        Parser c = new Parser();
        try {
            c.Parse("src/main/resources/test.xml");
        } catch (MalformedURLException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}
