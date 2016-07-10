
package epam.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hotelCharacteristicsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hotelCharacteristicsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nutrition" type="{}nutritionType"/>
 *         &lt;element name="roomsNumber">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;pattern value="[1234]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="additionalDevice" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="hotelStars" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="1"/>
 *             &lt;maxInclusive value="5"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hotelCharacteristicsType", propOrder = {
    "nutrition",
    "roomsNumber",
    "additionalDevice"
})
public class HotelCharacteristicsType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected NutritionType nutrition;
    protected int roomsNumber;
    protected List<String> additionalDevice;
    @XmlAttribute(name = "hotelStars", required = true)
    protected int hotelStars;

    //default constructor
    public HotelCharacteristicsType() {
    }

    public HotelCharacteristicsType(NutritionType nutrition, int roomsNumber, List<String> additionalDevice, int hotelStars) {
        this.nutrition = nutrition;
        this.roomsNumber = roomsNumber;
        this.additionalDevice = additionalDevice;
        this.hotelStars = hotelStars;
    }

    /**
     * Gets the value of the nutrition property.
     * 
     * @return
     *     possible object is
     *     {@link NutritionType }
     *     
     */
    public NutritionType getNutrition() {
        return nutrition;
    }

    /**
     * Sets the value of the nutrition property.
     * 
     * @param value
     *     allowed object is
     *     {@link NutritionType }
     *     
     */
    public void setNutrition(NutritionType value) {
        this.nutrition = value;
    }

    /**
     * Gets the value of the roomsNumber property.
     * 
     */
    public int getRoomsNumber() {
        return roomsNumber;
    }

    /**
     * Sets the value of the roomsNumber property.
     * 
     */
    public void setRoomsNumber(int value) {
        this.roomsNumber = value;
    }

    /**
     * Gets the value of the additionalDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAdditionalDevice() {
        if (additionalDevice == null) {
            additionalDevice = new ArrayList<String>();
        }
        return this.additionalDevice;
    }

    /**
     * Gets the value of the hotelStars property.
     * 
     */
    public int getHotelStars() {
        return hotelStars;
    }

    /**
     * Sets the value of the hotelStars property.
     * 
     */
    public void setHotelStars(int value) {
        this.hotelStars = value;
    }

    @Override
    public String toString() {
        return "HotelCharacteristicsType{" +
                "hotelStars=" + hotelStars +
                ", nutrition=" + nutrition +
                ", roomsNumber=" + roomsNumber +
                ", additionalDevice=" + additionalDevice +
                '}';
    }
}
