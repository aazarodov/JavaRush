package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine(), fileName2 = reader.readLine();

        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        byte[] bufferRead = new byte[file1.available()];
        byte[] bufferWrite = new byte[file1.available()];
        file1.read(bufferRead);
        for(int i = bufferRead.length - 1; i >= 0; i--)
            bufferWrite[bufferRead.length - i - 1] = bufferRead[i];
        file2.write(bufferWrite);

        reader.close();
        file1.close();
        file2.close();
    }
}
