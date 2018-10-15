package ru.study.classWork;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        //new ReflectionTest().printAllFields(String.class)
        List<Object> list = new LinkedList<>();
        list.add(new TestClass(1, "one"));
        list.add(new TestClass(2, "two"));
        System.out.println(new ToXmlConverterImpl<>().converter(list));
    }
}
