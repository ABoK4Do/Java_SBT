package ru.study.classWork;

import java.util.List;

public interface Converter<T> {
    T converter(List<Object> o) throws IllegalAccessException;
}
