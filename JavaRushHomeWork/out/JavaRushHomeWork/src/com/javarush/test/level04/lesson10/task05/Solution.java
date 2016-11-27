package com.javarush.test.level04.lesson10.task05;

import java.io.*;

/* Таблица умножения
Вывести на экран таблицу умножения 10х10 используя цикл while.
Числа разделить пробелом.
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int row = 1;
        while (row < 11) {
            int col = 1;
            while (col < 11) {
                System.out.print(row * col);
                System.out.print(" ");
                col++;
            }
            System.out.println();
            row++;
        }

    }
}
