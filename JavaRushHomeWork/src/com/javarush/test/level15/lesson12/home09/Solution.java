package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14

javarush.ru/alpha/index.html?obj=3.14&name=Amigo&obj=adas&lvl=15&view
javarush.ru/alpha/index.html?lvl=15&view&name=Amigo&obj=2.0&objobbbjjj=3.14&qweobj=3
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        reader.close();

        //Обрезаем 1 часть строки

        s = s.substring(s.indexOf("?")+1,s.length());

        //Разбиваем на отдельные параметры и заносим в массив отдельные параметры

        while (s.indexOf('&')!=-1) {
            list.add(s.substring(0,s.indexOf('&')));
            s = s.substring(s.indexOf('&')+1,s.length());
        }
        list.add(s);

        // Заносим в массив listOfObj значения obj, в массив list2 все параметры

        ArrayList<String> listOfObj = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for(String s1:list) {
            if ((s1.length()>3)&&(s1.substring(0,4).equals("obj="))) {listOfObj.add(s1.substring(4,s1.length()));}
            if (s1.contains("=")){list2.add(s1.substring(0,s1.indexOf('=')));} else list2.add(s1.trim());
        }

        // Выводим все параметры

        for(String s1:list2) {System.out.print(s1+" ");}
        System.out.println();

        // Если были obj, то выводим их

        for(String s1:listOfObj) {
            try {alert(Double.parseDouble(s1));}
            catch (Exception e){alert(s1);}
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
