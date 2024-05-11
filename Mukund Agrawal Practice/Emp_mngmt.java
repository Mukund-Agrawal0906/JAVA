import java.util.ArrayList;
import java.util.Scanner;
class Employee{
    static int totalEmployeesCreated;
    int employeeID;
    int employeeJoiningDate;
    String employeeName;
    String employeeEmail;
    String employeeRole;
    float employeeSalary;
    float employeeDepartment;
    public Employee(){
        System.out.println("Constructor is called.......");
        setDetails();
    }
    void getSalary(){
        System.out.println(employeeSalary);
    }
    void setDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee name : ");
        employeeName = sc.next();
        System.out.println("Enter Employee Role (float): ");
        employeeRole = sc.next();
        System.out.println("Enter Employee Email: ");
        employeeEmail = sc.next();
        System.out.println("Enter Employee Joining Date : ");
        employeeJoiningDate = sc.nextInt();
        System.out.println("Enter Employee Department : ");
        employeeDepartment = sc.nextFloat();
        System.out.println("Enter Employee Salary : ");
        employeeSalary = sc.nextFloat();
    }
    void updateDetails( String role, String email, float department, float Salary)
    {
        employeeRole = role;
        employeeEmail = email;
        employeeDepartment = department;
        employeeSalary = Salary;
    }
    void getDetails(){
        System.out.println(" The Employee ID is : " + employeeID);
        System.out.println(" employee name is : " + employeeName );
        System.out.println(" employee email is : " + employeeEmail);
        System.out.println(" employee department is : " + employeeDepartment);
        System.out.println(" employee role is : " + employeeJoiningDate);
        System.out.println(" employee salaray is : " + employeeSalary);
        System.out.println(" employee joining date is : " + employeeJoiningDate);
    }
}
public class Emp_mngmt{
    static ArrayList<Employee> office = new ArrayList<Employee>();
    static Scanner scan = new Scanner(System.in);
    static void getDetails(int id){
        for(Employee p : office){
            if(p.employeeID == id){
                p.getDetails();
            }
        }
    }
    static void getSalary(int id){
        for(Employee p : office){
            if(p.employeeID == id){
                System.out.println("The Salary is "+p.employeeSalary);
            }
        }
    }
    static void updateDetails(int id)
    {
        for(Employee p : office){
            if(p.employeeID == id){
                System.out.println("Enter Employee Role (float): ");
                String role = scan.next();
                System.out.println("Enter Employee Email: ");
                String email = scan.next();
                System.out.println("Enter Employee Department : ");
                Float department = scan.nextFloat();
                System.out.println("Enter Employee Salary : ");
                Float Salary = scan.nextFloat();
                p.updateDetails(role, email, department, Salary);
            }
        }
    }
    static boolean removeEmployee(int id){
        for(Employee p : office){
            if(p.employeeID == id){
                office.remove(p);
                return true;
            }
        }
        return false;
    }
    static void compare(Employee e1, Employee e2){
        if(e1.employeeSalary > e2.employeeSalary){
            System.out.println(e1.employeeName + " has higher salary");
        }else{
            System.out.println(e2.employeeName + " has higher salary");
        }
    }
    static void listAll(){
        for(Employee p : office){
            p.getDetails();
            System.out.println();
        }   
}


    public static void main(String[] args){
        int id = 10010;
        System.out.print("Welcome to the Employee Management System \n   * press 1 to enter a new emplyee \n   * press 2 to get details of emplyee. \n   * press 3 to update details of employee.\n   * press 4 to get salary \n   * press 5 to list all employees \n   *press 6 to remove a employee \n   *press 7 to compare \n   *press 8 to exit");
        int ans = 1;
        while(ans>0){
            System.out.println("Enter YOur choice : ");
            ans = scan.nextInt();
            if(ans == 1){
                Employee temp = new Employee();
                temp.employeeID = Employee.totalEmployeesCreated + id;
                Employee.totalEmployeesCreated = Employee.totalEmployeesCreated + 1;
                office.add(temp);
                System.out.println("Employee added with id" + temp.employeeID);
            }else if(ans == 2){
                System.out.println("Enter the Employee id :");
                int temp = scan.nextInt();
                getDetails(temp);
            }else if(ans == 3){
                System.out.println("Enter the Employee id :");
                int temp = scan.nextInt();
                updateDetails(temp);
            }else if(ans == 4){
                System.out.println("Enter the Employee id : ");
                int temp = scan.nextInt();
                getSalary(temp);
            }else if(ans == 5){
                System.out.println("Listing all employees....");
                listAll();
            }else if(ans == 6){
                System.out.print("Enter the Employee ID to be removed : ");
                int temp = scan.nextInt();
                if(removeEmployee(temp)){
                    System.out.println("removed succesfully");
                }
            }else if(ans == 7){
                System.out.println("enter Employee id of 1st :");
                int t1 = scan.nextInt();
                System.out.println("enter Employee id of 2nd :");
                int t2 = scan.nextInt();
                Employee u1 = null;
                Employee u2 = null;
                for(Employee e : office){
                    if(e.employeeID == t1)
                        u1 = e;
                    if(e.employeeID == t2)
                        u2 = e;
                }
                compare(u1, u2);
            }else if(ans == 8){
                System.out.print("ThankYou for using the managment system");
                break;
            }
        System.out.println("System menu quitted.");
        }
    }
}
