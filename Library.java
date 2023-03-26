import java.util.ArrayList;
import java.util.Scanner;

// Book class represens a book in the library and its information
class Book {
  private int id;
  private String title;
  private String author;
  private boolean available;

  public Book(int id, String title, String author, boolean available) {
      this.id = id;
      this.title = title;
      this.author = author;
      this.available = available;
  }
  
  // Getters and setters for book information
  public int getId() {
      return id;
  }

  public void setId(int id) {
      this.id = id;
  }

  public String getTitle() {
        return title;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public String getAuthor() {
        return author;
  }

  public void setAuthor(String author) {
      this.author = author;
  }

  public boolean isAvailable() {
      return available;
  }

  public void setAvailable(boolean available) {
      this.available = available;
  }
}

// Librarian class represents a librarian with corresponding authorizations
class Librarian {
  private int id;
  private String name;
  private String email;

  public Librarian(int id, String name, String email) {
      this.id = id;
      this.name = name;
      this.email = email;
  }
  
  // Getters and setters for librarian information
  public int getId() {
      return id;
  }

  public void setId(int id) {
      this.id = id;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }
}


// User class represents a normal user that is not a librarian
class User {
  private int id;
  private String name;
  private String email;
  private ArrayList<Book> borrowedBooks;

  public User(int id, String name, String email) {
      this.id = id;
      this.name = name;
      this.email = email;
      borrowedBooks = new ArrayList<>();
  }
  
}
