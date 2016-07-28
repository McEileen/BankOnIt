import java.time.LocalDateTime;
import java.util.Random;


public class Transaction {
    private float amount;
    private TransactionType type;
    private String id;
    private LocalDateTime localDateTime;

    public Transaction(float amount, TransactionType type) {
        this.amount = amount;
        this.type = type;
        this.localDateTime = LocalDateTime.now();
        Random rand = new Random();
        id = String.valueOf(Math.abs(rand.nextLong()));
    }

    public TransactionType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return localDateTime;
    }

    public float getAmount() {
        return amount;
    }
    @Override
    public String toString() {
        return this.id + " made a " + this.type + " of " + String.format("%.2f", this.amount) + " on " + this.localDateTime.toString();
    }


}
