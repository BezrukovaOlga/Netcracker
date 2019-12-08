package ru.vsu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LabInjector {
    Object obj = null;
    public <T> T injector(T object) {
        try {
            Class<?> clazz = object.getClass();
            System.out.println(object.getClass());
            Field[] field = clazz.getDeclaredFields();
            for (Field f : field) {
                if (f.isAnnotationPresent(Injector.class)) {
                    f.setAccessible(true);
                    Class fieldType = f.getType();
                    Class cl = fieldType.forName("ru.vsu.BubbleSort");
                    obj = cl.newInstance();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return (T)obj;
    }
}
