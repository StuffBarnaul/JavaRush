package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String s="";
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                s = reader.readLine();
                if (s.equals("")) break;
                FileInputStream fis = new FileInputStream(new File(s));
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println(s);
        }
        catch (IOException e){}
    }
}
