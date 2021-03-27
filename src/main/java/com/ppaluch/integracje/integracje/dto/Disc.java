package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement( name = "disc" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "storage"} )

public class Disc {

    @XmlAttribute( name = "type", required = false )
    private String type;

    @XmlElement( name = "storage" )
    private String storage;





}
