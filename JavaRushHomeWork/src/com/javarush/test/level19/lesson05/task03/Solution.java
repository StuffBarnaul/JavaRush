package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader fr = new BufferedReader(new FileReader(file1));
        FileWriter fw = new FileWriter(file2);
        String s;
        while ((s = fr.readLine()) != null){
            String[] s1;
            s1 = s.split(" ");
            for (int j=0;j<s1.length;j++){
                try {
                    int k = Integer.parseInt(s1[j]);
                    fw.write(s1[j]+" ");
                }
                catch (NumberFormatException e) {}
            }
        }
        fr.close();
        fw.close();
    }
}
