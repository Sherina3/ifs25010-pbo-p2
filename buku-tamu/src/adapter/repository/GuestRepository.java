package adapter.repository;

import domain.entity.Guest;
import domain.repository.IGuestRepository;
import java.util.ArrayList;
import java.util.List;

public class GuestRepository implements IGuestRepository {
    private final List<Guest> guests = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public List<Guest> findAll() {
        return guests;
    }

    @Override
    public Guest findById(int id) {
        for (Guest g : guests) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    @Override
    public Guest save(String name, String purpose) {
        Guest guest = new Guest(idCounter++, name, purpose);
        guests.add(guest);
        return guest;
    }

    @Override
    public boolean deleteById(int id) {
        return guests.removeIf(g -> g.getId() == id);
    }

    // Tempatkan method update di sini
    @Override
    public boolean update(Guest guest) {
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getId() == guest.getId()) {
                guests.set(i, guest);
                return true;
            }
        }
        return false;
    }
}