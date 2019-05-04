package com.javarush.test.level22.lesson13.task02;

import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("2"));
        byte[] str = fileReader.readLine().getBytes("Windows-1251");
        fileReader.close();
        String s = new String(str,"UTF-8");
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("3"));
        fileWriter.write(s);
        fileWriter.close();
    }
}
