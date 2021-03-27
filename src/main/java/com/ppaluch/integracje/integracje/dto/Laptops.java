package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@Data
@XmlRootElement( name = "laptops" )
public class Laptops {
    @XmlElement( name = "laptop" )
    private List laptops;
    @XmlAttribute(name = "moddate", required = false)
    private Date modDate;


}
