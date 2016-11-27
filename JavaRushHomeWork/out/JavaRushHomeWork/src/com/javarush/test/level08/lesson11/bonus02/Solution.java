package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        Map<String, List<String>> addresses = new HashMap<String, List<String>>();
        while (true)
        {
            //System.out.println("Введите город:");
            String country = reader.readLine();
            if (country.isEmpty()) break;

            List<String> listFamily = addresses.get(country);
            if (listFamily == null) {
                listFamily = new ArrayList<String>();
                addresses.put(country, listFamily);
            }
//            while (true) {
//                System.out.println("Введите фамилию:");
                String family = reader.readLine();
                if (family.isEmpty()) break;
                listFamily.add(family);
            //}
        }

        //read home number
        //System.out.println("Введите город:");
        String county = reader.readLine();
        List<String> listFamily = addresses.get(county);

        for (int i = 0; i < listFamily.size(); i++) {
            System.out.println(listFamily.get(i));
        }
    }
}
