package hu.alkfejl.dao;

import hu.alkfejl.model.Contact;
import hu.alkfejl.util.ConnectionUtil;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static hu.alkfejl.util.SqlUtil.*;

public class ContactDAOImpl implements ContactDAO {

    private String connectionURL;

    public ContactDAOImpl() {
        connectionURL = ConnectionUtil.getValue("db.url");
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionURL);
             Statement stmt =  conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_CONTACTS)
        ){
            while(rs.next()){
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setEmail(rs.getString("email"));
                contact.setAddress(rs.getString("address"));
                contact.setDateOfBirth(LocalDate.parse(rs.getString("dateOfBirth")));
                contact.setCompany(rs.getString("company"));
                contact.setPosition(rs.getString("position"));

                result.add(contact);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Contact save(Contact contact) {
        try(Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement stmt = contact.getId() <= 0 ? conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS) :
                                                            conn.prepareStatement(UPDATE_CONTACT);
        ) {
            int index = 1;

            stmt.setString(index++,contact.getName());
            stmt.setString(index++, contact.getEmail());
            stmt.setString(index++, contact.getAddress());
            stmt.setString(index++, contact.getDateOfBirth().toString());
            stmt.setString(index++, contact.getCompany());
            stmt.setString(index++, contact.getPosition());

            if(contact.getId() > 0) {
                stmt.setInt(index++,contact.getId());
            }

            int affectedRows = stmt.executeUpdate();
            if(affectedRows == 0){
                return null;
            }

            if(contact.getId() <= 0){
                ResultSet genKeys = stmt.getGeneratedKeys();
                if(genKeys.next()){
                    contact.setId(genKeys.getInt(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        try(Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement stmt = conn.prepareStatement(DELETE_CONTACT)
        ){
            stmt.setInt(1,contact.getId());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
