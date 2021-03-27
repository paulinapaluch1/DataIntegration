package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@XmlRootElement( name = "processor" )
public class Processor {

    @XmlElement( name = "name" )
    private String name;

    @XmlElement( name = "physical_cores" )
    private String physicalCores;

    @XmlElement( name = "clock_speed" )
    private String clockSpeed;






}
