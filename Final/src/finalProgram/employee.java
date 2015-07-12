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

/**
 *
 * @author Alexander
 */
public class employee {
    String employeeFirstName;   // Employee's first name
    String employeeLastName;    // Employee's last name
    int    employeeId;          // Employee's ID
        
    // Constructor for the employee's information
    public employee
            (String employeeLastName,
            String employeeFirstName,
            int employeeId) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName  = employeeLastName;
        this.employeeId        = employeeId;
    }
    
    // accessor for employee's first name
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }
    
    // accessor for employee's last name
    public String getEmployeeLastName() {
        return employeeLastName;
    }
    
    // accessor for employee's ID
    public int getEmployeeId() {
        return employeeId;
    }
}
