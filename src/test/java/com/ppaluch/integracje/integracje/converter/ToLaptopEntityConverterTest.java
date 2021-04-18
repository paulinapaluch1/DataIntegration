package com.ppaluch.integracje.integracje.converter;

import com.ppaluch.integracje.integracje.dto.LaptopGuiDto;
import com.ppaluch.integracje.integracje.entity.Laptop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ToLaptopEntityConverterTest {

    ToLaptopEntityConverter converter;

    @BeforeAll
    public  void setUp(){
        converter = new ToLaptopEntityConverter();
    }

    @Test
    public void shouldConvertLaptopToLaptopGuiDto(){
       Laptop laptop = prepareLaptopForTests();

       LaptopGuiDto dto = converter.from(laptop);

       assertNotNull(dto);
       assertEquals(laptop.getId(), dto.getId());
       assertEquals(laptop.getClockSpeed(), dto.getClockSpeed());
       assertEquals(laptop.getDiskCapacity(), dto.getDiskCapacity());
       assertEquals(laptop.getDiskType(), dto.getDiskType());
       assertEquals(laptop.getLaptopIndex(), dto.getLaptopIndex());

    }



    private Laptop prepareLaptopForTests(){
        Laptop laptop = new Laptop();
        laptop.setId(1);
        laptop.setClockSpeed(1900);
        laptop.setDiskCapacity("240GB");
        laptop.setDiskType("SSD");
        laptop.setGraphics("intel HD 4000");
        laptop.setIsScreenTouch("tak");
        laptop.setLaptopIndex(1);
        laptop.setMemoryGPU("1GB");
        laptop.setPhysicalCoresNumber(8);
        laptop.setPhysicalDriveType("Blue Ray");
        laptop.setScreenSurfaceType("matowa");
        laptop.setScreenDiagonal("14");
        return laptop;
    }

    @Test
    public void shouldConvertLaptopGuiDtoToLaptop(){
        LaptopGuiDto laptop = prepareLaptopGuiDtoForTests();

        Laptop dto = converter.from(laptop);

        assertNotNull(dto);
        assertEquals(laptop.getId(), dto.getId());
        assertEquals(laptop.getClockSpeed(), dto.getClockSpeed());
        assertEquals(laptop.getDiskCapacity(), dto.getDiskCapacity());
        assertEquals(laptop.getDiskType(), dto.getDiskType());
        assertEquals(laptop.getLaptopIndex(), dto.getLaptopIndex());

    }



    private LaptopGuiDto prepareLaptopGuiDtoForTests(){
        LaptopGuiDto laptop = new LaptopGuiDto();
        laptop.setId(1);
        laptop.setClockSpeed(1900);
        laptop.setDiskCapacity("240GB");
        laptop.setDiskType("SSD");
        laptop.setGraphics("intel HD 4000");
        laptop.setIsScreenTouch("tak");
        laptop.setLaptopIndex(1);
        laptop.setMemoryGPU("1GB");
        laptop.setPhysicalCoresNumber(8);
        laptop.setPhysicalDriveType("Blue Ray");
        laptop.setScreenSurfaceType("matowa");
        laptop.setScreenDiagonal("14");
        return laptop;
    }



}