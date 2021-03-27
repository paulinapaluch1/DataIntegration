package com.ppaluch.integracje.integracje.xml;

import com.ppaluch.integracje.integracje.converter.LaptopListMapper;
import com.ppaluch.integracje.integracje.dto.Laptop;
import com.ppaluch.integracje.integracje.dto.LaptopXml;
import com.ppaluch.integracje.integracje.dto.Laptops;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlHelper {

    public List<Laptop> readLaptops()  {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Laptops.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Laptops laptops = (Laptops) jaxbUnmarshaller.unmarshal(new File("katalog.xml"));
            return LaptopListMapper.from(laptops);

        }catch(JAXBException e){
            System.out.println("Wystąpił błąd");
        }
        return null;
    }



}
