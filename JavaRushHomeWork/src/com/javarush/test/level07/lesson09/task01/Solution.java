package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> listx3 = new ArrayList<Integer>();
        ArrayList<Integer> listx2 = new ArrayList<Integer>();
        ArrayList<Integer> listother = new ArrayList<Integer>();
        for(int i = 0;i < 20;i++){list.add(Integer.parseInt(reader.readLine()));}
        boolean a1 = true,a2 = true;
        for(int i = 0;i < 20;i++){
            if(list.get(i)%3 == 0){listx3.add(list.get(i));a1 = false;}
            if(list.get(i)%2 == 0){listx2.add(list.get(i));a2 = false;}
            if(a1&a2){listother.add(list.get(i));}
            a1 = true;
            a2 = true;}
        printList(listx3);
        printList(listx2);
        printList(listother);
    }

    public static void printList(List<Integer> list)
    {
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
