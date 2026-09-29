package framework.view;

import adapter.presenter.GuestPresenter;
import framework.util.InputUtil;
import usecase.GuestUseCase;
import domain.entity.Guest;
import java.util.List;

public class GuestView {
    private final GuestUseCase guestUseCase;
    private final GuestPresenter guestPresenter;

    public GuestView(GuestUseCase guestUseCase, GuestPresenter guestPresenter) {
        this.guestUseCase = guestUseCase;
        this.guestPresenter = guestPresenter;
    }

    public void show() {
        while (true) {
            // 1. Tampilkan daftar tamu
            List<Guest> guests = guestUseCase.getAllGuests();
            guestPresenter.showGuests(guests);

            // 2. Tampilkan menu
            guestPresenter.showMenu();

            // 3. Prompt pilih menu
            String menuOption = InputUtil.input("Pilih : ");

            if ("1".equals(menuOption)) {
                System.out.println("[Mendaftarkan Tamu]");
                String name = InputUtil.input("Nama (x Jika Batal) : ");
                if ("x".equalsIgnoreCase(name)) {
                    continue;
                }

                String purpose = InputUtil.input("Tujuan Kunjungan (x Jika Batal) : ");
                if ("x".equalsIgnoreCase(purpose)) {
                    continue;
                }

                Guest createdGuest = guestUseCase.addGuest(name, purpose);
                guestPresenter.showAddSuccess(createdGuest);
                System.out.println();

            } else if ("2".equals(menuOption)) {
                System.out.println("[Mencari Tamu]");
                String keyword = InputUtil.input("Nama (x Jika Batal) : ");
                if ("x".equalsIgnoreCase(keyword)) {
                    continue;
                }

                List<Guest> searchResults = guestUseCase.searchGuests(keyword);
                guestPresenter.showSearchResults(keyword, searchResults);
                System.out.println();

            } else if ("3".equals(menuOption)) {
                System.out.println("[Menghapus Tamu]");
                String idInput = InputUtil.input("[ID Tamu] yang dihapus (x Jika Batal) : ");
                if ("x".equalsIgnoreCase(idInput)) {
                    continue;
                }

                try {
                    int id = Integer.parseInt(idInput);
                    boolean isDeleted = guestUseCase.deleteGuest(id);
                    if (isDeleted) {
                        System.out.println("Berhasil menghapus tamu.");
                    } else {
                        System.out.println("[!] ID tidak valid!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("[!] ID tidak valid!");
                }
                System.out.println();

            } else if ("x".equalsIgnoreCase(menuOption)) {
                break;

            } else {
                // Perbaikan di sini: Menambahkan "[!] "
                System.out.println("[!] Pilihan tidak dimengerti.");
                System.out.println();
            }
        }
    }
}