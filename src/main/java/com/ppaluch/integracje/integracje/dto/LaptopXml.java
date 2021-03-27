package com.ppaluch.integracje.integracje.dto;


import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlType( propOrder = { "ram", "operatingSystem", "discReader","screen","graphicCard","disc","processor","manufacturer"} )
@XmlRootElement( name = "laptop" )
@XmlAccessorType(XmlAccessType.FIELD)
public class LaptopXml {

    @XmlAttribute( name = "id")
    private String id;

    @XmlElement( name = "manufacturer" )
    private String manufacturer;

    @XmlElement( name = "ram" )
    private String ram;

    @XmlElement( name = "os" )
    private String operatingSystem;

    @XmlElement( name = "disc_reader" )
    private String discReader;

    @XmlElement( name = "screen" )
    private Screen screen;

    @XmlElement( name = "processor" )
    private Processor processor;

    @XmlElement( name = "disc" )
    private Disc disc;

    @XmlElement( name = "graphic_card" )
    private GraphicCard graphicCard;

}
