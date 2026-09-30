package framework.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    /** Membaca satu baris input dari pengguna dengan label prompt. */
    public static String input(String info) {
        System.out.print(info + " : ");
        if (!scanner.hasNextLine()) {
            System.exit(0);
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
}
