package framework.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    /** Membaca satu baris input dari pengguna dengan label prompt. */
    public static String input(String info) {
        System.out.print(info + " : ");
        if (!scanner.hasNextLine()) {
            throw new EndOfInputException("Input ditutup.");
        }
        return scanner.nextLine();
    }

    /**
     * Mem-parsing string menjadi Integer.
     * Mengembalikan null jika string bukan angka bulat yang valid.
     */
    public static Integer parseId(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Mem-parsing string menjadi Double.
     * Mengembalikan null jika string bukan angka desimal yang valid.
     */
    public static Double parseDouble(String value) {
        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void requireNonBlank(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static int requireValidId(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID tidak valid!");
        }
    }

    public static double requireValidDouble(String value) {
        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Nominal tidak valid!");
        }
    }

    public static int requireValidInteger(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Jumlah tidak valid!");
        }
    }
}
