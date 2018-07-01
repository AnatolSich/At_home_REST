package app.controller;

import app.model.Contact;
import app.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping(value = "/")
    public String welcome() {
        return "Welcome!";
    }

    @GetMapping(value = "/getContacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> getContactsByRegExp(@RequestParam(value = "regExp", required = true) String regExp) {
        return contactRepository.getContactByRegExp(regExp);
    }

    @PutMapping(value = "/putContact", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Contact putContact(@RequestBody Contact contact) {
        return contactRepository.putContact(contact);
    }
}
