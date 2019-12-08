package ru.vsu;

import java.util.Comparator;

public interface ISorted<T> {

    Object[] sort(Object[] array, Comparator<T> comparator);
}
