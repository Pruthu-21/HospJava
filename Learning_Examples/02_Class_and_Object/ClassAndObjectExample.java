/*
 * CLASS = blueprint
 * OBJECT = actual thing created from the blueprint
 */

class Doctor {

    String name;
    String specialization;

    void display() {
        System.out.println("Doctor: " + name);
        System.out.println("Specialization: " + specialization);
    }
}

public class ClassAndObjectExample {

    public static void main(String[] args) {

        // Creating an object from the Doctor class.
        Doctor doctor = new Doctor();

        doctor.name = "Dr. Patel";
        doctor.specialization = "Cardiology";

        doctor.display();
    }
}
