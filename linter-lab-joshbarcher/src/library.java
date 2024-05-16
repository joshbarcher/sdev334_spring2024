import java.util.ArrayList;

public class library {
    ArrayList<book> Books = new ArrayList<>();

    public void addBook(book Book) {
        Books.add(Book);
    }

    public void list() {
        for(book Book : Books) {
            System.out.println("Title: " + Book.title + ", Author: " + Book.author);
        }
    }
}