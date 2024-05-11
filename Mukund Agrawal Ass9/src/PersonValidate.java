import java.util.*;

class Person {
    private String firstName;
    private String lastName;
    private String PAN;
    private String addressPIN;
    private String emailID;
    private String dateOfBirth;

    public Person(String firstName, String lastName, String PAN, String addressPIN, String emailID,
                  String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PAN = PAN;
        this.addressPIN = addressPIN;
        this.emailID = emailID;
        this.dateOfBirth = dateOfBirth;
    }

    public boolean validate() {
        if (!PAN.matches("[A-Z0-9]*")) {
            return false;
        }

        if (!addressPIN.matches("\\d{6}")) {
            return false;
        }

        if (!dateOfBirth.matches("\\d{8}")) {
            int month = Integer.parseInt(dateOfBirth.substring(0,2));
            int date = Integer.parseInt(dateOfBirth.substring(2,4));
            if(!(date >=1 && date <=31 && month >=1 && month <=12)) {
                return false;
            }
            return false;
        }

        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }
}

class Student extends Person {
    private final String rollNumber;
    private final String employeeID;

    public Student(String firstName, String lastName, String PAN, String addressPIN,
                   String emailID, String dateOfBirth, String rollNumber, String employeeID) {
        super(firstName, lastName, PAN, addressPIN, emailID, dateOfBirth);
        this.rollNumber = rollNumber;
        this.employeeID = employeeID;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    @Override
    public boolean validate() {
        if (!super.validate()) {
            return false;
        }

        if (!rollNumber.matches("[1-2][1-2][0-9]*")) {
            return false;
        }

        if (!super.validate()) {
            return false;
        }

        return employeeID.matches("^S[A-Z0-9]*");
    }
}

class Faculty extends Person {
    private final String employeeID;

    public Faculty(String firstName, String lastName, String PAN, String addressPIN,
                   String emailID, String dateOfBirth, String employeeID) {
        super(firstName, lastName, PAN, addressPIN, emailID, dateOfBirth);
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public boolean validate() {
        if (!super.validate()) {
            return false;
        }

        return employeeID.matches("^F[A-Z0-9]+");
    }
}

class Staff extends Person {
    private final String employeeID;

    public Staff(String firstName, String lastName, String PAN, String addressPIN,
                 String emailID, String dateOfBirth, String employeeID) {
        super(firstName, lastName, PAN, addressPIN, emailID, dateOfBirth);
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public boolean validate() {
        if (!super.validate()) {
            return false;
        }

        return employeeID.matches("^E[A-Z0-9]*");
    }
}

public class PersonValidate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        while (true) {
            System.out.print("Enter First Name: ");
            String firstName = scanner.next();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.next();
            System.out.print("Enter PAN: ");
            String PAN = scanner.next();
            System.out.print("Enter Address PIN: ");
            String addressPIN = scanner.next();
            System.out.print("Enter Email ID: ");
            String emailID = scanner.next();
            System.out.print("Enter Date of Birth (mmddyyyy): ");
            String dateOfBirth = scanner.next();

            String employeeID = "";
            do {
                System.out.print("Enter Employee ID (F for Faculty, S for Student, E for Staff): ");
                employeeID = scanner.next();
            } while (!(employeeID.matches("^F[A-Z0-9]*") || employeeID.matches("^S[A-Z0-9]*")
                    || employeeID.matches("^E[A-Z0-9]*")));

            Person person;

            if (employeeID.charAt(0) == 'F') {
                person = new Faculty(firstName, lastName, PAN, addressPIN, emailID, dateOfBirth, employeeID);
            } else if (employeeID.charAt(0) == 'S') {
                String rollNumber = "";
                do {
                    System.out.println("Enter the Roll Number as First two Digits as 1 or 2 ");
                    rollNumber = scanner.next();
                }while (!(rollNumber.matches("[1-2][1-2][0-9]*")));
                person = new Student(firstName, lastName, PAN, addressPIN, emailID, dateOfBirth, rollNumber,
                        employeeID);

            } else {
                person = new Staff(firstName, lastName, PAN, addressPIN, emailID, dateOfBirth, employeeID);
            }

            if (person.validate()) {
                people.add(person);
                System.out.println("Person added successfully.");
            } else {
                System.out.println("Invalid input. Please re-enter the details.");
            }

            System.out.print("Do you want to enter another person (yes/no)? ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1 instanceof Student && p2 instanceof Student) {
                    return ((Student) p1).getRollNumber().compareTo(((Student) p2).getRollNumber());
                } else if (p1 instanceof Faculty && p2 instanceof Faculty) {
                    return ((Faculty) p1).getEmployeeID().compareTo(((Faculty) p2).getEmployeeID());
                } else if (p1 instanceof Staff && p2 instanceof Staff) {
                    return ((Staff) p1).getEmployeeID().compareTo(((Staff) p2).getEmployeeID());
                }
                return 0;
            }
        });

        System.out.println("\nSorted List by EMP ID or Roll no:");
        for (Person person : people) {
            if (person instanceof Student student) {
                System.out.println("Student: " + student.getFirstName() + " " + student.getLastName()
                        + ", Roll Number: " + student.getRollNumber());
            } else if (person instanceof Faculty faculty) {
                System.out.println("Faculty: " + faculty.getFirstName() + " " + faculty.getLastName()
                        + ", Employee ID: " + faculty.getEmployeeID());
            } else if (person instanceof Staff staff) {
                System.out.println("Staff: " + staff.getFirstName() + " " + staff.getLastName()
                        + ", Employee ID: " + staff.getEmployeeID());
            }
        }

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getDateOfBirth().substring(4,8).compareTo(p2.getDateOfBirth().substring(4,8));                
            }
        });
        System.out.println("\nSorted by birth year:");
        for (Person person : people) {
            System.out.println("Person: " + person.getFirstName() + " " + person.getLastName() + " " + person.getDateOfBirth());
        }
    }
}
