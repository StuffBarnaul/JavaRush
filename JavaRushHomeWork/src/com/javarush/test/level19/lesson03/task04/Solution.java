package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;
        public PersonScannerAdapter(Scanner sc){
            this.scanner = sc;
        }
        @Override
        public Person read() throws IOException
        {
            String[] s = scanner.nextLine().split(" ");
            GregorianCalendar date = new GregorianCalendar(Integer.parseInt(s[5]), Integer.parseInt(s[4])-1, Integer.parseInt(s[3]));
            Person person = new Person(s[1], s[2], s[0], date.getTime());
            return person;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
    public static void main(String args[]) throws IOException{
        File file = new File("D:\\Java\\JavaRushHomeWork\\3");
        Scanner sc = new Scanner(file);
        PersonScannerAdapter psa = new PersonScannerAdapter(sc);
        psa.read();
    }
}
