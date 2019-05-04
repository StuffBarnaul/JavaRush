package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File temp = new File("D:\\Java\\JavaRushHomeWork\\4");
            OutputStream outputStream = new FileOutputStream(temp);
            InputStream inputStream = new FileInputStream(temp);

            //Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            Human ivanov = new Human("Ivanov");
            ivanov.save(outputStream);

            outputStream.flush();
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            if (somePerson.name.equals(ivanov.name)&&
                    somePerson.assets.size() == ivanov.assets.size())
                System.out.println("OK"); else System.out.println("Not OK");
            inputStream.close();
            System.out.println(somePerson.name);
            int size = somePerson.assets.size();
            System.out.println(size);
            for (int i=0;i<size;i++){
                System.out.println(somePerson.assets.get(i).getName());
                System.out.println(somePerson.assets.get(i).getPrice());
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(name);
            writer.print(assets.size());
            for (int i=0;i<assets.size();i++){
                writer.print(System.lineSeparator());
                writer.println(assets.get(i).getName());
                writer.print(String.valueOf(assets.get(i).getPrice()));
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            name = reader.readLine();
            int size = Integer.parseInt(reader.readLine());
            for (int i=0;i<size;i++){
                Asset asset = new Asset(reader.readLine());
                asset.setPrice(Double.parseDouble(reader.readLine()));
                assets.add(asset);
            }
            reader.close();
        }
    }
}
