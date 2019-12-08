package ru.vsu;

import org.joda.time.Period;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainList {
    public static void main(String[] args) throws IOException {
        Person firstPerson = new Person(23, "Irina", "Chulkova", java.time.LocalDate.of(1999, Month.AUGUST, 20), Gender.FEMALE, new BigDecimal(67899), new Division(12, "F"));
        Person secondPerson = new Person(45, "Olga", "Bezrukova", java.time.LocalDate.of(1999, Month.MAY, 30), Gender.FEMALE, new BigDecimal(98764), new Division(12, "I"));
        Person thirdPerson = new Person(16, "Ivan", "Ivanov", java.time.LocalDate.of(1999, Month.MAY, 17), Gender.MALE, new BigDecimal(70098), new Division(45, "H"));
        Person fourPerson = new Person(56, "APeter", "Parker", java.time.LocalDate.of(1987, Month.APRIL, 19), Gender.MALE, new BigDecimal(1409), new Division(6, "Y"));
        Person fivePerson = new Person(11, "Jaack", "Maven", java.time.LocalDate.of(1978, Month.OCTOBER, 21), Gender.MALE, new BigDecimal(4834), new Division(11, "U"));
        Person sixPerson = new Person(45, "Jaack", "Maven", java.time.LocalDate.of(2006, Month.DECEMBER, 25), Gender.MALE, new BigDecimal(68900), new Division(8, "N"));

        LabInjector inj = new LabInjector();
        Comparator<Person> comporator = Comparator.comparing(x->x.getFirstName());
        Object object = inj.injector(new Repository<>());
        ((Repository) object).sortBy(new SortedByAge());

    }


}

