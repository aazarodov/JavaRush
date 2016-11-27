package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        System.out.println(NOD(x, y));
    }

    public static int NOD(int a, int b) {
        if (a != 0 && b != 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
            return NOD(a, b);
        } else
            return a + b;
    }
}
