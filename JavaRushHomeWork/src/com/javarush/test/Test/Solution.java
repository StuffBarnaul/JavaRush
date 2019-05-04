package com.javarush.test.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
Обращенные слова
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();
        Scanner scanner = new Scanner(file).useDelimiter(" ");
        ArrayList<String> allStrings = new ArrayList<>();
        while (scanner.hasNext())
        {
            allStrings.add(scanner.next());
        }
        for (int i = 0; i < allStrings.size(); i++)
        {
            String current = allStrings.get(i);
            for (int y = i + 1; y < allStrings.size(); y++)
            {
                String reverse = new StringBuilder(allStrings.get(y)).reverse().toString();
                if (current.equals(reverse))
                {
                    Pair p = new Pair();
                    p.first = current;
                    p.second = allStrings.get(y);
                    result.add(p);
                    break;
                }
            }
        }
        LinkedHashSet<Pair> uniq = new LinkedHashSet<>(result);
        result = new LinkedList<>(uniq);
        for (Pair p : result)
        {
            System.out.println(p.first + " " + p.second);
        }
    }

    public static class Pair
    {
        String first;
        String second;

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;
        }

        @Override
        public int hashCode()
        {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString()
        {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }
}