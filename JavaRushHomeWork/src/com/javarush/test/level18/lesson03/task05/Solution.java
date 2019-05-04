package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(file);
        ArrayList<Integer> list = new ArrayList();
        int data;
        while (fileInputStream.available()>0) {
            data = fileInputStream.read();
            if (!list.contains(data)) list.add(data);
        }
        Integer [] bytes = list.toArray(new Integer[list.size()]);
        Arrays.sort(bytes);
        for (Integer map : bytes){
            System.out.print(map+" ");
        }
        fileInputStream.close();
    }
}
