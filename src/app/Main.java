/*
 * Main
 *
 * 2026-11-05
 *
 * Authors: Elsius, kcompsci9, xalisha
 */
import ui.LoginUI;
import databasehandler.databaseHandler;

public class Main {
    public static void main(String[] args) {
        // creates user and exercise tables
        databaseHandler.createTables();
        
        // load ui here
        new LoginUI();
        
        
        
    }
}
