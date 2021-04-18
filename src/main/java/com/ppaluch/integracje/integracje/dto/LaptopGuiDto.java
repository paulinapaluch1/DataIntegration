package com.ppaluch.integracje.integracje.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data

public class LaptopGuiDto {

    private int id;

    private int laptopIndex;
    @NotNull
    @Pattern(regexp = "^[A-ZŁŚ]{1}+[a-ząęółśżźćń]+$", message="Wprowadz poprawną nazwe producenta")
    private String producerName;

    @Pattern(regexp = "^[0-9]+\"{1}+$", message="Wprowadz przekątną np. 12\"")
    private String screenDiagonal;

    @Pattern(regexp = "^[0-9]+[x]{1}+[0-9]+$", message="Wprowadz rozmiar ekranu w formacie np. 1900x1800")
    private String screenSize;

    @Pattern(regexp = "^[a-ząęółśżźćń]+$", message="Wprowadz poprawny typ powierzchni np. matowa")
    private String screenSurfaceType;

    @Pattern(regexp = "^(?:tak|nie|yes|no)$", message="Wprowadź tak lub nie")
    private String isScreenTouch;
    @Pattern(regexp = "^[A-z0-9À-ž\\s]+$", message= "Wprowadź poprawną nazwe procesora")
    private String processorName;

    @NotNull
    private Integer physicalCoresNumber;

    @NotNull
    private Integer clockSpeed;
    @NotNull
    @Pattern(regexp = "^[0-9]+GB{1}+$", message= "Wprowadz poprawną ilość pamieci RAM np. 16GB")
    private String RAM;
    @NotNull
    private String diskCapacity;
    @NotNull
    @Pattern(regexp = "^[A-ZŁŚ]+$", message= "Wprowadź poprawny typ dysku")
    private String diskType;
    @NotNull
    @Pattern(regexp = "^[A-z0-9À-ž\\s]+$", message= "Wprowadź poprawny układ graficzny")
    private String graphics;
    @NotNull
    private String memoryGPU;
    @NotNull
    @Pattern(regexp = "^[A-z0-9À-ž\\s]+$", message= "Wprowadź poprawny system operacyjny")
    private String operatingSystem;
    @NotNull
    @Pattern(regexp = "^[A-z0-9À-ž\\s]+$", message= "Wprowadź poprawny rodzaj napedu fizycznego")
    private String physicalDriveType;
    private String status;


}
