package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        int count=0;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        FileInputStream fis = new FileInputStream(args[0]);
        byte[] buffer = new byte[(int)fis.getChannel().size()];
        fis.read(buffer);
        for (int i=0;i<buffer.length;i++){
            if (alphabet.contains((char)buffer[i]+"")) count++;
        }
        System.out.println(count);
        fis.close();
    }
}
