//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.03.26 at 06:08:09 PM MSK 
//


package travel_20190406.storage.loadinitialdata.xjc;

import travel_20190406.storage.loadinitialdata.xjc.Country;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countries">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="country" type="{}country" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "countries"
})
@XmlRootElement(name = "init-data")
public class InitData {

    @XmlElement(required = true)
    protected Countries countries;

    /**
     * Gets the value of the countries property.
     *
     * @return
     *     possible object is
     *     {@link Countries }
     *
     */
    public Countries getCountries() {
        return countries;
    }

    /**
     * Sets the value of the countries property.
     *
     * @param value
     *     allowed object is
     *     {@link Countries }
     *
     */
    public void setCountries(Countries value) {
        this.countries = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="country" type="{}country" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "country"
    })
    public static class Countries {

        @XmlElement(required = true)
        protected List<travel_20190406.storage.loadinitialdata.xjc.Country> country;

        /**
         * Gets the value of the country property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the country property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCountry().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link travel_20190406.storage.loadinitialdata.xjc.Country }
         *
         *
         */
        public List<travel_20190406.storage.loadinitialdata.xjc.Country> getCountry() {
            if (country == null) {
                country = new ArrayList<Country>();
            }
            return this.country;
        }

    }

}