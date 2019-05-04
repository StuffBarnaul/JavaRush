package SoupGame;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class DatabaseCreation {
    private static ArrayList<String> database = new ArrayList<>();

    public static void main(String[] args) {
        File endFile = new File(".\\src\\SoupGame\\Data");
        File fileRoot = new File(".\\src\\Resources");
        readDB(fileRoot);
        Collections.sort(database, (a, b) -> a.compareTo(b));
        for (String list:database){
            try {
                FileWriter fileReader = new FileWriter(endFile); // поток который подключается к текстовому файлу
                BufferedWriter bufferedWriter = new BufferedWriter(fileReader); // соединяем FileWriter с BufferedWitter
                for(String s : database) {
                    bufferedWriter.write(s + "\n");
                }
                bufferedWriter.close(); // закрываем поток
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void readDB(File fileRoot) {
        File[] files = fileRoot.listFiles();
        if (files == null) return;
        for (File file : files) {
            if (file.isDirectory()) {
                readDB(file);
            } else readFile(file);
        }
    }

    private static void readFile(File file){
        try {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] variations;
                variations = strLine.split("#");
                for (String str:variations){
                    if (!database.contains(str))
                        database.add(str);
                }
            }
            br.close();
            fstream.close();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла"+file.getName());
        }
    }

    //private static void add(File file){
}
