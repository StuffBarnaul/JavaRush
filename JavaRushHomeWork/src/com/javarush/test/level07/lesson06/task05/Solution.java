package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0;i < 5;i++)
        {
            list.add(reader.readLine());
        }
        for(int j = 0;j < 13;j++)
        {
            int n = list.size()-1;
            String s = list.get(n);
            list.remove(n);
            list.add(0,s);
        }
        for(int k = 0;k < list.size();k++)
        {
            System.out.println(list.get(k));
        }
    }
}
