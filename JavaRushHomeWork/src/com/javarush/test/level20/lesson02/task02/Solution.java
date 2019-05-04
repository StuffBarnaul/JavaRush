package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("4");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User j1 = new User();
            j1.setFirstName("First");
            j1.setLastName("Last");
            j1.setBirthDate(new Date(1977,8,19));
            j1.setMale(true);
            j1.setCountry(User.Country.OTHER);
            javaRush.users.add(j1);
            System.out.println(javaRush.users.size());
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject.users.get(0).getFirstName());
            System.out.println(loadedObject.users.get(0).getLastName());
            System.out.println(loadedObject.users.get(0).getBirthDate());
            System.out.println(loadedObject.users.get(0).isMale());
            System.out.println(loadedObject.users.get(0).getCountry());
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

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

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            if (this.users!=null){
                for (User x:users){
                    writer.println(x.getFirstName());
                    writer.println(x.getLastName());
                    writer.println(x.getBirthDate().getTime());
                    writer.println(x.isMale());
                    writer.println(x.getCountry());
                }
            }
            writer.println("#####");
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            users.clear();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int size = Integer.parseInt(reader.readLine());
            for (int i=0;i<size;i++){
                User temp = new User();
                temp.setFirstName(reader.readLine());
                temp.setLastName(reader.readLine());
                temp.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                temp.setMale(Boolean.parseBoolean(reader.readLine()));
                String s = reader.readLine();
                if (s.equals("UKRAINE")){temp.setCountry(User.Country.UKRAINE);}
                else if (s.equals("RUSSIA")){temp.setCountry(User.Country.RUSSIA);}
                else if (s.equals("OTHER")){temp.setCountry(User.Country.OTHER);}
                users.add(temp);
            }
            reader.close();
        }
    }
}
