package adapter.repository;

import domain.entity.SortOption;
import domain.entity.Transaction;
import domain.repository.ITransactionRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionRepository implements ITransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }

    @Override
    public Transaction getTransactionById(int id) {
        return transactions.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteTransaction(int id) {
        return transactions.removeIf(t -> t.getId() == id);
    }

    @Override
    public List<Transaction> searchTransactions(String query) {
        String lowerQuery = query.toLowerCase();
        return transactions.stream()
                .filter(t -> t.getDescription().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getSortedTransactions(SortOption sortOption) {
        List<Transaction> sortedList = new ArrayList<>(transactions);
        switch (sortOption) {
            case ID_ASC:
                sortedList.sort(Comparator.comparingInt(Transaction::getId));
                break;
            case ID_DESC:
                sortedList.sort((t1, t2) -> Integer.compare(t2.getId(), t1.getId()));
                break;
            case AMOUNT_ASC:
                sortedList.sort(Comparator.comparingDouble(Transaction::getAmount));
                break;
            case AMOUNT_DESC:
                sortedList.sort((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()));
                break;
        }
        return sortedList;
    }
}