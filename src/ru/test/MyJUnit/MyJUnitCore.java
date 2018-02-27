package ru.test.MyJUnit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyJUnitCore {
    private static Method beforeClass = null;
    private static Method beforeMethod = null;
    private static Method afterMethod = null;
    private static Method afterClass = null;
    private static final List<Method> testMethods = new ArrayList<>();

    private MyJUnitCore() {}

    @SafeVarargs
    public static <T> void test(Class<T>... types) {
        for (Class<T> type : types) {
            test(type);
        }
    }

    public static <T> void test(Class<T> type) {
        prepareData(type);

        try {
            T object = type.getConstructor().newInstance();
            if (beforeClass != null) beforeClass.invoke(object);

            for (Method testMethod : testMethods) {
                if (beforeMethod != null) beforeMethod.invoke(object);
                testMethod.invoke(object);
                if (afterMethod != null) afterMethod.invoke(object);
            }

            if (afterClass != null) afterClass.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        clear();
    }

    private static <T> void prepareData(Class<T> type) {
        for (Method method : type.getDeclaredMethods())
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                String annotationName = annotation.annotationType().getName();

                if (BeforeClass.class.getName().equals(annotationName)) beforeClass = method;
                else if (BeforeMethod.class.getName().equals(annotationName)) beforeMethod = method;
                else if (Test.class.getName().equals(annotationName)) testMethods.add(method);
                else if (AfterMethod.class.getName().equals(annotationName)) afterMethod = method;
                else if (AfterClass.class.getName().equals(annotationName)) afterClass = method;
            }
    }

    private static void clear() {
        beforeClass = null;
        beforeMethod = null;
        afterMethod = null;
        afterClass = null;
        testMethods.clear();
    }
}
