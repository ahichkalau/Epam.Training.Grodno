package com.epam.io;

import java.io.*;
import java.util.Scanner;

public class MainTaskIO {
    public StringBuffer fileCatalog = new StringBuffer();
    int count = 1;
    int directoryCount = 0;



    public static void main(String[] args) {
        MainTaskIO mainTaskIO = new MainTaskIO();
        mainTaskIO.getTreeDirectory("D:\\Music");
        mainTaskIO.getTreeDirectoryWithIncludedFolders("D:\\Games");
        mainTaskIO.getTreeDirectoryWithIncludedFolders("resources\\ResultIOMain.txt");
    }

    public void getTreeDirectory(String directoryPath) {
        File fileDirectory = new File(directoryPath);
        String[] strings = fileDirectory.list();

        if (fileDirectory.isDirectory()) {
            try {
                FileWriter fileWriter = new FileWriter("resources\\tree.txt");
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
            String[] fileDirectoryList = fileDirectory.list();
            for (int i = 0; i < fileDirectoryList.length; i++) {
                File checkedFile = new File(directoryPath + "\\" + fileDirectoryList[i]);
                if (checkedFile.isDirectory()) {
                    count++;
                    directoryCount = count;
                    fileCatalog = fileCatalog.append("|" + border.repeat(directoryCount * 5)
                            + checkedFile.getName() + border.repeat(directoryCount * 5) + "\n");
                    getTreeDirectoryWithIncludedFolders(directoryPath + "\\" + fileDirectoryList[i]);
                    count--;
                }
                if (checkedFile.isFile()) {
                    fileCatalog = fileCatalog.append("  ".repeat(directoryCount * 5) + fileDirectoryList[i] + "\n");
                }
            }

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources\\ResultIOMain.txt"));
                bufferedWriter.write(fileDirectory.getName() + "\n" + fileCatalog);
                bufferedWriter.close();
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
                fileReader.close();
                System.out.println("Количество папок " + directoryCount + "\n" +
                        "Количество файлов " + fileCount + "\n" +
                        "Среднее количество файлов в папке " + (double)fileCount/directoryCount + "\n" +
                        "Средняя длина названия файла " + (double)averageFileLength/fileCount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


