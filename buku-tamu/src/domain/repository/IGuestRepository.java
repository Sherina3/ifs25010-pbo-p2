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
    public Guest save(String name, String purpose) {
        Guest guest = new Guest(idCounter++, name, purpose);
        guests.add(guest);
        return guest;
    }
}