import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class user{
    String name;
    int dateOfBirth;
    int userID;
    public user(){
        System.out.println("Default user cunstructor is called");
    }
    public user(String nm, int dob, int uid){
        System.out.println("parametrized user consstruct is called");
        name = nm;
        dateOfBirth = dob;
        userID = uid;
    }
    String getEqual(){
        return name;
    }
    void setDetails(){
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        dateOfBirth = sc.nextInt();
        userID = sc.nextInt();
    }
    void showDetails(){
        System.out.println("name is : "+ name);
        System.out.println("date of borth is "+dateOfBirth);
        System.out.println("user ID is "+userID);
    }
    int getID(){
        return userID;
    }
    void update(){
        System.out.println("Enter the name ");
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        System.out.println("Enter the dob ");
        dateOfBirth = sc.nextInt();
    }

}
class student extends user{
    int rollNumber;
    int semester;
    int cpi;
    public student(){
        System.out.println("Default student cunstructor called ");
        setDetails();   
    }
    public student(int roll, int sem, int cp, String nm, int uid, int dob){
        System.out.println("Parametrized student cunstructor called ");   
        name  = nm;
        userID = uid;
        dateOfBirth = dob;
        rollNumber = roll;
        semester = sem;
        cpi = cp;
    }
    @Override void update(){
        System.out.println("Enter the name ");
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        System.out.println("Enter the dob ");
        dateOfBirth = sc.nextInt();
        System.out.println("Enter cpi ");
        cpi = sc.nextInt();
        System.out.println("Enter roll :");
        rollNumber = sc.nextInt();
    }
    @Override int getID(){
        return -1;
    }

    @Override void setDetails(){
        System.out.println("Overidden method to student is called");
        Scanner sc = new Scanner(System.in);
        System.out.println("name is : ");
        name = sc.next();
        System.out.println("date of borth is ");
        dateOfBirth = sc.nextInt();
        System.out.println("user ID is ");
        userID = sc.nextInt();
        System.out.println("Rollnumber is ");
        rollNumber = sc.nextInt();
        System.out.println("semester is ");
        semester = sc.nextInt();
        System.out.println("cpi is ");
        cpi = sc.nextInt();
    }
    @Override void showDetails(){
        System.out.println("name is : "+ name);
        System.out.println("date of borth is "+dateOfBirth);
        System.out.println("user ID is "+userID);
        System.out.println("Rollnumber is "+rollNumber);
        System.out.println("semester is "+semester);
        System.out.println("cpi is "+cpi);
    }
}
class staff extends user{
    int employeeID;
    String sectionName;
    String designation;
    public staff(){
        System.out.println("Default staff cunstructor called "); 
        setDetails();  
    }
    public staff(int eid, String secname, String desig, String nm, int uid, int dob){
        System.out.println("Parametrized staff cunstructor called ");   
        name  = nm;
        userID = uid;
        dateOfBirth = dob;
        sectionName = secname;
        employeeID = eid;
        designation = desig;
    }
    @Override void update(){
        System.out.println("Enter the name ");
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        System.out.println("Enter the dob ");
        dateOfBirth = sc.nextInt();
        System.out.println("Enter designation :");
        designation = sc.next();
    }
    @Override int getID(){
        return employeeID;
    }
    @Override void setDetails(){
        System.out.println("Overidden method to staff is called");
        Scanner sc = new Scanner(System.in);
        System.out.println("name is : ");
        name = sc.next();
        System.out.println("date of borth is ");
        dateOfBirth = sc.nextInt();
        System.out.println("user ID is ");
        userID = sc.nextInt();
        System.out.println("Employee ID is ");
        employeeID = sc.nextInt();
        System.out.println("designation is ");
        designation = sc.next();
        System.out.println("Section is ");
        sectionName = sc.next();
    }
    @Override void showDetails(){
        System.out.println("name is : "+ name);
        System.out.println("date of borth is "+dateOfBirth);
        System.out.println("user ID is "+userID);
        System.out.println("Employee ID is "+employeeID);
        System.out.println("Section is "+sectionName);
        System.out.println("designation is "+designation);
    }
}
class faculty extends user{
    int employeeID;
    String department;
    int noOfPublications;
     public faculty(){
        System.out.println("Default faculty cunstructor called ");  
        setDetails(); 
    }
    public faculty(int eid, String dept, int nop, String nm, int uid, int dob){
        System.out.println("Parametrized faculty cunstructor called ");   
        name  = nm;
        userID = uid;
        dateOfBirth = dob;
        department = dept;
        employeeID = eid;
        noOfPublications = nop;
    }
    @Override void update(){
        System.out.println("Enter the name ");
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        System.out.println("Enter the dob ");
        dateOfBirth = sc.nextInt();
        System.out.println("Enter number of publications  :");
        noOfPublications = sc.nextInt();
    }
    @Override int getID(){
        return employeeID;
    }
    @Override void setDetails(){
        System.out.println("Overidden method to faculty is called");
        Scanner sc = new Scanner(System.in);
        System.out.println("name is : ");
        name = sc.next();
        System.out.println("date of borth is ");
        dateOfBirth = sc.nextInt();
        System.out.println("user ID is ");
        userID = sc.nextInt();
        System.out.println("Employee ID is ");
        employeeID = sc.nextInt();
        System.out.println("Department is ");
        department = sc.next();
        System.out.println("No. of publications is ");
        noOfPublications = sc.nextInt();
    }
    @Override void showDetails(){
        System.out.println("name is : "+ name);
        System.out.println("date of borth is "+dateOfBirth);
        System.out.println("user ID is "+userID);
        System.out.println("Department is "+department);
        System.out.println("number of publications  is "+noOfPublications);
        System.out.println("employee ID is "+employeeID);
    }
}
public class testDrive{
    static List<user> list = new ArrayList<>();
    static void showDetails(int date){
        for(user p:list){
            if(p.dateOfBirth == date){
                p.showDetails();
            }
        }
    }
    static void uidShowDetails(int uid){
        for(user p:list){
            if(p.userID == uid){
                p.showDetails();
            }
        }
    }
    static void eidShowDetails(int eid){
        for(user p:list){
            if(p.getID() == eid){
                p.showDetails();
            }
        }
    }
    static void updateDetails(int temp){
        for(user p : list){
            if(p.userID == temp){
                p.update();
            }else{
                System.out.println("USer not found");
            }
        }
    }
    static void staffEquals(staff u1, staff u2){
        if(u1.designation.equals(u2.designation)){
            System.out.println("staff is equal");
        }else{
            System.out.println("staff not equal");
        }
    }
    static void facEqual(faculty u1, faculty u2){
        System.out.println(u1.department +" "+ u2.department);
        if(u1.department.equals(u2.department)){
            System.out.println("faculty is equal");
        }else{
            System.out.println("faculty not equal");
        }
    }
    static void equal(int t1, int t2){
        user u1 = null;
        user u2 = null;
        for(user p : list){
            if(p.userID == t1)
                u1 = p;
            else if(p.userID == t2)
                u2 = p;
        }
        if(u1 instanceof staff){
            staffEquals((staff)u1, (staff)u2);
        }else if(u1 instanceof faculty){
            facEqual((faculty)u1, (faculty)u2);
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int ans = 1;
        System.out.print("Welcome to the driver menu \n   * press 1 to create a new user \n   * press 2 to show details\n   * press 3 to update details.\n   * press 4 to compare .\n   * press 5 to exit.");
        while(ans>0){
            System.out.println("Enter YOur choice : ");
            ans = scan.nextInt();
            if(ans == 1){
                System.out.println("Select the type of user : \n ( 1 for student. )\n ( 2 for faculty. )\n (3 for staff)");
                int a = scan.nextInt();
                if(a == 1){
                    System.out.println("choose a constructor ( 0 or 1) : ");
                    int temp = scan.nextInt();
                    if(temp == 0){
                        student st = new student();
                        list.add(st);
                    }else{
                        System.out.println("name is : ");
                        String nm = scan.next();
                        System.out.println("date of borth is ");
                        int dob = scan.nextInt();
                        System.out.println("user ID is ");
                        int uid = scan.nextInt();
                        System.out.println("Rollnumber is ");
                        int roll = scan.nextInt();
                        System.out.println("semester is ");
                        int sem = scan.nextInt();
                        System.out.println("cpi is ");
                        int cp = scan.nextInt();
                        student st = new student(roll,sem,cp,nm,uid,dob);
                        list.add(st);
                    }
                }else if(a == 2){
                    System.out.println("choose a constructor ( 0 or 1) : ");
                    int temp = scan.nextInt();
                    if(temp == 0){
                        faculty ft = new faculty();
                        list.add(ft);
                    }else{
                        System.out.println("name is : ");
                        String nm = scan.next();
                        System.out.println("date of borth is ");
                        int dob = scan.nextInt();
                        System.out.println("user ID is ");
                        int uid = scan.nextInt();
                        System.out.println("Employee ID is ");
                        int eid = scan.nextInt();
                        System.out.println("department is ");
                        String dep = scan.next();
                        System.out.println("No. od Publications done :");
                        int nop = scan.nextInt();
                        faculty ft = new faculty(eid,dep,nop,nm,uid,dob);
                        list.add(ft);
                    }
                }else if(ans == 3){
                    System.out.println("choose a constructor ( 0 or 1) : ");
                    int temp = scan.nextInt();
                    if(temp == 0){
                        staff sf = new staff();
                        list.add(sf);
                    }else{
                        System.out.println("name is : ");
                        String nm = scan.next();
                        System.out.println("date of borth is ");
                        int dob = scan.nextInt();
                        System.out.println("user ID is ");
                        int uid = scan.nextInt();
                        System.out.println("Employee ID is ");
                        int eid = scan.nextInt();
                        System.out.println("designation is ");
                        String desig = scan.next();
                        System.out.println("Section is ");
                        String sec = scan.next();
                        staff sf = new staff(eid,sec,desig,nm,uid,dob);
                        list.add(sf);
                     }
                } 
            }else if(ans == 2){
                System.out.println("enter the attribute from which you wanna access the user : \n (0 for date of birth )\n (1 for user ID)\n (2 for Employee ID)");
                int t = scan.nextInt();
                if(t == 0){
                    System.out.println("Enter the dob of user : ");
                    int temp = scan.nextInt();
                    showDetails(temp);
                }else if(t == 1){
                    System.out.println("Enter the user ID : ");
                    int temp = scan.nextInt();
                    uidShowDetails(temp);
                }else if(t == 2){
                    System.out.println("Enter the Employee ID : ");
                    int temp = scan.nextInt();
                    eidShowDetails(temp);
                }
            }else if(ans == 3){
                System.out.print("Enter the user ID :");
                int temp = scan.nextInt();
                updateDetails(temp);
            }else if(ans == 4){
                System.out.print("Enetr the user Id for user 1 :");
                int t1 = scan.nextInt();
                System.out.print("Enetr the user Id for user 2 :");
                int t2 = scan.nextInt();
                equal(t1, t2);
            }else if(ans == 4){
                System.out.print("ThankYou for using the managment system");
                break;
            }
        }
    }
}

