import javax.swing.*;         // Gives us GUI components like JFrame, JButton, JTextField, etc.
import java.awt.*;            // Needed for layout managers like BorderLayout, GridLayout
import java.awt.event.*;      // Lets us respond to events like button clicks

public class LibraryGUI {
    private Library library;            // Our backend logic to store books
    private JFrame frame;               // Main application window
    private JTextField inputField;      // Text input field for user to type book names
    private JTextArea outputArea;       // Text area to show messages and book list


    public LibraryGUI() {
        library = new Library();        // Create a new Library instance
        frame = new JFrame("Library Management System");  // Create window and title it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app when window closes
        frame.setSize(400, 400);        // Set window size


        inputField = new JTextField();  // Where users type book titles
        JButton addButton = new JButton("Add Book");      // Button to add book
        JButton removeButton = new JButton("Remove Book");// Button to remove book
        JButton listButton = new JButton("List Books");   // Button to show all books


        outputArea = new JTextArea();         // Where feedback or book list is shown
        outputArea.setEditable(false);        // User can't type here
        JScrollPane scrollPane = new JScrollPane(outputArea);  // Scrollbar for text area


        JPanel topPanel = new JPanel(new BorderLayout()); // Panel that contains input and buttons
        topPanel.add(inputField, BorderLayout.CENTER);    // Text field takes center


        JPanel buttonPanel = new JPanel(new GridLayout(1, 3)); // Horizontal layout for buttons
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(listButton);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);    // Buttons go below input


        frame.add(topPanel, BorderLayout.NORTH); // Top: input + buttons
        frame.add(scrollPane, BorderLayout.CENTER); // Center: output area


        // Button listeners
        addButton.addActionListener(e -> {
            String book = inputField.getText().trim();    // Read and trim user input
            if (!book.isEmpty()) {
                library.addBook(book);                    // Add book to list
                inputField.setText("");                   // Clear input field
                outputArea.setText("Added: " + book);     // Show confirmation
            }
        });


        removeButton.addActionListener(e -> {
            String book = inputField.getText().trim();
            if (library.removeBook(book)) {
                outputArea.setText("Removed: " + book);
            } else {
                outputArea.setText("Book not found: " + book);
            }
            inputField.setText("");
        });


        listButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Books in Library:\n");
            for (String book : library.getBooks()) {
                sb.append("- ").append(book).append("\n");
            }
            outputArea.setText(sb.toString());
        });

        frame.setVisible(true);   // Show the window on the screen
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibraryGUI::new); // Launch GUI on the correct thread
    }
}
