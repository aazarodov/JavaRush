package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args) {
        HashSet<Integer> set = createSet();
        set = removeAllNumbersMoreThan10(set);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(i);
        }
    }
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        HashSet<Integer> setInt = new HashSet<Integer>();
        setInt.add(3);
        setInt.add(4);
        setInt.add(12);
        setInt.add(6);
        setInt.add(21);
        setInt.add(45);
        setInt.add(9);
        setInt.add(7);
        setInt.add(67);
        setInt.add(78);
        setInt.add(34);
        setInt.add(89);
        setInt.add(1);
        setInt.add(2);
        setInt.add(43);
        setInt.add(41);
        setInt.add(40);
        setInt.add(8);
        setInt.add(5);
        setInt.add(0);

        return setInt;
    };

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        HashSet<Integer> setInt = new HashSet<Integer>();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i <= 10)
                setInt.add(i);
        }
        return setInt;
    }
}
