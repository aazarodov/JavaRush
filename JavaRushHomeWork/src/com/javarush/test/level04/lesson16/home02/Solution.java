package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int array[] = new int[3];
        for (int i = 0; i < 3; i++)
            array[i] = Integer.parseInt(reader.readLine());
//        if ((array[0] >= array[1]) && (array[0] < array[2])) {
//            System.out.println(array[0]);
//        }
//        if ((array[1] >= array[0]) && (array[1] < array[2])) {
//            System.out.println(array[1]);
//        }
//        if ((array[2] >= array[0]) && (array[2] < array[1])) {
//            System.out.println(array[2]);
//        }
        if (array[0] >= array[1] && array[0] <= array[2] || array[0] <= array[1] && array[0] >= array[2]) {
            System.out.println(array[0]);
        }
        else
        if (array[1] >= array[0] && array[1] < array[2] || array[1] >= array[2] && array[1] <= array[0]) {
            System.out.println(array[1]);
        }
        if (array[2] >= array[0] && array[2] <=  array[1] || array[2] <= array[0] && array[2] >=  array[1]) {
            System.out.println(array[2]);
        }
    }
}
