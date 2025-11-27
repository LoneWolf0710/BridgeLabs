import java.util.*;

class Book {
    String title;
    public Book(String title) { this.title = title; }
    @Override
    public String toString() { return title; }
}

public class Q27_LibraryManagementSystem {

    public static void main(String[] args) {
        List<Book> allBooks = new ArrayList<>();
        Set<String> memberIds = new HashSet<>();
        Queue<Book> issueQueue = new LinkedList<>();
        Stack<Book> recentReturns = new Stack<>();

        allBooks.add(new Book("Book A"));
        allBooks.add(new Book("Book B"));

        memberIds.add("M1");
        memberIds.add("M2");

        issueQueue.add(allBooks.get(0));
        issueQueue.add(allBooks.get(1));

        System.out.println("Issuing books in queue:");
        while (!issueQueue.isEmpty()) {
            Book b = issueQueue.remove();
            System.out.println("Issued: " + b);
            recentReturns.push(b); // assume immediately returned for demo
        }

        System.out.println("Recently returned stack: " + recentReturns);
        if (!recentReturns.isEmpty()) {
            System.out.println("Re-issuing most recent: " + recentReturns.peek());
        }
    }
}
