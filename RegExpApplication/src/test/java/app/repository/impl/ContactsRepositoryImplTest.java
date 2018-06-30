package app.repository.impl;

import app.configurtion.HibernateConfig;
import app.configurtion.ServletInitializer;
import app.configurtion.SpringConfig;
import app.model.MyContact;
import app.repository.ContactsRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader=AnnotationConfigWebContextLoader.class,
        classes={SpringConfig.class, ServletInitializer.class, HibernateConfig.class}
)
public class ContactsRepositoryImplTest {

    @Autowired
    ContactsRepository contactsRepository;

    @Test
    public void findContactsByRegExp() {
        String regExp = "^A";
        MyContact myContact = new MyContact();
        myContact.setName("Alex");
        contactsRepository.addContact(myContact);
        List<MyContact> contactsByRegExp = contactsRepository.findContactsByRegExp(regExp);
        Assert.assertNotEquals(0,contactsByRegExp.size());
        MyContact myContact1 = contactsByRegExp.get(contactsByRegExp.size() - 1);
        String userName = myContact1.getName();
        Assert.assertEquals("Alex", userName);
    }

}