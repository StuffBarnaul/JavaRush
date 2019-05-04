package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Arrays.asList;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main (String[] args) {
        try {
            String[] result = getTokens("level22.lesson13.task01", ".");
            System.out.println(result);
        }catch (Exception e){e.printStackTrace();}
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query,delimiter);
        List list = new ArrayList();
        while (st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }
}
