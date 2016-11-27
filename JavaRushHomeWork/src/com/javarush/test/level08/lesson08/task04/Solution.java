package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Петров", new Date("JUNE 1 1980"));
        map.put("Сидиров", new Date("JULY 5 1989"));
        map.put("Васин", new Date("JUNE 1 1996"));
        map.put("Петин", new Date("JUNE 1 1975"));
        map.put("Колин", new Date("JUNE 1 1991"));
        map.put("Коровин", new Date("JUNE 1 1969"));
        map.put("Бычкин", new Date("JUNE 1 1992"));
        map.put("Корчагин", new Date("MAY 3 1985"));
        map.put("Рыжков", new Date("JANUARY 2 1986"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        HashMap<String, Date> resultMap = new HashMap<String, Date>();

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            if (value.getMonth() < 5 || pair.getValue().getMonth() > 7)
                resultMap.put(pair.getKey(), value);
        }
        map.clear();
        map.putAll(resultMap);
    }
}
