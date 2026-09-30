import java.util.Scanner;

public class ConsoleInputExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Hospital Console Input ===");

        System.out.print("Patient name: ");
        String patientName = scanner.nextLine();

        System.out.print("Patient age: ");
        int age = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Doctor name: ");
        String doctorName = scanner.nextLine();

        System.out.println("\nAppointment Details");
        System.out.println("-------------------");
        System.out.println("Patient: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Doctor: " + doctorName);

        scanner.close();
    }
}
