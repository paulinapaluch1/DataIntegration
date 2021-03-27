package com.ppaluch.integracje.integracje.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CSVConsolePrinter {

        private static final int COLUMN_SIZE = 25;
        private static final int LP_COLUMN_SIZE = 3;
        private static final String FILE_RELATIVE_PATH = "./katalog.txt";
        private static final String CSV_SEPARATOR = ";";
        private static final String COLUMN_SEPARATOR = " | ";
        private static final String LP_HEADER = "LP.";

        private static int amountDell = 0;
        private static int amountAsus = 0;
        private static int amountFujitsu = 0;
        private static int amountSamsung = 0;
        private static int amountHuawei = 0;
        private static int amountMSI = 0;
        private static int amountSony = 0;


        public static void main(String[] args){
            String line;

            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_RELATIVE_PATH));
                String[] headerArray = createHeaderArray();
                printHeader(headerArray);
                int i = 1;
                while((line = bufferedReader.readLine()) != null){
                    String[] values = line.split(CSV_SEPARATOR);
                    System.out.print(COLUMN_SEPARATOR + i + fillColumn(LP_COLUMN_SIZE - String.valueOf(i).length()));

                    for(String value : values){
                        String row = COLUMN_SEPARATOR + value + fillColumn(COLUMN_SIZE - value.length());
                        System.out.print(row);
                        countProducerAmount(row);
                    }
                    System.out.println(COLUMN_SEPARATOR);
                    i++;
                }
                printRowLine();
                printLaptopProducerAmount();

            } catch (FileNotFoundException e) {
                System.out.println("Nie znaleziono pliku");
            } catch (IOException e) {
                System.out.println("Wystąpił problem. Skontaktuj się z administratorem");
            }
        }

        private static void printLaptopProducerAmount() {
            System.out.println("Liczba laptopów producenta Dell wynosi: " + amountDell);
            System.out.println("Liczba laptopów producenta Sony wynosi: " + amountSony);
            System.out.println("Liczba laptopów producenta Samsung wynosi: " + amountSamsung);
            System.out.println("Liczba laptopów producenta MSI wynosi: " + amountMSI);
            System.out.println("Liczba laptopów producenta Fujitsu wynosi: " + amountFujitsu);
            System.out.println("Liczba laptopów producenta Huawei wynosi: " + amountHuawei);
            System.out.println("Liczba laptopów producenta Asus wynosi: " + amountAsus);
        }

        private static void countProducerAmount(String row) {
            Scanner scanner = new Scanner(row.toLowerCase());
            if (scanner.findInLine("dell") != null) {
                amountDell++;
            } else if (scanner.findInLine("asus") != null) {
                amountAsus++;
            } else if (scanner.findInLine("fujitsu") != null) {
                amountFujitsu++;
            } else if (scanner.findInLine("huawei") != null) {
                amountHuawei++;
            } else if (scanner.findInLine("msi") != null) {
                amountMSI++;
            } else if (scanner.findInLine("samsung") != null) {
                amountSamsung++;
            } else if (scanner.findInLine("sony") != null) {
                amountSony++;
            }
        }

        private static String[] createHeaderArray() {
            String[] headerArray = new String[] { "PRODUCENT", "PRZEKĄTNA","ROZMIAR EKRANU", "RODZAJ POWIERZCHNI",
                    "CZY EKRAN DOTYKOWY", "PROCESOR", "LICZBA RDZENI", "PRĘDKOŚĆ TAKTOWANIA MHz", "RAM", "POJEMNOŚĆ DYSKU",
                    "RODZAJ DYSKU", "UKŁAD GRAFICZNY","PAMIĘĆ UKŁ. GRAFICZNEGO", "SYSTEMOPERACYJNY","RODZAJ NAPĘDU FIZ." };

            return headerArray;
        }

        private static void printHeader(String[] headerArray) {
            printRowLine();
            System.out.print(COLUMN_SEPARATOR + LP_HEADER + fillColumn(LP_COLUMN_SIZE - LP_HEADER.length()));
            for(String column : headerArray){
                int difference = COLUMN_SIZE - column.length();
                System.out.print(COLUMN_SEPARATOR + column + fillColumn(difference));
            }
            System.out.println(COLUMN_SEPARATOR);
            printRowLine();

        }

        private static String fillColumn(int difference) {
            String text = "";
            StringBuilder builder = new StringBuilder(text);
            for(int i = 0; i < difference; i++){
                builder.append(" ");
            }
            return builder.toString();
        }

        private static void printRowLine(){
            System.out.println("-------------------------------------------------------------------------------------" +
                    "------------------------------------------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------------------------------" +
                    "--------------------------------------------------------------------------------------------------------" +
                    "------------------------------------");
        }
    }

