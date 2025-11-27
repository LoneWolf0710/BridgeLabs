class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Savings Account with interest rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Checking Account with withdrawal limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int maturityPeriod;

    FixedDepositAccount(int accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    void displayAccountType() {
        System.out.println("Fixed Deposit Account with maturity period: " + maturityPeriod + " months");
    }
}

public class BankAccounts {
    public static void main(String[] args) {
        BankAccount b1 = new SavingsAccount(101, 5000, 4.5);
        BankAccount b2 = new CheckingAccount(102, 10000, 2000);
        BankAccount b3 = new FixedDepositAccount(103, 20000, 12);

        ((SavingsAccount)b1).displayAccountType();
        ((CheckingAccount)b2).displayAccountType();
        ((FixedDepositAccount)b3).displayAccountType();
    }
}
