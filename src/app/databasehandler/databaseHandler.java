/*
* databaseHandler
* handles connection to database
* 11/14/2026
* Authors: Elsius, kcompsci9, TyDiCicco
* Last update: 11/15/2026
* Establishes a connection to given URL/USER/PASSWORD
*/
package databasehandler;

import java.sql.*;
import java.util.*;

public class databaseHandler {
    // user and pw are hardcoded here,
    // communication to db should be part of a backend service to separate from
    // frontend
    // path to database here, use a URL for a remote database
    private static final String URL = "jdbc:sqlite:/pathto/app.db";
    private static final String USER = "";
    private static final String PASSWORD = "";

    // attempts to connect to database
	/**
	 * @return A java.sql.Connection. 
	 * @throws java.sql.SQLException A Java SQL exception object.
	 */
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

	    // Receives strings for username and password from NewUserClass
    public static void addUser(String username, String password) {

        //Inserts new row into the SQL users table
        String query = "INSERT INTO users (Username, Password) VALUES (?, ?)";


        //Connects to database
        try (
                Connection dbConnection = connect();
                PreparedStatement placeholder =
                        dbConnection.prepareStatement(query)
        ) {

            //Sets up table with specific data
            placeholder.setString(1, username);
            placeholder.setString(2, password);

            placeholder.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
