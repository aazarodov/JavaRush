package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] list = new ArrayList[5];
        list[0] = new ArrayList<String>();
        list[0].add("qwe");
        list[0].add("asd");
        list[0].add("zxc");
        list[1] = new ArrayList<String>();
        list[1].add("rty");
        list[1].add("fgh");
        list[1].add("vbn");
        list[2] = new ArrayList<String>();
        list[2].add("rtyh");
        list[2].add("dfg");
        list[2].add("zf");
        list[3] = new ArrayList<String>();
        list[3].add("cxvb");
        list[3].add("fdg");
        list[3].add("rest");
        list[4] = new ArrayList<String>();
        list[4].add("dfg");
        list[4].add("ret");
        list[4].add("mghmnjgd");

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}