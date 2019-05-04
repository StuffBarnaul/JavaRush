package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(file1);
        ArrayList<Double> list = new ArrayList();
        byte[] buffer = new byte[(int)fis.getChannel().size()];
        fis.read(buffer);
        char space = ' ';
        int i=0;
        String s = "";
        while (i<buffer.length){
            boolean b=true;
            while (b){
                if (i == buffer.length) break;
                if ((char)buffer[i] == ((int)space)) {b = false; i++; break;}
                s += ((char)buffer[i]);
                i++;
            }
            double number = Double.parseDouble(s);
            list.add(number);
            s = "";
        }
        FileOutputStream fos = new FileOutputStream(file2);
        for (double d:list){
            s="";
            int tmp=0;
            if (d>0&&Math.abs(d-(int)d)<0.5) tmp = (int)d;
            if (d>0&&Math.abs(d-(int)d)>=0.5) tmp = (int)d+1;
            if (d<0&&Math.abs(d-(int)d)<=0.5) tmp = (int)d;
            if (d<0&&Math.abs(d-(int)d)>0.5) tmp = (int)d-1;
            s = tmp + " ";
            buffer = s.getBytes();
            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }
}
