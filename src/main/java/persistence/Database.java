package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection connection;

    private final String USER;
    private final String PASSWORD;
    private final String URL;


    public Database(String USER, String PASSWORD, String URL) {
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        this.URL = URL;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Fejl ved instantiering af Driver klasse", e);
        }
    }

    public Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Fejl under etablering af forbindelse til database", e);
        }
        return connection;
    }
}