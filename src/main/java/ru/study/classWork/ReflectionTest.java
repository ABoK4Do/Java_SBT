package ru.study.classWork;

import java.lang.reflect.Field;

public class ReflectionTest {
    public static void printAllFields(Object o) throws IllegalAccessException {
        Class<?> clazz = o.getClass();
        for(Field field: clazz.getDeclaredFields()){
            field.setAccessible(true);
            System.out.println(field.getName() + "=" + field.get(o));
        }
    }
}


