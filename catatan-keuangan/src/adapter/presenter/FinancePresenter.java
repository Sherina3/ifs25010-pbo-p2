package adapter.presenter;

import domain.entity.Transaction;
import domain.entity.TransactionType;
import java.util.List;

public class FinancePresenter {

    public void showTransactions(List<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        for (Transaction t : transactions) {
            System.out.println("[" + t.getId() + "] " + t.getType() + " - " + t.getDescription() + " - Rp" + (long)t.getAmount());
        }
    }

    public void showBalance(double totalIncome, double totalExpense, double balance) {
        System.out.println("Total Pemasukan  : Rp" + (long)totalIncome);
        System.out.println("Total Pengeluaran: Rp" + (long)totalExpense);
        System.out.println("Saldo Akhir      : Rp" + (long)balance);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String error) {
        System.out.println("Error: " + error);
    }
}