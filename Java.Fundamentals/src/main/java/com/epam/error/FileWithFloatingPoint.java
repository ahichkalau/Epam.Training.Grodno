package com.epam.error;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWithFloatingPoint {

//    public void readFile(String fileName) throws ExceptionsForFileFloatingPoint {
//
//        FileReader fileReader = new FileReader(fileName);
//        Scanner scanner = new Scanner(fileReader);
//        ArrayList<String> arrayList = new ArrayList();
//        while (scanner.hasNext()){
//            arrayList.add(scanner.next());
//        }
//            fileReader.close();
//        System.out.println(arrayList);
//        ArrayList<Double> doubleArrayList = new ArrayList<Double>();
//        for (int i = 0; i < arrayList.size() ; i++) {
//            try {
//                Double.parseDouble(arrayList.get(i));
//            } catch (NumberFormatException e){
//                throw new ExceptionsForFileFloatingPoint("NumberFormat");
//
//            }
//            doubleArrayList.add(Double.parseDouble(arrayList.get(i)));
//        }
//        System.out.println(doubleArrayList);
//    }
}
