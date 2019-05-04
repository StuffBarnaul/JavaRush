package com.javarush.test.level15.lesson09.task05;

/* Статики 4
Внутри статического блока:
1. Создайте класс Cat
2. Внутри Cat создайте поле класса String name = "Пушок"
3. Создайте объект класса Cat - myCat
4. Присвойте статическому объекту Object cat объект, созданный в п.3
5. Выведите в консоль myCat.name
*/

public class Solution {
    static {
        class Cat {String name = "Пушок";} // Пункт 1+2
        Cat myCat = new Cat();             // Пункт 3
        cat = myCat;
        System.out.println(myCat.name);    // Пункт 5
    }
    public static Object cat;
}
