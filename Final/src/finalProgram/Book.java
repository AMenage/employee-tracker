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
public class Book {
    String ISBN;
    String title;
    String author;
    float price;
    int count;
    
    // Constructor for the book information entered by the employee
    public Book 
            (String ISBN,
            String title,
            String author,
            float price,
            int count) {
        this.ISBN          = ISBN;
        this.title         = title;
        this.author        = author;
        this.price         = price;
        this.count         = count;
    }
    
    // accessor for ISBN
    public String getISBN() {
        return ISBN;
    }
    
    // accessor for title
    public String getBookTitle() {
        return title;
    }
    
    // accessor for author
    public String getAuthor() {
        return author;
    }
    
    // accessor for price
    public void getPrice(float newPrice) {
        price = newPrice;
    }
    
    // accessor for stock
    public void getCount(int newCount) {
        count = newCount;
    }
    
    // override toString() method with employee's first name and last name,
    // and the book's title, reminding who sold what book
    @Override
    public String toString() {
        return title + " is in stock.";
    }
    
    /*
     * Function to add a book to the database using the INSERT command
     * on SQLite.
     */
    public void insertBookSql
            (String bookISBN,
            String bookTitle,
            String bookAuthor,
            float bookPrice,
            int bookCount) {
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
             * Enter the book's information using INSERT in SQLite and execute the update.
             */
            stmt = c.createStatement();
            String sql = "INSERT INTO Books (ISBN,Title,Author,Price,OnHandCount) " +
                    "VALUES ('" + bookISBN + 
                    "', '" + bookTitle + 
                    "', '" + bookAuthor + 
                    "', " + bookPrice + 
                    ", " + bookCount + " );";
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