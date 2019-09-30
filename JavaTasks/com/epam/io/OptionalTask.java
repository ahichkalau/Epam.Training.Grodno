package com.epam.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class OptionalTask {

    public static void main(String[] args) {
        OptionalTask optionalTask = new OptionalTask();
        optionalTask.createFileWithRandomNumbers(30);
        optionalTask.readJavaFileAndWriteInReverseTextInOtherFile("TESTTT.java");
    }

    public void createFileWithRandomNumbers(int numberOfRandomNumber){
        File myDir = new File("resources\\io");
        File file = new File("resources\\io\\fileWithRandomNumbers.txt");
        Random randomNumber = new Random();
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < numberOfRandomNumber; i++) {
                arrayList.add(randomNumber.nextInt(1000));
            }
            Collections.sort(arrayList);
            for (Integer count:arrayList) {
                printWriter.write(count + "\n");
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readJavaFileAndWriteInReverseTextInOtherFile(String javaFileName){

        try {
            FileReader fileReader = new FileReader("resources\\io\\" + javaFileName);
            File reverseFile = new File("resources\\io\\reverse" + javaFileName);
            Scanner fileScanner = new Scanner(fileReader);
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(reverseFile)));

            while (fileScanner.hasNext()){
                String originalString = fileScanner.nextLine();
                String reverseString = new String();
                for (int i = originalString.length() - 1; i >= 0; i--) {
                    reverseString += originalString.toCharArray()[i];
                }
                printWriter.write(reverseString + "\n");
            }
            printWriter.close();
            fileScanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
