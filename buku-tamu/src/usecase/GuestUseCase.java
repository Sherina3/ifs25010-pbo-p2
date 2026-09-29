package usecase;

import domain.entity.Guest;
import domain.repository.IGuestRepository;
import java.util.ArrayList;
import java.util.List;

public class GuestUseCase {
    private final IGuestRepository repository;

    public GuestUseCase(IGuestRepository repository) {
        this.repository = repository;
    }

    public List<Guest> getAllGuests() {
        return repository.findAll();
    }

    public Guest addGuest(String name, String purpose) {
        return repository.save(name, purpose);
    }

    public List<Guest> searchGuests(String keyword) {
        List<Guest> allGuests = repository.findAll();
        List<Guest> results = new ArrayList<>();
        if (keyword != null && !keyword.trim().isEmpty()) {
            for (Guest guest : allGuests) {
                if (guest.getName().toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(guest);
                }
            }
        }
        return results;
    }

    public boolean deleteGuest(int id) {
        return repository.deleteById(id);
    }
}