package adapter.presenter;

import domain.entity.Transaction;
import java.util.List;

public class FinancePresenter {

    public void showTransactions(List<Transaction> transactions) {
        System.out.println("Daftar Transaksi:");
        if (transactions == null || transactions.isEmpty()) {
            System.out.println("- Belum ada transaksi!");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t.getId() + " | " + t.getDescription() + " | Rp" + t.getAmount() + " | " + t.getType());
            }
        }
    }

    // --- PERBAIKAN DI SINI ---
    // Ubah "Saldo saat ini: Rp" menjadi "Saldo: Rp"
    public void showBalance(long balance) {
        System.out.println("Saldo: Rp" + balance);
    }

    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Pemasukan");
        System.out.println("2. Tambah Pengeluaran");
        System.out.println("3. Cari");
        System.out.println("4. Urutkan");
        System.out.println("5. Lihat Saldo");
        System.out.println("6. Hapus");
        System.out.println("x. Keluar");
    }

    public void showAddSuccess(Transaction transaction) {
        System.out.println("Berhasil menambah transaksi: " + transaction.getId() + " | " + transaction.getDescription() + " | Rp" + transaction.getAmount() + " | " + transaction.getType());
    }
}