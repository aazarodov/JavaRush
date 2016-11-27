package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум
        Iterator<Integer> iterator = array.iterator();
        Integer min;
        if (iterator.hasNext()) {
            min = iterator.next();
            while (iterator.hasNext()) {
                Integer temp = iterator.next();
                if (min > temp)
                    min = temp;
            }
        }
        else
            return 0;
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //Тут создать и заполнить список
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(reader.readLine());
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            integerList.add(Integer.parseInt(reader.readLine()));
        }
        return integerList;
    }
}
