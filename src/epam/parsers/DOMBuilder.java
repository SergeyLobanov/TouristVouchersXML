package epam.parsers;

import epam.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Сергей on 09.07.2016.
 */
public class DOMBuilder extends AbstractTouristVouchersBuilder {

    private DocumentBuilder docBuilder;

    public DOMBuilder() {
        super();
        //DOM analyzer creating
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("Parsers configuration error: " + e);
        }
    }

    @Override
    public void buildListOfTouristVouchers(String fileName) {
        Document doc = null;
        try {
            // parsing of XML and creating of tree structure
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();

            NodeList touristVouchersList = root.getElementsByTagName("touristVoucher");
            for (int i = 0; i < touristVouchersList.getLength(); i++) {
                Element touristVoucherElement = (Element) touristVouchersList.item(i);
                TouristVoucher touristVoucher = buildTouristVoucher(touristVoucherElement);
                touristVouchers.add(touristVoucher);
            } 
            
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        } catch (SAXException e) {
            System.out.println("Parsing failure: " + e);
        }
    }

    private TouristVoucher buildTouristVoucher(Element touristVoucherElement) {
        TouristVoucher touristVoucher = new TouristVoucher();

        touristVoucher.setId(touristVoucherElement.getAttribute(TouristVoucherEnum.ID.getValue()));
        touristVoucher.setVoucherKind(VoucherKind.valueOf(getElementTextContent(touristVoucherElement,
                        TouristVoucherEnum.VOUCHER_KIND.getValue())));
        touristVoucher.setCountry(getElementTextContent(touristVoucherElement,
                        TouristVoucherEnum.COUNTRY.getValue()));
        Integer numberOfDays = Integer.parseInt(getElementTextContent(touristVoucherElement,
                        TouristVoucherEnum.NUMBER_OF_DAYS.getValue()));
        touristVoucher.setNumberOfDays(numberOfDays);
        touristVoucher.setTransport(TransportType.valueOf(getElementTextContent(touristVoucherElement,
                        TouristVoucherEnum.TRANSPORT.getValue())));

        HotelCharacteristics hotelCharacteristics = touristVoucher.getHotelCharacteristics();

        Element hotelCharacteristicsElement = (Element) touristVoucherElement.getElementsByTagName(
                               TouristVoucherEnum.HOTEL_CHARACTERISTICS.getValue()).item(0);
        Integer hotelStars = Integer.parseInt(getElementTextContent(hotelCharacteristicsElement,
                        TouristVoucherEnum.HOTEL_STARS.getValue()));
        hotelCharacteristics.setHotelStars(hotelStars);
        hotelCharacteristics.setNutrition(NutritionType.valueOf(getElementTextContent(
                        hotelCharacteristicsElement, TouristVoucherEnum.NUTRITION.getValue())));
        Integer roomsNumber = Integer.parseInt(getElementTextContent(hotelCharacteristicsElement,
                       TouristVoucherEnum.ROOMS_NUMBER.getValue()));
        hotelCharacteristics.setRoomsNumber(roomsNumber);

        //additional devices can contains list of elements
        NodeList nList = hotelCharacteristicsElement
                        .getElementsByTagName(TouristVoucherEnum.ADDITIONAL_DEVICE.getValue());
        for (int i = 0; i < nList.getLength(); i++) {
            hotelCharacteristics.addAdditionalDevice(nList.item(i).getTextContent());
        }
        /*hotelCharacteristics.addAdditionalDevice(getElementTextContent(hotelCharacteristicsElement,
                       TouristVoucherEnum.ADDITIONAL_DEVICE.getValue()));*/

        Integer voucherCost = Integer.parseInt(getElementTextContent(touristVoucherElement,
                TouristVoucherEnum.VOUCHER_COST.getValue()));
        touristVoucher.setVoucherCost(voucherCost);
        return touristVoucher;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }


}
