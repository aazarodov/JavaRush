package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {
        long curTime = System.currentTimeMillis();

        //Date curDate = new Date(curTime);
        String curStringDate = new SimpleDateFormat("dd MM yyyy").format(curTime);
        System.out.println(curStringDate);
    }
}
