package ru.study.homeWork.countmap;

import java.util.HashMap;
import java.util.Map;

public class CountMapIml<E> implements CountMap<E> {
    final private HashMap<E, Integer> hashMap = new HashMap<>();

    @Override
    public void add(E o) {
        hashMap.put(o, getCount(o) + 1);
    }

    @Override
    public int getCount(E o) {
        return hashMap.getOrDefault(o, 0);
    }

    @Override
    public int remove(E o) {
        Integer count = hashMap.remove(o);
        if (count == null) count = 0;
        return count;
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {
        for (Map.Entry<? extends E, Integer> entry : source.toMap().entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue() + getCount(entry.getKey()));
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        return hashMap;
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        destination.putAll(hashMap);
    }
}
