package epam.parsers;

import epam.entity.NutritionType;
import epam.entity.TouristVoucher;
import epam.entity.TransportType;
import epam.entity.VoucherKind;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;


/**
 * Created by Сергей on 09.07.2016.
 */
public class SaxParser extends DefaultHandler {

    private List<TouristVoucher> touristVouchers;
    private TouristVoucher currentVoucher = null;
    private TouristVoucherEnum currentEnum = null;
    private EnumSet<TouristVoucherEnum> withText;

    public SaxParser() {
        this.touristVouchers = new ArrayList<>();
        this.withText = EnumSet.range(TouristVoucherEnum.VOUCHER_KIND,
                TouristVoucherEnum.VOUCHER_COST);
    }

    public List<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }

    /**
     *
     * @param uri unique namespace
     * @param localName elements name without prefix
     * @param qName full elements name
     * @param attributes list of attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if ("touristVoucher".equals(localName)) {
            currentVoucher = new TouristVoucher();
            currentVoucher.setId(attributes.getValue(0));
        } else {
            TouristVoucherEnum temp = TouristVoucherEnum.stringToEnum(localName); {
                if(withText.contains(temp)) {
                    currentEnum = temp;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("touristVoucher".equals(localName)) {
            touristVouchers.add(currentVoucher);
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        String s = new String(chars, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case VOUCHER_KIND:
                    currentVoucher.setVoucherKind(VoucherKind.valueOf(s));
                    break;
                case COUNTRY:
                    currentVoucher.setCountry(s);
                    break;
                case NUMBER_OF_DAYS:
                    currentVoucher.setNumberOfDays(Integer.parseInt(s));
                    break;
                case TRANSPORT:
                    currentVoucher.setTransport(TransportType.valueOf(s));
                    break;
                case HOTEL_STARS:
                    currentVoucher.getHotelCharacteristics().setHotelStars(Integer.parseInt(s));
                    break;
                case NUTRITION:
                    currentVoucher.getHotelCharacteristics().setNutrition(NutritionType.valueOf(s));
                    break;
                case ROOMS_NUMBER:
                    currentVoucher.getHotelCharacteristics().setRoomsNumber(Integer.parseInt(s));
                    break;
                case ADDITIONAL_DEVICE:
                    currentVoucher.getHotelCharacteristics().addAdditionalDevice(s);
                    break;
                case VOUCHER_COST:
                    currentVoucher.setVoucherCost(Integer.parseInt(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
