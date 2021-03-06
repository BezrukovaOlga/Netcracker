package ru.vsu;

import ru.vsu.lab.entities.IDivision;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Division implements IDivision {
    private Integer id;
    private String name;

    public Division() {
    }

    public Division(Integer id, String name) {
        this.id = id;
        this.name = name;
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String s) {
        this.name = s;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return Objects.equals(id, division.id) &&
                Objects.equals(name, division.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
