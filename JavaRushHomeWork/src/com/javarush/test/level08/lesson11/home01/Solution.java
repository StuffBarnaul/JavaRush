package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Iterator<Cat> i = cats.iterator();
        i.next();
        i.remove();

        //напишите тут ваш код. пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> cat = new HashSet<Cat>();//напишите тут ваш код. пункт 2
        cat.add(new Cat("1"));
        cat.add(new Cat("2"));
        cat.add(new Cat("3"));
        return cat;
    }

    public static void printCats(Set<Cat> cats)
    {
        for(Cat c:cats){System.out.println(c);}// пункт 4
    }

    public static class Cat
    {
        String name;

        public Cat(String name)
        {
            this.name = name;
        }
    }// пункт 1
}
