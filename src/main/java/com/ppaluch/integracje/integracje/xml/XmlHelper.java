package com.ppaluch.integracje.integracje.xml;

import com.ppaluch.integracje.integracje.converter.LaptopListMapper;
import com.ppaluch.integracje.integracje.dto.LaptopGuiDto;
import com.ppaluch.integracje.integracje.dto.Laptops;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlHelper {

    public List<LaptopGuiDto> readLaptops(String path)  {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Laptops.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Laptops laptops = (Laptops) jaxbUnmarshaller.unmarshal(new File(path));
            return LaptopListMapper.from(laptops);

        }catch(JAXBException e){
            System.out.println("Wystąpił błąd");
        }
        return null;
    }


    public void saveLaptops(List<LaptopGuiDto> laptopList, String filepath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Laptops.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File XMLfile = new File(filepath);

            jaxbMarshaller.marshal(LaptopListMapper.from(laptopList), XMLfile);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
