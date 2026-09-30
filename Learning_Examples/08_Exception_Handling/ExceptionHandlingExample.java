import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter patient age: ");

            int age = scanner.nextInt();

            System.out.println("Age entered: " + age);

        } catch (InputMismatchException e) {

            // This runs if the user enters something like "abc".
            System.out.println(
                    "Invalid input! Please enter a number."
            );

        } finally {

            // finally runs whether an exception occurs or not.
            System.out.println("Input operation finished.");
        }

        scanner.close();
    }
}
