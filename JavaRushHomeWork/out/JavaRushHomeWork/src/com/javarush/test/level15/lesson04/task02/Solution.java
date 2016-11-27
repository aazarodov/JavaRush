package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {

        printMatrix(2, 3, "8");

        printMatrix(2, (Integer) 3, "8");
        printMatrix((Integer) 2, 3, "8");
        printMatrix(2, (short) 3, "8");
        printMatrix((short) 2, 3, "8");
        printMatrix(2, (byte) 3, "8");
        printMatrix((byte) 2, 3, "8");
        printMatrix((byte) 2, (short) 3, "8");
        printMatrix((short) 2, (byte) 3, "8");
    }

    public static void printMatrix(int m, int n, String value) { // 1
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, Integer n, String value) { // 2
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(Integer m, int n, String value) { // 3
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, short n, String value) { // 4
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(short m, int n, String value) { // 5
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, byte n, String value) { // 6
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(byte m, int n, String value) { // 7
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(byte m, short n, String value) { // 8
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(short m, byte n, String value) { // 9
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) { // 10
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
