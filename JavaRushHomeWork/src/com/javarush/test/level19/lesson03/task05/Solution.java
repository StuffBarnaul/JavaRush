package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
        Customer customer = new Customer() {
            @Override public String getCompanyName()  {
                return "JavaRush Ltd.";
            }
            @Override public String getCountryName() {return countries.get("UA");}
        };
        Contact contact = new Contact()
        {
            @Override public String getName() {
                return "Ivanov, Ivan";
            }
            @Override public String getPhoneNumber() {return "+38(050)123-45-67";}
        };
        DataAdapter da = new DataAdapter(customer,contact);
        System.out.println(da.getCountryCode());        //example UA
        System.out.println(da.getCompany());            //example JavaRush Ltd.
        System.out.println(da.getContactFirstName());   //example Ivan
        System.out.println(da.getContactLastName());    //example Ivanov
        System.out.println(da.getDialString());         //example callto://+380501234567
    }
    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
        @Override
        public String getCountryCode() {
            String key = "";
            for (Map.Entry<String,String> map:countries.entrySet()) {
                if (customer.getCountryName().equals("Ukraine")) {key = map.getKey();break;}
            }
            return key;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            Scanner scanner = new Scanner(contact.getName());
            String[] s = scanner.nextLine().split(", ");
            return s[1];
        }

        @Override
        public String getContactLastName()
        {
            Scanner scanner = new Scanner(contact.getName());
            String[] s = scanner.next().split(" ");
            return s[0].substring(0,s[0].length()-1);
        }

        @Override
        public String getDialString()
        {
            String s = "callto://";
            char[] buffer = contact.getPhoneNumber().toCharArray();
            for (int i = 0;i<buffer.length;i++){
                if (buffer[i]=='('||buffer[i]==')'||buffer[i]=='-') continue;
                else s+=buffer[i];
            }
            return s;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
    public static void main(String[] args){

    }
}