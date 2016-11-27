package com.javarush.test.level03.lesson03.task02;

/* Конвертер валют
Реализуйте метод convertEurToUsd, переводящий евро в доллары по заданному курсу.
Вызовите его дважды в методе main с любыми параметрами. Результаты выведите на экран, каждый раз с новой строки.
Подсказка:
Расчет выполняется по формуле: долларСША = евро * курс
*/
public class Solution
{
    public static void main(String[] args) {
        double dollar1 = convertEurToUsd(10, 1.1);
        System.out.println(dollar1);
        double dollar2 = convertEurToUsd(15, 1.1);
        System.out.println(dollar2);
    }

    public static double convertEurToUsd(int eur, double course){
        double dollar = eur * course;
        return  dollar;
    }
}
