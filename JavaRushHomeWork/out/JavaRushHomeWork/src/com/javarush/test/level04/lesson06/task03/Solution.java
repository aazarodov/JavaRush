package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[3];
        for (int i = 0; i < 3; i++)
            array[i] = Integer.parseInt(reader.readLine());
        for (int i = 0; i < 3; i++) {
            int temp = 0;
            for (int j = i + 1; j < 3; j++)
                if (array[i] < array[j])
                    temp = j;
            if (temp > 0) {
                int tempa = array[temp];
                array[temp] = array[i];
                array[i] = tempa;
            }
        }
        for (int i = 0; i < 3; i++)
            System.out.println(array[i]);
    }
}
