
package epam.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for touristVouchersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="touristVouchersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="touristVoucher" type="{}touristVoucherType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "touristVouchersType", propOrder = {
    "touristVoucher"
})
@XmlRootElement//i had added to marshall this object
public class TouristVouchersType {

    @XmlElement(required = true)
    protected List<TouristVoucherType> touristVoucher;

    /**
     * Gets the value of the touristVoucher property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the touristVoucher property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTouristVoucher().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TouristVoucherType }
     *
     * 
     */
    public List<TouristVoucherType> getTouristVoucher() {
        if (touristVoucher == null) {
            touristVoucher = new ArrayList<TouristVoucherType>();
        }
        return this.touristVoucher;
    }

    public void addTouristVoucher(TouristVoucherType tv) {
        if (touristVoucher == null) {
            touristVoucher = new ArrayList<TouristVoucherType>();
        }
        touristVoucher.add(tv);
        //todo:to try
    }

}
