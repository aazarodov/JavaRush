package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int max1 = max(a, b);
        int max2 = max(c, d);

        if (max1 > max2)
            System.out.println(max1);
        else
            System.out.println(max2);
    }

    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
}
