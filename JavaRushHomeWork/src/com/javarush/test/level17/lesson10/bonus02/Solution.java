package com.javarush.test.level17.lesson10.bonus02;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException,ParseException
    {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            for (int i=0;i<((args.length-1)/3);i++) {
                if (args[3*i+2].equals("м")) allPeople.add(Person.createMale(args[3*i+1], date.parse(args[3*i+3])));
                else allPeople.add(Person.createFemale(args[3*i+1], date.parse(args[3*i+3])));
                System.out.println(allPeople.size() - 1);
            }
        }
        if (args[0].equals("-u")){
            for (int i =0;i<((args.length-1)/4);i++) {
                int id = Integer.parseInt(args[4*i+1]);
                allPeople.get(id).setName(args[4*i+2]);
                if (args[4*i+3].equals("м")) allPeople.get(id).setSex(Sex.MALE);
                else allPeople.get(id).setSex(Sex.FEMALE);
                allPeople.get(id).setBirthDay(date.parse(args[4*i+4]));
            }
        }
        if (args[0].equals("-d")){
            for (int i =0;i<(args.length-1);i++) {
                int id = Integer.parseInt(args[1+i]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
            }
        }
        if (args[0].equals("-i")) {
            for (int i =0;i<(args.length-1);i++) {
                int id = Integer.parseInt(args[1+i]);
                SimpleDateFormat dateOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.print(allPeople.get(id).getName()+" ");
                if (allPeople.get(id).getSex() == Sex.MALE) System.out.print("м "); else System.out.print("ж ");
                System.out.print(dateOut.format(allPeople.get(id).getBirthDay()));
                System.out.println();
            }
        }
    }
}
