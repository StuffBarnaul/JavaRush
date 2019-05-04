package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileOutputStream fos = new FileOutputStream(args[1]);
        String s;
        while((s=reader.readLine()) != null){
            String[] s1 = s.split(" ");
            for (int i = 0;i<s1.length;i++){
                byte[] tmp = s1[i].getBytes();
                for (int j = 0;j<tmp.length;j++){
                    if (tmp[j]>='0'&&tmp[j]<='9'){
                        fos.write(tmp);
                        fos.write(' ');
                        break;
                    }
                }
            }
        }
        reader.close();
        fos.close();
    }
}
