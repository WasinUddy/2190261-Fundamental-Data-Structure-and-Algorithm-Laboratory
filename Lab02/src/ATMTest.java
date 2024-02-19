import static org.junit.Assert.*;
import org.junit.*;

public class ATMTest {

    // Creating a sample account for testing
    private Account testAccount;

    @Before
    public void setUp() {
        // Initialize a test account before each test
        testAccount = new Account("123456", "Test Account");
    }

    @Test
    public void testDeposit() {
        try {
        	TransactionManager.getInstance().clear();
            testAccount.deposit(100.0);
            assertEquals(100.0, testAccount.getBalance(), 0.001);

            // Ensure that the deposit transaction is logged
            assertEquals(1, TransactionManager.getInstance().getTransactionList().size());
            assertTrue(TransactionManager.getInstance().getTransactionList().get(0).contains("DEPOSIT"));

            testAccount.deposit(50.0);
            assertEquals(150.0, testAccount.getBalance(), 0.001);
            // Ensure that the deposit transaction is logged
            assertEquals(2, TransactionManager.getInstance().getTransactionList().size());
            assertTrue(TransactionManager.getInstance().getTransactionList().get(0).contains("DEPOSIT"));

        } catch (NegativeAmountException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testWithdraw() {
        try {
        	TransactionManager.getInstance().clear();
            // Deposit initial amount
            testAccount.deposit(200.0);

            // Withdraw a valid amount
            testAccount.withdraw(50.0);
            assertEquals(150.0, testAccount.getBalance(), 0.001);

            // Ensure that the withdrawal transaction is logged
            assertEquals(2, TransactionManager.getInstance().getTransactionList().size());
            assertTrue(TransactionManager.getInstance().getTransactionList().get(0).contains("DEPOSIT"));
            assertTrue(TransactionManager.getInstance().getTransactionList().get(1).contains("WITHDRAW"));

            // Attempt to withdraw an invalid amount (more than the balance)
            try {
                testAccount.withdraw(200.0);
                fail("Expected InsufficientAmount exception");
            } catch (InsufficientAmountException e) {
                // Expected exception
            }

        } catch (NegativeAmountException | InsufficientAmountException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testTransfer() {
        try {
            // Create a second account for testing transfer
            Account targetAccount = new Account("654321", "Target Account");
            TransactionManager.getInstance().clear();
            // Deposit initial amount in the source account
            testAccount.deposit(300.0);

            // Transfer a valid amount
            testAccount.transfer(targetAccount, 100.0);
            assertEquals(200.0, testAccount.getBalance(), 0.001);
            assertEquals(100.0, targetAccount.getBalance(), 0.001);

            // Ensure that the transfer transactions are logged
            assertEquals(2, TransactionManager.getInstance().getTransactionList().size());
            assertTrue(TransactionManager.getInstance().getTransactionList().get(0).contains("DEPOSIT"));
            assertTrue(TransactionManager.getInstance().getTransactionList().get(1).contains("TRANSFER"));

            // Attempt to transfer an invalid amount (more than the balance)
            try {
                testAccount.transfer(targetAccount, 250.0);
                fail("Expected InsufficientAmount exception");
            } catch (InsufficientAmountException e) {
                // Expected exception
            }

        } catch (NegativeAmountException | InsufficientAmountException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testNegativeAmountException() {
        try {
            testAccount.deposit(-50.0);
            fail("Expected NegativeAmount exception");
        } catch (NegativeAmountException e) {
            // Expected exception
        }
    }

    @Test
    public void testInsufficientAmountException() {
        try {
            testAccount.withdraw(100.0);
            fail("Expected InsufficientAmount exception");
        } catch (NegativeAmountException e) {
            fail("Unexpected NegativeAmount exception");
        } catch (InsufficientAmountException e) {
            // Expected exception
        }
    }
}
