package hu.alkfejl.dao;


import hu.alkfejl.model.*;

import java.util.List;

public interface PhoneDAO {
    List<Phone> findAllByContactId(Contact contact);
    List<Phone> findAllByContactId(int contactID);
    Phone save(Phone phone, int contactId);
    void delete(Phone phone);
}
