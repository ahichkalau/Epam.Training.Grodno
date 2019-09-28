package com.epam.collections;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*1.+Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
3.   Создать список из элементов каталога и его подкаталогов.
4.  +Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
5. Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец,
а положительные — в начало списка.
6.  +Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из
класса Collections.
7. Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}». Проверить правильность расстановки скобок.
Использовать стек.
8. Задан файл с текстом на английском языке. Выделить все различные слова. Слова, отличающиеся только регистром букв,
считать одинаковыми. Использовать класс HashSet.*/

public class CollectionsOT {

    public static void main(String[] args) throws Exception {
        reverseTextInFile("src/resources/ExampleOT1.txt");
        sortTextInFile("src/resources/ExampleSort.txt");

    }

    public static void reverseTextInFile(String fileName) throws Exception{
        ArrayList<String> arrayList = readTextWithFile(fileName);
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                fileWriter.write(arrayList.get(i) + "\n");
            }
            fileWriter.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void sortTextInFile(String fileName) throws Exception {
        ArrayList<String> arrayList = readTextWithFile(fileName);
        try {
            Collections.sort(arrayList, new LineComparator());
            FileWriter fileWriter = new FileWriter(fileName);
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                fileWriter.write(arrayList.get(i) + "\n");
            }
            fileWriter.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
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
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
