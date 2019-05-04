package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> list = new HashMap<String, String>();
        list.put("1","1");
        list.put("2","2");
        list.put("3","4");
        list.put("4","5");
        list.put("5","3");
        list.put("6","3");
        list.put("7","9");
        list.put("8","5");
        list.put("9","6");
        list.put("0","8");
        return list;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int c=0;
        for (Map.Entry<String,String> list: map.entrySet()){if (list.getValue().equals(name)) c++;}
        return c;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int c=0;
        for (Map.Entry<String,String> list: map.entrySet()){if (list.getKey().equals(lastName)) c++;}
        return c;
    }
}
