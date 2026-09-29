package adapter.presenter;

import domain.entity.Transaction;
import java.util.List;

public class FinancePresenter {

    public FinancePresenter() {
    }

    // 1. Menampilkan daftar transaksi beserta saldo (2 parameter)
    public void showTransactions(List<Transaction> transactions, double balance) {
        System.out.println("Daftar Transaksi:");
        if (transactions == null || transactions.isEmpty()) {
            System.out.println("- Belum ada transaksi!");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t.getId() + " | " + t.getDescription() + " | Rp" + (long) t.getAmount() + " | " + t.getType());
            }
        }
        System.out.println("Saldo: Rp" + (long) balance);
    }

    // 2. Menampilkan menu utama
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

    // 3. Menampilkan pesan sukses tambah transaksi
    public void showAddSuccess(Transaction transaction) {
        System.out.println("Berhasil menambah transaksi: " + transaction.getId() + " | " + transaction.getDescription() + " | Rp" + (long) transaction.getAmount() + " | " + transaction.getType());
    }

    // 4. Menampilkan saldo saat ini
    public void showBalance(double balance) {
        System.out.println("Saldo: Rp" + (long) balance);
    }

    // 5. Menampilkan hasil pencarian (List, String)
    public void showSearchResults(List<Transaction> results, String keyword) {
        System.out.println("Hasil Pencarian: \"" + keyword + "\"");
        if (results == null || results.isEmpty()) {
            System.out.println("- Catatan tidak ditemukan!");
        } else {
            for (Transaction t : results) {
                System.out.println(t.getId() + " | " + t.getDescription() + " | Rp" + (long) t.getAmount() + " | " + t.getType());
            }
        }
    }

    // 6. Menampilkan transaksi yang diurutkan (List, double)
    public void showSortedTransactions(List<Transaction> transactions, double balance) {
        showTransactions(transactions, balance);
    }

    // 7. Pesan sukses & gagal hapus
    public void showRemoveSuccess() {
        System.out.println("Berhasil menghapus transaksi.");
    }

    public void showRemoveFailed(int id) {
        System.out.println("[!] Gagal menghapus transaksi dengan ID: " + id + ".");
    }

    // 8. Pesan-pesan error/validasi input
    public void showInvalidChoice() {
        System.out.println("[!] Pilihan tidak dimengerti.");
    }

    public void showInvalidAmount() {
        System.out.println("[!] Jumlah tidak valid!");
    }

    public void showInvalidSortOption() {
        System.out.println("[!] Opsi pengurutan tidak valid!");
    }

    public void showInvalidId() {
        System.out.println("[!] ID tidak valid!");
    }
}