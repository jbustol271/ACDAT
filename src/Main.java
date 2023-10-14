import com.acdat.unit2.MiGestorContactosXML;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
    public static void main(String[] args) {

        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse("contactos.xml", new MiGestorContactosXML());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}