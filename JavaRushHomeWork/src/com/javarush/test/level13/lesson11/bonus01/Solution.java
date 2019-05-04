package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        ArrayList<Integer> array = new ArrayList();
        BufferedReader file = new BufferedReader(new FileReader(name));
        String line;
        String firstLine = "";
        while ((line = file.readLine()) != null)
        {
            for (char ch : line.toCharArray())
            {
                if (Character.isDigit(ch))
                {
                    firstLine = firstLine + ch;
                }
            }
                if (!firstLine.equals("")) array.add(Integer.parseInt(firstLine));
                firstLine = "";
        }
        Integer[] arrayInteger = array.toArray(new Integer[array.size()]);
        Arrays.sort(arrayInteger);
        for(int i=0;i<arrayInteger.length;i++)
        {
            if (arrayInteger[i]%2 == 0)System.out.println(arrayInteger[i]);
        }
    }
}
