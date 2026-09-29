package framework.view;

import adapter.presenter.FinancePresenter;
import domain.entity.SortOption;
import domain.entity.TransactionType;
import framework.util.InputUtil;
import usecase.FinanceUseCase;

public class FinanceView {
    private final FinanceUseCase useCase;
    private final FinancePresenter presenter;

    public FinanceView(FinanceUseCase useCase, FinancePresenter presenter) {
        this.useCase = useCase;
        this.presenter = presenter;
    }

    public void show() {
        while (true) {
            System.out.println("\n=== APLIKASI CATATAN KEUANGAN ===");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Lihat Semua Transaksi");
            System.out.println("3. Cari Transaksi");
            System.out.println("4. Urutkan Transaksi");
            System.out.println("5. Hapus Transaksi");
            System.out.println("6. Lihat Ringkasan Saldo");
            System.out.println("x. Keluar");

            String input = InputUtil.input("Pilih menu");
            if (input.equalsIgnoreCase("x")) {
                break;
            }

            switch (input) {
                case "1":
                    addTransaction();
                    break;
                case "2":
                    presenter.showTransactions(useCase.getAllTransactions());
                    break;
                case "3":
                    searchTransaction();
                    break;
                case "4":
                    sortTransactions();
                    break;
                case "5":
                    deleteTransaction();
                    break;
                case "6":
                    presenter.showBalance(useCase.getTotalIncome(), useCase.getTotalExpense(), useCase.getBalance());
                    break;
                default:
                    presenter.showError("Pilihan menu tidak valid!");
                    break;
            }
        }
    }

    private void addTransaction() {
        System.out.println("\n--- Tambah Transaksi ---");
        String typeStr = InputUtil.input("Tipe (1: Pemasukan, 2: Pengeluaran) (x untuk batal)");
        if (typeStr.equalsIgnoreCase("x")) return;

        TransactionType type;
        if (typeStr.equals("1")) {
            type = TransactionType.PEMASUKAN;
        } else if (typeStr.equals("2")) {
            type = TransactionType.PENGELUARAN;
        } else {
            presenter.showError("Tipe transaksi tidak valid!");
            return;
        }

        String desc = InputUtil.input("Deskripsi (x untuk batal)");
        if (desc.equalsIgnoreCase("x")) return;

        String amountStr = InputUtil.input("Nominal (x untuk batal)");
        if (amountStr.equalsIgnoreCase("x")) return;

        try {
            double amount = Double.parseDouble(amountStr);
            if (amount <= 0) {
                presenter.showError("Nominal harus lebih dari 0!");
                return;
            }
            useCase.addTransaction(desc, amount, type);
            presenter.showMessage("Transaksi berhasil ditambahkan!");
        } catch (NumberFormatException e) {
            presenter.showError("Nominal tidak valid!");
        }
    }

    private void searchTransaction() {
        String query = InputUtil.input("Masukkan kata kunci pencarian (x untuk batal)");
        if (query.equalsIgnoreCase("x")) return;
        presenter.showTransactions(useCase.searchTransactions(query));
    }

    private void sortTransactions() {
        System.out.println("1. ID Ascending\n2. ID Descending\n3. Nominal Ascending\n4. Nominal Descending");
        String opt = InputUtil.input("Pilih urutan (x untuk batal)");
        if (opt.equalsIgnoreCase("x")) return;

        SortOption sortOption;
        switch (opt) {
            case "1": sortOption = SortOption.ID_ASC; break;
            case "2": sortOption = SortOption.ID_DESC; break;
            case "3": sortOption = SortOption.AMOUNT_ASC; break;
            case "4": sortOption = SortOption.AMOUNT_DESC; break;
            default:
                presenter.showError("Pilihan urutan tidak valid!");
                return;
        }
        presenter.showTransactions(useCase.getSortedTransactions(sortOption));
    }

    private void deleteTransaction() {
        String idStr = InputUtil.input("Masukkan ID transaksi yang ingin dihapus (x untuk batal)");
        if (idStr.equalsIgnoreCase("x")) return;

        try {
            int id = Integer.parseInt(idStr);
            if (useCase.deleteTransaction(id)) {
                presenter.showMessage("Transaksi berhasil dihapus!");
            } else {
                presenter.showError("Transaksi dengan ID tersebut tidak ditemukan!");
            }
        } catch (NumberFormatException e) {
            presenter.showError("ID tidak valid!");
        }
    }
}