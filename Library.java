import java.util.ArrayList;

public class Library {
    private ArrayList<String> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title) {
        books.add(title);
    }

    public boolean removeBook(String title) {
        return books.remove(title);
    }

    public ArrayList<String> getBooks() {
        return books;
    }
}

