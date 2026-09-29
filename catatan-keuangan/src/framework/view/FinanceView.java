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

    // Ganti nama method di sini menjadi show()
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

    // ... sisa method private (addTransaction, searchTransaction, dll.) tetap sama
}