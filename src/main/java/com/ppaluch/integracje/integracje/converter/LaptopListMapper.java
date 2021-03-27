package com.ppaluch.integracje.integracje.converter;

import com.ppaluch.integracje.integracje.dto.Laptop;
import com.ppaluch.integracje.integracje.dto.LaptopXml;
import com.ppaluch.integracje.integracje.dto.Laptops;

import java.util.ArrayList;
import java.util.List;

public class LaptopListMapper {


    public static List<Laptop> from(Laptops laptops){
        List<Laptop> list = new ArrayList<>();
        int i = 1;
        for(LaptopXml laptopXml : laptops.getLaptopList()){
            Laptop laptop = new Laptop();
            laptop.setIndex(i);
            laptop.setProducerName(laptopXml.getManufacturer());
            laptop.setScreenDiagonal(laptopXml.getScreen().getSize());
            laptop.setScreenSize(laptopXml.getScreen().getResolution());
            laptop.setScreenSurfaceType(laptopXml.getScreen().getType());
            laptop.setIsScreenTouch(laptopXml.getScreen().getTouch());
            laptop.setProcessorName(laptopXml.getProcessor().getName());
            laptop.setPhysicalCoresNumber(laptopXml.getProcessor().getPhysicalCores());
            laptop.setClockSpeed(laptopXml.getProcessor().getClockSpeed());
            laptop.setRAM(laptop.getRAM());
            laptop.setDiskCapacity(laptopXml.getDisc().getStorage());
            laptop.setDiskType(laptopXml.getDisc().getType());
            laptop.setGraphics(laptopXml.getGraphicCard().getName());
            laptop.setMemoryGPU(laptopXml.getGraphicCard().getMemory());
            laptop.setOperatingSystem(laptopXml.getOperatingSystem());
            laptop.setPhysicalDriveType(laptopXml.getDiscReader());
            list.add(laptop);
            i++;
        }
            return list;
    }







}
