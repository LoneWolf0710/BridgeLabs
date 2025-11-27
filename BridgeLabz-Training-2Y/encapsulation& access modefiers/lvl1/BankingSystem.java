import java.util.ArrayList;
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber,String holderName,double balance){this.accountNumber=accountNumber;this.holderName=holderName;this.balance=balance;}
    public String getAccountNumber(){return accountNumber;}
    public String getHolderName(){return holderName;}
    protected double getBalance(){return balance;}
    public void deposit(double amount){ if(amount>0) balance+=amount; }
    public void withdraw(double amount){ if(amount>0 && amount<=balance) balance-=amount; }
    public abstract double calculateInterest();
}
interface Loanable { boolean applyForLoan(double amount); double calculateLoanEligibility(); }
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String no,String name,double bal){ super(no,name,bal); }
    public double calculateInterest(){ return getBalance()*0.04; }
    public boolean applyForLoan(double amount){ return getBalance()>=1000; }
    public double calculateLoanEligibility(){ return getBalance()*5; }
}
class CurrentAccount extends BankAccount {
    public CurrentAccount(String no,String name,double bal){ super(no,name,bal); }
    public double calculateInterest(){ return 0; }
}
public class BankingSystem {
    public static void main(String[] args){
        ArrayList<BankAccount> accounts=new ArrayList<>();
        accounts.add(new SavingsAccount("AC1","Ravi",10000));
        accounts.add(new CurrentAccount("AC2","Mina",2000));
        for(BankAccount a:accounts){
            System.out.println(a.getHolderName()+" interest:"+a.calculateInterest());
            if(a instanceof Loanable) System.out.println("LoanElig:" + ((Loanable)a).calculateLoanEligibility());
        }
    }
}
