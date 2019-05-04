package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5

    //        file1: 1 4 5
    //        file2: 2 1 3 4 5 6
    //        output: А2 S1 A3 S4 S5 A6
    //        file1: 1 2 3
    //        file2: 1 3 4
    //        ouput: S1 R2 S3 A4
    //        file1: 1 1
    //        file2: 1 2 1
    //        ouput: S1 A2 S1
    //        file1: 1 2 1
    //        file2: 2 3 1 4
    //        ouput: R1 S2 A3 S1 A4
    //        file1: 1 2 3 4
    //        file2: 1 3
    //        ouput: S1 R2 S3 R4
    //        file1: 1 2 3 5
    //        file2: 0 1 3 4 5 6
    //        ouput: A0 S1 R2 S3 A4 S5 A6
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader fr1 = new BufferedReader(new FileReader(file1));
        BufferedReader fr2 = new BufferedReader(new FileReader(file2));
        boolean b1=true,b2=true;
        String s11 = fr1.readLine();
        String s21 = fr2.readLine();
        String s12="",s22="";
        while (b1|b2){
            if (b1) s12 = fr1.readLine();
            if (b2) s22 = fr2.readLine();
            b1=true;
            b2=true;
            if (s12 == null) b1 = false;
            if (s22 == null) b2 = false;
            LineItem line = null;
            if ((s12 == null)&&(s22 == null)){
                if (s11 == null) line = new LineItem(Type.ADDED,s21); else
                if (s21 == null) line = new LineItem(Type.REMOVED,s11); else
                if (s11.equals(s21)) line = new LineItem(Type.SAME,s11);
            }else
            if (s11.equals(s21)) {line = new LineItem(Type.SAME,s11);s21=s22;s11=s12;} else
            if (s11.equals(s22)) {line = new LineItem(Type.ADDED,s21); b1 = false; s21 = s22;} else
            if (s12.equals(s21)) {line = new LineItem(Type.REMOVED,s11);b2 = false; s11 = s12;}
            lines.add(line);

        }
        fr1.close();
        fr2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
