package ru.test;

import ru.test.MyJUnit.MyJUnitCore;
import test.CalculatorTest;

class Main {

    public static void main(String[] args) {
        MyJUnitCore.test(CalculatorTest.class);
        MyJUnitCore.test(CalculatorTest.class);
        System.out.println("Success");
    }
}
