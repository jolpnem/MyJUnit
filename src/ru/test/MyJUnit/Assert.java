package ru.test.MyJUnit;

public class Assert {
    private Assert() {}

    public static void isEquals(Object p1, Object p2) {
        if (!p1.equals(p2)) throw new AssertionError(p1 + " is not equals for " + p2);
    }

    public static void isSame(Object p1, Object p2) {
        if (!(p1.hashCode() == p2.hashCode())) throw new AssertionError(p1 + " is not same for " + p2);
    }
}
