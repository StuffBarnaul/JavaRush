package com.javarush.test.level07.lesson04.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 2 массива
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк, индекс/номер ячейки которой совпадает
с текущим индексом из массива чисел. Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mi = new int[10];
        String[] ms = new String[10];
        for (int i = 0; i < ms.length; i++)
        {
            ms[i] = reader.readLine();
        }
        for (int i = 0; i < mi.length; i++)
        {
            mi[i] = ms[i].length();
            System.out.println(mi[i]);
        }
    }
}
