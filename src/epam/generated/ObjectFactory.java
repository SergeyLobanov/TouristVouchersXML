
package epam.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the epam.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TouristVouchers_QNAME = new QName("", "touristVouchers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: epam.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TouristVouchersType }
     * 
     */
    public TouristVouchersType createTouristVouchersType() {
        return new TouristVouchersType();
    }

    /**
     * Create an instance of {@link HotelCharacteristicsType }
     * 
     */
    public HotelCharacteristicsType createHotelCharacteristicsType() {
        return new HotelCharacteristicsType();
    }

    /**
     * Create an instance of {@link TouristVoucherType }
     * 
     */
    public TouristVoucherType createTouristVoucherType() {
        return new TouristVoucherType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TouristVouchersType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "touristVouchers")
    public JAXBElement<TouristVouchersType> createTouristVouchers(TouristVouchersType value) {
        return new JAXBElement<TouristVouchersType>(_TouristVouchers_QNAME, TouristVouchersType.class, null, value);
    }

}
