//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v@@BUILD_VERSION@@ 
// 	See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 	Any modifications to this file will be lost upon recompilation of the source schema. 
// 	Generated on: 2011.07.04 en 12:38:50 CEST 
//


package org.notariado.ancert.xml.plusvalias.liquidacion;


/**
 * Java content class for ActoJuridicoType complex type.
 * 	<p>The following schema fragment specifies the expected 	content contained within this java content object. 	(defined at file:/C:/Sun/jwsdp-1.5/jaxb/bin/IIVTNU-WS-Ayto.xsd line 1315)
 * <p>
 * <pre>
 * &lt;complexType name="ActoJuridicoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CODIGO">
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;length value="4"/>
 *           &lt;/restriction>
 *         &lt;/element>
 *         &lt;element name="DESCRIPCION">
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="255"/>
 *           &lt;/restriction>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface ActoJuridicoType {


    /**
     * Descripci�n de Acto jur�dico
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getDESCRIPCION();

    /**
     * Descripci�n de Acto jur�dico
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setDESCRIPCION(java.lang.String value);

    /**
     * C�digo de Acto jur�dico
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getCODIGO();

    /**
     * C�digo de Acto jur�dico
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setCODIGO(java.lang.String value);

}
