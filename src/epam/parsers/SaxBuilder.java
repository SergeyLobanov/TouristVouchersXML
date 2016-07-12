package epam.parsers;

import epam.view.View;
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
            e.printStackTrace();
        }
    }

    @Override
    public void buildListOfTouristVouchers(String fileName) {
        View.printMessage(View.SAX_PARSER);
        try {
            //XML document processing
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        touristVouchers = saxParser.getTouristVouchers();
    }
}
