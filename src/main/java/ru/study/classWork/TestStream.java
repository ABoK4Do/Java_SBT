package ru.study.classWork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TestStream {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = TestStream.class.getClassLoader();
        Path path = new File(classLoader.getResource("classWork/input1.txt").getFile()).toPath();
        Map<String, Long> map = Files
                .readAllLines(path)
                .stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .collect(groupingBy(String::toString, Collectors.counting()));
        System.out.println(map);
    }
}
