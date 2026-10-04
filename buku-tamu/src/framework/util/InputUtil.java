package framework.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
<<<<<<< HEAD
        System.out.print(info);
=======
        System.out.print(info + " : ");
        if (!scanner.hasNextLine()) {
            throw new EndOfInputException("Input ditutup.");
        }
>>>>>>> 25ed260698a420d91dda95444012d41bf4a61474
        return scanner.nextLine();
    }
}