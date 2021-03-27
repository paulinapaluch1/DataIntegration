package com.ppaluch.integracje.integracje.csv;

import com.ppaluch.integracje.integracje.dto.Laptop;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
    private static final String FILE_RELATIVE_PATH = "./katalog.txt";
    private static final String CSV_SEPARATOR = ";";

   public List<Laptop> readLaptops() {
       String line;
       List<Laptop> laptops = new ArrayList<>();
       try {
           BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_RELATIVE_PATH));
           int i = 1;
           while ((line = bufferedReader.readLine()) != null) {
               String[] values = line.split(CSV_SEPARATOR);
               Laptop laptop = new Laptop();
               laptop.setIndex(i);
               laptop.setProducerName(values[0]);
               laptop.setScreenDiagonal(values[1]);
               laptop.setScreenSize(values[2]);
               laptop.setScreenSurfaceType(values[3]);
               laptop.setIsScreenTouch(values[4]);
               laptop.setProcessorName(values[5]);
               laptop.setPhysicalCoresNumber(values[6].isBlank()? null : Integer.valueOf(values[6]));
               laptop.setClockSpeed(values[7].isBlank()? null : Integer.valueOf(values[7]));
               laptop.setRAM(values[8]);
               laptop.setDiskCapacity(values[9]);
               laptop.setDiskType(values[10]);
               laptop.setGraphics(values[11]);
               laptop.setMemoryGPU(values[12]);
               if(values.length > 13)
                   laptop.setOperatingSystem(values[13]);
               if(values.length > 14)
                   laptop.setPhysicalDriveType(values[14]);
               laptops.add(laptop);
               i++;
           }

       } catch (FileNotFoundException e) {
           System.out.println("Nie znaleziono pliku");
       } catch (IOException e) {
           System.out.println("Wystąpił problem. Skontaktuj się z administratorem");
       }
       return laptops;

   }

   public void saveLaptops(List<Laptop> laptops){
       try(Writer writer = new FileWriter(FILE_RELATIVE_PATH);
           CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.newFormat(';'))
       ) {
           for(Laptop laptop : laptops){
               csvPrinter.printRecord(laptop.getProducerName(),
                       laptop.getScreenDiagonal(),
                       laptop.getScreenSize(),
                       laptop.getScreenSurfaceType(),
                       laptop.getIsScreenTouch(),
                       laptop.getProcessorName(),
                       laptop.getPhysicalCoresNumber(),
                       laptop.getClockSpeed(),
                       laptop.getRAM(),
                       laptop.getDiskCapacity(),
                       laptop.getDiskType(),
                       laptop.getGraphics(),
                       laptop.getMemoryGPU(),
                       laptop.getOperatingSystem(),
                       laptop.getPhysicalDriveType());
               csvPrinter.print("\n");

           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}
