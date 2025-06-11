import javax.swing.*;         // Gives us GUI components like JFrame, JButton, JTextField, etc.
import java.awt.*;            // Needed for layout managers like BorderLayout, GridLayout
import java.awt.event.*;      // Lets us respond to events like button clicks

public class LibraryGUI {
    private Library library;            // Our backend logic to store books
    private JFrame frame;               // Main application window
    private JTextField inputField;      // Text input field for user to type book names
    private JTextArea outputArea;       // Text area to show messages and book list

    public LibraryGUI() {
        // Initialize logic
        library = new Library();

        // Create window
        frame = new JFrame("📚 Library Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(245, 245, 245)); // Light gray background

        // User input field
        inputField = new JTextField();
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        inputField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Buttons
        JButton addButton = createButton("Add Book");       // Blue themed
        JButton removeButton = createButton("Remove Book");
        JButton listButton = createButton("List Books");

        // Layout for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(listButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Output area (shows messages and book list)
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputArea.setBackground(Color.WHITE);
        outputArea.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Top layout: input field + buttons
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(245, 245, 245));
        topPanel.add(inputField, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add to main window
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Logic for Add Button
        addButton.addActionListener(e -> {
            String book = inputField.getText().trim();
            if (!book.isEmpty()) {
                library.addBook(book);                        // Add book
                inputField.setText("");                       // Clear field
                outputArea.setText("✅ Added: " + book);      // Show confirmation
            }
        });

        // Logic for Remove Button
        removeButton.addActionListener(e -> {
            String book = inputField.getText().trim();
            if (library.removeBook(book)) {
                outputArea.setText("❌ Removed: " + book);
            } else {
                outputArea.setText("⚠️ Book not found: " + book);
            }
            inputField.setText("");
        });

        // Logic for List Button
        listButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("📖 Books in Library:\n\n");
            for (String book : library.getBooks()) {
                sb.append("• ").append(book).append("\n");
            }
            outputArea.setText(sb.toString());
        });

        // Display the window
        frame.setVisible(true);
    }

    // Button styling method
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(new Color(66, 133, 244)); // Google blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        return button;
    }

    public static void main(String[] args) {
        // Launch GUI safely on the Event Dispatch Thread
        SwingUtilities.invokeLater(LibraryGUI::new);
    }
}
