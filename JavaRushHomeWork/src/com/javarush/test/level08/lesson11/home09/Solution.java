package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        //System.out.println(isDateOdd("JANUARY 3 2000"));
    }

    public static boolean isDateOdd(String date)
    {
        boolean b=true;
        Date date2 = new Date(date);
        int year = date2.getYear();
        date2.setHours(0);
        date2.setMinutes(0);
        date2.setSeconds(0);
        Date yearStartTime = new Date();
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);

        yearStartTime.setDate(1);      // первое число
        yearStartTime.setMonth(0);     // месяц январь, нумерация для месяцев 0-11
        yearStartTime.setYear(year);

        long msTimeDistance = date2.getTime() - yearStartTime.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках
        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней
        if (dayCount%2 == 0) b=false;
        if (dayCount == 0 & date2.getDate() == 1) b=true;
        return b;
    }
}
