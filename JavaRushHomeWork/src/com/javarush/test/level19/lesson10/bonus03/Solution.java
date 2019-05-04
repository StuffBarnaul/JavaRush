package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader fr = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s=fr.readLine())!=null) {
            sb.append(s);
        }
        sb.delete(0,sb.indexOf("<")+1);
        String buffer = sb.toString();
        String[] array = buffer.split("<");
        String tag = "";
        Stack stack = new Stack();
        for (int i=0;i<array.length;i++){
            int i1 = array[i].indexOf(">");
            int i2 = array[i].indexOf(" ");
            if (i2 == -1) tag = array[i].substring(0,array[i].indexOf(">"));
            else{
                if (i1<i2){tag = array[i].substring(0,array[i].indexOf(">"));}
                else {tag = array[i].substring(0,array[i].indexOf(" "));}
            }
            System.out.print("<"+array[i]);
            if (stack.getSize() == 0) {
                stack.pop(tag);
            }
            else if (tag.equals("/"+stack.get())) stack.push();
            else stack.pop(tag);
            if (stack.getSize() == 0) System.out.println();
        }
        fr.close();
    }

    private static class Stack {
        ArrayList<String> list;
        int index;
        Stack(){
            this.list = new ArrayList<String>();
            this.index = 0;
        }
        private void pop(String s){
            list.add(s);
            index++;
        }
        private String push(){
            String s = null;
            if (index<1) try {throw new IndexOutOfBoundsException();}catch (Exception ignored) {}
            else{
            s = list.get(index-1);
            list.remove(index-1);
            index--;
            }
            return s;
        }
        private String get(){
            String s = null;
            if (index<1) try {throw new IndexOutOfBoundsException();}catch (Exception ignored) {}
            else{
                s = list.get(index-1);
            }
            return s;
        }
        private int getSize(){
            return index;
        }
    }
}
