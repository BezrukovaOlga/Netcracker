package ru.vsu;

import ru.vsu.Sorters.BubbleSort;
import ru.vsu.Sorters.ISorted;
import ru.vsu.lab.repository.IRepository;

import java.util.*;
import java.util.function.Predicate;

import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Repository<T> implements IRepository<T> {
    private final static Logger logger = Logger.getLogger(Repository.class.toString());
    private int DEFAULT_CAPACITY = 1;
    private Object[] person = new Object[DEFAULT_CAPACITY];
    private int index = 0;

    private ISorted sorter = new BubbleSort();

    public Repository() {
    }


    public Repository(Object[] person) {

        this.person = person;
        this.index = person.length;
    }

    public int getIndex() {
        return index;
    }

    public boolean empty() {
        if (index == 0)
            return true;
        else
            return false;
    }

    private void arrayCompression() {
        Object[] newPersonArray = new Object[person.length - 1];
        System.arraycopy(person, 0, newPersonArray, 0, index);
        person = newPersonArray;
        logger.info("Array compression occurred");
    }

    /**
     * Add one to the size of the array, and then copies the existing elements to a new array.
     */
    private void arrayExpansion() {
        Object[] newPersonArray = new Object[person.length + 1];
        System.arraycopy(person, 0, newPersonArray, 0, index);
        person = newPersonArray;
        logger.trace("Array expansion occurred");
    }

    @Override
    public void add(T t) {
        if (index == person.length)
            arrayExpansion();
        person[index++] = t;
        logger.info("Element was added in array");
    }

    @Override
    public T get(int i) {
        return (T) person[i];
    }

    @Override
    public T delete(int i) {
        for (int j = i; j < index - 1; j++) {
            person[i] = person[i + 1];
        }
        index--;
        arrayCompression();
        logger.info("Element with index " + i + " was delete from array");
        return null;
    }

    @Override
    public T set(int i, T t) {
        person[i] = t;
        logger.info("Element with index " + i + " was change");
        return null;
    }

    @Override
    public void add(int i, T t) {
        arrayExpansion();
        Object[] newArray = new Object[person.length];
        System.arraycopy(person, 0, newArray, 0, i);
        newArray[i] = t;
        System.arraycopy(person, i, newArray, i + 1, index - i);
        person = newArray;
        index++;
        logger.info("Element was added on position " + i);
    }

    @Override
    public List<T> toList() {
        List<T> list = new LinkedList<T>();
        for (T addPerson : (T[]) person) {
            list.add(addPerson);
        }
        logger.info("Array was change to list");
        return list;
    }

    @Override
    public void sortBy(Comparator<T> comparator) {
        sorter.sort(person, comparator);
        logger.info("Array was sorted");
    }

    @Override
    public IRepository<T> searchBy(Predicate<T> predicate) {
        Repository list = new Repository();
        for (int i = 0; i < index; i++) {
            if (predicate.test((T) person[i]))
                list.add(person[i]);
        }
        if (!list.empty()) {
            logger.info("Repository was search element");
        } else {
            logger.info("Repository was not search element");
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository<?> that = (Repository<?>) o;
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
        return "Repository{" +
                "person=" + Arrays.toString(person) +
                ", index=" + index +
                '}';
    }
}
