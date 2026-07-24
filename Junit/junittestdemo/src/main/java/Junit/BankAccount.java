package Junit;

public class BankAccount {
    String bankAccountNumber;
    double balance;
    
    public BankAccount(String bankAccountNumber, double balance) {
        this.bankAccountNumber = bankAccountNumber;
        this.balance = balance;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void withDraw(double amount) throws IllegalArgumentException{
        if(balance < amount){
            throw new IllegalArgumentException("No sufficient Balance");
        }
        balance -= amount;
        System.out.println("Amount Withdrawed");
    }

    public void deposit(double amount) throws IllegalArgumentException{
        if(amount <= 0){
            throw new IllegalArgumentException("Deposit must be more than 0!");
        }
        balance += amount;
        System.out.println("Amount deposited");
    }
    
}
