package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("1", new Date("JANUARY 1 1981"));
        map.put("2", new Date("september 1 1982"));
        map.put("3", new Date("JUNE 1 1983"));
        map.put("5", new Date("JUNE 1 1984"));
        map.put("6", new Date("JUNE 1 1985"));
        map.put("7", new Date("JUNE 1 1986"));
        map.put("8", new Date("JUNE 1 1987"));
        map.put("9", new Date("JUNE 1 1988"));
        map.put("0", new Date("MAY 1 1989"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String,Date>> it = map.entrySet().iterator();
        while(it.hasNext())
        {
            int i = it.next().getValue().getMonth();
            if ((i>=5)&&(i<=7)) {it.remove();}
        }
    }
}
