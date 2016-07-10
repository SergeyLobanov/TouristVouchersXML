
package epam.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transportType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="transportType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PLANE"/>
 *     &lt;enumeration value="TRAIN"/>
 *     &lt;enumeration value="CAR"/>
 *     &lt;enumeration value="SHIP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "transportType")
@XmlEnum
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
