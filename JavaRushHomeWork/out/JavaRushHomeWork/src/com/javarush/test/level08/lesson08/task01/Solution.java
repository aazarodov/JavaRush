package com.javarush.test.level08.lesson08.task01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("Лава");
        hashSet.add("Лажа");
        hashSet.add("Лак");
        hashSet.add("Лама");
        hashSet.add("Ларец");
        hashSet.add("Лев");
        hashSet.add("Легенда");
        hashSet.add("Лед");
        hashSet.add("Лесть");
        hashSet.add("Лиса");
        hashSet.add("Логово");
        hashSet.add("Лодырь");
        hashSet.add("Лук");
        hashSet.add("Любовь");
        hashSet.add("Липа");
        hashSet.add("Лупа");
        hashSet.add("Люстра");
        hashSet.add("Луг");
        hashSet.add("Лига");
        hashSet.add("Лакрица");

        return hashSet;
    }
}
