package epam.parsers;

import epam.entity.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        System.out.println("StAX Parser");
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream((new File(fileName)));
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
        } catch (XMLStreamException e) {
            System.out.println("StAX parsing error: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found! " + e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private TouristVoucher buildTouristVoucher(XMLStreamReader reader)
                                                    throws XMLStreamException {
        TouristVoucher touristVoucher = new TouristVoucher();

        touristVoucher.setId(reader.getAttributeValue(null,
                                TouristVoucherEnum.ID.getValue()));
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
                    if (TouristVoucherEnum.stringToEnum(name) ==
                            TouristVoucherEnum.TOURIST_VOUCHER) {
                        return touristVoucher;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag TouristVoucher");
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
                    if (TouristVoucherEnum.stringToEnum(name) ==
                            TouristVoucherEnum.HOTEL_CHARACTERISTICS) {
                        return hotelCharacteristics;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag HotelCharacteristics");
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
