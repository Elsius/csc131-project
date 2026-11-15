/*
* databaseHandler
* handles connection to database
* 11/14/2026
* Authors: Elsius
* Last update: 11/15/2026
* Establishes a connection to given URL/USER/PASSWORD
*/
package databaseHandler;

import java.sql.*;
import java.util.*;

public class databaseHandler {
    // user and pw are hardcoded here,
    // communication to db should be part of a backend service to seperate from
    // frontend
    // path to database here, use a URL for a remote database
    private static final String URL = "jdbc:sqlite:/pathto/app.db";
    private static final String USER = "";
    private static final String PASSWORD = "";

    // attempts to connect to database
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}