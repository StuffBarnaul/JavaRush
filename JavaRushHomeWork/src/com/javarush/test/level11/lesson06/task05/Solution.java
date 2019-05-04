package com.javarush.test.level11.lesson06.task05;

/* ИТ-компания
Написать девять классов: Worker(сотрудник), Clerk (клерк), IT (ИТ-специалист), Programmer(программист),
ProjectManager(менеджер проекта), CTO(технический директор), HR(рекрутер), OfficeManager(офис-менеджер), Cleaner (уборщик).
Унаследовать программиста, менеджера проекта и технического директора от ИТ-специалиста.
Унаследовать рекрутера, уборщика и офис-менеджера от клерка.
Унаследовать клерка и ИТ-специалиста от сотрудника.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Worker
    {
        String name;
    }

    public class Clerk extends Worker
    {
        String name;
    }

    public class IT extends Worker
    {
        String name;
    }

    public class Programmer extends IT
    {
        String name;
        public Programmer (String name){this.name = name;}
    }

    public class ProjectManager extends IT
    {
        String name;
        public ProjectManager (String name){this.name = name;}
    }

    public class CTO extends IT
    {
        String name;
        public CTO (String name){this.name = name;}
    }

    public class OfficeManager extends Clerk
    {
        String name;
        public OfficeManager (String name){this.name = name;}
    }

    public class HR extends Clerk
    {
        String name;
        public HR (String name){this.name = name;}
    }

    public class Cleaner extends Clerk
    {
        String name;
        public Cleaner (String name){this.name = name;}
    }
}
