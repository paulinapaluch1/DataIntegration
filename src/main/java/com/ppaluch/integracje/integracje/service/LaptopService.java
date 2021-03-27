package com.ppaluch.integracje.integracje.service;

import com.ppaluch.integracje.integracje.csv.CSVReader;
import com.ppaluch.integracje.integracje.dto.Laptop;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class LaptopService {

    @Autowired
    CSVReader csvReader;

    public List<Laptop> getAllLaptops() {
        return csvReader.readLaptops();
    }

    public void saveLaptops(List<Laptop> laptops){
        csvReader.saveLaptops(laptops);
    }

    public List<Laptop> getAllLaptopsFromXml() {
        return csvReader.readLaptops();
    }
}
