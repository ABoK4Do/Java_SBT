package ru.study.classWork;

public class TestClass {
    int field1;
    String name;

    public TestClass(int field1, String name) {
        this.field1 = field1;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "field1=" + field1 +
                ", name='" + name + '\'' +
                '}';
    }
}
