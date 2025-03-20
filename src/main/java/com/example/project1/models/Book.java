package com.example.project1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private int year;

    @Column(name = "title")
    private String title;

    @Column(name = "person_id")
    private Integer person_id;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return author + " " + title + " " + year;
    }


}
