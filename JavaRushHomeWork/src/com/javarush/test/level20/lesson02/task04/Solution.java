package com.javarush.test.level20.lesson02.task04;

import java.io.*;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            OutputStream outputStream = new FileOutputStream("4");
            InputStream inputStream = new FileInputStream("4");

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            if (loadedObject.staticString.equals(classWithStatic.staticString)) System.out.println("1");
            if (loadedObject.i == classWithStatic.i) System.out.println("2");
            if (loadedObject.j == classWithStatic.j) System.out.println("3");
            //check here that classWithStatic object equals to loadedObject object - проверьте тут, что classWithStatic и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            int is = i,js = j;
            writer.println(staticString);
            writer.println(is);
            writer.println(js);
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            staticString = reader.readLine();
            i = Integer.parseInt(reader.readLine());
            j = Integer.parseInt(reader.readLine());
        }
    }
}
