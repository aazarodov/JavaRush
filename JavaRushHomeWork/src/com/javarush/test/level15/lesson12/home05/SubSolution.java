package com.javarush.test.level15.lesson12.home05;

import java.math.BigDecimal;

/**
 * Created by zarodov on 07.11.2016.
 */
public class SubSolution extends Solution {
    public SubSolution(Object o) {
        super(o);
    }
    public SubSolution(String s) {
        super(s);
    }
    public SubSolution(Integer l) {
        super(l);
    }

    protected SubSolution(Long l) {
        super(l);
    }
    protected SubSolution(Short sh) {
        super(sh);
    }
    protected SubSolution(Double d) {
        super(d);
    }

    private SubSolution(Character c) {
        super(c);
    }
    private SubSolution(Boolean b) {
        super(b);
    }
    private SubSolution(float f) {
        super(f);
    }

    SubSolution(Exception e) {
        super(e);
    }
    SubSolution(Number n) {
        super(n);
    }
    SubSolution(BigDecimal bd) {
        super(bd);
    }
}
