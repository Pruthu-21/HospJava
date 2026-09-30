/*
 * ENCAPSULATION
 *
 * Data is kept private.
 * Other classes access it through public methods.
 */

class Patient {

    // Private means direct access is not allowed outside this class.
    private String name;
    private int age;

    // Setter: changes the value.
    public void setName(String name) {
        this.name = name;
    }

    // Getter: reads the value.
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class EncapsulationExample {

    public static void main(String[] args) {

        Patient patient = new Patient();

        patient.setName("Pruthuraj");
        patient.setAge(20);

        System.out.println("Patient: " + patient.getName());
        System.out.println("Age: " + patient.getAge());
    }
}
