package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement( name = "graphic_card" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "name", "memory"} )

public class GraphicCard {

    @XmlElement( name = "name" )
    private String name;

    @XmlElement( name = "memory" )
    private String memory;


}
