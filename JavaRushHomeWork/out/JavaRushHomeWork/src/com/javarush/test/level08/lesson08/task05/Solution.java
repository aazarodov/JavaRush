package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
//    public static void main(String[] args) {
//        HashMap<String, String> mapString = createMap();
//        removeTheFirstNameDuplicates(mapString);
//        for(Map.Entry<String, String> pair : mapString.entrySet())
//            System.out.println(pair.getKey() + " - " + pair.getValue());
//    }

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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        ArrayList<String> arrayName = new ArrayList<String>();
        //напишите тут ваш код
        for (String name : map.values()){
            int count = 0;
            for (String name1 : map.values()) {
                if (name.equals(name1))
                    count++;
            }
            if (count > 1 && !arrayName.contains(name))
                arrayName.add(name);
        }
        for(String name : arrayName)
            removeItemFromMapByValue(map, name);
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
