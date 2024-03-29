package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable{

    public static void main(String[] args) {
            try{
                Solution p1 = new Solution(12);
                System.out.println(p1);
                FileOutputStream fileOutput = new FileOutputStream("4");
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
                outputStream.writeObject(p1);
                fileOutput.close();
                outputStream.close();
                p1 = new Solution(132);
                System.out.println(p1);

                FileInputStream fiStream = new FileInputStream("4");
                ObjectInputStream objectStream = new ObjectInputStream(fiStream);
                p1 = (Solution) objectStream.readObject();
                fiStream.close();
                objectStream.close();
                System.out.println(p1);
        }
        catch(Exception e){}
        }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private int temperature;
    String string;

    public Solution(){super();}

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
