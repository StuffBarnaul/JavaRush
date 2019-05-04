package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = consoleReader.readLine();
            consoleReader.close();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String s = fileReader.readLine();
            fileReader.close();
            if (s == null) {System.out.println("Пустой файл"); s = "";}
            StringBuilder result = getLine(s.split(" "));
            System.out.println(result.toString());
        }catch (Exception e){e.printStackTrace();}
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words.length == 0 || words == null) return sb;
        if (words.length == 1) {sb.append(words[0]); return sb;}
        List firstletters = new ArrayList();
        List lastletters = new ArrayList();
        for (int i=0;i<words.length;i++){
            firstletters.add(words[i].toLowerCase().charAt(0));
            lastletters.add(words[i].toLowerCase().charAt(words[i].length()-1));
        }
        List diff = new ArrayList(firstletters);
        diff.removeAll(lastletters);
        lastletters.removeAll(firstletters);
        int index = -1, lastwordindex = -1;
        if (diff.size() > 1) {sb.append("No decision"); return sb;}
        if (diff.size() == 1) {
            for (int i=0;i<words.length;i++){
                if (diff.get(0).equals(words[i].toLowerCase().charAt(0))) index = i;
                if (lastletters.get(0).equals(words[i].toLowerCase().charAt(words[i].length()-1))) lastwordindex = i;
            }
        }
        List<String> cities = new ArrayList<String>(Arrays.asList(words));
        String lastWord = words[lastwordindex];
        cities.remove(lastwordindex);
        while (cities.size()>0){
            sb.append(" "+cities.get(index));
            char str = sb.charAt(sb.length()-1);
            cities.remove(index);
            index = -1;
            int i = 0;
            while(index == -1 && cities.size()>0){
                if (cities.get(i).toLowerCase().charAt(0) == str) {
                    index = i;
                }
                i++;
            }
        }
        return sb.deleteCharAt(0).append(" "+lastWord);
    }
}
