import java.util.ArrayList;

class TransactionManager {
    private static TransactionManager instance = new TransactionManager();
    private ArrayList<String> transactionList;

    private TransactionManager() {
    	// Put your code here
    	this.transactionList = new ArrayList<>();
    }

    public void clear() {
    	this.transactionList.clear();
    }
    
    public static TransactionManager getInstance() {
    	// Put your code here
    	return instance;
    }

    public void logTransaction(String transaction) {
    	// Put your code here
    	this.transactionList.add(transaction);
    }

    public ArrayList<String> getTransactionList() {
        return transactionList;
    }
}
