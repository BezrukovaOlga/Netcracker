import org.junit.jupiter.api.Test;
import ru.vsu.Division;
import ru.vsu.Person;
import ru.vsu.Repository;
import ru.vsu.SortedByName;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void add() {
        Repository<Person> expected = new Repository<Person>();
        Person firstPerson = new Person(23, "Irina", "Chulkova", java.time.LocalDate.of(1999, Month.AUGUST, 20), Gender.FEMALE, new BigDecimal(67899), new Division(12, "F"));
        Person secondPerson = new Person(45, "Olga", "Bezrukova", java.time.LocalDate.of(1999, Month.MAY, 30), Gender.FEMALE, new BigDecimal(98764), new Division(12,"I"));
        Person thirdPerson = new Person(16, "Ivan", "Ivanov", java.time.LocalDate.of(1999, Month.MAY, 17), Gender.MALE, new BigDecimal(70098), new Division(45,"H"));
        expected.add(firstPerson);
        expected.add(secondPerson);
        expected.add(thirdPerson);
        Person[] persons = new Person[3];
        persons[0]=firstPerson;
        persons[1]=secondPerson;
        persons[2]=thirdPerson;
        Repository actual = new Repository(persons);
        assertEquals(actual,expected);
    }

    @Test
    void delete() {
        Repository actual = new Repository();
        Person firstPerson = new Person(23, "Irina", "Chulkova", java.time.LocalDate.of(1999, Month.AUGUST, 20), Gender.FEMALE, new BigDecimal(67899), new Division(12, "F"));
        Person secondPerson = new Person(45, "Olga", "Bezrukova", java.time.LocalDate.of(1999, Month.MAY, 30), Gender.FEMALE, new BigDecimal(98764), new Division(12,"I"));
        Person thirdPerson = new Person(16, "Ivan", "Ivanov", java.time.LocalDate.of(1999, Month.MAY, 17), Gender.MALE, new BigDecimal(70098), new Division(45,"H"));
        Person fourPerson = new Person(12,"Peter", "Parker", java.time.LocalDate.of(1991, Month.APRIL, 19),  Gender.MALE,new BigDecimal(45666), new Division(5,"I"));
        actual.add(firstPerson);
        actual.add(secondPerson);
        actual.add(thirdPerson);
        actual.add(fourPerson);
        actual.delete(2);
        Repository expected = new Repository();
        expected.add(firstPerson);
        expected.add(secondPerson);
        expected.add(fourPerson);
        assertEquals(actual,expected);

    }

    @Test
    void set() {
        Repository actual = new Repository();
        Person firstPerson = new Person(23, "Irina", "Chulkova", java.time.LocalDate.of(1999, Month.AUGUST, 20), Gender.FEMALE, new BigDecimal(67899), new Division(12, "F"));
        Person secondPerson = new Person(45, "Olga", "Bezrukova", java.time.LocalDate.of(1999, Month.MAY, 30), Gender.FEMALE, new BigDecimal(98764), new Division(12,"I"));
        Person thirdPerson = new Person(16, "Ivan", "Ivanov", java.time.LocalDate.of(1999, Month.MAY, 17), Gender.MALE, new BigDecimal(70098), new Division(45,"H"));
        Person fourPerson = new Person(12,"Peter", "Parker", java.time.LocalDate.of(1991, Month.APRIL, 19),  Gender.MALE,new BigDecimal(45666), new Division(5,"I"));
        actual.add(firstPerson);
        actual.add(thirdPerson);
        actual.set(1,secondPerson);
        Repository expected = new Repository();
        expected.add(firstPerson);
        expected.add(secondPerson);
        assertEquals(actual,expected);

    }


    @Test
    void empty() {
        Repository actual = new Repository();
        boolean expected = true;
        assertEquals(actual.empty(),expected);
    }

    @Test
    void searchBy() {
        Person firstPerson = new Person(23, "Irina", "Chulkova", java.time.LocalDate.of(1998, Month.AUGUST, 20), Gender.FEMALE, new BigDecimal(67899), new Division(12, "F"));
        Person secondPerson = new Person(45, "Olga", "Bezrukova", java.time.LocalDate.of(1999, Month.MAY, 30), Gender.FEMALE, new BigDecimal(98764), new Division(12,"I"));
        Person thirdPerson = new Person(16, "Ivan", "Ivanov", java.time.LocalDate.of(1998, Month.MAY, 17), Gender.MALE, new BigDecimal(70098), new Division(45,"H"));
        Repository<Person> actual = new Repository<Person>();
        actual.add(firstPerson);
        actual.add(secondPerson);
        actual.add(thirdPerson);
        Repository<Person> expected = new Repository<Person>();
        expected.add(firstPerson);
        expected.add(thirdPerson);
        assertEquals(actual.searchBy(x->x.getAge() == 21),expected);
    }

    @Test
    void sortBy() {
        Repository actual = new Repository();
        Person firstPerson = new Person(23, "Irina", "Chulkova", java.time.LocalDate.of(1999, Month.AUGUST, 20), Gender.FEMALE, new BigDecimal(67899), new Division(12, "F"));
        Person secondPerson = new Person(45, "Olga", "Bezrukova", java.time.LocalDate.of(1999, Month.MAY, 30), Gender.FEMALE, new BigDecimal(98764), new Division(12,"I"));
        Person thirdPerson = new Person(16, "Ivan", "Ivanov", java.time.LocalDate.of(1999, Month.MAY, 17), Gender.MALE, new BigDecimal(70098), new Division(45,"H"));
        Person fourPerson = new Person(12,"Peter", "Parker", java.time.LocalDate.of(1991, Month.APRIL, 19),  Gender.MALE,new BigDecimal(45666), new Division(5,"I"));
        actual.add(firstPerson);
        actual.add(secondPerson);
        actual.add(thirdPerson);
        actual.add(fourPerson);
        Repository expected = new Repository();
        expected.add(firstPerson);
        expected.add(thirdPerson);
        expected.add(secondPerson);
        expected.add(fourPerson);
        actual.sortBy(new SortedByName());
        assertEquals(actual,expected);
    }
}