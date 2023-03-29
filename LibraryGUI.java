/* GUI for Library class
 * Author: Sergio Alvarez Tapia
 * Created: Mar, 2023
 */

// GUI imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class LibraryGUI {
    // GUI frames, buttons, panels, and text fields
    private JFrame frame;
    private JPanel librarianPanel;   // panel for librarian section
    private JPanel userPanel;        // panel for user section
    private JPanel currentPanel;     // the panel currently displayed (either librarianPanel or userPanel)
    private JButton librarianButton; // button to switch to librarian section
    private JButton userButton;      // button to switch to user section
    private JButton logoutButton;    // button to log out and return to main panel
    private JButton addButton;       // button to add a book
    private JButton removeButton;    // button to remove a book
    private JButton updateButton;    // button to update a book
    private JButton searchButton;    // button to search for books
    private JButton borrowButton;    // button to borrow a book
    private JTextField idField;      // field to enter book ID
    private JTextField titleField;   // field to enter book title
    private JTextField authorField;  // field to enter book author
    private JTextField emailField;   // field to enter user email
    private JTextArea resultArea;    // area to display search results or error messages
    private JComboBox<Book> bookComboBox;  // dropdown to select a book
    private JComboBox<User> userComboBox;  // dropdown to select a user
    
    private ArrayList<Book> books;      // list of all books in the library
    private ArrayList<Librarian> librarians;  // list of all librarians (for login purposes)
    private ArrayList<User> users;      // list of all users (for borrowing purposes)

    private Librarian currentLibrarian; // currently logged in librarian
    private User currentUser;           // currently logged in user

    public LibraryManagementSystemGUI() {
        frame = new JFrame("Library Management System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }
}
