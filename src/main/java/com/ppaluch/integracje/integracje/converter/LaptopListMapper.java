package com.ppaluch.integracje.integracje.converter;

import com.ppaluch.integracje.integracje.dto.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LaptopListMapper {


    public static List<Laptop> from(Laptops laptops){
        List<Laptop> list = new ArrayList<>();
        for(LaptopXml laptopXml : laptops.getLaptopList()){
            Laptop laptop = new Laptop();
            laptop.setIndex(laptopXml.getId());
            laptop.setProducerName(laptopXml.getManufacturer());
            laptop.setScreenDiagonal(laptopXml.getScreen().getSize());
            laptop.setScreenSize(laptopXml.getScreen().getResolution());
            laptop.setScreenSurfaceType(laptopXml.getScreen().getType());
            laptop.setIsScreenTouch(laptopXml.getScreen().getTouch());
            laptop.setProcessorName(laptopXml.getProcessor().getName());
            laptop.setPhysicalCoresNumber(laptopXml.getProcessor().getPhysicalCores());
            laptop.setClockSpeed(laptopXml.getProcessor().getClockSpeed());
            laptop.setRAM(laptopXml.getRam());
            laptop.setDiskCapacity(laptopXml.getDisc().getStorage());
            laptop.setDiskType(laptopXml.getDisc().getType());
            laptop.setGraphics(laptopXml.getGraphicCard().getName());
            laptop.setMemoryGPU(laptopXml.getGraphicCard().getMemory());
            laptop.setOperatingSystem(laptopXml.getOperatingSystem());
            laptop.setPhysicalDriveType(laptopXml.getDiscReader());
            list.add(laptop);
        }
            return list;
    }


    public static Laptops from(List<Laptop> laptopList) {
        Laptops laptops = new Laptops();
        laptops.setModDate(new Date().toString());
        List<LaptopXml> list = new ArrayList<>();

        for(Laptop laptop : laptopList){
            LaptopXml laptopXml = new LaptopXml();
            laptopXml.setId(laptop.getIndex());
            laptopXml.setRam(laptop.getRAM());
            laptopXml.setOperatingSystem(laptop.getOperatingSystem());
            laptopXml.setDiscReader(laptop.getPhysicalDriveType());
            laptopXml.setManufacturer(laptop.getProducerName());

            laptopXml.setDisc(getDiscFromLaptop(laptop));
            laptopXml.setProcessor(getProcessorFromLaptop(laptop));
            laptopXml.setGraphicCard(getGraphicCardFromLaptop(laptop));
            laptopXml.setScreen(getScreenFromLaptop(laptop));

            list.add(laptopXml);

        }
        laptops.setLaptopList(list);

        return laptops;
    }

    private static Screen getScreenFromLaptop(Laptop laptop) {
        Screen screen = new Screen();
        screen.setResolution(laptop.getScreenSize());
        screen.setSize(laptop.getScreenDiagonal());
        screen.setTouch(laptop.getIsScreenTouch());
        screen.setType(laptop.getScreenSurfaceType());
        return screen;
    }

    private static GraphicCard getGraphicCardFromLaptop(Laptop laptop) {
        GraphicCard graphicCard = new GraphicCard();
        graphicCard.setMemory(laptop.getMemoryGPU());
        graphicCard.setName(laptop.getGraphics());
        return graphicCard;
    }

    private static Processor getProcessorFromLaptop(Laptop laptop) {
        Processor processor = new Processor();
        processor.setName(laptop.getProcessorName());
        processor.setClockSpeed(laptop.getClockSpeed());
        processor.setPhysicalCores(laptop.getPhysicalCoresNumber());
        return processor;
    }

    private static Disc getDiscFromLaptop(Laptop laptop) {
            Disc disc = new Disc();
            disc.setStorage(laptop.getDiskCapacity());
            disc.setType(laptop.getDiskType());
            return disc;

    }
}
