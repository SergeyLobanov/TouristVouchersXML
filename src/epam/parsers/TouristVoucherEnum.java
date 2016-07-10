package epam.parsers;

/**
 * Created by Сергей on 09.07.2016.
 */
public enum TouristVoucherEnum {

    TOURIST_VOUCHERS("touristVouchers"),
    ID("id"),
    TOURIST_VOUCHER("touristVoucher"),
    VOUCHER_KIND("voucherKind"),
    COUNTRY("country"),
    NUMBER_OF_DAYS("numberOfDays"),
    TRANSPORT("transport"),
    HOTEL_STARS("hotelStars"),
    NUTRITION("nutrition"),
    ROOMS_NUMBER("roomsNumber"),
    ADDITIONAL_DEVICE("additionalDevice"),
    VOUCHER_COST("voucherCost"),
    HOTEL_CHARACTERISTICS("hotelCharacteristics");

    private String value;

    private TouristVoucherEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * method to get enum element by his string representation
     * @param localName string in camel case converted in enum element form
     * @return corresponding enum element
     */
    public static TouristVoucherEnum stringToEnum(String localName) {
        String[] res = localName.split("(?=[A-Z])");
        StringBuilder res1 = new StringBuilder();

        for(String a : res) {
            res1.append(a + "_");
        }
        //res1.delete(res1.length() - 1, res1.length());
        //String res2 = res1.toString().substring(0, res1.length()-1).toUpperCase();
        return valueOf(res1.toString().substring(0, res1.length()-1).toUpperCase());
    }
}
