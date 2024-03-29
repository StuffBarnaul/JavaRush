package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter{
    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    @Override
    public void write(int c) throws IOException
    {
        super.write(c);
        System.out.println((char) c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        super.write(cbuf, off, len);
        for (int i=off;i<off+len;i++) System.out.print(cbuf[i]);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        super.write(str, off, len);
        System.out.println(str.substring(off,off+len));
    }

    public static void main(String[] args) throws IOException{
        File file = new File("2");
        String s = "123af";
        char[] cbuf = s.toCharArray();
        FileConsoleWriter fcw = new FileConsoleWriter(file);
        fcw.write(12);
        //fcw.write(cbuf,1,5);
        //fcw.write(s,1,5);
        fcw.write(cbuf);
        fcw.write(s);
        fcw.close();
    }
}
