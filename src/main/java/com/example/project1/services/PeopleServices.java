package com.example.project1.services;

import com.example.project1.models.Person;
import com.example.project1.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PeopleServices {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleServices(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findById(int id) {
        return peopleRepository.findById(id);
    }

    public void updatedPerson(int id,Person updatedPerson) {
        Person person = peopleRepository.findById(id);
        person.setId(updatedPerson.getId());
        person.setFull_name(updatedPerson.getFull_name());
        person.setBirthday(updatedPerson.getBirthday());
        peopleRepository.save(person);
    }

    public void deletePerson(int id) {
        peopleRepository.deleteById(id);
    }

    public void createPerson(Person person) {
        peopleRepository.save(person);
    }
}
