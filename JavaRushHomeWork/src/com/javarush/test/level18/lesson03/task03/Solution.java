package com.javarush.test.level18.lesson03.task03;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> mapBytes = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int _byte = 0;
        FileInputStream fileStream = new FileInputStream(fileName);
        Integer count = 0, maxCount = 0;
        while (fileStream.available() > 0) {
            _byte = fileStream.read();
            if (mapBytes.containsKey(_byte))
                count = mapBytes.get(_byte) + 1;
            else
                count = 1;
            mapBytes.put(_byte, count);
            if (maxCount < count)
                maxCount = count;
        }
        for (Map.Entry entry : mapBytes.entrySet()) {
            if (entry.getValue() == maxCount)
                System.out.print(entry.getKey().toString() + " ");
        }
    }
}
