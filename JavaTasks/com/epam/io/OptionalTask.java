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

    public void createFileWithRandomNumbers(int quantityOfRandomNumbers){
        File createdFile = new File("resources\\io\\fileWithRandomNumbers.txt");
        Random randomNumber = new Random();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(createdFile));
            ArrayList<Integer> listOfRandomNumbers = new ArrayList<>();
            for (int i = 0; i < quantityOfRandomNumbers; i++) {
                listOfRandomNumbers.add(randomNumber.nextInt(1000));
            }
            Collections.sort(listOfRandomNumbers);
            for (Integer count:listOfRandomNumbers) {
                bufferedWriter.write(count + "\n");
            }
            bufferedWriter.close();
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
                StringBuffer reverseString = new StringBuffer(originalString).reverse();
                printWriter.write(reverseString + "\n");
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
