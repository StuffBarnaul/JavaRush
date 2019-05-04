package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);
        if (args[0].equals("-e")){
            byte[] buffer = new byte[(int)fis.getChannel().size()];
            fis.read(buffer);
            for (int i=0;i<buffer.length;i++){
                int tmp = buffer[i];
                if (tmp == 127) buffer[i] = -128; else buffer[i] = (byte)(tmp+1);
            }
            fos.write(buffer);
            fis.close();
            fos.close();
        }
        if (args[0].equals("-d")){
            byte[] buffer = new byte[(int)fis.getChannel().size()];
            fis.read(buffer);
            for (int i=0;i<buffer.length;i++){
                int tmp = buffer[i];
                if (tmp == -128) buffer[i] = 127; else buffer[i] = (byte)(tmp-1);
            }
            fos.write(buffer);
            fis.close();
            fos.close();
        }
    }

}
