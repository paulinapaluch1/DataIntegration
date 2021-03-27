package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement( name = "laptops" )
@XmlAccessorType(XmlAccessType.FIELD)

public class Laptops {

    @XmlElement( name = "laptop" )
    private List<LaptopXml> laptopList;

    @XmlAttribute(name = "moddate", required = false)
    private String modDate;


}
