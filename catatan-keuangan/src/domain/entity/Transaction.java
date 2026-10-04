package domain.entity;

import java.util.Objects;

public class Transaction {
    private final int id;
    private String description;
    private double amount;
    private TransactionType type;

    public Transaction(int id, String description, double amount, TransactionType type) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public int getId() {
        return id;
    }

<<<<<<< HEAD
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
=======
    public void changeDescription(String description) { this.description = description; }
    public void changeAmount(double amount) { this.amount = amount; }
    public void changeType(TransactionType type) { this.type = type; }

    /** Kesetaraan berdasarkan ID agar aman dikelola dalam koleksi. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction other)) return false;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
>>>>>>> 25ed260698a420d91dda95444012d41bf4a61474
