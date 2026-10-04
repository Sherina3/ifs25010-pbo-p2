package adapter.repository;

import domain.entity.Guest;
import domain.repository.IGuestRepository; // <-- Import yang benar
import java.util.ArrayList;
import java.util.List;

public class GuestRepository implements IGuestRepository {
<<<<<<< HEAD
    private final List<Guest> database = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public Guest addGuest(String name, String purpose) {
        Guest guest = new Guest(idCounter++, name, purpose);
        database.add(guest);
        return guest;
    }

    @Override
    public List<Guest> getAllGuests() {
        return database;
=======
    // Penyimpanan data tamu secara in-memory
    private final List<Guest> data = new ArrayList<>();
    // ID auto-increment dimulai dari 1
    private int idCounter = 0;

    @Override
    public List<Guest> findAll() {
        // Kembalikan salinan defensif agar caller tidak dapat memodifikasi list internal
        return new ArrayList<>(data);
    }

    @Override
    public Optional<Guest> findById(int id) {
        // Mengembalikan referensi langsung ke objek dalam list;
        // mutasi harus selalu diikuti pemanggilan update() agar kontrak repository terpenuhi
        return data.stream().filter(g -> g.getId() == id).findFirst();
>>>>>>> 25ed260698a420d91dda95444012d41bf4a61474
    }

    @Override
    public List<Guest> searchGuests(String keyword) {
        List<Guest> results = new ArrayList<>();
        for (Guest guest : database) {
            if (guest.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(guest);
            }
        }
        return results;
    }

    @Override
    public boolean deleteGuest(int id) {
        return database.removeIf(guest -> guest.getId() == id);
    }
<<<<<<< HEAD
}
=======

    @Override
    public void update(Guest guest) {
        // Timpa elemen lama dengan objek yang telah diperbarui berdasarkan kecocokan ID
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == guest.getId()) {
                data.set(i, guest);
                return;
            }
        }
    }
}
>>>>>>> 25ed260698a420d91dda95444012d41bf4a61474
