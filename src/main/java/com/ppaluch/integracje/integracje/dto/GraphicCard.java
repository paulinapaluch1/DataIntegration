package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement( name = "graphic_card" )
public class GraphicCard {

    @XmlElement( name = "name" )
    private String name;

    @XmlElement( name = "memory" )
    private String memory;


}
