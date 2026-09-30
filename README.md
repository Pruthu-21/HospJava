# Hospital Appointment Management System

A beginner-friendly Java console project for learning OOP, Collections, File I/O,
Scanner input, loops, validation, and exception handling.

## Project structure

```text
HospitalAppointmentSystem/
├── Main.java
├── Appointment.java
├── AppointmentManager.java
├── appointments.txt
├── run.sh
├── run.bat
├── Learning_Examples/
│   ├── 01_Scanner_Input/
│   ├── 02_Class_and_Object/
│   ├── 03_Encapsulation_Getter_Setter/
│   ├── 04_Array_and_ArrayList/
│   ├── 05_Console_Input/
│   ├── 06_For_Each_Loop/
│   ├── 07_If_Switch_While/
│   ├── 08_Exception_Handling/
│   ├── 09_File_Read_Write/
│   └── 10_Parameterized_Constructor/
└── create_project.bat
```

## Main application

The application supports:

1. Add appointment
2. View all appointments
3. Search by appointment ID
4. Search by patient name
5. Delete appointment
6. Exit and save data

Data is stored in `appointments.txt`, so no database is required.

## Run

### Mac / Linux

```bash
chmod +x run.sh
./run.sh
```

Or:

```bash
javac Main.java Appointment.java AppointmentManager.java
java Main
```

### Windows

Double-click `run.bat`, or run:

```cmd
run.bat
```

## Learning order

Open the files in `Learning_Examples` in order. Each file focuses on one concept
and contains comments explaining what is happening.

## Assignment mapping

- OOP: `Appointment.java`, `AppointmentManager.java`
- Encapsulation: private fields + public getters/setters
- Collections: `ArrayList<Appointment>`
- Add/View/Search/Delete: `AppointmentManager`
- File I/O: `BufferedReader`, `FileReader`, `PrintWriter`, `FileWriter`
- Exception handling: `try-catch`, `InputMismatchException`, `IOException`
- Console UI: `Scanner`, `while`, `switch`
