package ru.vsu.Sorters;

import ru.vsu.Person;

import java.util.Comparator;

public class SortedByName implements Comparator<Person> {

    @Override
    public int compare(Person person, Person person1) {
        return person.getFirstName().compareTo(person1.getFirstName());
    }
}
