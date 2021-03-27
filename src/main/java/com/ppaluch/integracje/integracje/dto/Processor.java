package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlRootElement( name = "processor" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "name", "physicalCores", "clockSpeed"} )
public class Processor {

    @XmlElement( name = "name" )
    private String name;

    @XmlElement( name = "physical_cores" )
    private Integer physicalCores;

    @XmlElement( name = "clock_speed" )
    private Integer clockSpeed;






}
