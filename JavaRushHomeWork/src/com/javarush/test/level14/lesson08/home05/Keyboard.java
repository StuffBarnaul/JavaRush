package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Osinka on 10.07.2016.
 */
public class Keyboard implements CompItem
{
    public String getName()
    {
        return new Keyboard().getClass().getSimpleName();
    }
}
