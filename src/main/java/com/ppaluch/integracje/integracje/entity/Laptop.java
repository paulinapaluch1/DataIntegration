package com.ppaluch.integracje.integracje.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int laptopIndex;
    private String producerName;
    private String screenDiagonal;
    private String screenSize;
    private String screenSurfaceType;
    private String isScreenTouch;
    private String processorName;
    private Integer physicalCoresNumber;
    private Integer clockSpeed;
    private String RAM;
    private String diskCapacity;
    private String diskType;
    private String graphics;
    private String memoryGPU;
    private String operatingSystem;
    private String physicalDriveType;


}
