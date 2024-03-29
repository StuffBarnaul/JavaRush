package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String,Double> map = new TreeMap<>();
        String s;
        while((s=reader.readLine()) != null){
            String[] s1 = s.split(" ");
            if (map.containsKey(s1[0])){
                double tmp = map.get(s1[0]);
                map.put(s1[0],tmp+Double.parseDouble(s1[1]));
            } else map.put(s1[0],Double.parseDouble(s1[1]));
        }
        reader.close();
        String name = "";
        double max = 0;
        for (Map.Entry<String,Double> me : map.entrySet()){
            if (me.getValue()>max) {name = me.getKey(); max = me.getValue();}
        }
        System.out.println(name);
    }
}
