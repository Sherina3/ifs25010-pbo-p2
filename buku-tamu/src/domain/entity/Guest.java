package domain.entity;

/**
 * Entity inti yang merepresentasikan satu tamu.
 * Tidak ada fitur ubah data tamu, sehingga seluruh field bersifat final.
 */
public class Guest {
    /** ID unik tamu. */
    private final int id;

    /** Nama tamu. */
    private final String name;

    /** Tujuan kunjungan. */
    private final String purpose;

    public Guest(int id, String name, String purpose) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPurpose() {
        return purpose;
    }
}
