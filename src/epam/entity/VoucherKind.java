package epam.entity;

/**
 * Created by Сергей on 09.07.2016.
 */
public enum VoucherKind {
    WEEKEND,
    EXCURSION,
    RECREATION,
    PILGRIMAGE;

    public String value() {
        return name();
    }

    public static VoucherKind fromValue(String v) {
        return valueOf(v);
    }

}
