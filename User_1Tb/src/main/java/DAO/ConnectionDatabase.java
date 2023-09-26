package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public class ConnectionDatabase {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/userdb";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "Long1234@@";
    protected  Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
