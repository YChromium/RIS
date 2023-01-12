//LAB 4 EDITED FOR AJAX
//EDITED FILES ONLY

package ru.mail.yuriyhrom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.mail.yuriyhrom.DAO.PersonDAO;

//Этот контроллер отлавливает весь функционал для Ajax
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final PersonDAO personDAO;

    @Autowired
    public RestController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/ajax/{id}")
    public String ajax(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "Ok";
    }

    @GetMapping("/create/{name}")
    public String create(@PathVariable("name") String name) {
        return personDAO.saveName(name).toString();
    }
}
