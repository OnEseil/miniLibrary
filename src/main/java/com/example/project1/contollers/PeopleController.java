package com.example.project1.contollers;

import com.example.project1.models.Person;
import com.example.project1.services.PeopleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PeopleController {
    private final PeopleServices peopleServices;

    @Autowired
    public PeopleController(PeopleServices peopleServices) {
        this.peopleServices = peopleServices;
    }

    @GetMapping("/listPeople")
    public String people(Model model)
    {
        model.addAttribute("people", peopleServices.findAll());

        return "listPeople";
    }

    @GetMapping("/people/new")
    public String createPerson(Model model){
        model.addAttribute("person", new Person());
        return "new";
    }

    @PostMapping("/people/new")
    public String createPeople(@ModelAttribute Person person){
        peopleServices.createPerson(person);
        return "redirect:/listPeople";
    }

    @GetMapping("/person/{id}")
    public String getPeopleWithId(Model model, @PathVariable int id)
    {
        model.addAttribute("person", peopleServices.findById(id));
        return "person";
    }

    @GetMapping("/person/{id}/edit")
    public String editPerson(Model model, @PathVariable int id) {
        model.addAttribute("person", peopleServices.findById(id));
        return "peopleEdit";
    }

    @PostMapping("/person/{id}/edit")
    public String editPerson(@ModelAttribute Person person, @PathVariable int id) {
        peopleServices.updatedPerson(id, person);
        return "redirect:/listPeople";
    }

    @PostMapping("/person/{id}/delete")
    public String deletePerson(@PathVariable int id) {
        peopleServices.deletePerson(id);
        return "redirect:/listPeople";
    }

}
