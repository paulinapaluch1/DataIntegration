package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement( name = "screen" )
public class Screen {

    @XmlAttribute( name = "touch", required = false )
    private String touch;

    @XmlElement( name = "size" )
    private String size;

    @XmlElement( name = "resolution" )
    private String resolution;

    @XmlElement( name = "type" )
    private String type;
}
