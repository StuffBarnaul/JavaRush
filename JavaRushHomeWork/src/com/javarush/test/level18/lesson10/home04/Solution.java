package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);
        byte[] buffer1 = new byte[(int)fis1.getChannel().size()];
        byte[] buffer2 = new byte[(int)fis2.getChannel().size()];
        fis1.read(buffer1);
        fis2.read(buffer2);
        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(buffer2);
        fos.write(buffer1);
        fis1.close();
        fis2.close();
        fos.close();
    }
}
