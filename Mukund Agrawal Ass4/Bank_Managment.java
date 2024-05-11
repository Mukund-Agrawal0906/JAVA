import java.util.ArrayList;
import java.util.Scanner;

public class Bank_Managment {

    Scanner sc = new Scanner(System.in);
    ArrayList<Account> accounts = new ArrayList<>(); // ArrayList to store accounts

    public class Account {
        long acc_num;
        String acc_type;

        String serviceBranchIFSC;
        float minimumBalance;
        float availableBalance;
        int customerID;
        String customerName;

        public Account(long acc_num, String acc_type, String serviceBranchIFSC, float minimumBalance,
                float availableBalance, int customerID, String customerName) {
            this.acc_num = acc_num;
            this.acc_type = acc_type;
            this.serviceBranchIFSC = serviceBranchIFSC;
            this.minimumBalance = minimumBalance;
            this.availableBalance = availableBalance;
            this.customerID = customerID;
            this.customerName = customerName;

        }

        public void displayDetails() {
            System.out.println("Account number : " + acc_num);
            System.out.println("Account type: " + acc_type);
            System.out.println("Service branch IFSC code: " + serviceBranchIFSC);
            System.out.println("Minimum balance: " + minimumBalance);
            System.out.println("Available balance: " + availableBalance);
            System.out.println("Customer ID: " + customerID);
            System.out.println("Customer Name" + customerName);

        }
    }

    // Method to add default accounts to the ArrayList
    void defaultAccCreator() {
        accounts.add(new Account(1, "Savings", "INDB0000764", 1000, 4556, 1, "A"));
        accounts.add(new Account(2, "Current", "INDB0004764", 2000, 6000, 2, "B"));
        accounts.add(new Account(3, "Savings", "INDB00007674", 1500, 3000, 3, "C"));
        accounts.add(new Account(4, "Fixed Deposit", "INDB00007654", 5000, 8000, 4, "D"));
        accounts.add(new Account(5, "Savings", "INDB00007654", 1200, 7000, 5, "E"));
    }

    // Method to update account details based on account number
    void updateAccountDetails(int accountNumber) {
        for (Account account : accounts) {
            if (account.acc_num == accountNumber) {
                System.out.println("Select the detail to update:");
                System.out.println("1. Account type");
                System.out.println("2. Minimum balance");
                System.out.println("3. Customer ID");
                // Add more options for other details as needed

                int choice = sc.nextInt();
                sc.nextLine(); // Consume the newline left by nextInt()

                switch (choice) {
                    case 1:
                        System.out.println("Enter new account type:");
                        String newAccountType = sc.nextLine();
                        account.acc_type = newAccountType;
                        System.out.println("Account type updated.");
                        break;
                    case 2:
                        System.out.println("Enter new minimum balance:");
                        float newMinBalance = sc.nextFloat();
                        account.minimumBalance = newMinBalance;
                        System.out.println("Minimum balance updated.");
                        break;
                    case 3:
                        System.out.println("Enter new customer ID:");
                        int newCustomerID = sc.nextInt();
                        account.customerID = newCustomerID;
                        System.out.println("Customer ID updated.");
                        break;
                    // Add cases for other details as needed
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                return;
            }
        }
        System.out.println("Account not found with account number " + accountNumber);
    }

    // Method to get account details based on account number
    void getAccountDetails(int accountNumber) {
        for (Account account : accounts) {
            if (account.acc_num == accountNumber) {
                System.out.println("Account details for account number " + accountNumber + ":");
                account.displayDetails();
                return;
            }
        }
        System.out.println("Account not found with account number " + accountNumber);
    }

    // Method to deposit an amount into the account
    void deposit(int accountNumber) {
        float amount;
        System.out.println("Enter the amount you want to deposit: ");
        amount = sc.nextInt();
        for (Account account : accounts) {
            if (account.acc_num == accountNumber) {
                account.availableBalance = account.availableBalance + amount;
                System.out.println("Money Deposited.");
                return;
            }
        }
        System.out.println("Account not found with account number " + accountNumber);
    }

    // Method to create a new account
    void createNewAccount() {
        System.out.println("Enter account number:");
        int acc_num = sc.nextInt();

        // Check if the account number already exists
        for (Account account : accounts) {
            if (account.acc_num == acc_num) {
                System.out.println("An account with this account number already exists.");
                return;
            }
        }

        System.out.println("Enter account type:");
        String acc_type = sc.next();

        String serviceBranchIFSC = sc.nextLine();
        float minimumBalance = sc.nextFloat();
        float availableBalance = sc.nextFloat();
        int customerID = sc.nextInt();
        String customerName = sc.nextLine();

        accounts.add(new Account(acc_num, acc_type, serviceBranchIFSC, minimumBalance, availableBalance, customerID,
                customerName));

        System.out.println("New account created successfully.");
    }

    void withdraw(int accountNumber) {
        float amount;
        System.out.println("Enter the amount you want to deposit: ");
        amount = sc.nextInt();
        for (Account account : accounts) {
            if (account.acc_num == accountNumber) {
                if (account.availableBalance - amount > account.minimumBalance) {
                    account.availableBalance = account.availableBalance - amount;
                    System.out.println("Account type updated.");
                } else
                    System.out.println("Withdraw limited exceeded Please Maintain Minimum BALANCE to withdraw!!");
                return;
            }
        }
        System.out.println("Account not found with account number " + accountNumber);
    }

    // Method to compare and display details of the account with higher available
    // balance
    void compareAndDisplay() {
        if (accounts.size() < 2) {
            System.out.println("Not enough accounts to compare.");
            return;
        }

        Account maxBalanceAccount = accounts.get(0);
        for (Account account : accounts) {
            if (account.availableBalance > maxBalanceAccount.availableBalance) {
                maxBalanceAccount = account;
            }
        }

        System.out.println("Account with the highest available balance:");
        maxBalanceAccount.displayDetails();
    }

    // Method to display the total number of accounts created
    void displayTotalAccounts() {
        System.out.println("Total number of accounts created: " + accounts.size());
    }

    // Method to display the menu and handle user input
    void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("___________________");
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Update Details");
            System.out.println("2. Get Details");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Display Total Accounts");
            System.out.println("6. Create a new Account");
            System.out.println("7. Compare account balance");
            System.out.println("8. Compare any two account balance");
            System.out.println("9. Exit");
            System.out.println();
            System.out.println("___________________");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int acc_numb;
                    System.out.println("Enter Account Number to update details: ");
                    acc_numb = sc.nextInt();
                    updateAccountDetails(acc_numb);
                    break;
                case 2:
                    int acc_num;
                    System.out.println("Enter Account Number to see details: ");
                    acc_num = sc.nextInt();
                    getAccountDetails(acc_num);
                    break;
                case 3:
                    int acc_numd;
                    System.out.println("Enter Account Number to deposit : ");
                    acc_numd = sc.nextInt();
                    deposit(acc_numd);
                    break;
                case 4:
                    int acc_numw;
                    System.out.println("Enter Account Number to deposit : ");
                    acc_numw = sc.nextInt();
                    withdraw(acc_numw);
                    break;
                case 5:
                    displayTotalAccounts();
                    break;
                case 6:
                    createNewAccount();
                    break;
                case 7:
                    compareAndDisplay();
                    break;

                case 8:
                    compareAnyTwo();
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

        Account account1 = findAccountByNumber(accountNumber1);
        Account account2 = findAccountByNumber(accountNumber2);

        if (account1 == null || account2 == null) {
            System.out.println("One or both of the account numbers are not found.");
            return;
        }

        if (account1.availableBalance > account2.availableBalance) {
            System.out.println("Account " + account1.acc_num + " has a higher available balance.");
            account1.displayDetails();
        } else if (account2.availableBalance > account1.availableBalance) {
            System.out.println("Account " + account2.acc_num + " has a higher available balance.");
            account2.displayDetails();
        } else {
            System.out.println("Both accounts have the same available balance.");
        }
    }

    // Method to find an account by account number
    Account findAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.acc_num == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Bank_Managment bank = new Bank_Managment();
        bank.defaultAccCreator();
        bank.displayMenu();
    }

}