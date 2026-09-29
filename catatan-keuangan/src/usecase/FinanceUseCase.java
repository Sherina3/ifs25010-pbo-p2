package usecase;

import domain.entity.SortOption;
import domain.entity.Transaction;
import domain.entity.TransactionType;
import domain.repository.FinanceRepository; // <-- Disesuaikan ke FinanceRepository

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FinanceUseCase {
    private final FinanceRepository repository; // <-- Ubah ke FinanceRepository

    public FinanceUseCase(FinanceRepository repository) { // <-- Ubah ke FinanceRepository
        this.repository = repository;
    }

    public Transaction addIncome(String description, double amount) {
        return repository.addTransaction(description, amount, TransactionType.INCOME);
    }

    public Transaction addExpense(String description, double amount) {
        return repository.addTransaction(description, amount, TransactionType.EXPENSE);
    }

    public boolean deleteTransaction(int id) {
        return repository.deleteTransaction(id);
    }

    public List<Transaction> getAllTransactions() {
        return repository.getAllTransactions();
    }

    public double getBalance() {
        return repository.getBalance();
    }

    public List<Transaction> searchTransactions(String keyword) {
        return repository.searchTransactions(keyword);
    }

    public List<Transaction> sortTransactions(SortOption option) {
        List<Transaction> transactions = new ArrayList<>(repository.getAllTransactions());
        if (option == SortOption.AMOUNT_DESC) {
            transactions.sort((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()));
        } else if (option == SortOption.AMOUNT_ASC) {
            transactions.sort(Comparator.comparingDouble(Transaction::getAmount));
        }
        return transactions;
    }
}