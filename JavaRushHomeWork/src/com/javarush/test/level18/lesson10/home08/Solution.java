package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if (s.equals("exit")) break;
            new ReadThread(s).start();
        }
        reader.close();
        for(Map.Entry entry: resultMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static class ReadThread  extends Thread{
        private String file;
        public ReadThread(String fileName) {
            this.file = fileName;
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream fis = new FileInputStream(new File(file));
                TreeMap<Integer, Integer> map = new TreeMap<>();
                int data;
                while (fis.available() > 0)
                {
                    data = fis.read();
                    if (map.containsKey(data))
                    {
                        int count;
                        count = map.get(data);
                        count++;
                        map.put(data, count);
                    } else map.put(data, 1);
                }
                int max = 0, symbol = 0;
                for(Map.Entry entry: map.entrySet()){
                    if ((int)entry.getValue()>max) {
                        max = (int)entry.getValue();
                        symbol = (int)entry.getKey();
                    }
                }
                resultMap.put(file,symbol);
                fis.close();
            }
            catch (IOException e) {System.out.println("Error");}
        }
    }
}
