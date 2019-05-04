package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(file);
        HashMap<Integer,Integer> list = new HashMap();
        int data;
        int max=0;
        while (fileInputStream.available()>0) {
            data = fileInputStream.read();
            if (list.containsKey(data)){
                int tmp = list.get(data);
                list.put(data,++tmp);
            }
            else {
                list.put(data,1);
            }
        }
        for (Map.Entry<Integer,Integer> map : list.entrySet()){
            if (map.getValue()>max) max = map.getValue();
        }
        for (Map.Entry<Integer,Integer> map : list.entrySet()){
            if (map.getValue() == max) System.out.print(map.getKey()+" ");
        }
        fileInputStream.close();
    }
}
