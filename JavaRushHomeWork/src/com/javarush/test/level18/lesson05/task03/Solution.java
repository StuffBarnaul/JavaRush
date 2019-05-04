package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(file2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
        if (fileInputStream.available() > 0) {
            int i=0;
            if (fileInputStream.available()%2 == 1) i=1;
            byte[] buffer = new byte[(fileInputStream.available()/2)];
            int count = fileInputStream.read(buffer);
            fileOutputStream1.write(buffer,0,count);
            if (i == 1) {
                byte[] ost = new byte[1];
                count = fileInputStream.read(ost);
                fileOutputStream1.write(ost, 0, count);
            }
            count = fileInputStream.read(buffer);
            fileOutputStream2.write(buffer,0,count);
        }
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
