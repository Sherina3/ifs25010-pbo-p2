package usecase;

import domain.entity.Guest;
import domain.repository.IGuestRepository; // <-- Pastikan baris ini ada
import java.util.List;
import java.util.Locale;

public class GuestUseCase {
    private final IGuestRepository repository;

    public GuestUseCase(IGuestRepository repository) {
        this.repository = repository;
    }

    public Guest addGuest(String name, String purpose) {
        return repository.addGuest(name, purpose);
    }

    public List<Guest> getAllGuests() {
        return repository.getAllGuests();
    }

    public List<Guest> searchGuests(String keyword) {
<<<<<<< HEAD
        return repository.searchGuests(keyword);
=======
        String lowerKeyword = keyword.toLowerCase(Locale.ROOT);
        return repository.findAll().stream()
                .filter(g -> g.getName().toLowerCase(Locale.ROOT).contains(lowerKeyword))
                .toList();
>>>>>>> 25ed260698a420d91dda95444012d41bf4a61474
    }

    public boolean deleteGuest(int id) {
        return repository.deleteGuest(id);
    }
}