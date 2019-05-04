package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        int spaces=0;
        FileInputStream fis = new FileInputStream(args[0]);
        byte[] buffer = new byte[(int)fis.getChannel().size()];
        fis.read(buffer);
        for (int i=0;i<buffer.length;i++){
            if (((char)buffer[i]+"").equals(" ")) spaces++;
        }
        double result = ((double) spaces/(double) buffer.length);
        System.out.printf("%.2f",result*100);
        fis.close();
    }
}
