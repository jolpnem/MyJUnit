package ru.test;

public class Calculator {
    private Calculator() {}

    public static long add(long a, long b) {
        return a + b;
    }

    public static long subtract(long a, long b) {
        return a - b;
    }

    public static long multiple(long a, long b) {
        return a * b;
    }

    public static long devise(long a, long b) {
        return a / b;
    }
}
