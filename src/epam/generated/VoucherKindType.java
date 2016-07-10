
package epam.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for voucherKindType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="voucherKindType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WEEKEND"/>
 *     &lt;enumeration value="EXCURSION"/>
 *     &lt;enumeration value="RECREATION"/>
 *     &lt;enumeration value="PILGRIMAGE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "voucherKindType")
@XmlEnum
public enum VoucherKindType {

    WEEKEND,
    EXCURSION,
    RECREATION,
    PILGRIMAGE;

    public String value() {
        return name();
    }

    public static VoucherKindType fromValue(String v) {
        return valueOf(v);
    }

}
