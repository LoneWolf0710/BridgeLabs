public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "James Gosling");
        Book b2 = new Book("Effective Java", "Joshua Bloch");

        Library lib1 = new Library("City Library");
        Library lib2 = new Library("College Library");

        lib1.addBook(b1);
        lib1.addBook(b2);
        lib2.addBook(b2);

        lib1.showBooks();
        lib2.showBooks();
    }
}