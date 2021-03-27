package com.ppaluch.integracje.integracje.dto;


import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlType( propOrder = { "manufacturer", "screen", "processor", "disc" , "graphic_card", "os", "disc_reader"} )
@XmlRootElement( name = "laptop" )
public class LaptopXml {

    @XmlAttribute( name = "manufacturer", required = false )
    private String manufacturer;

    @XmlElement( name = "ram" )
    private String ram;

    @XmlElement( name = "os" )
    private String operatingSystem;

    @XmlElement( name = "disc_reader" )
    private String discReader;

}
