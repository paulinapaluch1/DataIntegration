package com.ppaluch.integracje.integracje.service;

import com.ppaluch.integracje.integracje.csv.CSVReader;
import com.ppaluch.integracje.integracje.dao.LaptopRepository;
import com.ppaluch.integracje.integracje.dto.LaptopGuiDto;
import com.ppaluch.integracje.integracje.entity.Laptop;
import com.ppaluch.integracje.integracje.xml.XmlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import static com.ppaluch.integracje.integracje.controller.LaptopController.laptopList;
import static com.ppaluch.integracje.integracje.converter.ToLaptopEntityConverter.from;

@Service
public class LaptopService {

    private static final String STATUS_DUPLICATED = "duplicated";
    private static final String STATUS_NEW = "new";
    public static final String STATUS_EDITED = "edited";

    @Autowired
    private CSVReader csvReader;
    @Autowired
    private XmlHelper xmlHelper;
    @Autowired
    private LaptopRepository laptopRepository;

    public List<LaptopGuiDto> getAllLaptops() {
        List<LaptopGuiDto> laptops = csvReader.readLaptops();
        setStatuses(laptops);
        return laptops;
    }

    public void saveLaptops(List<LaptopGuiDto> laptops){
        csvReader.saveLaptops(laptops);
    }

    public List<LaptopGuiDto> getAllLaptopsFromXml(String path) {
        List<LaptopGuiDto> laptops =  xmlHelper.readLaptops(path);
        setStatuses(laptops);
        return laptops;
    }

    public void saveLaptopsToXml(List<LaptopGuiDto> laptopList, String filepath) {
       xmlHelper.saveLaptops(laptopList,filepath);
    }

    public void updateLaptopsInDatabase(List<LaptopGuiDto> laptopList) {
        for(LaptopGuiDto dto : laptopList){
           Laptop laptop = from(dto);
           if(!isDuplicate(laptop)) {
               laptopRepository.save(laptop);
           }
       }
    }

    private boolean isDuplicate(Laptop laptop) {
        List<Laptop> laptops = laptopRepository.findAll();
        Laptop duplicateLaptop = laptops.stream()
                .filter(d->ObjectUtils.nullSafeEquals(d.getClockSpeed(), laptop.getClockSpeed())
                && ObjectUtils.nullSafeEquals(d.getDiskCapacity(), laptop.getDiskCapacity())
                && ObjectUtils.nullSafeEquals(d.getGraphics(), laptop.getGraphics())
                && ObjectUtils.nullSafeEquals(d.getDiskType(), laptop.getDiskType())
                && ObjectUtils.nullSafeEquals(d.getIsScreenTouch(), laptop.getIsScreenTouch())
                && ObjectUtils.nullSafeEquals(d.getMemoryGPU(), laptop.getMemoryGPU())
                && ObjectUtils.nullSafeEquals(d.getOperatingSystem(), laptop.getOperatingSystem())
                && ObjectUtils.nullSafeEquals(d.getProcessorName(), laptop.getProcessorName())
                && ObjectUtils.nullSafeEquals(d.getPhysicalDriveType(), laptop.getPhysicalDriveType())
                && ObjectUtils.nullSafeEquals(d.getProducerName(), laptop.getProducerName())
                && ObjectUtils.nullSafeEquals(d.getScreenSurfaceType(), laptop.getScreenSurfaceType())
                && ObjectUtils.nullSafeEquals(d.getScreenSize(), laptop.getScreenSize())
                && ObjectUtils.nullSafeEquals(d.getScreenDiagonal(), laptop.getScreenDiagonal())
                && ObjectUtils.nullSafeEquals(d.getPhysicalCoresNumber(), laptop.getPhysicalCoresNumber())
                && ObjectUtils.nullSafeEquals(d.getRAM(), laptop.getRAM())
                )
                .findFirst().orElse(null);
        return duplicateLaptop != null;
    }


    public List<LaptopGuiDto> getAllLaptopsFromDatabase() {
       List<Laptop> laptops = laptopRepository.findAll();
       List<LaptopGuiDto> laptopsGui = new ArrayList<>();

       for(int i = 0 ; i < laptops.size() ; i++){
           LaptopGuiDto laptopGuiDto = from(laptops.get(i));
           laptopGuiDto.setLaptopIndex(i+1);
           laptopsGui.add(laptopGuiDto);
       }
        setStatuses(laptopsGui);
       return laptopsGui;
    }

    public int countNewLaptops(List<LaptopGuiDto> laptopList) {
        int readLaptops = 0;
        for(LaptopGuiDto dto : laptopList){
            Laptop laptop = from(dto);
            if(!isDuplicate(laptop)) {
                readLaptops++;
            }
        }
        return readLaptops;
    }

    public int countDuplicateLaptops(List<LaptopGuiDto> list) {
        int duplicateLaptops = 0;
        for(LaptopGuiDto dto : laptopList){
            Laptop laptop = from(dto);
            if(isDuplicate(laptop)) {
                duplicateLaptops++;
            }
        }
        return duplicateLaptops;
    }

    private void setStatuses(List<LaptopGuiDto> laptops) {
        for(LaptopGuiDto dto : laptops){
            if(isDuplicate(from(dto))){
                dto.setStatus(STATUS_DUPLICATED);
            }else{
                dto.setStatus(STATUS_NEW);
            }
        }
    }

}
