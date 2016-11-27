package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        for (int row = 1; row < 11; row++)
        {
            for (int col = 1; col < 11; col++)
            {
                int composition = row * col;
                System.out.print(composition + " ");
            }
            System.out.println();
        }
    }
}