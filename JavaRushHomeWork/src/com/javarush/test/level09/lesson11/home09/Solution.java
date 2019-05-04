package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Cat cat = new Cat("Q");
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("1",cat);
        map.put("2",cat);
        map.put("3",cat);
        map.put("4",cat);
        map.put("5",cat);
        map.put("6",cat);
        map.put("7",cat);
        map.put("8",cat);
        map.put("9",cat);
        map.put("0",cat);
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> catset = new HashSet<Cat>();
        for (Map.Entry<String, Cat> s:map.entrySet())
        catset.add(s.getValue());
        return catset;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
