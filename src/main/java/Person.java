import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.Objects;

public class Person{
    private LocalDate localDate = new LocalDate();
    private int id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private int age;
    private String sex;
    private int salary;
    private String division;

    public Person() {
    }

    public Person(int id, String name, String surname, LocalDate dateOfBirth, String sex, int salary, String division) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.age = Years.yearsBetween(dateOfBirth,localDate).getYears();
        this.sex = sex;
        this.salary = salary;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void printPerson(){
        System.out.println("ID: "+id+", Name: "+name+", Surname: "+surname+", Date of birth: "+dateOfBirth+", Age: "+age+", Sex: "+sex+", Salary: "+salary+", Division: "+division);
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
                "localDate=" + localDate +
                ", id=" + id +
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
