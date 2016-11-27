package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Integer> arrayListOfInt = new ArrayList<Integer>();
        ArrayList<Integer> arrayListOfEven = new ArrayList<Integer>();

        File file = new File(fileName);
        BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        StringBuilder sb = new StringBuilder();
        String s;
        Integer x;
        while ((s = in.readLine()) != null) {
            x = Integer.parseInt(s);
            if (x % 2 == 0)
                arrayListOfInt.add(x);
        }

        for(Integer i : arrayListOfInt) {
            if (arrayListOfEven.size() == 0) {
                arrayListOfEven.add(i);
            }
            else {
                for (int index = 0; index < arrayListOfEven.size(); index++) {
                    if (index == (arrayListOfEven.size() - 1)) {
                        if (arrayListOfEven.get(index) > i)
                            arrayListOfEven.add(index, i);
                        else
                            arrayListOfEven.add(i);
                        break;
                    }
                    else
                        if (arrayListOfEven.get(index) > i) {
                            arrayListOfEven.add(index, i);
                            break;
                        }
                }
            }
        }
        for(Integer i : arrayListOfEven) {
            System.out.println(i);
        }
    }
}
