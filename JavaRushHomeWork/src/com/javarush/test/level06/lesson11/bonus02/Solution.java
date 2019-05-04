package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String gfName = reader.readLine();
        Cat catGf = new Cat(gfName);

        String gmName = reader.readLine();
        Cat catGm = new Cat(gmName);

        String fName = reader.readLine();
        Cat catF = new Cat(fName,catGf,null);

        String mName = reader.readLine();
        Cat catM = new Cat(mName,null,catGm);

        String sName = reader.readLine();
        Cat catS = new Cat(sName,catF,catM);

        String dName = reader.readLine();
        Cat catD = new Cat(dName,catF,catM);

        System.out.println(catGf);
        System.out.println(catGm);
        System.out.println(catF);
        System.out.println(catM);
        System.out.println(catS);
        System.out.println(catD);
    }

    public static class Cat
    {
        private String name;
        private Cat pf;
        private Cat pm;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat pf, Cat pm)
        {
            this.name = name;
            this.pf = pf;
            this.pm = pm;
        }

        @Override
        public String toString()
        {
            if (pm == null){
                if (pf == null)return "Cat name is " + name + ", no mother, no father";
                else return "Cat name is " + name + ", no mother, father is " + pf.name;
            }
            else if (pf == null) return "Cat name is " + name + ", mother is " + pm.name + ", no father";
            else return "Cat name is " + name + ", mother is " + pm.name + ", father is " + pf.name;
        }
    }

}
