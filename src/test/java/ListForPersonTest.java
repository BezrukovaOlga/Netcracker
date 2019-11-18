import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListForPersonTest {

    @Test
    void add() {
        ListForPerson expected = new ListForPerson();
        Person firstPerson = new Person(23,"Irina", "Chulkova", new LocalDate(1999,8, 20) , "Female",23345, "S");
        Person secondPerson = new Person(15,"Olga", "Bezrukova", new LocalDate(1999,5, 30), "Female", 70890, "I");
        Person thirdPerson = new Person(34,"Ivan", "Ivanov", new LocalDate(1999,5, 17),  "Male",56777,"F");
        expected.add(firstPerson);
        expected.add(secondPerson);
        expected.add(thirdPerson);
        Person[] persons = new Person[3];
        persons[0]=firstPerson;
        persons[1]=secondPerson;
        persons[2]=thirdPerson;
        ListForPerson actual = new ListForPerson(persons);
        assertEquals(actual,expected);
    }

    @Test
    void remove() {
        ListForPerson actual = new ListForPerson();
        Person firstPerson = new Person(23,"Irina", "Chulkova", new LocalDate(1999,8, 20) , "Female",23345, "S");
        Person secondPerson = new Person(15,"Olga", "Bezrukova", new LocalDate(1999,5, 30), "Female", 70890, "I");
        Person thirdPerson = new Person(34,"Ivan", "Ivanov", new LocalDate(1999,5, 17),  "Male",56777,"F");
        Person fourPerson = new Person(12,"Peter", "Parker", new LocalDate(1991,4, 19),  "Male",45666,"I");
        actual.add(firstPerson);
        actual.add(secondPerson);
        actual.add(thirdPerson);
        actual.add(fourPerson);
        actual.remove(2);
        ListForPerson expected = new ListForPerson();
        expected.add(firstPerson);
        expected.add(secondPerson);
        expected.add(fourPerson);
        assertEquals(actual,expected);

    }

    @Test
    void set() {
        ListForPerson actual = new ListForPerson();
        Person firstPerson = new Person(23,"Irina", "Chulkova", new LocalDate(1999,8, 20) , "Female",23345, "S");
        Person secondPerson = new Person(15,"Olga", "Bezrukova", new LocalDate(1999,5, 30), "Female", 70890, "I");
        Person thirdPerson = new Person(34,"Ivan", "Ivanov", new LocalDate(1999,5, 17),  "Male",56777,"F");
        Person fourPerson = new Person(12,"Peter", "Parker", new LocalDate(1991,4, 19),  "Male",45666,"I");
        actual.add(firstPerson);
        actual.add(thirdPerson);
        actual.set(1,secondPerson);
        ListForPerson expected = new ListForPerson();
        expected.add(firstPerson);
        expected.add(secondPerson);
        expected.add(thirdPerson);
        assertEquals(actual,expected);

    }

    @Test
    void size() {
        ListForPerson actual = new ListForPerson();
        Person firstPerson = new Person(23,"Irina", "Chulkova", new LocalDate(1999,8, 20) , "Female",23345, "S");
        Person secondPerson = new Person(15,"Olga", "Bezrukova", new LocalDate(1999,5, 30), "Female", 70890, "I");
        Person thirdPerson = new Person(34,"Ivan", "Ivanov", new LocalDate(1999,5, 17),  "Male",56777,"F");

        actual.add(firstPerson);
        actual.add(secondPerson);
        actual.add(thirdPerson);
        int expected = 3;
        assertEquals(actual.getIndex(),expected);

    }

    @Test
    void print() {
    }

    @Test
    void found() {
        ListForPerson actual = new ListForPerson();
        Person firstPerson = new Person(23,"Irina", "Chulkova", new LocalDate(1999,8, 20) , "Female",23345, "S");
        Person secondPerson = new Person(15,"Olga", "Bezrukova", new LocalDate(1999,5, 30), "Female", 70890, "I");
        Person thirdPerson = new Person(34,"Ivan", "Ivanov", new LocalDate(1999,5, 17),  "Male",56777,"F");
        actual.add(firstPerson);
        actual.add(secondPerson);
        actual.add(thirdPerson);
        Person[] person = new Person[1];
        person[0]= new Person(15,"Olga", "Bezrukova", new LocalDate(1999,5, 30), "Female", 70890, "I");
        ListForPerson expected = new ListForPerson(person);
        assertEquals(actual.found("Olga"),expected);
    }

    @Test
    void empty() {
        ListForPerson actual = new ListForPerson();
        boolean expected = true;
        assertEquals(actual.empty(),expected);
    }

    @Test
    void testFound() {
        ListForPerson actual = new ListForPerson();
        Person firstPerson = new Person(23,"Irina", "Chulkova", new LocalDate(1993,8, 20) , "Female",23345, "S");
        Person secondPerson = new Person(15,"Olga", "Bezrukova", new LocalDate(1994,5, 30), "Female", 70890, "I");
        Person thirdPerson = new Person(34,"Ivan", "Ivanov", new LocalDate(1999,5, 17),  "Male",56777,"F");
        Person fourPerson = new Person(45,"Vladislav", "Muras", new LocalDate(1999,5, 17),  "Male", 76885,"O");
        actual.add(firstPerson);
        actual.add(secondPerson);
        actual.add(thirdPerson);
        actual.add(fourPerson);
        Person[] person = new Person[2];
        person[0]=thirdPerson;
        person[1]=fourPerson;
        ListForPerson expected = new ListForPerson(person);
        assertEquals(actual.found(20),expected);
    }

    @Test
    void testFound1() {
        ListForPerson actual = new ListForPerson();
        Person firstPerson = new Person(23,"Irina", "Chulkova", new LocalDate(1999,8, 20) , "Female",23345, "S");
        Person secondPerson = new Person(15,"Olga", "Bezrukova", new LocalDate(1999,5, 30), "Female", 70890, "I");
        Person thirdPerson = new Person(34,"Ivan", "Ivanov", new LocalDate(1999,5, 17),  "Male",56777,"F");
        actual.add(firstPerson);
        actual.add(secondPerson);
        actual.add(thirdPerson);
        Person[] person = new Person[1];
        person[0]=secondPerson;
        ListForPerson expected = new ListForPerson(person);
        assertEquals(actual.found(new LocalDate(1999,5,30)),expected);
    }

    @Test
    void sort() {
        ListForPerson actual = new ListForPerson();
        Person firstPerson = new Person(44,"Jack", "Maven", new LocalDate(2005,10, 29),  "Male", 56774, "P");
        Person secondPerson = new Person(15,"Olga", "Bezrukova", new LocalDate(1999,5, 30), "Female", 70890, "I");
        Person thirdPerson = new Person(34,"Ivan", "Ivanov", new LocalDate(1999,5, 17),  "Male",56777,"F");
        Person fourPerson = new Person(12,"Peter", "Parker", new LocalDate(1991,4, 19),  "Male",45666,"I");
        actual.add(firstPerson);
        actual.add(secondPerson);
        actual.add(thirdPerson);
        actual.add(fourPerson);
        ListForPerson expected = new ListForPerson();
        expected.add(thirdPerson);
        expected.add(firstPerson);
        expected.add(secondPerson);
        expected.add(fourPerson);
        actual.sort(new SortedByName());
        assertEquals(actual,expected);
    }
}