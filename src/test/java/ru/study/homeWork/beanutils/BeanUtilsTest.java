package ru.study.homeWork.beanutils;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class BeanUtilsTest {

    @Test
    public void successTest() throws InvocationTargetException, IllegalAccessException {
        TestClassFrom from = new TestClassFrom();
        from.setName("From");
        from.setCount(1);
        from.setPrice(10.);

        TestClassTo to = new TestClassTo();
        to.setName("To");
        to.setCount(2);
        to.setValue(20.);

        BeanUtils.assign(to, from);

        assertEquals("From", to.getName());
        assertEquals(1, to.getCount());
        assertEquals(20., to.getValue(), 0.0001);
    }
}
