package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char[] s1 = new char[s.length()];
        for(int i=0;i<40;i++)
        {
            if (i==0) {s.getChars(i,s.length()-i,s1,0);}
            else {s.getChars(i,s.length(),s1,0);}
            System.out.println(s1);
            for(int j=0;j<47;j++) {s1[j]=' ';}
        }
    }

}
