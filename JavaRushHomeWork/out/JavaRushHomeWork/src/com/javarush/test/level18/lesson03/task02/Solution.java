package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int minByte, temp;
        FileInputStream fileStream = new FileInputStream(fileName);
        minByte = fileStream.read();
        while (fileStream.available() > 0) {
            temp = fileStream.read();
            if (temp < minByte)
                minByte = temp;
        }
        System.out.println(minByte);
        fileStream.close();
    }
}
