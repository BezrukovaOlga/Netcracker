import org.joda.time.LocalDate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;


public class ListForPerson {
    private int DEFAULT_CAPACITY = 1;
    private Person[] person = new Person[DEFAULT_CAPACITY];
    private int index = 0;

    public int getIndex() {
        return index;
    }

    public ListForPerson() {
    }

    public ListForPerson(Person[] person) {

        this.person = person;
        this.index = person.length;
    }

    /**
     * The method adds a person to the array. If the index of the current
     * element of the array is equal to the size of the array, then we use the
     * method to expand the array.
     *
     * @param element item to add
     */
    public void add(Person element) {
        if (index == person.length)
            arrayExpansion();
        person[index++] = element;
    }

    /**
     * Removing an element from an array by index.
     *
     * @param indexOfRemoveElement index of item to remove
     */
    public void remove(int indexOfRemoveElement) {
        for (int i = indexOfRemoveElement; i < index - 1; i++) {
            person[i] = person[i + 1];
        }
        //person[index - 1] = null;
        index--;
        arrayCompression();
    }

    /**
     * Adding a person to a user-defined position in the list
     * @param ind item insertion position
     * @param addPerson added person
     */
    public void set(int ind, Person addPerson){
       arrayExpansion();
       Person[] newArray = new Person[person.length];
       System.arraycopy(person, 0, newArray, 0, ind);
       newArray[ind]=addPerson;
       System.arraycopy(person, ind, newArray, ind+1,index-ind);
       person=newArray;
       index++;

    }
    private void arrayCompression(){
        Person[] newPersonArray = new Person[person.length - 1];
        System.arraycopy(person, 0, newPersonArray, 0, index);
        person = newPersonArray;
    }
    /**
     * Add one to the size of the array, and then copies the existing elements to a new array.
     */
    private void arrayExpansion() {
        Person[] newPersonArray = new Person[person.length + 1];
        System.arraycopy(person, 0, newPersonArray, 0, index);
        person = newPersonArray;
    }

    /**
     * The index stores the number of elements in the array.
     *
     * @return array size
     */
    public int size() {
        return index;
    }

    /**
     * Array output
     */
    public void print() {
        for (int i = 0; i < index; i++) {
            person[i].printPerson();
        }
    }

    /**
     * Search for a person by name
     * @param name name to search
     * @return an array of people satisfying the condition
     */
    public ListForPerson found(String name) {
        ListForPerson list = new ListForPerson();
        for (int i = 0; i < index; i++) {
            if (person[i].getName() == name) {
                list.add(person[i]);
            }
        }
        if (!list.empty())
            return list;
        else
            throw new NullPointerException("Exception: person not found!");
    }

    /**
     * Checking array for void
     * @return true or false
     */
    public boolean empty() {
        if (index == 0)
            return true;
        else
            return false;
    }

    /**
     * Search for a person by age
     * @param age age to search
     * @return an array of people satisfying the condition
     */
    public ListForPerson found(int age) {
        ListForPerson list = new ListForPerson();
        for (int i = 0; i < index; i++) {
            if (person[i].getAge() == age)
                list.add(person[i]);
        }
        if (!list.empty())
            return list;
        else
            throw new NullPointerException("Exception: person with age " + age + " not found!");

    }

    /**
     * Search for a person by date of birthday
     * @param date birthday to search
     * @return an array of people satisfying the condition
     */
    public ListForPerson found(LocalDate date) {
        ListForPerson list = new ListForPerson();
        for (int i = 0; i < index; i++) {
            if (person[i].getDateOfBirth().equals(date))
                list.add(person[i]);
        }
        if (!list.empty())
            return list;
        else
            throw new NullPointerException("Exception: person with date " + date + " not found!");
    }

    /**
     * A method for sorting an array using a comparator,
     * which determines by what parameter the array is sorted
     * @param comparator
     */
    public void sort(Comparator<Person> comparator) {
        boolean isSorted = false;
        Person buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < index - 1; i++) {
                if (comparator.compare(person[i], person[i + 1]) >= 1) {
                    isSorted = false;
                    buf = person[i];
                    person[i] = person[i + 1];
                    person[i + 1] = buf;

                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListForPerson that = (ListForPerson) o;
        return DEFAULT_CAPACITY == that.DEFAULT_CAPACITY &&
                index == that.index &&
                Arrays.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(DEFAULT_CAPACITY, index);
        result = 31 * result + Arrays.hashCode(person);
        return result;
    }

    @Override
    public String toString() {
        return "ListForPerson{" +
                "DEFAULT_CAPACITY=" + DEFAULT_CAPACITY +
                ", person=" + Arrays.toString(person) +
                ", index=" + index +
                '}';
    }
}
