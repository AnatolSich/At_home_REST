package app.controller;

import app.model.MyContact;
import app.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/")
public class UserController {

    private final ContactsRepository contactsRepository;

    @Autowired
    public UserController(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @GetMapping
    public String welcome(){
        return "Welcome";
    }

    @GetMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MyContact> findContactsByRegExp(@RequestParam(value = "regExp", required = true) String regExp){
        return contactsRepository.findContactsByRegExp(regExp);
    }

    @PutMapping (value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addContact(MyContact myContact){
         contactsRepository.addContact(myContact);
         return "redirect:/";
    }
}
