package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<String> copy = new ArrayList<String>();
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> numbers = new ArrayList<String>();
        //создаем 3 списка, один для маркеров, 2 для строк
        int i = 0,iw = 0,in = 0;
        for (String s:array)
        {
            if (isNumber(array[i])) {copy.add("n");numbers.add(array[i]);i++;}
            else {copy.add("w");words.add(array[i]);i++;}
        }
        int l = numbers.size();
        //распихиваем array по 2 массивам, маркерами помечаем последовательность
        String[] wordsarray = words.toArray(new String[words.size()]);
        String[] numbersarray = numbers.toArray(new String[numbers.size()]);
        String[] copyarray = copy.toArray(new String[copy.size()]);
        Integer[] numbersarrayint = new Integer[l];
        for (int j=0;j<l;j++) {numbersarrayint[j] = Integer.parseInt(numbersarray[j]);}
        Arrays.sort(wordsarray);
        Arrays.sort(numbersarrayint);

        Integer[] numbersarrayint2 = new Integer[l];


        // реверсируем массив чисел

        for (int j=0;j<l;j++) {numbersarrayint2[j] = numbersarrayint[l-j-1];}
        for (int j=0;j<l;j++) {numbersarrayint[j] = numbersarrayint2[j];}
        i=0;
        for (String s:array)
        {
            if (copyarray[i].equals("w"))
            {
                array[i]=wordsarray[iw];
                i++;
                iw++;
            }
            else if (copyarray[i].equals("n"))
            {
                array[i]=Integer.toString(numbersarrayint[in]);
                i++;
                in++;
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
