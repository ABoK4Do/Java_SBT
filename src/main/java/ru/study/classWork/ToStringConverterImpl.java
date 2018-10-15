package ru.study.classWork;

import ru.study.classWork.Converter;

import java.util.List;

public class ToStringConverterImpl<T> implements Converter<String> {
    @Override
    public String converter(List<Object> o) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object oo : o) {
            stringBuilder.append(oo.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
