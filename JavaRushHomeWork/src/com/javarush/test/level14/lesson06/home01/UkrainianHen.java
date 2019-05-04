package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Osinka on 10.07.2016.
 */
public class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth(){return 1;}
    public String getDescription(){return super.getDescription()+" Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";}
}
