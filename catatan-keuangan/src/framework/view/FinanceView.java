package framework.view;

import adapter.presenter.FinancePresenter;
import domain.entity.SortOption;
import domain.entity.Transaction;
import framework.util.InputUtil;
import usecase.FinanceUseCase;

import java.util.List;

public class FinanceView {
    private final FinanceUseCase useCase;
    private final FinancePresenter presenter;

    public FinanceView(FinanceUseCase useCase, FinancePresenter presenter) {
        this.useCase = useCase;
        this.presenter = presenter;
    }

    public void show() {
        while (true) {
            // Tampilkan daftar transaksi dan saldo
            presenter.showTransactions(useCase.getAllTransactions(), useCase.getBalance());
            presenter.showMenu();

            String choice = InputUtil.input("Pilih : ");

            if ("1".equals(choice)) {
                System.out.println("[Tambah Pemasukan]");
                String desc = InputUtil.input("Keterangan (x Jika Batal) : ");
                if ("x".equalsIgnoreCase(desc)) {
                    System.out.println();
                    continue;
                }

                String amountStr = InputUtil.input("Jumlah : ");
                try {
                    double amount = Double.parseDouble(amountStr);
                    Transaction t = useCase.addIncome(desc, amount);
                    presenter.showAddSuccess(t);
                } catch (NumberFormatException e) {
                    presenter.showInvalidAmount();
                }
                System.out.println();

            } else if ("2".equals(choice)) {
                System.out.println("[Tambah Pengeluaran]");
                String desc = InputUtil.input("Keterangan (x Jika Batal) : ");
                if ("x".equalsIgnoreCase(desc)) {
                    System.out.println();
                    continue;
                }

                String amountStr = InputUtil.input("Jumlah : ");
                try {
                    double amount = Double.parseDouble(amountStr);
                    Transaction t = useCase.addExpense(desc, amount);
                    presenter.showAddSuccess(t);
                } catch (NumberFormatException e) {
                    presenter.showInvalidAmount();
                }
                System.out.println();

            } else if ("3".equals(choice)) {
                System.out.println("[Mencari Transaksi]");
                String keyword = InputUtil.input("Keterangan (x Jika Batal) : ");
                if ("x".equalsIgnoreCase(keyword)) {
                    System.out.println();
                    continue;
                }

                List<Transaction> results = useCase.searchTransactions(keyword);
                presenter.showSearchResults(results, keyword);
                System.out.println();

            } else if ("4".equals(choice)) {
                System.out.println("[Urutkan Transaksi]");
                System.out.println("1. Jumlah Terbesar");
                System.out.println("2. Jumlah Terkecil");
                String sortChoice = InputUtil.input("Pilih Opsi : ");
                
                SortOption option = null;
                if ("1".equals(sortChoice)) {
                    option = SortOption.AMOUNT_DESC;
                } else if ("2".equals(sortChoice)) {
                    option = SortOption.AMOUNT_ASC;
                }

                if (option != null) {
                    presenter.showSortedTransactions(useCase.sortTransactions(option), useCase.getBalance());
                } else {
                    presenter.showInvalidSortOption();
                }
                System.out.println();

            } else if ("5".equals(choice)) {
                presenter.showBalance(useCase.getBalance());
                System.out.println();

            } else if ("6".equals(choice)) {
                System.out.println("[Menghapus Transaksi]");
                String idStr = InputUtil.input("[ID Transaksi] yang dihapus (x Jika Batal) : ");
                if ("x".equalsIgnoreCase(idStr)) {
                    System.out.println();
                    continue;
                }

                try {
                    int id = Integer.parseInt(idStr);
                    boolean isDeleted = useCase.deleteTransaction(id);
                    if (isDeleted) {
                        presenter.showRemoveSuccess();
                    } else {
                        presenter.showRemoveFailed(id);
                    }
                } catch (NumberFormatException e) {
                    presenter.showInvalidId();
                }
                System.out.println();

            } else if ("x".equalsIgnoreCase(choice)) {
                break;

            } else {
                presenter.showInvalidChoice();
                System.out.println();
            }
        }
    }
}