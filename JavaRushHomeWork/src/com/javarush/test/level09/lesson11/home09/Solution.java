package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("Васька", new Cat("Васька"));
        map.put("Кузька", new Cat("Кузька"));
        map.put("Музька", new Cat("Музька"));
        map.put("Тишка", new Cat("Тишка"));
        map.put("Пышка", new Cat("Пышка"));
        map.put("Сосиска", new Cat("Сосиска"));
        map.put("Тушка", new Cat("Тушка"));
        map.put("Пыжик", new Cat("Пыжик"));
        map.put("Рыжик", new Cat("Рыжик"));
        map.put("Тузик", new Cat("Тузик"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<Cat>();
        for(Map.Entry<String, Cat> entry : map.entrySet())
            set.add(entry.getValue());
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
