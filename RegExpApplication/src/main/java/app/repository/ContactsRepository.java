package app.repository;

import app.model.MyContact;

import java.io.Serializable;
import java.util.List;

public interface ContactsRepository {
    List<MyContact> findContactsByRegExp(String regExp);

    Serializable addContact(MyContact myContact);
}
