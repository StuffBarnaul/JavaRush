package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;
    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
    public boolean equals(Object n) {
        if (n == this)
            return true;
        if(n == null)
            return false;
        if(n.getClass() != this.getClass())
            return false;
        Solution object = (Solution) n;
        if (Objects.equals(first, object.first) && Objects.equals(last, object.last))
            return true;
        else
            return false;
    }
    public int hashCode() {
        return Objects.hash(first,last);
    }
    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add( new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
