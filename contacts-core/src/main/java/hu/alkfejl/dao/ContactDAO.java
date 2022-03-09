package hu.alkfejl.dao;

import hu.alkfejl.model.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAll();
    Contact save(Contact contact);
    void delete(Contact contact);
}
