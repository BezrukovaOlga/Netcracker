package ru.vsu;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

public class LabFactory implements ILabFactory {
    @Override
    public IPerson createPerson() {
        Person person = new Person();
        return person;
    }

    @Override
    public IDivision createDivision() {
        Division division = new Division();
        return division;
    }

    @Override
    public <T> IRepository<T> createRepository(Class<T> clazz) {
        Repository<T> repository = new Repository<T>();
        return repository;
    }

    @Override
    public IPersonRepository createPersonRepository() {
        return null;
    }
}
