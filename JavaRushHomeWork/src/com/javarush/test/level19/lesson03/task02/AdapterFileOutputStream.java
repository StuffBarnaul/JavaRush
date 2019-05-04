package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream fos;
    public AdapterFileOutputStream(FileOutputStream fileOutputStream){
        this.fos = fileOutputStream;
    }
    @Override
    public void flush() throws IOException
    {
        fos.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        byte[] buffer = s.getBytes();
        fos.write(buffer);
    }

    @Override
    public void close() throws IOException
    {
        fos.close();
    }
}

