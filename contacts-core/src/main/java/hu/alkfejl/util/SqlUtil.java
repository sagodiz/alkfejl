package hu.alkfejl.util;

public final class SqlUtil {
    public static final String SELECT_ALL_CONTACTS = "SELECT * FROM CONTACT;";
    public static final String INSERT_CONTACT = "INSERT INTO CONTACT (name, email, address, dateOfBirth, company, position) VALUES (?,?,?,?,?,?);";
    public static final String UPDATE_CONTACT = "UPDATE CONTACT SET name=?, email=?, address=?, dateOfBirth=?, company=?, position=? WHERE id=?;";
    public static final String DELETE_CONTACT = "DELETE FROM CONTACT WHERE id=?;";

    public static final String SELECT_PHONES_BY_CONTACT = "SELECT * FROM PHONE WHERE contact_id=?";
    public static final String INSERT_PHONE = "INSERT INTO PHONE (number, phoneType, contact_id) VALUES (?,?,?);";
    public static final String UPDATE_PHONE = "UPDATE PHONE SET number=?, phoneType=? WHERE id=?;";
    public static final String DELETE_PHONE = "DELETE FROM PHONE WHERE id=?;";
}
