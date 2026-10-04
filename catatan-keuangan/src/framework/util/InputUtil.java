package framework.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
        System.out.print(info + " : ");
<<<<<<< HEAD
        return scanner.nextLine().trim();
=======
        if (!scanner.hasNextLine()) {
            throw new EndOfInputException("Input ditutup.");
        }
        return scanner.nextLine();
>>>>>>> 25ed260698a420d91dda95444012d41bf4a61474
    }
}