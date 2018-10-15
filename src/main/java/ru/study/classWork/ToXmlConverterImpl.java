package ru.study.classWork;

import java.lang.reflect.Field;
import java.util.List;

public class ToXmlConverterImpl<T> implements Converter<String> {
    @Override
    public String converter(List<Object> list) throws IllegalAccessException {
        if (list.isEmpty()) return null;
        Class<?> clazz = list.get(0).getClass();
        if (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            StringBuilder stringBuilder = new StringBuilder("<root-" + clazz.getSimpleName() + ">").append("\n");
            for (Object o : list) {
                stringBuilder.append("\t").append("<").append(clazz.getSimpleName()).append(">").append("\n");
                for (Field field : fields) {
                    field.setAccessible(true);
                    stringBuilder.append("\t\t").append("<").append(field.getName()).append(">");
                    stringBuilder.append(field.get(o));
                    stringBuilder.append("</").append(field.getName()).append(">").append("\n");
                }
                stringBuilder.append("\t").append("</").append(clazz.getSimpleName()).append(">").append("\n");

            }
            stringBuilder.append("</root-").append(clazz.getSimpleName()).append(">");
            return stringBuilder.toString();
        } else return null;

    }
}
