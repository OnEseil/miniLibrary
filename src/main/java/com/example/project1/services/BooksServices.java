package com.example.project1.services;

import com.example.project1.models.Book;
import com.example.project1.models.Person;
import com.example.project1.repository.BookRepository;
import com.example.project1.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class BooksServices {
    private final BookRepository bookRepository;
    private final PeopleRepository peopleRepository;

    @Autowired
    public BooksServices(BookRepository bookRepository, PeopleRepository peopleRepository) {
        this.bookRepository = bookRepository;
        this.peopleRepository = peopleRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    public void update(Book updatedBook, int id) {
        Book book = bookRepository.findById(id);
        book.setId(updatedBook.getId());
        book.setPerson_id(updatedBook.getPerson_id());
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setYear(updatedBook.getYear());
        bookRepository.save(book);
    }


    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public void setOwner(@ModelAttribute Person person, int id) {
        Book book = bookRepository.findById(id);
        book.setPerson_id(person.getId());
        System.out.println(book + " " + id);
        bookRepository.save(book);

    }

}