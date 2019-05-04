package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String,Double> map = new TreeMap<>();
        String s;
        while((s=reader.readLine()) != null){
            String[] s1 = s.split(" ");
            String name = s1[0];
            Date date = new Date();
            date.setYear(Integer.parseInt(s1[s1.length-1]));
            date.setMonth(Integer.parseInt(s1[s1.length-2])-1);
            date.setDate(Integer.parseInt(s1[s1.length-3]));
            for (int i=1;i<s1.length-3;i++){
                name += " "+s1[i];
            }
            PEOPLE.add(new Person(name,date));
        }
        reader.close();
    }

}
