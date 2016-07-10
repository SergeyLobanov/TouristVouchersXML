
package epam.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nutritionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="nutritionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ONLY_BED"/>
 *     &lt;enumeration value="BED_AND_BREAKFAST"/>
 *     &lt;enumeration value="HALF_BOARD"/>
 *     &lt;enumeration value="FULL_BOARD"/>
 *     &lt;enumeration value="ALL_INCLUSIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "nutritionType")
@XmlEnum
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
