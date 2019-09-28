package com.epam.io;

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


