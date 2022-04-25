package dao;

import model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findByName(final String name);
    boolean promoteUser(User user);
    void deleteUser(User user);
}
