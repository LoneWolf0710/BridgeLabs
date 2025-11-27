import java.util.ArrayList;
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    public LibraryItem(String itemId,String title,String author){this.itemId=itemId;this.title=title;this.author=author;}
    public String getItemId(){return itemId;}
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public String getItemDetails(){ return itemId+" "+title+" "+author; }
    public abstract int getLoanDuration();
}
interface Reservable { void reserveItem(String user); boolean checkAvailability(); }
class Book extends LibraryItem implements Reservable {
    private boolean reserved=false;
    public Book(String id,String title,String author){ super(id,title,author); }
    public int getLoanDuration(){ return 21; }
    public void reserveItem(String user){ reserved=true; }
    public boolean checkAvailability(){ return !reserved; }
}
class Magazine extends LibraryItem {
    public Magazine(String id,String t,String a){ super(id,t,a); }
    public int getLoanDuration(){ return 7; }
}
class DVD extends LibraryItem {
    public DVD(String id,String t,String a){ super(id,t,a); }
    public int getLoanDuration(){ return 3; }
}
public class LibraryManagement {
    public static void main(String[] args){
        ArrayList<LibraryItem> items=new ArrayList<>();
        items.add(new Book("B1","Java","AuthorA"));
        items.add(new Magazine("M1","Design","AuthorB"));
        items.add(new DVD("D1","Movie","DirectorC"));
        for(LibraryItem it:items) System.out.println(it.getItemDetails()+" loanDays:"+it.getLoanDuration());
    }
}
