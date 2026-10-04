package adapter.repository;

import domain.entity.SortOption;
import domain.entity.Transaction;
import domain.entity.TransactionType;
import domain.repository.ITransactionRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionRepository implements ITransactionRepository {
<<<<<<< HEAD
    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
=======
    // Penyimpanan data transaksi secara in-memory
    private final List<Transaction> data = new ArrayList<>();
    // ID auto-increment dimulai dari 1
    private int idCounter = 0;

    @Override
    public List<Transaction> findAll() {
        // Kembalikan salinan defensif agar caller tidak dapat memodifikasi list internal
        return new ArrayList<>(data);
    }

    @Override
    public Optional<Transaction> findById(int id) {
        // Mengembalikan referensi langsung ke objek dalam list;
        // mutasi harus selalu diikuti pemanggilan update() agar kontrak repository terpenuhi
        return data.stream().filter(t -> t.getId() == id).findFirst();
>>>>>>> 25ed260698a420d91dda95444012d41bf4a61474
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
<<<<<<< HEAD
    public List<Transaction> searchTransactions(String query) {
        String lowerQuery = query.toLowerCase();
        return transactions.stream()
                .filter(t -> t.getDescription().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toList());
=======
    public void update(Transaction transaction) {
        // Timpa elemen lama dengan objek yang telah diperbarui berdasarkan kecocokan ID
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == transaction.getId()) {
                data.set(i, transaction);
                return;
            }
        }
>>>>>>> 25ed260698a420d91dda95444012d41bf4a61474
    }

    @Override
    public List<Transaction> getSortedTransactions(SortOption sortOption) {
        List<Transaction> sortedList = new ArrayList<>(transactions);
        switch (sortOption) {
            case AMOUNT_ASC:
                sortedList.sort(Comparator.comparingDouble(Transaction::getAmount));
                break;
            case AMOUNT_DESC:
                sortedList.sort(Comparator.comparingDouble(Transaction::getAmount).reversed());
                break;
            case INCOME_FIRST:
                sortedList.sort(Comparator.comparing(t -> t.getType() != TransactionType.PEMASUKAN));
                break;
            case EXPENSE_FIRST:
                sortedList.sort(Comparator.comparing(t -> t.getType() != TransactionType.PENGELUARAN));
                break;
        }
        return sortedList;
    }
}