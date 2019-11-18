import java.util.Comparator;

public class SortedByAge implements Comparator<Person> {

    @Override
    public int compare(Person person, Person person1) {
        if (person.getAge() > person1.getAge())
            return 1;
        else if (person.getAge() < person1.getAge())
            return -1;
        else
            return 0;
    }
}
