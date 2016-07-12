package epam.parsers;

import epam.entity.*;
import epam.view.View;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Сергей on 07.07.2016.
 */
public class StAXBuilder extends AbstractTouristVouchersBuilder{

    private XMLInputFactory inputFactory;

    public StAXBuilder() {
        super();
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildListOfTouristVouchers(String fileName) {
        View.printMessage(View.STAX_PARSER);

        XMLStreamReader reader = null;
        String name;
        try (FileInputStream inputStream = new FileInputStream((new File(fileName)))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            //StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (TouristVoucherEnum.stringToEnum(name)
                            == TouristVoucherEnum.TOURIST_VOUCHER) {
                        TouristVoucher touristVoucher = buildTouristVoucher(reader);
                        touristVouchers.add(touristVoucher);
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    private TouristVoucher buildTouristVoucher(XMLStreamReader reader)
                                                    throws XMLStreamException {
        TouristVoucher touristVoucher = new TouristVoucher();

        touristVoucher.setId(reader.getAttributeValue(null, TouristVoucherEnum.ID.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TouristVoucherEnum.stringToEnum(name)) {
                        case VOUCHER_KIND:
                            touristVoucher.setVoucherKind(VoucherKind
                                    .valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case COUNTRY:
                            touristVoucher.setCountry(getXMLText(reader));
                            break;
                        case NUMBER_OF_DAYS:
                            touristVoucher.setNumberOfDays(Integer
                                    .parseInt(getXMLText(reader)));
                            break;
                        case TRANSPORT:
                            touristVoucher.setTransport(TransportType
                                    .valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case HOTEL_CHARACTERISTICS:
                            touristVoucher.setHotelCharacteristics(
                                    getXMLHotelCharacteristics(reader));
                            break;
                        case VOUCHER_COST:
                            touristVoucher.setVoucherCost(Integer
                                    .parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TouristVoucherEnum.stringToEnum(name)
                            == TouristVoucherEnum.TOURIST_VOUCHER) {
                        return touristVoucher;
                    }
                    break;
            }
        }
        throw new XMLStreamException();
    }

    private HotelCharacteristics getXMLHotelCharacteristics(XMLStreamReader reader)
                                                            throws XMLStreamException {
        HotelCharacteristics hotelCharacteristics = new HotelCharacteristics();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TouristVoucherEnum.stringToEnum(name)) {
                        case HOTEL_STARS:
                            hotelCharacteristics.setHotelStars(Integer
                                    .parseInt(getXMLText(reader)));
                            break;
                        case NUTRITION:
                            hotelCharacteristics.setNutrition(NutritionType
                                    .valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case ROOMS_NUMBER:
                            hotelCharacteristics.setRoomsNumber(Integer
                                    .parseInt(getXMLText(reader)));
                            break;
                        case ADDITIONAL_DEVICE:
                            hotelCharacteristics.addAdditionalDevice(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TouristVoucherEnum.stringToEnum(name)
                            == TouristVoucherEnum.HOTEL_CHARACTERISTICS) {
                        return hotelCharacteristics;
                    }
                    break;
            }
        }
        throw new XMLStreamException();
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
