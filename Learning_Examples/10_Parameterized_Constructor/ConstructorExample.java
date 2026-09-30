class SimpleAppointment {

    private int id;
    private String patientName;

    /*
     * Parameterized constructor.
     *
     * It receives values when the object is created.
     */
    public SimpleAppointment(int id, String patientName) {

        this.id = id;
        this.patientName = patientName;
    }

    public void display() {

        System.out.println("Appointment ID: " + id);
        System.out.println("Patient: " + patientName);
    }
}

public class ConstructorExample {

    public static void main(String[] args) {

        // Values are passed directly to the constructor.
        SimpleAppointment appointment =
                new SimpleAppointment(101, "Pruthuraj");

        appointment.display();
    }
}
