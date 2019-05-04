package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> childrenofchildren = new ArrayList<Human>();
        Human c1 = new Human("c1",true,60,childrenofchildren);
        Human c2 = new Human("c2",true,60,childrenofchildren);
        Human c3 = new Human("c3",true,60,childrenofchildren);
        ArrayList<Human> childrenofparents = new ArrayList<Human>();
        childrenofparents.add(c1);
        childrenofparents.add(c2);
        childrenofparents.add(c3);
        Human m = new Human("mother",false,60,childrenofparents);
        Human f = new Human("father",true,60,childrenofparents);
        ArrayList<Human> childrenofg1 = new ArrayList<Human>();
        childrenofg1.add(m);
        ArrayList<Human> childrenofg2 = new ArrayList<Human>();
        childrenofg2.add(f);
        Human gf1 = new Human("gf1",true,60,childrenofg1);
        Human gf2 = new Human("gf2",true,60,childrenofg2);
        Human gm1 = new Human("gm1",false,60,childrenofg1);
        Human gm2 = new Human("gm2",false,60,childrenofg2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(m);
        System.out.println(f);
        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gm1);
        System.out.println(gm2);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human (String name,boolean sex,int age,ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
