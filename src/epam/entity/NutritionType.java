package epam.entity;

/**
 * Created by Сергей on 09.07.2016.
 */
public enum NutritionType {

    ONLY_BED,
    BED_AND_BREAKFAST,
    HALF_BOARD,
    FULL_BOARD,
    ALL_INCLUSIVE;

    public String value() {
        return name();
    }

    public static NutritionType fromValue(String v) {
        return valueOf(v);
    }

}
