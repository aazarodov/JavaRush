package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> maxStringList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
        {
            list.add(i, reader.readLine());
        }
        String maxString = list.get(0);
        maxStringList.add(0, maxString);
        int maxLength = maxString.length();
        for (int i = 1; i < 5; i++)
        {
            String currentValue = list.get(i);
            if (maxLength < currentValue.length()) {
                maxStringList.clear();
                maxStringList.add(0, currentValue);
                maxLength = currentValue.length();
            }
            else
                if (maxLength == currentValue.length())
                    maxStringList.add(maxStringList.size() - 1, currentValue);
        }
        for (int i = 0; i < maxStringList.size(); i++)
        {
            System.out.println(maxStringList.get(i));
        }
    }
}
