package com.javarush.test.level13.lesson11.bonus02;

public class Person implements RepkaItem
{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh)
    {
        this.name = name;
        this.namePadezh = namePadezh;
    }
    public String getNamePadezh()
    {
        return namePadezh;
    }
    //В классе Person реализовать метод pull(Person person), который выводит фразу типа '<name> за <person>'.
    public void pull (Person person)
    {
        System.out.println(name+" за "+person.getNamePadezh());
    }
}
