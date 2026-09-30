public class Student {

    private int id;
    private String name;
    private String course; // private means other classes shouldn't directly modify them.

    public Student(int id, String name, String course) { // Constructor we'll use encapsulation methods.

        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() { // Used to read the value.
        return id;
    }

    public void setId(int id) { // Used to modify the value.
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}