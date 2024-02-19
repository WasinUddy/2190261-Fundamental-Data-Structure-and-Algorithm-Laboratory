import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Sample usage
        try {
            Account sourceAccount = new Account("123456", "Source Account");
            Account targetAccount = new Account("654321", "Target Account");

            sourceAccount.deposit(500.0);
            sourceAccount.withdraw(200.0);
            sourceAccount.transfer(targetAccount, 100.0);

            System.out.println("Source Account Balance: " + sourceAccount.getBalance());
            System.out.println("Target Account Balance: " + targetAccount.getBalance());

            // Display logged transactions
            System.out.println("Logged Transactions:");
            TransactionManager.getInstance().getTransactionList().forEach(System.out::println);

        } catch (NegativeAmountException | InsufficientAmountException e) {
            e.printStackTrace();
        }
    }
}