package dao;

import model.User;
import util.ConfigUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserSQLite implements UserDao {
    private static final String SELECT_ALL = "SELECT * FROM User";
    private static final String FIND_BY_NAME = "SELECT * FROM User WHERE name = ?";
    private static final String DELETE = "DELETE FROM User WHERE name = ?";
    private static final String PROMOTE = "UPDATE User SET admin = 1 WHERE name = ?; ";
    private final String connectionURL;
    public UserSQLite() {
        connectionURL = ConfigUtil.getValue("db");
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        try (
            Connection connection = DriverManager.getConnection(connectionURL);
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SELECT_ALL)
            ) {
            while( resultSet.next() ) {
                User user = new User();
                user.setAdmin( resultSet.getBoolean("admin") );
                user.setName( resultSet.getString("name") );
                user.setPwd( resultSet.getString("pwd") );
                users.add( user );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByName(String name) {
        User user = null;
        try (
            Connection connection = DriverManager.getConnection(connectionURL);
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)
            ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                user = new User();
                user.setPwd( resultSet.getString("pwd") );
                user.setName( resultSet.getString("name") );
                user.setAdmin( resultSet.getBoolean("admin") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean promoteUser(User user) {
        boolean result = true;
        try(
            Connection connection = DriverManager.getConnection(connectionURL);
            PreparedStatement preparedStatement = connection.prepareStatement(PROMOTE);
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public void deleteUser(User user) {
        try(
            Connection connection = DriverManager.getConnection(connectionURL);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
