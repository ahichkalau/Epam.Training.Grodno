package com.epam.io;
/*Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории, например "D:/movies".
Записать в текстовый файл структуру папок и файлов в виде, похожем на выполнение программы tree /F. Пример:

Amon Amarth
    |-----2004 - Fate Of Norns
    |       01 - An Ancient Sign Of Coming Storm.mp3
    |       02 - Where Death Seems To Dwell.mp3
    |       03 - The Fate Of Norns.mp3
    |       04 - The Pursuit Of Vikings.mp3
    |       05 - Valkyries Ride.mp3
    |       06 - The Beheading Of A King.mp3
    |       07 - Arson.mp3
    |       08 - Once Sealed In Blood.mp3
    |
    |-----2016 - Jomsviking
    |       01 First Kill.mp3
    |       02 Wanderer.mp3
    |       03 On A Sea Of Blood.mp3
    |       04 One Against All.mp3
    |       05 Raise Your Horns.mp3
    |       06 The Way Of Vikings.mp3
    |       07 At Dawn’s First Light.mp3
    |       08 One Thousand Burning Arrows.mp3
    |       09 Vengeance Is My Name.mp3
    |       10 A Dream That Cannot Be (feat. Doro Pesch).mp3
    |       11 Back On Northern Shores.mp3
    |       12 Death In Fire 2016.mp3
    |       13 Death In Fire (Live).mp3
    |
    |-----2019 - Berserker
            01 Fafner's Gold.mp3
            02 Crack the Sky.mp3
            03 Mjölner, Hammer of Thor.mp3
            04 Shield Wall.mp3
            05 Valkyria.mp3
            06 Raven's Flight.mp3
            07 Ironside.mp3
            08 The Berserker at Stamford Bridge.mp3
            09 When Once Again We Can Set Our Sails.mp3
            10 Skoll and Hati.mp3
            11 Wings of Eagles.mp3
            12 Into the Dark.mp3


Если в качестве параметра в программу передается не путь к директории, а путь к txt файлу по образцу выше -
прочитать файл и вывести в консоль следующие данные:

Количество папок
Количество файлов
Среднее количество файлов в папке
Среднюю длинну названия файла*/

import java.io.*;
import java.util.Scanner;

public class MainTaskIO {
    public String str = "";
    int count = 1;



    public static void main(String[] args) {
        MainTaskIO mainTaskIO = new MainTaskIO();
        mainTaskIO.getTreeDirectory("D:\\Music");
        mainTaskIO.getTreeDirectoryWithIncludedFolders("D:\\Music");
        mainTaskIO.getTreeDirectoryWithIncludedFolders("src\\resources\\tr.txt");
    }

    public void getTreeDirectory(String directoryPath) {
        File fileDirectory = new File(directoryPath);
        String[] strings = fileDirectory.list();

        if (fileDirectory.isDirectory()) {
            try {
                FileWriter fileWriter = new FileWriter("src\\resources\\tree.txt");
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWriter));
                printWriter.println(fileDirectory.getName());

                for (String str : strings) {
                    File currentFile = new File(directoryPath + "\\" + str);

                    if (currentFile.isDirectory()) {
                        File directoryFile = new File(directoryPath + "\\" + str);
                        printWriter.write(" |------------------------------" + directoryFile.getName() +
                                "---------------------------" + "\n");
                        for (int i = 0; i < directoryFile.list().length; i++) {
                            printWriter.println(" |---" + directoryFile.list()[i]);
                        }
                        printWriter.write(" |" + "\n");
                    }
                }

                for (String str : strings) {
                    File currentFile = new File(directoryPath + "\\" + str);
                if (currentFile.isFile()) {
                    printWriter.println(" |-" + currentFile.getName());
                }
                }
                printWriter.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getTreeDirectoryWithIncludedFolders(String directoryPath){
        File fileDirectory = new File(directoryPath);
        if (fileDirectory.isDirectory()) {
            String border = "--";
            String[] strings = fileDirectory.list();
            for (int i = 0; i < strings.length; i++) {
                File file = new File(directoryPath + "\\" + strings[i]);
                if (file.isDirectory()) {
                    str = str.concat("|" + border.repeat(count * 5) + file.getName() + border.repeat(count * 5) + "\n");
                    ++count;
                    getTreeDirectoryWithIncludedFolders(directoryPath + "\\" + strings[i]);
                }
                if (file.isFile()) {
                    int fileCount = count + 1;
                    str = str.concat(" ".repeat(fileCount) + strings[i] + "\n");
                }
            }
            count = 1;
            try {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("src\\resources\\tr.txt")));
                printWriter.write(fileDirectory.getName() + "\n" + str);
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (fileDirectory.isFile()){
            try {
                FileReader fileReader = new FileReader(directoryPath);
                Scanner fileScanner = new Scanner(fileReader);
                int directoryCount = 0;
                int averageFileLength = 0;
                int fileCount = 0;
                while (fileScanner.hasNext()){
                    String textLine = fileScanner.nextLine();
                    if (textLine.startsWith("|-")){
                        directoryCount++;
                    } else if (textLine.startsWith(" ")){
                        averageFileLength += textLine.replace(" ", "").length();
                        fileCount++;
                    }
                }
                System.out.println("Количество папок " + directoryCount + "\n" +
                        "Количество файлов " + fileCount + "\n" +
                        "Среднее количество файлов в папке " + (double)fileCount/directoryCount + "\n" +
                        "Средняя длина названия файла " + (double)averageFileLength/fileCount);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}


