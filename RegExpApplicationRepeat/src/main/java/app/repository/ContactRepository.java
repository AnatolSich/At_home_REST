package app.repository;

import app.model.Contact;

import java.util.List;

public interface ContactRepository {

    Contact putContact(Contact contact);
    List<Contact> getContactByRegExp(String regExp);
}
