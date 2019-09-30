package com.epam.collections;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CollectionsOT {

    public static void main(String[] args) throws Exception {
        reverseTextInFile("resources/ExampleOT1.txt");
        sortTextInFile("resources/ExampleSort.txt");
    }

    public static void reverseTextInFile(String fileName) throws Exception{
        ArrayList<String> arrayList = readTextWithFile(fileName);
        writeTextInFile(fileName, arrayList);
    }

    public static void sortTextInFile(String fileName) throws Exception {
        ArrayList<String> arrayList = readTextWithFile(fileName);
        Collections.sort(arrayList, new LineComparator());
        writeTextInFile(fileName, arrayList);
    }

    static class LineComparator implements Comparator<String>{
        public int compare(String firstLine, String secondLine) {
        if (firstLine.length() < secondLine.length() ){
            return 1;}
        else if (firstLine.length()<secondLine.length()){
            return -1;
        } else return 0;
        }
    }

    private static ArrayList<String>  readTextWithFile (String fileName){
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner textScan = new Scanner(fileReader);
            while (textScan.hasNext()){
                arrayList.add(textScan.nextLine());
            }
            System.out.println("Текст из файла "  + fileName +" прочитан");
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private static void writeTextInFile(String fileName, ArrayList<String> arrayList){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                fileWriter.write(arrayList.get(i) + "\n");
            }
            System.out.println("Текст записан в файл "  + fileName);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
