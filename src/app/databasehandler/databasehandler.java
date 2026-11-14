/*
* databasehandler
* handles read/write with given database.
* 11/14/2026
* Authors: Elsius
*/
package databasehandler;

import java.sql.*;
import java.util.*;

public class dbFetch {
    // path to database here, use a URL for a remote database
    private static final String URL = "jdbc:sqlite:/pathto/app.db";
    
    // runQuery function sends a query to the db at URL. 
    // converts it to a usable data type, adds to a list, return the list 
    //  something like:
    // public list runQuery(String query){
    //      // query will be something like: "SELECT * FROM Patient WHERE Patient ID = ?, 12345"
    //      list rows = new listobject;
    //      try // attempt to send query to db
    //          // should return a results object, typecast and append it to rows
    //      catch // failed query attempt handle
    //      return rows
    //}
    // Multiple functions to handle what data and how to organize it for use in processing may be needed
}