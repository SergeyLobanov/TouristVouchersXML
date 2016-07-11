package epam.parsers;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Сергей on 09.07.2016.
 */
public class SaxBuilder extends AbstractTouristVouchersBuilder{

    private SaxParser saxParser;
    private XMLReader reader;

    public SaxBuilder() {
        super();
        //SAX analyzer creating
        saxParser = new SaxParser();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(saxParser);
        } catch (SAXException e) {
            System.out.println("SAX parser error: " + e);
        }
    }

    @Override
    public void buildListOfTouristVouchers(String fileName) {
        System.out.println("SAX Parser");
        try {
            //XML document processing
            reader.parse(fileName);
        } catch (SAXException e) {
            System.out.println("SAX parser error: " + e);
        } catch (IOException e) {
            System.out.println("IO Stream error: " + e);
        }
        touristVouchers = saxParser.getTouristVouchers();
    }
}
