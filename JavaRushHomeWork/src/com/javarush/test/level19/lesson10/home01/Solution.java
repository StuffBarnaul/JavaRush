package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
        for (Map.Entry me : map.entrySet()){
            System.out.println(me.getKey()+" "+me.getValue());
        }
    }
}
