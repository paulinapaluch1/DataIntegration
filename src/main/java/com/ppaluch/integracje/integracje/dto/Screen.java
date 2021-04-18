package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement( name = "screen" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "size", "resolution", "type"} )

public class Screen {

    @XmlAttribute( name = "touch")
    private String touch;

    @XmlElement( name = "size" )
    private String size;

    @XmlElement( name = "resolution" )
    private String resolution;

    @XmlElement( name = "type" )
    private String type;
}
