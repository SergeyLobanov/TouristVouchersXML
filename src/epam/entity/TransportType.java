package epam.entity;

/**
 * Created by Сергей on 09.07.2016.
 */
public enum TransportType {

    PLANE,
    TRAIN,
    CAR,
    SHIP;

    public String value() {
        return name();
    }

    public static TransportType fromValue(String v) {
        return valueOf(v);
    }

}
