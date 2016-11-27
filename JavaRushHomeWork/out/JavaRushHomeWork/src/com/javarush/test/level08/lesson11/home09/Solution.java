package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) {

    }

    public static boolean isDateOdd(String date)  {
        Date dateFromString = new Date(date);

        Date yearStartTime = new Date(date);

        yearStartTime.setDate(0);      // первое число
        yearStartTime.setMonth(0);

        long msTimeDistance = dateFromString.getTime() - yearStartTime.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней

        if (dayCount%2 == 0)
            return false;
        else
            return true;
    }
}
