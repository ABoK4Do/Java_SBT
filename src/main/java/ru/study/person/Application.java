package ru.study.person;

public class Application {
    public static void main(String[] args) {
        Person dima = new PersonImpl(true, "Dima");
        Person lexa = new PersonImpl(true, "Lexa");
        Person sveta = new PersonImpl(false, "Sveta");
        Person dasha = new PersonImpl(false, "Dasha");

        System.out.println(dima.divorce()); //false
        System.out.println(dima.marry(lexa)); //false
        System.out.println(lexa.marry(dasha)); //true
        System.out.println(lexa.getSpouse().getName()); //Dasha
        System.out.println(dima.marry(dasha)); //false
        System.out.println(dima.divorce()); //false
        System.out.println(lexa.marry(sveta)); //false
        System.out.println(lexa.divorce()); //true
        System.out.println(lexa.divorce()); //false
    }
}
