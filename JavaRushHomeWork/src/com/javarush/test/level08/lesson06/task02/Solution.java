/*10 тысяч удалений и вставок
        Для arrayList и linkedList провести 10 тысяч вставок, удалений, а также вызовов get и set.
        Требования:
        1. Программа не должна выводить текст на экран.
        2. Программа не должна считывать значения с клавиатуры.
        3. Класс Solution должен содержать только 5 методов.
        4. Метод insert10000(List list) должен вставлять 10 тысяч элементов в список.
        5. Метод get10000(List list) должен вызывать 10 тысяч раз get у списка.
        6. Метод set10000(List list) должен вызывать 10 тысяч раз set у списка.
        7. Метод remove10000(List list) должен удалять 10 тысяч элементов из списка.
*/
package com.javarush.test.level08.lesson06.task02;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws Exception {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);
        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
    }
    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }//напишите тут ваш код
    }
    public static void get10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.get(i);
        }//напишите тут ваш код
    }
    public static void set10000(List list) {
        for (int i = 0; i < 1000; i++) {
            list.set(i, null);
        }
        //напишите тут ваш код
    }
    public static void remove10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.removeAll(list);//напишите тут ваш код
        }
    }
}