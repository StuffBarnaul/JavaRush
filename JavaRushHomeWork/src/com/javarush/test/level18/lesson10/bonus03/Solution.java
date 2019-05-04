package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        File file = new File(fileName);
        reader = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList();
        String s;
        if (args[0].equals("-u")&&args.length>=5){
            while ((s = reader.readLine()) != null){
                if (s.substring(0,8).trim().equals(args[1])) {
                    String su = addSpases(8,args[1]) + addSpases(30,args[2]) + addSpases(8,args[3]) + addSpases(4,args[4]);
                    list.add(su);
                }else list.add(s);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i=0;i<list.size();i++){
                writer.write(list.get(i));
                if (i<list.size()-1) writer.write(System.lineSeparator());
            }
            writer.close();
        }
        if (args[0].equals("-d")&&args.length==2){
            while ((s = reader.readLine()) != null){
                if (s.substring(0,8).trim().equals(args[1])) {
                    continue;
                }else list.add(s);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i=0;i<list.size();i++){
                writer.write(list.get(i));
                if (i<list.size()-1) writer.write(System.lineSeparator());
            }
            writer.close();
        }
    }
    private static String addSpases(int length,String data){
        String result = data;
        if (data.length()>=length) result = result.substring(0,length);
        while(result.length()<length) {result = result+" ";}
        return result;
    }
}
