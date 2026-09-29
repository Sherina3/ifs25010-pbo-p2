package adapter.presenter;

import domain.entity.Transaction;
import domain.entity.TransactionType;
import java.util.List;

public class FinancePresenter {

    public void showTransactions(List<Transaction> transactions) {
        System.out.println("Daftar Transaksi:");
        if (transactions.isEmpty()) {
            System.out.println("- Belum ada transaksi!");
            return;
        }
        for (Transaction t : transactions) {
            showSingleTransaction(t);
        }
    }

    public void showSingleTransaction(Transaction t) {
        String typeStr = (t.getType() == TransactionType.PEMASUKAN) ? "Pemasukan" : "Pengeluaran";
        System.out.println(t.getId() + " | " + t.getDescription() + " | Rp " + (long)t.getAmount() + " | " + typeStr);
    }

    public void showBalance(double balance) {
        System.out.println("Saldo: Rp " + (long)balance);
    }

    public void showBalance(long balance) {
        System.out.println("Saldo: Rp " + balance);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String error) {
        System.out.println("Error: " + error);
    }
}