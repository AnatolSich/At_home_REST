package app.repository.impl;

import app.model.Contact;
import app.repository.ContactRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class ContactRepositoryImpl implements ContactRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public ContactRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Contact putContact(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.persist("Contact", contact);
        return session.get(Contact.class, contact.getId());
    }

    @Override
    public List<Contact> getContactByRegExp(String regExp) {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<Contact> query = session
                .createNativeQuery("Select * from contacts c Where c.name ~ :regExpPar", Contact.class);
        query.setParameter("regExpPar", regExp);
        return query.list();
    }
}
