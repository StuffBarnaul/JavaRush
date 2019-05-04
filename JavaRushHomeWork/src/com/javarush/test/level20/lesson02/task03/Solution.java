package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String args[]) throws IOException{
        Solution s = new Solution();
        s.fillInPropertiesMap();
    }
    public void fillInPropertiesMap() throws IOException{
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            reader.close();
            InputStream inputStream = new FileInputStream(filename);
            load(inputStream);
            inputStream.close();
        }
        catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties saveProperties = new Properties();
        for (Map.Entry<String, String> map : properties.entrySet()) {
            saveProperties.setProperty(map.getKey(), map.getValue());
        }
        saveProperties.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties proper = new Properties();
        proper.load(inputStream);
        for (Map.Entry map:proper.entrySet()){
            String key = (String) map.getKey();
            properties.put(key, proper.getProperty(key));
        }
    }
}
