package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.print(5);
        solution.print(6);
    }

    //Напишите тут ваши методы
    public void print(int i) {
        System.out.println(i);
    }
    public void print(Integer in) {
        System.out.println(in);
    }
}
