package ru.vsu;

import java.util.Comparator;

public class BubbleSort<T> implements ISorted<T> {
    @Override
    public Object[] sort(Object[] array, Comparator<T> comparator) {
        boolean isSorted = false;
        T buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (comparator.compare((T)array[i], (T)array[i + 1]) >= 1) {
                    isSorted = false;
                    buf = (T)array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;

                }
            }
        }
        return array;
    }
}
