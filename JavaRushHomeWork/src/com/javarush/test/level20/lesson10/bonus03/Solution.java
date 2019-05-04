package com.javarush.test.level20.lesson10.bonus03;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<Word>();
        int width = crossword[0].length;
        int heigth = crossword.length;
        for (int k=0;k<words.length;k++) {
            Word currentWord = new Word(words[k]);
            boolean b = false;
            char[] cwca = words[k].toCharArray();
            int len = cwca.length-1;
            for (int i = 0; i < heigth; i++) {
                for (int j = 0; j < width; j++) {
                    //System.out.println("("+i+","+j+") "+(char)crossword[i][j]);
                    if (crossword[i][j] == cwca[0]){
                        if (isHere(crossword,i,j,-1,-1,cwca)) {currentWord.setStartPoint(j,i); currentWord.setEndPoint(j+len*(-1),i+len*(-1));b = true;}
                        if (isHere(crossword,i,j,-1,0,cwca)) {currentWord.setStartPoint(j,i); currentWord.setEndPoint(j+len*(0),i+len*(-1));b = true;}
                        if (isHere(crossword,i,j,-1,1,cwca)) {currentWord.setStartPoint(j,i); currentWord.setEndPoint(j+len*(1),i+len*(-1));b = true;}
                        if (isHere(crossword,i,j,0,-1,cwca)) {currentWord.setStartPoint(j,i); currentWord.setEndPoint(j+len*(-1),i+len*(0));b = true;}
                        if (isHere(crossword,i,j,0,1,cwca)) {currentWord.setStartPoint(j,i); currentWord.setEndPoint(j+len*(1),i+len*(0));b = true;}
                        if (isHere(crossword,i,j,1,-1,cwca)) {currentWord.setStartPoint(j,i); currentWord.setEndPoint(j+len*(-1),i+len*(1));b = true;}
                        if (isHere(crossword,i,j,1,0,cwca)) {currentWord.setStartPoint(j,i); currentWord.setEndPoint(j+len*(0),i+len*(1));b = true;}
                        if (isHere(crossword,i,j,1,1,cwca)) {currentWord.setStartPoint(j,i); currentWord.setEndPoint(j+len*(1),i+len*(1));b = true;}
                    }
                }
            }
            if (b) list.add(currentWord);
        }
        return list;
    }

    public static boolean isHere (int[][] crossword,int si, int sj, int di,int dj,char[] cwca){
        boolean result = false;
        boolean b = true;
        int width = crossword[0].length;
        int heigth = crossword.length;
        for (int i=1;i<cwca.length;i++){
            if (si+di>=0 && si+di<width && sj+dj>=0 && sj+dj<heigth){
                if (cwca[i] == (char)crossword[si+di][sj+dj]){
                    if (i == cwca.length-1) result = true;
                } else break;
            }
            si+=di;sj+=dj;
        }
        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
