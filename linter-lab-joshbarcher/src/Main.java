

public class Main {
    public static void main(String[] args) {
        library myLibrary = new library();
        book Book1 = new book("1984", "George Orwell");
        book Book2 = new book("The Hobbit", "J.R.R. Tolkien");

        myLibrary.addBook(Book1);
        myLibrary.addBook(Book2);

        myLibrary.list();
    }
}
