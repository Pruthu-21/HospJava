import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main.java
 *
 * CONSOLE USER INTERFACE
 *
 * This is the class the user interacts with.
 *
 * Concepts demonstrated:
 * - Scanner
 * - Console input
 * - while loop
 * - switch
 * - try-catch
 * - InputMismatchException
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        AppointmentManager manager = new AppointmentManager();

        boolean running = true;

        printWelcome();

        // The menu keeps running until the user chooses Exit.
        while (running) {

            printMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addAppointment(manager);
                    break;

                case 2:
                    manager.viewAppointments();
                    pause();
                    break;

                case 3:
                    searchAppointment(manager);
                    break;

                case 4:
                    deleteAppointment(manager);
                    break;

                case 5:
                    System.out.println("\nSaving appointments...");
                    if (manager.saveAppointments()) {
                        System.out.println("Data saved successfully.");
                    }
                    System.out.println("Thank you for using the system.");
                    running = false;
                    break;

                default:
                    System.out.println(
                            "\nPlease choose a number from 1 to 5."
                    );
            }
        }

        scanner.close();
    }

    private static void printWelcome() {

        System.out.println();
        System.out.println("======================================================");
        System.out.println("       HOSPITAL APPOINTMENT MANAGEMENT SYSTEM");
        System.out.println("======================================================");
        System.out.println("A simple Java console application");
        System.out.println();
    }

    private static void printMenu() {

        System.out.println();
        System.out.println("-------------------- MAIN MENU --------------------");
        System.out.println("1. Add Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("3. Search Appointment");
        System.out.println("4. Delete Appointment");
        System.out.println("5. Exit");
        System.out.println("----------------------------------------------------");
    }

    /**
     * ADD APPOINTMENT
     */
    private static void addAppointment(AppointmentManager manager) {

        System.out.println("\n================ ADD APPOINTMENT ================");

        int id = readPositiveInt("Appointment ID: ");

        // Check duplicate ID before asking for all remaining details.
        if (manager.findById(id) != null) {
            System.out.println(
                    "An appointment with this ID already exists."
            );
            pause();
            return;
        }

        String patientName = readNonEmptyString("Patient Name: ");

        int age = readAge("Patient Age: ");

        String doctorName = readNonEmptyString("Doctor Name: ");

        String date = readNonEmptyString(
                "Appointment Date (DD-MM-YYYY): "
        );

        String time = readNonEmptyString(
                "Appointment Time (e.g. 10:30 AM): "
        );

        Appointment appointment = new Appointment(
                id,
                patientName,
                age,
                doctorName,
                date,
                time
        );

        if (manager.addAppointment(appointment)) {
            System.out.println("\nAppointment added successfully!");
        } else {
            System.out.println("\nCould not add appointment.");
        }

        pause();
    }

    /**
     * SEARCH APPOINTMENT
     *
     * User can search either by ID or patient name.
     */
    private static void searchAppointment(
            AppointmentManager manager) {

        System.out.println("\n================ SEARCH ================");
        System.out.println("1. Search by Appointment ID");
        System.out.println("2. Search by Patient Name");

        int choice = readInt("Choose search type: ");

        if (choice == 1) {

            int id = readPositiveInt("Enter Appointment ID: ");

            Appointment appointment = manager.findById(id);

            if (appointment != null) {
                System.out.println("\nAppointment found:");
                System.out.println(appointment);
            } else {
                System.out.println("\nNo appointment found.");
            }

        } else if (choice == 2) {

            String name = readNonEmptyString("Enter Patient Name: ");

            manager.searchByPatientName(name);

        } else {

            System.out.println("\nInvalid search option.");
        }

        pause();
    }

    /**
     * DELETE APPOINTMENT
     */
    private static void deleteAppointment(
            AppointmentManager manager) {

        System.out.println("\n================ DELETE ================");

        int id = readPositiveInt(
                "Enter Appointment ID to delete: "
        );

        Appointment appointment = manager.findById(id);

        if (appointment == null) {
            System.out.println("\nAppointment not found.");
            pause();
            return;
        }

        System.out.println("\nAppointment selected:");
        System.out.println(appointment);

        String confirm = readNonEmptyString(
                "Delete this appointment? (Y/N): "
        );

        if (confirm.equalsIgnoreCase("Y")) {

            if (manager.deleteAppointment(id)) {
                System.out.println("\nAppointment deleted successfully.");
            }

        } else {
            System.out.println("\nDelete cancelled.");
        }

        pause();
    }

    /**
     * Read an integer safely.
     *
     * This demonstrates exception handling.
     */
    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {

                return scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                // Remove the invalid input.
                scanner.nextLine();
            }
        }
    }

    /**
     * Read a positive integer.
     */
    private static int readPositiveInt(String message) {

        while (true) {

            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println("Please enter a value greater than 0.");
        }
    }

    /**
     * Read patient age with simple validation.
     */
    private static int readAge(String message) {

        while (true) {

            int age = readPositiveInt(message);

            if (age >= 1 && age <= 120) {
                return age;
            }

            System.out.println("Please enter an age between 1 and 120.");
        }
    }

    /**
     * Read a non-empty text value.
     */
    private static String readNonEmptyString(String message) {

        while (true) {

            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }

    /**
     * Pause so the user can read the output.
     */
    private static void pause() {

        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
