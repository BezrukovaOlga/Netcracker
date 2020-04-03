package ru.vsu.Sorters;

import java.util.Comparator;

public class InsertionSort<T> implements ISorted<T> {
    @Override
    public Object[] sort(Object[] array, Comparator<T> comparator) {
        for (int i = 1; i < array.length; i++) {
            T current = (T)array[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(current, (T)array[j]) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        return array;
    }
}
