package ru.vsu.Xml;

import ru.vsu.Person;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Persons {
    List<Person> personsList = new ArrayList<>();

    @XmlElement
    public List<Person> getPersons() {
        return personsList;
    }

    public void setPersons(List<Person> persons) {
        this.personsList = persons;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "persons=" + personsList +
                '}';
    }
}
