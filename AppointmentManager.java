import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * AppointmentManager.java
 *
 * MANAGEMENT / BUSINESS LOGIC CLASS
 *
 * This class is responsible for:
 * - Keeping appointments in an ArrayList
 * - Adding appointments
 * - Viewing appointments
 * - Searching appointments
 * - Deleting appointments
 * - Loading data from a file
 * - Saving data to a file
 */
public class AppointmentManager {

    // ArrayList stores Appointment objects dynamically.
    private ArrayList<Appointment> appointments;

    // Local text file used for persistence.
    private final String FILE_NAME = "appointments.txt";

    public AppointmentManager() {
        appointments = new ArrayList<>();

        // When the manager starts, load old data automatically.
        loadAppointments();
    }

    /**
     * ADD
     */
    public boolean addAppointment(Appointment appointment) {

        // Do not allow duplicate appointment IDs.
        if (findById(appointment.getAppointmentId()) != null) {
            return false;
        }

        appointments.add(appointment);
        return true;
    }

    /**
     * VIEW ALL
     */
    public void viewAppointments() {

        if (appointments.isEmpty()) {
            System.out.println("\nNo appointments found.");
            return;
        }

        System.out.println("\n==================== ALL APPOINTMENTS ====================");

        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }

        System.out.println("===========================================================");
        System.out.println("Total appointments: " + appointments.size());
    }

    /**
     * SEARCH BY ID
     */
    public Appointment findById(int id) {

        for (Appointment appointment : appointments) {

            if (appointment.getAppointmentId() == id) {
                return appointment;
            }
        }

        return null;
    }

    /**
     * SEARCH BY PATIENT NAME
     */
    public void searchByPatientName(String name) {

        boolean found = false;

        System.out.println("\n================ SEARCH RESULTS ================");

        for (Appointment appointment : appointments) {

            if (appointment.getPatientName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                System.out.println(appointment);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointment found for: " + name);
        }

        System.out.println("===============================================");
    }

    /**
     * DELETE
     */
    public boolean deleteAppointment(int id) {

        Appointment appointment = findById(id);

        if (appointment == null) {
            return false;
        }

        appointments.remove(appointment);
        return true;
    }

    /**
     * LOAD DATA FROM appointments.txt
     *
     * File format:
     * ID|Patient|Age|Doctor|Date|Time
     */
    private void loadAppointments() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Could not create data file.");
            }

            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] data = line.split("\\|", -1);

                    if (data.length != 6) {
                        System.out.println("Skipped invalid record: " + line);
                        continue;
                    }

                    int id = Integer.parseInt(data[0]);
                    String patientName = data[1];
                    int age = Integer.parseInt(data[2]);
                    String doctorName = data[3];
                    String date = data[4];
                    String time = data[5];

                    Appointment appointment = new Appointment(
                            id,
                            patientName,
                            age,
                            doctorName,
                            date,
                            time
                    );

                    // Avoid duplicate IDs when loading.
                    if (findById(id) == null) {
                        appointments.add(appointment);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Skipped invalid numeric record: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading appointments.txt: "
                    + e.getMessage());
        }
    }

    /**
     * SAVE DATA TO appointments.txt
     */
    public boolean saveAppointments() {

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Appointment appointment : appointments) {

                writer.println(
                        appointment.getAppointmentId() + "|" +
                        cleanForFile(appointment.getPatientName()) + "|" +
                        appointment.getPatientAge() + "|" +
                        cleanForFile(appointment.getDoctorName()) + "|" +
                        cleanForFile(appointment.getAppointmentDate()) + "|" +
                        cleanForFile(appointment.getAppointmentTime())
                );
            }

            return true;

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
            return false;
        }
    }

    /**
     * The | character is our file separator.
     * Replace it if a user enters it in text.
     */
    private String cleanForFile(String value) {
        return value.replace("|", "/");
    }
}
