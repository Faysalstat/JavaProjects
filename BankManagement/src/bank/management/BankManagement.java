
package bank.management;
import dao.Login;
import dao.AccountDao;
import dao.EmployeeDao;
import java.util.Scanner;


public class BankManagement {

    
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        EmployeeDao officer = new EmployeeDao();
        AccountDao account = new AccountDao();
        Login login = new Login();
        account.objectread();
        while (true) {
            System.out.println("Choose your type of account.");
            System.out.println("1. Manager");
            System.out.println("2. Account Officer");
            System.out.println("3. Cash Officer");
            System.out.println("4. Customer");
            System.out.println("5. Exit");
            System.out.print("Choose a option : ");
            int choose = input.nextInt();
            input.nextLine();
            if (choose == 1) {
                officer.getAccessAsManager(input);
            }
            if (choose == 2) {

                officer.getAccessAsAccountOfficer(input);
            }
            if (choose == 3) {
                officer.getAccessAsCashOfficer(input);
            }
            if (choose == 4) {
                account.getAccessAsCustomer(input);
            }
            if (choose == 5) {
                account.objectSaved();
                break;
            }

        }

    }

}
