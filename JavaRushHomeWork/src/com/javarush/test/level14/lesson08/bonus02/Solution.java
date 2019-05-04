package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long a = Integer.parseInt(reader.readLine());
        long b = Integer.parseInt(reader.readLine());
        long min = a>b?b:a;
        for (int i = (int)min; i>0; i--)
        {
            //System.out.println(a%min);
            //System.out.println(b%min);
            if(a%i == 0 & b%i == 0) {System.out.println(i);break;}
        }
    }
}
