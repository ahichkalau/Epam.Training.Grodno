package com.epam.fundamentals;

import java.util.Scanner;

/*Задание. Ввести n чисел с консоли.
1.     +Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
2.     +Вывести числа в порядке возрастания (убывания) значений их длины.
3.     +Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.*/

public class OptionalTasks {
    public static void main(String[] args) {
        int[] testArray = createArray();
        System.out.println(findTheShortestNumber(testArray));
        System.out.println(findTheLongestNumber(testArray));
        System.out.println(sortByLengthOfNumberFromMinToMax(testArray));
        System.out.println(sortByLengthOfNumberFromMaxToMin(testArray));
        System.out.println(findNumberWithMoreLengthThanAverageInArray(testArray));
    }

    public static int[] createArray(){
        System.out.println("Input the quantity of numbers");
        int quantityOfNumbers = new Scanner(System.in).nextInt();
        System.out.println("Input the numbers");
        int[] arrayOfNumber = new int[quantityOfNumbers];
        for (int i = 0; i < quantityOfNumbers; i++) {
            arrayOfNumber[i] = new Scanner(System.in).nextInt();
        }
        return arrayOfNumber;
    }

    public static String findTheShortestNumber(int[] array){
        int shortNumberLength = String.valueOf(array[0]).length();
        int shortNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (shortNumberLength > String.valueOf(array[i]).length()){
                shortNumberLength = String.valueOf(array[i]).length();
                shortNumber = array[i];
            }
        }
        return "Shortest number length " + shortNumberLength + " Shortest number " + shortNumber + "\n" ;
    }

    public static String findTheLongestNumber(int[] array){
        int longestNumberLength = String.valueOf(array[0]).length();
        int longestNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (longestNumberLength < String.valueOf(array[i]).length()){
                longestNumberLength = String.valueOf(array[i]).length();
                longestNumber = array[i];
            }
        }
        return "Longest number length " + longestNumberLength + "Longest number " + longestNumber+ "\n" ;
    }

    public static String sortByLengthOfNumberFromMinToMax(int[] array){
        for (int i = array.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]){
                    int tempMin = array[j];
                    array[j] = array[j+1];
                    array[j + 1] = tempMin;
                }
            }
        }
        String arraySortByLengthFromMinToMax = new String();
        for (int i = 0; i < array.length; i++) {
            arraySortByLengthFromMinToMax += array[i] + " ";
        }
        return arraySortByLengthFromMinToMax + "\n";
    }

    public static String sortByLengthOfNumberFromMaxToMin(int[] array){
        for (int i = array.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]){
                    int tempMin = array[j];
                    array[j] = array[j+1];
                    array[j + 1] = tempMin;
                }
            }
        }
        String arraySortByLengthFromMaxToMin = new String();
        for (int i = 0; i < array.length; i++) {
            arraySortByLengthFromMaxToMin += array[i] + " ";
        }
        return arraySortByLengthFromMaxToMin + "\n";
    }

    public static String findNumberWithMoreLengthThanAverageInArray(int[] array){
        int summLengthOfNumberinArray = 0;
        for (int i = 0; i < array.length; i++) {
            summLengthOfNumberinArray += String.valueOf(array[i]).length();
        }
        double averageLengthOfNumber = (double) summLengthOfNumberinArray / array.length;
        String numberWithMoreNumberThanAverage = new String();
        for (int i = 0; i < array.length ; i++) {
            if (String.valueOf(array[i]).length() >= averageLengthOfNumber){
                numberWithMoreNumberThanAverage += array[i] + " ";
            }
        }
        return numberWithMoreNumberThanAverage + " Average lenth of numbers " + averageLengthOfNumber;
    }
}
