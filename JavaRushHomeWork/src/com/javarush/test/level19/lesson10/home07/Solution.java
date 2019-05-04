package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileOutputStream fos = new FileOutputStream(args[1]);
        String s;
        int z=0;
        while((s=reader.readLine()) != null){
            String[] s1 = s.split(" ");
            for (int i = 0;i<s1.length;i++){
                if (s1[i].length()>6){
                    if (z>0) {fos.write(',');}
                    fos.write(s1[i].getBytes());
                    z++;
                }
            }
        }
        reader.close();
        fos.close();
    }
}
