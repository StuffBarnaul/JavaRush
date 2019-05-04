package com.javarush.test.level18.lesson08.task03;

import java.io.*;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream file;
    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
        super(fileName,true);
        file = fos;
    }

    @Override
    public void write(int b) throws IOException
    {
        file.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        file.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        file.write(b, off, len);
    }

    @Override
    public FileChannel getChannel()
    {
        return file.getChannel();
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();
    }

    @Override
    public void close() throws IOException {
        flush();
        byte[] buffer = "JavaRush © 2012-2013 All rights reserved.".getBytes();
        file.write(buffer);
        file.close();
    }
    public static void main(String[] args) throws FileNotFoundException,IOException {
        AmigoOutputStream a = new AmigoOutputStream(new FileOutputStream(fileName,true));
        a.close();
    }
}

/*public class AmigoOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}*/