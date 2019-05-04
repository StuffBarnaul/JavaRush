package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Osinka on 11.07.2016.
 */
public class Singleton
{
    private static Singleton singleton;
    private Singleton()
    {
    }

    public static Singleton getInstance()
    {
        return singleton;
    }
}
