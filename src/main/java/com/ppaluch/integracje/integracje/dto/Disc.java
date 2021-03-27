package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement( name = "disc" )
public class Disc {

    @XmlAttribute( name = "type", required = false )
    private String type;

    @XmlElement( name = "storage" )
    private String storage;





}
