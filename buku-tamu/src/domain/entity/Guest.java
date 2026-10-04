package domain.entity;

import java.util.Objects;

public class Guest {
    private Integer id;
    private String name;
    private String purpose;

    public Guest(Integer id, String name, String purpose) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
    }

    public Integer getId() {
        return id;
    }

<<<<<<< HEAD
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
=======
    public void changeName(String name) { this.name = name; }
    public void changePurpose(String purpose) { this.purpose = purpose; }

    /** Kesetaraan berdasarkan ID agar aman dikelola dalam koleksi. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest other)) return false;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
>>>>>>> 25ed260698a420d91dda95444012d41bf4a61474
