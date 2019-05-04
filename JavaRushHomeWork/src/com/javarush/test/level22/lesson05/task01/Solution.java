package com.javarush.test.level22.lesson05.task01;

import java.io.IOException;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main (String[] args) throws TooShortStringException{
        String s = "JavaRush - лучший сервис обучения Java.";
        String s1 = getPartOfString(s);
        System.out.println(s1);
    }
    public static String getPartOfString(String string) throws TooShortStringException
    {
        int i = 0, spacecount = 0, sPos = 0,ePos = 0, l = string.length();
        boolean b = true;
        while(b){
            if (string.charAt(i)==' '){
                if (spacecount > 0) spacecount++;
                if (spacecount == 0) {sPos = i; spacecount++;}
                if (spacecount == 5) {ePos = i; b = false;}
            }
            i++;
            if (i==l) b=false;
        }
        if (spacecount == 5) return string.substring(sPos+1,ePos);
        else throw new TooShortStringException();
    }

    public static class TooShortStringException extends Exception{
    }
}
