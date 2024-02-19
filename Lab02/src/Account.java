public class Account {
    private String accountId;
    private String accountName;
    private TransactionManager transactionManager;
    private double balance;

    public Account(String accountId, String accountName) {
    	// Put your code here
    	this.accountId = accountId;
    	this.accountName = accountName;
    	this.balance = 0;
    }

    public void deposit(double amount) throws NegativeAmountException {
    	// Put your code here
    	
    	if (amount < 0) {
    		throw new NegativeAmountException("Unexpected NegativeAmount exception");
    	}
    	this.balance += amount;
    	this.transactionManager.getInstance().logTransaction("DEPOSIT - Amount: " + amount + " - Account ID: " + this.accountId);	
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientAmountException {
    	// Put your code here
    	if (amount < 0) {
    		throw new NegativeAmountException("Unexpected NegativeAmount exception");
    	}
    	
    	if (this.balance - amount < 0) {
    		throw new InsufficientAmountException("Expected InsufficientAmount exception");
    	}
    	
    	this.balance -= amount;
    	this.transactionManager.getInstance().logTransaction("WITHDRAWAL - Amount: " + amount + " - Account ID: " + this.accountId);
    }

    public void transfer(Account targetAccount, double amount) throws NegativeAmountException, InsufficientAmountException {
    	// Put your code here
    	if (amount < 0) {
    		throw new NegativeAmountException("Unexpected NegativeAmount exception");
    	}
    	
    	if (this.balance - amount < 0) {
    		throw new InsufficientAmountException("Expected InsufficientAmount exception");
    	}
    	
    	targetAccount.balance += amount;
    	
    	this.balance -= amount;
    	
    	this.transactionManager.getInstance().logTransaction("TRANSFER - Amount: " + amount + " - From Account ID: " + this.accountId + " - To Account ID: " + targetAccount.getAccountId());
    }

    public double getBalance() {
        return balance;
    }
    
    public String getAccountId() {
    	return accountId;
    }
    

}