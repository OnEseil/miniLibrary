package com.example.project1.contollers;

import com.example.project1.models.Book;
import com.example.project1.models.Person;
import com.example.project1.repository.BookRepository;
import com.example.project1.services.BooksServices;
import com.example.project1.services.PeopleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BooksController {
    private final BooksServices booksServices;
    private final PeopleServices peopleServices;


    @Autowired
    public BooksController(BooksServices booksServices, PeopleServices peopleServices) {
        this.booksServices = booksServices;
        this.peopleServices = peopleServices;
    }

   @GetMapping("/listBooks")
    public String listBooks(Model model)
   {
        model.addAttribute("books", booksServices.findAll());
        return "listBooks";
   }

    @GetMapping("/book/new")
    public String createBook(Model model){
        model.addAttribute("book", new Book());
        return "newBook";
   }
    @PostMapping("/book/new")
    public String createBooks(@ModelAttribute Book book){
        booksServices.createBook(book);
        return "redirect:/listBooks";
    }

    @GetMapping("/book/{id}")
    public String showBook(@PathVariable int id, Model model){
        model.addAttribute("book", booksServices.findById(id));
        model.addAttribute("people", peopleServices.findAll());
        return "showBook";
    }
    @PostMapping("/book/{id}/editBook")
    public String editBooks1(@ModelAttribute Person person, @PathVariable int id) {
        booksServices.setOwner(person, id);
        return "redirect:/listBooks";
    }
    @GetMapping("/book/{id}/edit")
    public String editBook(Model model, @PathVariable int id) {
        model.addAttribute("book", booksServices.findById(id));
        return "bookEdit";
    }
    @PostMapping("/book/{id}/edit")
    public String editBooks(@ModelAttribute Book book, @PathVariable int id) {
        booksServices.update(book, id);
        return "redirect:/listBooks";
    }

    @PostMapping("/book/{id}/delete")
    public String deleteBook(@PathVariable int id) {
        booksServices.deleteBook(id);
        return "redirect:/listBooks";
    }
}

