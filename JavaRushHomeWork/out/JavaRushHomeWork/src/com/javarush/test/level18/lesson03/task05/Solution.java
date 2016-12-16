package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> listBytes = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int _byte = 0;
        FileInputStream fileStream = new FileInputStream(fileName);
        Integer count = 0, minCount = 1;
        while (fileStream.available() > 0) {
            _byte = fileStream.read();
            if (listBytes.size() == 0)
                listBytes.add(_byte);
            else if (!listBytes.contains(_byte)) {
                boolean toEnd = true;
                for (int i = 0; i < listBytes.size(); i++) {
                    if (_byte < listBytes.get(i)) {
                        listBytes.add(i, _byte);
                        toEnd = false;
                        break;
                    }
                }
                if (toEnd)
                    listBytes.add(_byte);
            }

        }
        fileStream.close();
        for (int i = 0; i < listBytes.size(); i++) {
            System.out.print(listBytes.get(i).toString() + " ");
        }
    }
}
