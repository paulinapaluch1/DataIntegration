package com.ppaluch.integracje.integracje.converter;

import com.ppaluch.integracje.integracje.dto.*;
import com.ppaluch.integracje.integracje.dto.LaptopGuiDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LaptopListMapper {

    public static List<LaptopGuiDto> from(Laptops laptops){
        List<LaptopGuiDto> list = new ArrayList<>();
        for(LaptopXml laptopXml : laptops.getLaptopList()){
            LaptopGuiDto laptop = getLaptopFromLaptopXml(laptopXml);
            list.add(laptop);
        }
            return list;
    }

    private static LaptopGuiDto getLaptopFromLaptopXml(LaptopXml laptopXml) {
        LaptopGuiDto laptop = new LaptopGuiDto();
        laptop.setLaptopIndex(laptopXml.getId());
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
        return laptop;
    }


    public static Laptops from(List<LaptopGuiDto> laptopList) {
        Laptops laptops = new Laptops();
        laptops.setModDate(new Date().toString());
        List<LaptopXml> list = new ArrayList<>();

        for(LaptopGuiDto laptop : laptopList){
            LaptopXml laptopXml = new LaptopXml();
            laptopXml.setId(laptop.getLaptopIndex());
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

    private static Screen getScreenFromLaptop(LaptopGuiDto laptop) {
        Screen screen = new Screen();
        screen.setResolution(laptop.getScreenSize());
        screen.setSize(laptop.getScreenDiagonal());
        screen.setTouch(laptop.getIsScreenTouch());
        screen.setType(laptop.getScreenSurfaceType());
        return screen;
    }

    private static GraphicCard getGraphicCardFromLaptop(LaptopGuiDto laptop) {
        GraphicCard graphicCard = new GraphicCard();
        graphicCard.setMemory(laptop.getMemoryGPU());
        graphicCard.setName(laptop.getGraphics());
        return graphicCard;
    }

    private static Processor getProcessorFromLaptop(LaptopGuiDto laptop) {
        Processor processor = new Processor();
        processor.setName(laptop.getProcessorName());
        processor.setClockSpeed(laptop.getClockSpeed());
        processor.setPhysicalCores(laptop.getPhysicalCoresNumber());
        return processor;
    }

    private static Disc getDiscFromLaptop(LaptopGuiDto laptop) {
            Disc disc = new Disc();
            disc.setStorage(laptop.getDiskCapacity());
            disc.setType(laptop.getDiskType());
            return disc;

    }
}
