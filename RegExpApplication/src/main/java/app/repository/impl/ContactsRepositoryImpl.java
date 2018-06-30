package app.repository.impl;

import app.model.MyContact;
import app.repository.ContactsRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class ContactsRepositoryImpl implements ContactsRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public ContactsRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<MyContact> findContactsByRegExp(String regExp) {
        Session session = sessionFactory.getCurrentSession();
        return session.createNativeQuery(" SELECT * FROM my_contacts c WHERE c.name ~ :regExp", MyContact.class).setParameter("regExp", regExp).list();
    }

    @Override
    public Serializable addContact(MyContact myContact) {
        Session session = sessionFactory.getCurrentSession();
        return session.save(myContact);
    }
}
