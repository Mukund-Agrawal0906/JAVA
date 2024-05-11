
import java.util.*;

public class Bank {
    Scanner sc = new Scanner(System.in);
    ArrayList<Account> accounts = new ArrayList<Account>();

    public class Account {
        int Acc_Number;
        String Acc_Type;
        String Branch_IFSC;
        float Minimum_Balance;
        float Available_Balance;
        int Customer_ID;
        String Customer_Name;

        public Account(int acno, String type, String ifsc, float min,
                float avai, int ID, String Name) {
            this.Acc_Number = acno;
            this.Acc_Type = type;
            this.Branch_IFSC = ifsc;
            this.Minimum_Balance = min;
            this.Available_Balance = avai;
            this.Customer_ID = ID;
            this.Customer_Name = Name;
        }

        public void Display_Details() {
            System.out.println("Account Number: " + Acc_Number);
            System.out.println("Account Number: " + Acc_Type);
            System.out.println("Service Branch IFSC: " + Branch_IFSC);
            System.out.println("Minimum Balance: " + Minimum_Balance);
            System.out.println("Available Balance: " + Available_Balance);
            System.out.println("Customer ID: " + Customer_ID);
            System.out.println("Customer Name: " + Customer_Name);
        }
    }

    void default_creation() {
        accounts.add(new Account(1, "saving", "mun00045fe", 2000, 30000, 9584, "Person1"));
        accounts.add(new Account(2, "current", "mun06145fe", 10000, 300000, 9684, "Person2"));
        accounts.add(new Account(3, "current", "mun52145fe", 10000, 10000, 9574, "Person3"));
        accounts.add(new Account(4, "saving", "mun12145fe", 2000, 2000, 9587, "Person4"));
        accounts.add(new Account(5, "current", "mun02144fe", 10000, 30000, 9504, "Person5"));
        accounts.add(new Account(6, "saving", "mun01145fe", 2000, 3001, 8421, "Person6"));
        accounts.add(new Account(7, "saving", "mun02135fe", 2000, 3000, 9004, "Person7"));
        accounts.add(new Account(8, "current", "mun02132fe", 10000, 10000, 8584, "Person8"));

    }

    void update_Acc_Details(int accountNumber) {
        for (Account account : accounts) {
            if (account.Acc_Number == accountNumber) {
                System.out.println("Select the detail to update:");
                System.out.println("1. Account type");
                System.out.println("2. Minimum balance");
                System.out.println("3. Customer ID");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new account type:");
                        String newAccountType = sc.nextLine();
                        account.Acc_Type = newAccountType;
                        System.out.println("Account type updated.");
                        break;
                    case 2:
                        System.out.println("Enter new minimum balance:");
                        float newMinBalance = sc.nextFloat();
                        account.Minimum_Balance = newMinBalance;
                        System.out.println("Minimum balance updated.");
                        break;
                    case 3:
                        System.out.println("Enter new customer ID:");
                        int newCustomerID = sc.nextInt();
                        account.Customer_ID = newCustomerID;
                        System.out.println("Customer ID updated.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                return;
            }
        }
        System.out.println("Account not found with account number " + accountNumber);
    }

    void get_Acc_Details(int Acc_Number) {
        for (Account acc : accounts) {
            if (acc.Acc_Number == Acc_Number) {
                System.out.println("Account details for account number " + Acc_Number + ":");
                acc.Display_Details();
                return;
            }
        }
        System.out.println("Account not found with account number " + Acc_Number);
    }

    void Deposit_Money(int Acc_Number) {
        float amount;
        System.out.println("Enter the amount you want to deposit: ");
        amount = sc.nextInt();
        for (Account acc : accounts) {
            if (acc.Acc_Number == Acc_Number) {
                acc.Available_Balance = acc.Available_Balance + amount;
                System.out.println("Money Deposited.");
                return;
            }
        }
        System.out.println("Account not found with account number " + Acc_Number);
    }

    void create_New_Account() {
        System.out.println("Enter Account Number:");
        int Acc_Number = sc.nextInt();

        for (Account acc : accounts) {
            if (acc.Acc_Number == Acc_Number) {
                System.out.println("An account with this account number already exists.");
                return;
            }
        }

        System.out.println("Enter account type:");
        String Acc_Type = sc.next();
        sc.nextLine();
        System.out.println("Enter Branch_IFSC:");
        String Branch_IFSC = sc.nextLine();
        System.out.println("Enter Minimum Balance:");
        float Minimum_Balance = sc.nextFloat();
        sc.nextLine();
        System.out.println("Enter Available Balance:");
        float Available_Balance = sc.nextFloat();
        sc.nextLine();

        System.out.println("Enter Customer ID :");
        int Customer_ID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Customer Name:");

        String Customer_Name = sc.nextLine();

        accounts.add(new Account(Acc_Number, Acc_Type, Branch_IFSC, Minimum_Balance, Available_Balance, Customer_ID,
                Customer_Name));

        System.out.println("New account created successfully.");
    }

    void Withdrawl_Money(int Acc_Number) {
        float amount;
        System.out.println("Enter the amount you want to withdraw: ");
        amount = sc.nextInt();
        for (Account acc : accounts) {
            if (acc.Acc_Number == Acc_Number) {
                if (acc.Available_Balance - amount > acc.Minimum_Balance) {
                    acc.Available_Balance = acc.Available_Balance - amount;
                    System.out.println("Account type updated.");
                } else
                    System.out.println("Withdraw limited exceeded Please Maintain Minimum BALANCE to withdraw!!");
                return;
            }
        }
        System.out.println("Account not found with account number " + Acc_Number);
    }

    void DeleteAccount(int Acc_Number) {
        for (int i=0;i<accounts.size();i++) {
            if (accounts.get(i).Acc_Number==Acc_Number){
                accounts.remove(i);
                System.out.println("Account has been Deleted ");
                return;
            }
        }
        System.out.println("Account is not in the records ");
        return;
    }

    void Compare_And_Display() {
        if (accounts.size() < 2) {
            System.out.println("Not Enough Accounts to Compare.");
            return;
        }

        Account Max_Balance_Account = accounts.get(0);
        for (Account acc : accounts) {
            if (acc.Available_Balance > Max_Balance_Account.Available_Balance) {
                Max_Balance_Account = acc;
            }
        }

        System.out.println("Account with the highest available balance:");
        Max_Balance_Account.Display_Details();
    }

    void Display_Total_Accounts() {
        System.out.println("Total number of accounts created: " + accounts.size());
    }

    void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("-----------------------------------------------------");
            System.out.println();
            System.out.println("Welcome to Bank Management System :");
            System.out.println();
            System.out.println("Choose from the Given Menu :");
            System.out.println("1. Update Account Details");
            System.out.println("2. Get Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdrawl Money");
            System.out.println("5. Display Total Number of Accounts");
            System.out.println("6. Create a new Account");
            System.out.println("7. Compare any two account balance");
            System.out.println("8. Delete the Account ");
            System.out.println("9. Exit");
            System.out.println();
            System.out.println("-----------------------------------------------------");
            System.out.println("Enter the choice");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int acc_numb;
                    System.out.println("Enter Account Number to update details: ");
                    acc_numb = sc.nextInt();
                    update_Acc_Details(acc_numb);
                    break;
                case 2:
                    int acc_num;
                    System.out.println("Enter Account Number to see details: ");
                    acc_num = sc.nextInt();
                    get_Acc_Details(acc_num);
                    break;
                case 3:
                    int acc_numd;
                    System.out.println("Enter Account Number to deposit : ");
                    acc_numd = sc.nextInt();

                    Deposit_Money(acc_numd);
                    break;
                case 4:
                    int acc_numw;
                    System.out.println("Enter Account Number to deposit : ");
                    acc_numw = sc.nextInt();
                    Withdrawl_Money(acc_numw);
                    break;
                case 5:
                    Display_Total_Accounts();
                    break;
                case 6:
                    create_New_Account();
                    break;

                case 7:
                    compareAnyTwo();
                    break;
                case 8:
                    int Acc1;
                    System.out.println("Enter the Account Number : ");
                    Acc1=sc.nextInt();
                    DeleteAccount(Acc1);
                    break;
                case 9:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
    }

    void compareAnyTwo() {
        System.out.println("Enter two bank account numbers to compare their available balances:");
        int accountNumber1 = sc.nextInt();
        int accountNumber2 = sc.nextInt();

        Account account1 = find_Account_By_Number(accountNumber1);
        Account account2 = find_Account_By_Number(accountNumber2);

        if (account1 == null || account2 == null) {
            System.out.println("One or both of the account numbers are not found.");
            return;
        }

        if (account1.Available_Balance > account2.Available_Balance) {
            System.out.println("Account " + account1.Acc_Number + " has a higher available balance.");
            account1.Display_Details();
        } else if (account2.Available_Balance > account1.Available_Balance) {
            System.out.println("Account " + account2.Acc_Number + " has a higher available balance.");
            account2.Display_Details();
        } else {
            System.out.println("Both accounts have the same available balance.");
        }
    }

    Account find_Account_By_Number(int Acc_Number) {
        for (Account acc : accounts) {
            if (acc.Acc_Number == Acc_Number) {
                return acc;
            }
        }
        return null;
    }

    public static void main(String[] args) {

       Bank bank=new Bank();
        bank.default_creation();
        bank.displayMenu();
    }
}
