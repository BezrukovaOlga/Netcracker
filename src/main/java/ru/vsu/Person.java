package ru.vsu;//import org.joda.time.LocalDate;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@XmlRootElement
@XmlSeeAlso({Repository.class, Division.class, LocalDate.class})
public class Person implements IPerson {
    private LocalDate localDate = LocalDate.now();
    private int id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private int age;
    private Gender sex;
    private BigDecimal salary;
    private IDivision division;

    public Person() {
    }

    public Person(int id, String name, String surname, LocalDate dateOfBirth, Gender sex, BigDecimal salary, IDivision division) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, localDate).getYears();
        this.sex = sex;
        this.salary = salary;
        this.division = division;
    }

    @XmlElement
    public Integer getYear() {
        return dateOfBirth.getYear();
    }

    @XmlElement
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer integer) {
        this.id = integer;
    }

    @XmlElement
    @Override
    public String getFirstName() {
        return name;
    }

    @Override
    public void setFirstName(String s) {
        this.name = s;
    }

    @XmlElement
    @Override
    public String getLastName() {
        return surname;
    }

    @Override
    public void setLastName(String s) {
        this.surname = s;
    }

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @Override
    public java.time.LocalDate getBirthdate() {
        return dateOfBirth;
    }

    @Override
    public void setBirthdate(java.time.LocalDate localDate) {
        this.dateOfBirth = localDate;
    }

    @XmlElement
    @Override
    public Integer getAge() {
        return Period.between(dateOfBirth, localDate).getYears();
    }

    @XmlElement
    @Override
    public Gender getGender() {
        return sex;
    }

    @Override
    public void setGender(Gender gender) {
        this.sex = gender;
    }

    @XmlAnyElement
    @Override
    public IDivision getDivision() {
        return division;
    }

    @Override
    public void setSalary(BigDecimal bigDecimal) {
        this.salary = bigDecimal;
    }

    @Override
    public void setDivision(IDivision iDivision) {
        this.division = iDivision;
    }

    @XmlElement
    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    public void printPerson() {
        System.out.println("ID: " + id + ", Name: " + name + ", Surname: " + surname + ", Date of birth: " + dateOfBirth + ", Age: " + age + ", Gender: " + sex + ", Salary: " + salary + ", Division: " + division);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                salary == person.salary &&
                Objects.equals(localDate, person.localDate) &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(dateOfBirth, person.dateOfBirth) &&
                Objects.equals(sex, person.sex) &&
                Objects.equals(division, person.division);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDate, id, name, surname, dateOfBirth, age, sex, salary, division);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", division='" + division + '\'' +
                '}';
    }
}
