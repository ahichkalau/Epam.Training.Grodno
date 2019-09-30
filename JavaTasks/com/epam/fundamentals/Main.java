package com.epam.fundamentals;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        welcomeUserName();
        outputArgumentsOfComandLineInReverse(args);
        inputNumbersAndCalculateSumm();
        printRandomNumbers();
        getMonthName();
    }


    public static void welcomeUserName(){
        System.out.println("Please, input user name");
        String userName = new Scanner(System.in).nextLine();
        System.out.println("Hello, " + userName + "\n");
    }

    public static void outputArgumentsOfComandLineInReverse(String ... args){
        if (args.length > 0){
            System.out.println(new StringBuffer().append(args[0]).reverse() + "\n");
        }
        else {
            System.out.println("Please, input program arguments \n" );
        }
    }

    public static void printRandomNumbers(){
        System.out.println("Enter the number of random digits");
        int numberOfRandomDigits = new Scanner(System.in).nextInt();
        System.out.println("Outputting numbers on one line (enter the number 1) " +
                "or output with switching to a new line (enter the number 2)");
        int outputNumber = new Scanner(System.in).nextInt();
        switch (outputNumber){
            case 1:for (int i = 0; i < numberOfRandomDigits; i++) {
                int randomDigits = new Random().nextInt(1000);
                System.out.print(randomDigits + " ");
            }
                System.out.println();
                break;
            case 2:for (int i = 0; i < numberOfRandomDigits; i++) {
                int randomDigits = new Random().nextInt(1000);
                System.out.println(randomDigits);
            }
                break;
            default:
                System.out.println("Invalid input");
                printRandomNumbers();
                break;
        }
    }

    public static void inputNumbersAndCalculateSumm(){
        System.out.println("Input quantity of numbers");
        int quantityOfNumbers = new Scanner(System.in).nextInt();
        int summ = 0;
        for (int i = 0; i < quantityOfNumbers; i++) {
            summ += new Scanner(System.in).nextInt();
        }
        System.out.println("Summ of numbers - " + summ);
    }

    public static void inputNumbersAndCalculateMultiply(){
        System.out.println("Input quantity of numbers");
        int quantityOfNumbers = new Scanner(System.in).nextInt();
        int summ = 0;
        for (int i = 0; i < quantityOfNumbers; i++) {
            summ *= new Scanner(System.in).nextInt();
        }
        System.out.println("Summ of numbers - " + summ);
    }

    public static void getMonthName(){
        System.out.println("Input month number");
        int monthNumber = new Scanner(System.in).nextInt();
        String monthName;
        switch (monthNumber){
            case 1 : monthName = "January";
                break;
            case 2 : monthName = "February";
                break;
            case 3 : monthName = "March";
                break;
            case 4 : monthName = "April";
                break;
            case 5 : monthName = "May";
                break;
            case 6 : monthName = "June";
                break;
            case 7 : monthName = "July";
                break;
            case 8 : monthName = "August";
                break;
            case 9 : monthName = "September";
                break;
            case 10 : monthName = "October";
                break;
            case 11 : monthName = "November";
                break;
            case 12 : monthName = "December";
                break;
            default: monthName = "invalid input";
                getMonthName();
                break;
        }
        System.out.println(monthName);
    }



}
