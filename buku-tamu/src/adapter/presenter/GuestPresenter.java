package adapter.presenter;

import domain.entity.Guest;
import usecase.GuestUseCase;
import java.util.List;

public class GuestPresenter {
    private final GuestUseCase useCase;

    public GuestPresenter(GuestUseCase useCase) {
        this.useCase = useCase;
    }

    public void showAllGuests() {
        List<Guest> guests = useCase.getAllGuests();
        System.out.println("Daftar Tamu:");
        if (guests.isEmpty()) {
            System.out.println("- Data tamu belum tersedia!");
        } else {
            for (Guest guest : guests) {
                System.out.println(guest.getId() + " | " + guest.getName() + " | " + guest.getPurpose());
            }
        }
    }

    public void addGuest(String name, String purpose) {
        Guest guest = useCase.addGuest(name, purpose);
        System.out.println("Berhasil mendaftarkan tamu: " + guest.getId() + " | " + guest.getName() + " | " + guest.getPurpose());
    }
}