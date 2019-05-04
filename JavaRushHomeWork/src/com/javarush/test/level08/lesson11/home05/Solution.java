package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Character;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        s += '.'; // чтоб сохранить последние пробелы
        String[] s0 = s.split(" ");
        s = "";
        for (String s1 : s0)
        {
            if (!s1.isEmpty())
            {
                char[] a = s1.toCharArray();
                a[0] = Character.toUpperCase(a[0]);
                s += (new String(a) + " ");
            } else s += " "; // пробелы между слов
        }
        s = s.substring(0, s.length() - 2); // убирает лишние пробел и точку в конце
        System.out.println(s);
        for (String s1 : s0) System.out.println(s1);
    }
    /*public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] bufChar = new char[s.length()];
        Character[] bufCharacter = new Character[s.length()];
        s.getChars(0, s.length(), bufChar, 0);
        for (int i=0;i<s.length();i++) {bufCharacter[i] = bufChar[i];}
        for (int i=0;i<s.length();i++)
        {
            if (i==0)
            {
                if (Character.isLetter(bufCharacter[i]))
                {
                    System.out.print(Character.toUpperCase(bufCharacter[i]));
                }
                else System.out.print(bufCharacter[i]);
            }
            else
            {
                if (Character.isLetter(bufCharacter[i]) & Character.isWhitespace(bufCharacter[i-1]))
                {
                    System.out.print(Character.toUpperCase(bufCharacter[i]));
                }
                else System.out.print(bufCharacter[i]);
            }

        }
    }*/
}
