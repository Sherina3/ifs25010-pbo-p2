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
        // Tampilkan daftar transaksi & saldo awal sebelum menu utama
        presenter.showTransactions(useCase.getAllTransactions());
        presenter.showBalance((long) useCase.getBalance());

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Pemasukan");
            System.out.println("2. Tambah Pengeluaran");
            System.out.println("3. Cari");
            System.out.println("4. Urutkan");
            System.out.println("5. Lihat Saldo");
            System.out.println("6. Hapus");
            System.out.println("x. Keluar");

            String input = InputUtil.input("Pilih");
            if (input.equalsIgnoreCase("x")) {
                break;
            }

            switch (input) {
                case "1":
                    addTransaction(TransactionType.PEMASUKAN);
                    break;
                case "2":
                    addTransaction(TransactionType.PENGELUARAN);
                    break;
                case "3":
                    searchTransaction();
                    break;
                case "4":
                    sortTransactions();
                    break;
                case "5":
                    presenter.showBalance((long) useCase.getBalance());
                    break;
                case "6":
                    deleteTransaction();
                    break;
                default:
                    presenter.showError("Pilihan menu tidak valid!");
                    break;
            }
        }
    }

    private void addTransaction(TransactionType type) {
        if (type == TransactionType.PEMASUKAN) {
            System.out.println("[Tambah Pemasukan]");
        } else {
            System.out.println("[Tambah Pengeluaran]");
        }

        String desc = InputUtil.input("Keterangan (x Jika Batal)");
        if (desc.equalsIgnoreCase("x")) return;

        String amountStr = InputUtil.input("Jumlah");
        if (amountStr.equalsIgnoreCase("x")) return;

        try {
            double amount = Double.parseDouble(amountStr);
            useCase.addTransaction(desc, amount, type);

            var transactions = useCase.getAllTransactions();
            var lastTx = transactions.get(transactions.size() - 1);
            
            // Hanya cetak konfirmasi berhasil tambah
            System.out.print("Berhasil menambah transaksi: ");
            presenter.showSingleTransaction(lastTx);

        } catch (NumberFormatException e) {
            presenter.showError("Nominal tidak valid!");
        }
    }

    private void searchTransaction() {
        String query = InputUtil.input("Cari");
        if (query.equalsIgnoreCase("x")) return;
        presenter.showTransactions(useCase.searchTransactions(query));
    }

    private void sortTransactions() {
        String opt = InputUtil.input("Urutkan (1: ID ASC, 2: ID DESC, 3: Nominal ASC, 4: Nominal DESC)");
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
        String idStr = InputUtil.input("ID Transaksi yang dihapus");
        if (idStr.equalsIgnoreCase("x")) return;

        try {
            int id = Integer.parseInt(idStr);
            if (useCase.deleteTransaction(id)) {
                presenter.showMessage("Transaksi berhasil dihapus!");
            } else {
                presenter.showError("Transaksi tidak ditemukan!");
            }
        } catch (NumberFormatException e) {
            presenter.showError("ID tidak valid!");
        }
    }
}