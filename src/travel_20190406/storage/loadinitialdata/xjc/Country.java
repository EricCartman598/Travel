//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.03.26 at 06:08:09 PM MSK 
//


package travel_20190406.storage.loadinitialdata.xjc;

import travel_20190406.storage.loadinitialdata.xjc.City;
import travel_20190406.storage.loadinitialdata.xjc.Discriminator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for country complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="country">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="city" type="{}city" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="telephoneCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPolarNight" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotestMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="averageTemperature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="discriminator" type="{}discriminator" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "country", propOrder = {
    "name",
    "language",
    "cities",
    "telephoneCode",
    "isPolarNight",
    "hotestMonth",
    "averageTemperature"
})
public class Country {

    protected String name;
    protected String language;
    protected Cities cities;
    protected String telephoneCode;
    protected String isPolarNight;
    protected String hotestMonth;
    protected String averageTemperature;
    @XmlAttribute(name = "discriminator")
    protected Discriminator discriminator;

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the language property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the cities property.
     *
     * @return
     *     possible object is
     *     {@link Cities }
     *
     */
    public Cities getCities() {
        return cities;
    }

    /**
     * Sets the value of the cities property.
     *
     * @param value
     *     allowed object is
     *     {@link Cities }
     *
     */
    public void setCities(Cities value) {
        this.cities = value;
    }

    /**
     * Gets the value of the telephoneCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTelephoneCode() {
        return telephoneCode;
    }

    /**
     * Sets the value of the telephoneCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTelephoneCode(String value) {
        this.telephoneCode = value;
    }

    /**
     * Gets the value of the isPolarNight property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIsPolarNight() {
        return isPolarNight;
    }

    /**
     * Sets the value of the isPolarNight property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIsPolarNight(String value) {
        this.isPolarNight = value;
    }

    /**
     * Gets the value of the hotestMonth property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHotestMonth() {
        return hotestMonth;
    }

    /**
     * Sets the value of the hotestMonth property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHotestMonth(String value) {
        this.hotestMonth = value;
    }

    /**
     * Gets the value of the averageTemperature property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAverageTemperature() {
        return averageTemperature;
    }

    /**
     * Sets the value of the averageTemperature property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAverageTemperature(String value) {
        this.averageTemperature = value;
    }

    /**
     * Gets the value of the discriminator property.
     *
     * @return
     *     possible object is
     *     {@link Discriminator }
     *
     */
    public Discriminator getDiscriminator() {
        return discriminator;
    }

    /**
     * Sets the value of the discriminator property.
     *
     * @param value
     *     allowed object is
     *     {@link Discriminator }
     *     
     */
    public void setDiscriminator(Discriminator value) {
        this.discriminator = value;
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
     *         &lt;element name="city" type="{}city" maxOccurs="unbounded" minOccurs="0"/>
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
        "city"
    })
    public static class Cities {

        protected List<travel_20190406.storage.loadinitialdata.xjc.City> city;

        /**
         * Gets the value of the city property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the city property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link travel_20190406.storage.loadinitialdata.xjc.City }
         * 
         * 
         */
        public List<travel_20190406.storage.loadinitialdata.xjc.City> getCity() {
            if (city == null) {
                city = new ArrayList<City>();
            }
            return this.city;
        }

    }

}
