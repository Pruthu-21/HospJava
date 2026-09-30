import java.util.ArrayList;

public class ArrayAndArrayListExample {

    public static void main(String[] args) {

        // =========================
        // NORMAL ARRAY
        // =========================

        // Array size is fixed.
        String[] doctors = new String[3];

        doctors[0] = "Dr. Patel";
        doctors[1] = "Dr. Shah";
        doctors[2] = "Dr. Mehta";

        System.out.println("Normal Array:");

        for (int i = 0; i < doctors.length; i++) {
            System.out.println(doctors[i]);
        }

        // =========================
        // ARRAYLIST
        // =========================

        // ArrayList can grow or shrink dynamically.
        ArrayList<String> patients = new ArrayList<>();

        patients.add("Rahul");
        patients.add("Amit");
        patients.add("Priya");

        System.out.println("\nArrayList:");

        for (String patient : patients) {
            System.out.println(patient);
        }

        System.out.println("\nNumber of patients: "
                + patients.size());
    }
}
