package com.ppaluch.integracje.integracje.converter;


import com.ppaluch.integracje.integracje.dto.*;
import com.ppaluch.integracje.integracje.dto.LaptopGuiDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LaptopListMapperTest {

    @Test
    public void shouldRepackLaptopListFromLaptops(){
        Laptops laptops = prepareLaptopsForTests();
        List<LaptopGuiDto> laptopList = LaptopListMapper.from(laptops);

        assertFalse(laptopList.isEmpty());
        assertEquals(laptopList.size(), 1);
        assertEquals(laptopList.get(0).getLaptopIndex(),1);
        assertEquals(laptopList.get(0).getRAM(),"8GB");
        assertEquals(laptopList.get(0).getDiskCapacity(),"500GB");
        assertEquals(laptopList.get(0).getProcessorName(),"intel core i7");
        assertEquals(laptopList.get(0).getScreenSize(),"1900x1900");

    }

    public static Laptops prepareLaptopsForTests() {
        Laptops laptops = new Laptops();
        laptops.setModDate("2015-10-30 T 10:15");
        List<LaptopXml> list = new ArrayList<>();
        list.add(prepareLaptopXmlForTest());
        laptops.setLaptopList(list);
        return laptops;
    }


    public static LaptopXml prepareLaptopXmlForTest(){
      LaptopXml laptopXml = new LaptopXml();
      laptopXml.setId(1);
      laptopXml.setRam("8GB");
      laptopXml.setOperatingSystem("Windows 10 Home");
      laptopXml.setDiscReader("Blue Ray");
      laptopXml.setManufacturer("Dell");

      laptopXml.setScreen(getScreeForTests());
      laptopXml.setDisc(getDiscForTests());
      laptopXml.setProcessor(getProcessorForTests());
      laptopXml.setGraphicCard(getGraphicCardForTests());
        return laptopXml;
  }


    public static Screen getScreeForTests() {
        Screen screen = new Screen();
        screen.setResolution("1900x1900");
        screen.setSize("12'");
        screen.setTouch("yes");
        screen.setType("matowa");
        return screen;
    }

    public static GraphicCard getGraphicCardForTests() {
        GraphicCard graphicCard = new GraphicCard();
        graphicCard.setMemory("1GB");
        graphicCard.setName("NVIDIA GeForce GTX 1050");
        return graphicCard;
    }

    public static Processor getProcessorForTests() {
        Processor processor = new Processor();
        processor.setName("intel core i7");
        processor.setClockSpeed(1900);
        processor.setPhysicalCores(8);
        return processor;
    }

    public static Disc getDiscForTests() {
        Disc disc = new Disc();
        disc.setStorage("500GB");
        disc.setType("SSD");
        return disc;

    }




}