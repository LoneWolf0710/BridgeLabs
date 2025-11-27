import java.util.ArrayList;

class User {
    private String id;
    private String name;
    public User(String id, String name){ this.id = id; this.name = name; }
    public String getId(){ return id; }
    public String getName(){ return name; }
}

class UserRepository {
    private ArrayList<User> store = new ArrayList<>();
    public void save(User u){ store.add(u); }
    public int count(){ return store.size(); }
}

class UserService {
    private UserRepository repo;
    public UserService(UserRepository repo){ this.repo = repo; }
    public void register(String id, String name){ repo.save(new User(id,name)); }
}

interface Formatter { String format(String text); }
class PlainFormatter implements Formatter {
    public String format(String text){ return text; }
}
class JsonFormatter implements Formatter {
    public String format(String text){ return "{\"msg\":\""+text+"\"}"; }
}

class ReportPrinter {
    private Formatter formatter;
    public ReportPrinter(Formatter formatter){ this.formatter = formatter; }
    public String print(String text){ return formatter.format(text); }
}

interface Printer { void print(String doc); }
interface ScannerDevice { String scan(); }
class MultiFunctionDevice implements Printer, ScannerDevice {
    public void print(String doc){ System.out.println("printing:"+doc); }
    public String scan(){ return "scanned-data"; }
}

abstract class Food { public abstract double price(); }
class Burger extends Food { public double price(){ return 100; } }
class Pizza extends Food { public double price(){ return 250; } }

public class DesignPrinciples {
    public static void main(String[] args){
        UserRepository ur = new UserRepository();
        UserService us = new UserService(ur);
        us.register("U1","Amit");
        us.register("U2","Sara");
        System.out.println("Users:"+ur.count());

        ReportPrinter rp1 = new ReportPrinter(new PlainFormatter());
        ReportPrinter rp2 = new ReportPrinter(new JsonFormatter());
        System.out.println(rp1.print("hello"));
        System.out.println(rp2.print("hello"));

        MultiFunctionDevice dev = new MultiFunctionDevice();
        dev.print("doc1");
        System.out.println(dev.scan());

        Food b = new Burger();
        Food p = new Pizza();
        System.out.println("Burger:"+b.price());
        System.out.println("Pizza:"+p.price());
    }
}
