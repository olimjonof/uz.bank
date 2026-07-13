public class BankAccount {

    //Encapsulation
    private String accountNumber;
    private String ownerName;
    private double balance;

    //Constructor
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){

        if (amount<=0){
            throw new RuntimeException("Kiritilgan summa musbat bo'lishi kerak !!!");
        }

        balance+=amount;
    }

    public void withdraw(double amount){

        if (amount<=0){
            throw new RuntimeException("Yechiladigan summa musbat bo'lsihi kerak !!!");
        }
        if (amount>balance){
            throw new RuntimeException("Hisobda mablag' yetarli emas !!!");
        }

        balance-=amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
