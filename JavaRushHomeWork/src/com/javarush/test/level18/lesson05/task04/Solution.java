package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        ArrayList list = new ArrayList();
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            list.add(data);
        }
        ArrayList list2 = new ArrayList();
        for (int i=list.size()-1;i>=0;i--){
            list2.add(list.get(i));
        }
        for (int i=0;i<list2.size();i++){
            fileOutputStream.write((int)list2.get(i));
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
