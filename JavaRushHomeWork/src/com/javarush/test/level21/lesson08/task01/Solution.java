package com.javarush.test.level21.lesson08.task01;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
Метод main изменять нельзя.
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        protected User clone() throws CloneNotSupportedException
        {
            int age = this.age;
            String name = this.name;
            User user = new User(age,name);
            return user;
        }

        public String toString(){
            return "Age = "+this.age+" ,name: "+this.name;
        }
    }

    protected Solution clone() throws CloneNotSupportedException
    {
        Solution sol = new Solution();
        for (Map.Entry entry: this.users.entrySet()){
            String s = (String) entry.getKey();
            User user = (User) entry.getValue();
            User u1 = user.clone();
            sol.users.put(s,u1);
        }
        return sol;
    }

    public String toString(){
        String s1 = null;
        for (Map.Entry entry: this.users.entrySet()){
            String s = "Name: "+entry.getKey()+" ,user: "+entry.getValue().toString()+" ";
            s1 += s;
        }
        return s1;
    }

}
