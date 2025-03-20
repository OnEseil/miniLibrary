package com.example.project1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person")
@Getter
@Setter
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String full_name;

   @Column(name = "birthday")
   private int birthday;

    @OneToMany(mappedBy = "person_id")
    private List<Book> books;


    public Person(int id, String full_name, int birthday) {
        this.id = id;
        this.full_name = full_name;
        this.birthday = birthday;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return full_name + " " + birthday;
    }
}
