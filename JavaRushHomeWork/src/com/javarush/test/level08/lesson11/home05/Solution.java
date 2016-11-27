package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        String temp, firstLetter, result = "";
        while (!s.isEmpty()) {
            if (s.substring(0, 1).equals(" ")) {
                result = result + " ";
                s = s.replaceFirst(" ", "");
            }
            else {
                int i = s.indexOf(' ');
                if (i == -1)
                    temp = s.substring(0);
                else
                    temp = s.substring(0, i);
                firstLetter = temp.substring(0, 1);
                result = result + firstLetter.toUpperCase() + temp.substring(1);
                s = s.replaceFirst(temp, "");
            }
        }
        System.out.println(result);
    }


}
