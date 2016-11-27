package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import java.math.BigDecimal;

public class Solution {
    public Solution(Object o) {};
    public Solution(String s) {};
    public Solution(Integer i) {};

    protected Solution(Long l) {};
    protected Solution(Short sh) {};
    protected Solution(Double d) {};

    private Solution(Character c) {};
    private Solution(Boolean b) {};
    private Solution(float f) {};

    Solution(Exception e) {};
    Solution(Number n) {};
    Solution(BigDecimal bd) {};
}

