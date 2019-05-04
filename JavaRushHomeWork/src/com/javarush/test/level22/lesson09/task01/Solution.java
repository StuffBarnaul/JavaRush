package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> strings = new ArrayList<String>();
        while (fileReader.ready()) {
            String nextString = fileReader.readLine();
            strings.addAll(Arrays.asList(nextString.split(" ")));
        }
        fileReader.close();
        while (strings.size()>0){
            StringBuilder sbd = new StringBuilder(strings.get(0));
            String s1 = sbd.toString();
            String s2 = sbd.reverse().toString();
            strings.remove(s1);
            if (strings.contains(s2)) {
                Pair pair = new Pair();
                pair.first = s1;
                pair.second = s2;
                result.add(pair);
                strings.remove(s2);
            }
        }
        for (Pair p: result){
            System.out.println(p.first + " " + p.second);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
