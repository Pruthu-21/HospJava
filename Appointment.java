/**
 * Appointment.java
 *
 * MODEL / DATA CLASS
 *
 * This class represents ONE hospital appointment.
 *
 * OOP concepts demonstrated:
 * - Class
 * - Private fields
 * - Encapsulation
 * - Parameterized constructor
 * - Getters and setters
 */
public class Appointment {

    // Private fields protect the data from direct access.
    private int appointmentId;
    private String patientName;
    private int patientAge;
    private String doctorName;
    private String appointmentDate;
    private String appointmentTime;

    /**
     * Parameterized constructor.
     * Used when creating a new Appointment object.
     */
    public Appointment(int appointmentId,
                       String patientName,
                       int patientAge,
                       String doctorName,
                       String appointmentDate,
                       String appointmentTime) {

        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    // Getter = reads a private value.
    public int getAppointmentId() {
        return appointmentId;
    }

    // Setter = changes a private value.
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    /**
     * Returns a readable representation of an appointment.
     */
    @Override
    public String toString() {
        return "ID: " + appointmentId
                + " | Patient: " + patientName
                + " | Age: " + patientAge
                + " | Doctor: " + doctorName
                + " | Date: " + appointmentDate
                + " | Time: " + appointmentTime;
    }
}
