package ru.study.homeWork.person;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonImplTest {
    private Person dima;
    private Person lexa;
    private Person nasta;
    private Person dasha;

    @Before
    public void init() {
        dima = new PersonImpl(true, "Dima");
        lexa = new PersonImpl(true, "Lexa");
        nasta = new PersonImpl(false, "Nasta");
        dasha = new PersonImpl(false, "Dasha");
    }

    //Обычный сценарий, женить
    @Test
    public void testCase_1_1() {
        assertTrue(dima.marry(nasta));
    }

    //Обычный сценарий, развести
    @Test
    public void testCase_1_2() {
        dima.marry(nasta);
        assertTrue(dima.divorce());
    }

    //Одинаковый пол
    @Test
    public void testCase_2() {
        assertFalse(dima.marry(lexa));
        assertFalse(nasta.marry(dasha));
    }

    //Развести неженатого
    @Test
    public void testCase_3() {
        assertFalse(dima.divorce());
    }

    //Дважды женить
    @Test
    public void testCase_4() {
        assertTrue(dima.marry(nasta));
        assertFalse(dima.marry(dasha));
    }

    //Проверить имя
    @Test
    public void testCase_5() {
        lexa.marry(dasha);
        assertEquals("Dasha", lexa.getSpouse().getName());
    }
}
