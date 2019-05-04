package com.javarush.test.level11.lesson06.task04;

/* Все мы работники
Написать четыре класса: Employee(сотрудник), Manager(управляющий), Chief(директор) и  Secretary(секретарь).
Унаследовать управляющего, директора и секретаря от сотрудника.
*/

public class Solution
{
    public class Manager extends Employee
    {
        String name;
        public Manager (String name){this.name = name;}
    }

    public class Chief extends Employee
    {
        String name;
        public Chief (String name){this.name = name;}
    }

    public class Employee
    {
        String name;
    }

    public class Secretary extends Employee
    {
        String name;
        public Secretary (String name){this.name = name;}
    }
}
