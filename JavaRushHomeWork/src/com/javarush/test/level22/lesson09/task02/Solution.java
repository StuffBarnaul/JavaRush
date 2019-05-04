package com.javarush.test.level22.lesson09.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main (String[] args) {
        try {
            Map map = new HashMap();
            map.put("1","2");
            map.put("3","4");
            map.put("5",null);
            map.put("6","7");
            StringBuilder result = getCondition(map);
            System.out.println(result.toString());
        }catch (Exception e){e.printStackTrace();}
    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> entries = params.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            if (entry.getValue() != null){ sb.append(entry.getKey()+" = '"+entry.getValue()+"'"); }
            if (entry.getValue() != null && entries.hasNext()) {sb.append(" and ");}
        }
        return sb;
    }
}
