package epam.entity;

/**
 * Created by Сергей on 09.07.2016.
 */
public class TouristVoucher {

    private String id;
    private VoucherKind voucherKind;
    private String country;
    private int numberOfDays;
    private TransportType transport;
    private HotelCharacteristics hotelCharacteristics;
    private int voucherCost;

    //default constructor
    public TouristVoucher() {
    }

    public TouristVoucher(String id, VoucherKind voucherKind, String country,
                              int numberOfDays, TransportType transport,
                              HotelCharacteristics hotelCharacteristics,
                              int voucherCost) {
        this.voucherKind = voucherKind;
        this.country = country;
        this.numberOfDays = numberOfDays;
        this.transport = transport;
        this.hotelCharacteristics = hotelCharacteristics;
        this.voucherCost = voucherCost;
        this.id = id;
    }

    //getters and setters
    public VoucherKind getVoucherKind() {
        return voucherKind;
    }

    public void setVoucherKind(VoucherKind value) {
        this.voucherKind = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int value) {
        this.numberOfDays = value;
    }

    public TransportType getTransport() {
        return transport;
    }

    public void setTransport(TransportType value) {
        this.transport = value;
    }

    public HotelCharacteristics getHotelCharacteristics() {
        if (hotelCharacteristics == null) {
            hotelCharacteristics = new HotelCharacteristics();
        }
        return hotelCharacteristics;
    }

    public void setHotelCharacteristics(HotelCharacteristics value) {
        this.hotelCharacteristics = value;
    }

    public int getVoucherCost() {
        return voucherCost;
    }

    public void setVoucherCost(int value) {
        this.voucherCost = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    @Override
    public String toString() {
        return "TouristVoucher{" +
                "id='" + id + '\'' +
                ", voucherKind=" + voucherKind +
                ", country='" + country + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", transport=" + transport +
                ", hotelCharacteristics=" + hotelCharacteristics +
                ", voucherCost=" + voucherCost +
                '}';
    }
}

