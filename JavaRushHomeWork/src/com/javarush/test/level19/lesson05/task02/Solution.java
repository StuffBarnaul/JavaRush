package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader filereader = new BufferedReader(new FileReader(file));
        String s;
        int count = 0;
        while ((s = filereader.readLine()) != null){
            s = s.replace("."," ");
            s = s.replace(","," ");
            s = s.replace("!"," ");
            s = s.replace("?"," ");
            s = s.replace(":"," ");
            s = s.replace(";"," ");
            String[] s1;
            s1 = s.split(" ");
            for (int j=0;j<s1.length;j++){
                if (s1[j].equals("world")) count++;
            }
        }
        System.out.println(count);
        filereader.close(); 
    }
}
