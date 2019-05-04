package com.javarush.test.level21.lesson08.task02;

import java.util.Map;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
Метод main изменять нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        protected Tree  clone() throws CloneNotSupportedException {
            Tree tree = (Tree)super.clone();
            if (this.getBranches() != null){
                String[] tt = new String[this.branches.length];
                for (int i = 0; i < this.branches.length ; i++)
                 {
                    tt[i]=this.branches[i];
                 }
                tree.branches=tt;
            } else tree.branches = null;
            return tree;
        }

        public String toString(){
            String s1 = "Name: "+this.getName()+" ";
            if (this.getBranches() != null){
                for (int i=0; i<getBranches().length; i++){
                    s1 += branches[i]+" ";
                }
            }
            return s1;
        }
    }
}
