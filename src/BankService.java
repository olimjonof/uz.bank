import java.util.HashMap;
import java.util.Map;

public class BankService {
    private final Map<String, BankAccount> accounts = new HashMap<>();

    public void createAccount(BankAccount account){
        accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount findAccount(String accountNumber){
        BankAccount account = accounts.get(accountNumber);
        if (account == null){
            throw new RuntimeException("Hisob topilmadi !!!");
        }
        return account;
    }
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount){

        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        //withdraw
        fromAccount.withdraw(amount);

        // add
        toAccount.deposit(amount);
        System.out.println(amount + " so'm " +
                fromAccount.getOwnerName() +
                " hisobidan " +
                toAccount.getOwnerName() +
                " hisobiga muvafaqqiyatli o'tkazildi.");

    }
}
