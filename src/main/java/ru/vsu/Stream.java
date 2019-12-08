package ru.vsu;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {

    public void first(List<Person> list){
      Map<String, Double> result =list.stream().collect(Collectors.groupingBy(x->x.getDivision().getName(),Collectors.summingDouble(x->x.getSalary().doubleValue())));
    }

    public void second(List<Person> list){
        list.stream()
                .filter(e->e.getSalary().compareTo(new BigDecimal(5000)) < 0)
                .filter(e->e.getAge()>30)
                .filter(e->e.getFirstName().toLowerCase().contains("a"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void third(List<Person> list){
        list.stream()
                .filter(e->e.getFirstName().toLowerCase().contains("aa"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void four(List<Person> list){
        Map<Integer, Long> fourMap = list.stream().collect(Collectors.groupingBy(Person::getYear, Collectors.counting()));

        for (Map.Entry<Integer, Long> pair : fourMap.entrySet()) {
            Integer key = pair.getKey();
            Long value = pair.getValue();
            System.out.println(key+"  "+value);
        }
    }
}
