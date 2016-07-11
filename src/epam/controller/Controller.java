package epam.controller;

import epam.parsers.*;
import epam.view.View;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Scanner;

/**
 * Created by Сергей on 09.07.2016.
 */
public class Controller {
    //constants
    public static final String XML_DIRECTORY = "src/epam/xml/TouristVoucher.xml";
    public static final String XSD_DIRECTORY = "src/epam/xml/TouristVoucherScheme.xsd";
    public static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    public static final String YES ="y";

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processXML() {

        Scanner sc = new Scanner(System.in);

        view.printMessage(View.VALIDATION);
        validateXMLWithXSD(XML_DIRECTORY, XSD_DIRECTORY);


        while(true) {
            view.printMessage(View.ASK_TO_PARSE);
            String enter = enterValue(sc);
            if (!enter.equals(YES)) {
                break;
            }

            view.printMessage(View.ENTER_PARSER);
            String parser = enterValue(sc);
            if (!TouristVoucherBuilderFactory.isParserType(parser)) {
                view.printMessage(View.WRONG_PARSER + parser);
                view.printMessage(View.ENTER_PARSER);
                parser = enterValue(sc);
                parseXML(parser);
                continue;
            }
            parseXML(parser);
        }

        view.printMessage(View.END_WORK);
    }

    private void parseXML(String parserType) {
        TouristVoucherBuilderFactory tvFactory = new TouristVoucherBuilderFactory();
        AbstractTouristVouchersBuilder builder = tvFactory.createTouristVoucherBuilder(parserType);
        builder.buildListOfTouristVouchers(XML_DIRECTORY);
        //builder.getTouristVouchers().forEach(System.out::println);
        builder.getSortedTouristVouchers().forEach(System.out::println);
    }

    public void validateXMLWithXSD(String xmlPath, String xsdPath) {

        SchemaFactory factory = SchemaFactory.newInstance(LANGUAGE);

        try {
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.validate(source);
            view.printMessage(xmlPath + View.XML_VALID);
        } catch (SAXException | IOException e) {
            view.printMessage(xmlPath + View.XML_INVALID + e.getMessage());
        }
    }

    private String enterValue(Scanner sc) {
        while( !sc.hasNextLine()) {
            sc.nextLine();
        }

        return sc.nextLine();
    }

}
