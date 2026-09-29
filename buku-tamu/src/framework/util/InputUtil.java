package framework.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
        System.out.print(info); // Menggunakan print agar kursor input berada di baris yang sama
        return scanner.nextLine();
    }
}