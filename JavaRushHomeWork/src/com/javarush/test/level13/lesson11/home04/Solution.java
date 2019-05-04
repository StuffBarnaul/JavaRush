package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        ArrayList<String> list = new ArrayList<String>();
        String s = reader.readLine();
        while (!s.equals("exit"))
        {
            list.add(s);
            s = reader.readLine();
        }
        list.add("exit");
        OutputStream outStream = new FileOutputStream(name);
        for(String s1:list)
        {
            outStream.write(s1.getBytes());
            outStream.write(System.lineSeparator().getBytes());
        }
    }
}
