package com.javarush.test.my;

/**
 * Created by Baloo on 25.05.2016.
 */
public class SomeClass {
    public static void main(String[] args) {
        SomeClass c = new SomeChild2();
        ((SomeClass)c).print();
        ((SomeChild1)c).print();
        ((SomeChild2)c).print();
    }
    public void print() {
        System.out.println("SomeClass");
    }
}
class SomeChild1 extends SomeClass {
    public void print() {
        System.out.println("SomeChild1");
    }
}
class SomeChild2 extends SomeClass {
    public void print() {
        System.out.println("SomeChild2");
    }
}
