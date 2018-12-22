package ru.study.homeWork.person;

public interface Person {
    Person getSpouse();

    boolean getMan();

    String getName();

    void setSpouse(Person person);

    boolean marry(Person person);

    boolean divorce();
}
