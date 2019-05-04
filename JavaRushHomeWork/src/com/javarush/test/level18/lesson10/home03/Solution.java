package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();
        FileOutputStream fos = new FileOutputStream(file1,true);
        FileInputStream fis = new FileInputStream(file2);
        while (fis.available()>0){
            fos.write(fis.read());
        }
        FileInputStream fis2 = new FileInputStream(file3);
        while (fis2.available()>0){
            fos.write(fis2.read());
        }
        fis.close();
        fis2.close();
        fos.close();
    }
}
