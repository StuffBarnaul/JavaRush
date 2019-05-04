package SoupGame;

import java.io.*;
import java.util.Collections;

public class Find {
    private static String stringToFind = "Капуста свежая";

    public static void main(String[] args) {
        File fileRoot = new File(".\\src\\Resources");
        readDB(fileRoot);
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
                if (strLine.contains(stringToFind)) System.out.println(file);
            }
            br.close();
            fstream.close();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла"+file.getName());
        }
    }
}
