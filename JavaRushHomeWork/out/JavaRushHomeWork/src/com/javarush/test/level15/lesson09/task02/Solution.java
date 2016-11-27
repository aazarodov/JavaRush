package com.javarush.test.level15.lesson09.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Статики 2
1. В статическом блоке считайте две переменные с консоли А и В с типом int.
2. Не забыть про IOException, который надо обработать в блоке catch.
3. Закрыть поток ввода методом close().
*/

public class Solution {
    public static int A;
    public static int B;

    static  {
        String err = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            err = "В качестве A было введено не число!";
            A = Integer.parseInt(reader.readLine());
            err = "В качестве B было введено не число!";
            B = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException exc) {
            System.out.println(err);
        }
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
