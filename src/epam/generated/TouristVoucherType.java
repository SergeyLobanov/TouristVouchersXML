
package epam.generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for touristVoucherType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="touristVoucherType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="voucherKind" type="{}voucherKindType"/>
 *         &lt;element name="country">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[a-zA-Z ]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="numberOfDays" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="transport" type="{}transportType"/>
 *         &lt;element name="hotelCharacteristics" type="{}hotelCharacteristicsType"/>
 *         &lt;element name="voucherCost" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "touristVoucherType", propOrder = {
    "voucherKind",
    "country",
    "numberOfDays",
    "transport",
    "hotelCharacteristics",
    "voucherCost"
})
public class TouristVoucherType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected VoucherKindType voucherKind;
    @XmlElement(required = true)
    protected String country;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numberOfDays;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TransportType transport;
    @XmlElement(required = true)
    protected HotelCharacteristicsType hotelCharacteristics;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger voucherCost;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    //default constructor
    public TouristVoucherType() {
    }

    public TouristVoucherType(VoucherKindType voucherKind, String country,
                              BigInteger numberOfDays, TransportType transport,
                              HotelCharacteristicsType hotelCharacteristics,
                              BigInteger voucherCost, String id) {
        this.voucherKind = voucherKind;
        this.country = country;
        this.numberOfDays = numberOfDays;
        this.transport = transport;
        this.hotelCharacteristics = hotelCharacteristics;
        this.voucherCost = voucherCost;
        this.id = id;
    }

    /**
     * Gets the value of the voucherKind property.
     * 
     * @return
     *     possible object is
     *     {@link VoucherKindType }
     *     
     */
    public VoucherKindType getVoucherKind() {
        return voucherKind;
    }

    /**
     * Sets the value of the voucherKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoucherKindType }
     *     
     */
    public void setVoucherKind(VoucherKindType value) {
        this.voucherKind = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the numberOfDays property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * Sets the value of the numberOfDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfDays(BigInteger value) {
        this.numberOfDays = value;
    }

    /**
     * Gets the value of the transport property.
     * 
     * @return
     *     possible object is
     *     {@link TransportType }
     *     
     */
    public TransportType getTransport() {
        return transport;
    }

    /**
     * Sets the value of the transport property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportType }
     *     
     */
    public void setTransport(TransportType value) {
        this.transport = value;
    }

    /**
     * Gets the value of the hotelCharacteristics property.
     * 
     * @return
     *     possible object is
     *     {@link HotelCharacteristicsType }
     *     
     */
    public HotelCharacteristicsType getHotelCharacteristics() {
        return hotelCharacteristics;
    }

    /**
     * Sets the value of the hotelCharacteristics property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelCharacteristicsType }
     *     
     */
    public void setHotelCharacteristics(HotelCharacteristicsType value) {
        this.hotelCharacteristics = value;
    }

    /**
     * Gets the value of the voucherCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVoucherCost() {
        return voucherCost;
    }

    /**
     * Sets the value of the voucherCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVoucherCost(BigInteger value) {
        this.voucherCost = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
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
