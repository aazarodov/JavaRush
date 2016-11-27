package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int array[] = new int[3];
        for (int i = 0; i < 3; i++)
            array[i] = Integer.parseInt(reader.readLine());

        for (int i = 0; i < 3; i++) {
            int a = array[i];
            int count = 1;
            for (int j = 0; j < 3; j++) {
                if (a == array[j])
                    count++;
            }
            if (count == 2) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
