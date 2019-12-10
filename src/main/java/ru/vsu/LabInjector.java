package ru.vsu;

import java.lang.reflect.Field;

import java.util.Iterator;
import java.util.Map;

public class LabInjector {

    public <T> void injector(T object) throws JavaException {
        T obj = null;
        try {
            Class<?> clazz = object.getClass();
            Field[] field = clazz.getDeclaredFields();
            for (Field f : field) {
                if (f.isAnnotationPresent(Injector.class)) {
                    f.setAccessible(true);
                    Class cl = Class.forName(classNameSearch(f.getType().getName()));
                    obj = (T) cl.newInstance();
                    f.set(object, obj);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new JavaException(e);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new JavaException(e);
        }

    }

    private String classNameSearch(String inputFieldType){
        WorkWithFile file = new WorkWithFile();
        Map<String, String> map = file.toMap();
        Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
        boolean flag = true;
        String nameOfClass = null;
        while (itr.hasNext() && flag) {
            Map.Entry<String, String> next = itr.next();
            String n = next.getValue();
            if (n.equals(inputFieldType)) {
                nameOfClass = next.getKey();
                flag = false;
            }
        }
        return nameOfClass;
    }
}
