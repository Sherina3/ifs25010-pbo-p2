import adapter.presenter.FinancePresenter;
import adapter.repository.TransactionRepository;
import domain.repository.ITransactionRepository;
import framework.view.FinanceView;
import usecase.FinanceUseCase;

public class App {
    public static void main(String[] args) {
        ITransactionRepository repository = new TransactionRepository();
        FinancePresenter presenter = new FinancePresenter();
        FinanceUseCase useCase = new FinanceUseCase(repository);
        FinanceView view = new FinanceView(useCase, presenter);

        view.show();
    }
}