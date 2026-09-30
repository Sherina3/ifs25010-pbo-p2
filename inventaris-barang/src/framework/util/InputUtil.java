package framework.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
        System.out.print(info + " : ");
        if (!scanner.hasNextLine()) {
            throw new EndOfInputException("Input ditutup.");
        }
        return scanner.nextLine();
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

    public static int requireValidInteger(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Jumlah tidak valid!");
        }
    }
}
