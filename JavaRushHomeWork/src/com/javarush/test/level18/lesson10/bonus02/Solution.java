package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        //Читаем имя файла, закрываем поток
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        //Парсим файл, находим максимальный id, закрываем поток
        reader = new BufferedReader(new FileReader(fileName));
        String s;
        int max=0;
        while ((s=reader.readLine()) != null){
            int i = Integer.parseInt(s.substring(0,8).trim());
            if (i>max) max = i;
        }
        reader.close();

        if (args[0].equals("-c")){
            //Записываем в файл то, что получили из командной строки, закрываем поток
            max++;
            String id = Integer.toString(max);
            s = "";
            s = System.lineSeparator() + addSpases(8, id) + addSpases(30,args[1]) + addSpases(8,args[2]) + addSpases(4,args[3]);
            FileOutputStream fos = new FileOutputStream(fileName, true);
            fos.write(s.getBytes());
            fos.close();
        }
    }
    private static String addSpases(int length,String data){
        //Возвращаем строку нужной длины, при необходимости добиваем пробелами
        String result = data;
        if (data.length()>=length) result = result.substring(0,length);
        while(result.length()<length) {result = result+" ";}
        return result;
    }
}
