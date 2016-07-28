import java.util.ArrayList;
import java.util.Random;

public class Account {
    private String id;
    private Type type;
    private float balance;
    private ArrayList<Transaction> transactions;
    private int numOverdrafts;
    private boolean accountClosed;

    public Account(Type type) {
        Random rand = new Random();
        id = String.valueOf(Math.abs(rand.nextLong()));
        this.type = type;
        this.transactions = new ArrayList<Transaction>();
        this.numOverdrafts = 0;
        this.accountClosed = false;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public float getBalance() {
        return balance;
    }

    public void deposit(float amount) {
        Transaction t = new Transaction(amount, TransactionType.DEPOSIT);
        this.transactions.add(t);
        this.balance += amount;
    }

    public void withdraw(float amount) {
        if (this.balance >= amount) {
            Transaction t = new Transaction(amount, TransactionType.WITHDRAWAL);
            this.transactions.add(t);
            this.balance -= amount;
        } else {
            this.numOverdrafts++;
            if (this.numOverdrafts >= 3) {
                this.accountClosed = true;
            }
            this.balance -= 50.0f;
        }
    }

    public int getNumOverDrafts() {
        return this.numOverdrafts;
    }

    public boolean isAccountClosed() {
        return this.accountClosed;
    }

}
