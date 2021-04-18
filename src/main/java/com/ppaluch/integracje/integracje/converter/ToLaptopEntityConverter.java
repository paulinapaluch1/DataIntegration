package com.ppaluch.integracje.integracje.converter;

import com.ppaluch.integracje.integracje.dto.LaptopGuiDto;
import com.ppaluch.integracje.integracje.entity.Laptop;

public class ToLaptopEntityConverter {

    public static Laptop from(LaptopGuiDto laptopGuiDto) {
        Laptop laptop = new Laptop();
        laptop.setId(laptopGuiDto.getId());
        laptop.setLaptopIndex(laptopGuiDto.getLaptopIndex());
        laptop.setProducerName(laptopGuiDto.getProducerName());
        laptop.setScreenDiagonal(laptopGuiDto.getScreenDiagonal());
        laptop.setScreenSize(laptopGuiDto.getScreenSize());
        laptop.setScreenSurfaceType(laptopGuiDto.getScreenSurfaceType());
        laptop.setIsScreenTouch(laptopGuiDto.getIsScreenTouch());
        laptop.setProcessorName(laptopGuiDto.getProcessorName());
        laptop.setPhysicalCoresNumber(laptopGuiDto.getPhysicalCoresNumber());
        laptop.setClockSpeed(laptopGuiDto.getClockSpeed());
        laptop.setRAM(laptopGuiDto.getRAM());
        laptop.setDiskCapacity(laptopGuiDto.getDiskCapacity());
        laptop.setDiskType(laptopGuiDto.getDiskType());
        laptop.setGraphics(laptopGuiDto.getGraphics());
        laptop.setMemoryGPU(laptopGuiDto.getMemoryGPU());
        laptop.setOperatingSystem(laptopGuiDto.getOperatingSystem());
        laptop.setPhysicalDriveType(laptopGuiDto.getPhysicalDriveType());
        return laptop;
    }

    public static LaptopGuiDto from(Laptop laptop) {
        LaptopGuiDto laptopGuiDto = new LaptopGuiDto();
        laptopGuiDto.setId(laptop.getId());
        laptopGuiDto.setLaptopIndex(laptop.getLaptopIndex());
        laptopGuiDto.setProducerName(laptop.getProducerName());
        laptopGuiDto.setScreenDiagonal(laptop.getScreenDiagonal());
        laptopGuiDto.setScreenSize(laptop.getScreenSize());
        laptopGuiDto.setScreenSurfaceType(laptop.getScreenSurfaceType());
        laptopGuiDto.setIsScreenTouch(laptop.getIsScreenTouch());
        laptopGuiDto.setProcessorName(laptop.getProcessorName());
        laptopGuiDto.setPhysicalCoresNumber(laptop.getPhysicalCoresNumber());
        laptopGuiDto.setClockSpeed(laptop.getClockSpeed());
        laptopGuiDto.setRAM(laptop.getRAM());
        laptopGuiDto.setDiskCapacity(laptop.getDiskCapacity());
        laptopGuiDto.setDiskType(laptop.getDiskType());
        laptopGuiDto.setGraphics(laptop.getGraphics());
        laptopGuiDto.setMemoryGPU(laptop.getMemoryGPU());
        laptopGuiDto.setOperatingSystem(laptop.getOperatingSystem());
        laptopGuiDto.setPhysicalDriveType(laptop.getPhysicalDriveType());
        return laptopGuiDto;
    }


}
