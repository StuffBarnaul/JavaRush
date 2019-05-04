package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String mainfile="";
        int part=0;
        int length=0;
        TreeMap<Integer,String> map = new TreeMap<>();
        for (int i=s.length();i>0;i--){
            if (s.substring(i-5,i).equals(".part")){
                mainfile = s.substring(0,i-5);
                part = Integer.parseInt(s.substring(i));
                length = i;
                break;
            }
        }
        map.put(part,s);
        while (!(s=reader.readLine()).equals("end")){
            map.put(Integer.parseInt(s.substring(length)),s);
        }
        reader.close();
        FileOutputStream fos = new FileOutputStream(new File(mainfile),true);
        for (Map.Entry entry:map.entrySet()){
            FileInputStream fis = new FileInputStream((String) entry.getValue());
            byte[] buffer = new byte[(int)fis.getChannel().size()];
            fis.read(buffer);
            fos.write(buffer);
            fis.close();
        }
        fos.close();
    }
}
