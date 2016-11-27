package com.javarush.test.level07.lesson06.task01;

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        list.add(0, "Qqwerty");
        list.add(1, "Asdfgh");
        list.add(2, "Zxcvbn");
        list.add(3, "Poiuyt");
        list.add(4, "Lkjhgf");
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}
