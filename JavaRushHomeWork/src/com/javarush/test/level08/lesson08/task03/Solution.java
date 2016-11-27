package com.javarush.test.level08.lesson08.task03;

import java.util.*;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, String> mapString = createMap();
        System.out.println(getCountTheSameFirstName(mapString, "Иванов"));
        System.out.println(getCountTheSameLastName(mapString, "Федор"));
    }

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> mapString = new HashMap<String, String>();
        mapString.put("Иванов", "Коля");
        mapString.put("Петров", "Петя");
        mapString.put("Сидоров", "Вася");
        mapString.put("Ковров", "Толя");
        mapString.put("Вьюшкин", "Петя");
        mapString.put("Капустин", "Федор");
        mapString.put("Сечкин", "Максим");
        mapString.put("Киприянов", "Саша");
        mapString.put("Васин", "Федор");
        mapString.put("Валуев", "Петр");

        return mapString;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getValue().equals(name))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getKey().equals(lastName))
                count++;
        }
        return count;
    }
}
