package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream(new File(args[0]));
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int data;
        while (fis.available()>0){
            data = fis.read();
            if (map.containsKey(data)){
                int count;
                count = map.get(data);
                count++;
                map.put(data,count);
            } else map.put(data,1);
        }
        for(Map.Entry entry: map.entrySet()){
            System.out.println( (char)(int)entry.getKey()+" "+entry.getValue());
        }
        fis.close();
    }
}
