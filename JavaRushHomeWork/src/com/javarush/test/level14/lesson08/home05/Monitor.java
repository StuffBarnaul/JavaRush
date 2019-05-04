package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Osinka on 10.07.2016.
 */
public class Monitor implements CompItem
{
    public String getName()
    {
        return new Monitor().getClass().getSimpleName();
    }
}
