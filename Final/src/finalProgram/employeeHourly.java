/*
 * Code written by Alexander Menage
 * Created 2015-04-13
 * 
 * This program utilizes a form application with SQLite.
 * It will receive the name of an employee, their ID,
 * the book they are selling (ISBN, Title, and Author),
 * where the book is being sold, how many copies of the book
 * is sold, and the price of each copy. The employee's information
 * will be saved into one table of the database, while the book's
 * information will be saved into another table of the database
 * 
 * Database: sbc.db (Single-Board Computer). The database
 * is located in the project's root folder (Final).
 */
package finalProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Alexander
 */
public class employeeHourly extends employee {
    float hourlyWage;
        
    // Constructor for the Salary employee's information
    public employeeHourly
            (String employeeLastName,
            String employeeFirstName,
            int employeeId,
            float yearlySalary) {
        super(employeeLastName, employeeFirstName, employeeId);
        this.hourlyWage = hourlyWage;
    }
    
    // accessor for employee's hourly wage
    public float earnings() {
        return hourlyWage;
    }
    
    // override toString() method with employee's first name and last name,
    // they are working salary
    @Override
    public String toString() {
        return "Welcome " + this.employeeFirstName
                + " " + this.employeeLastName 
                + "! You are working hourly.";
    }
    
    /*
     * Function to add an employee to the database using the INSERT command
     * on SQLite.
     */
    public void insertEmployeeSql
            (int newEmployeeId,
            String newLastName,
            String newFirstName,
            float newWage,
            float newSalary) {
        Connection c = null;    
        Statement stmt = null;
        try {
            /*
             * Connect to the database called sbc.db.
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:sbc.db");
            c.setAutoCommit(false);            
            System.out.println("Opened database successfully!");
            
            /*
             * Enter the employee's information using INSERT in SQLite and execute the update.
             */
            stmt = c.createStatement();
            String sql = "INSERT INTO Employees (Id,LastName,FirstName,WagePerHour,SalaryPerYear) " +
                    "VALUES (" + newEmployeeId + 
                    ", '" + newLastName + 
                    "', '" + newFirstName + 
                    "', '" + newWage + 
                    "', '" + newSalary + 
                    "' );";
            stmt.executeUpdate(sql);
            
            // Finish the SQLite database interface
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}