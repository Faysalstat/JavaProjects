/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Scanner;

/**
 *
 * @author Faysal
 */
public class EmployeeDao extends AccountDao {

    public void getAccessAsAccountOfficer(Scanner input) {

        while (true) {
            System.out.println("1. Create an Account."
                    + "\n2. View an Account." + "\n3. Update anAccount" + "\n4. Delete an acccount"
                    + "\n5. Back"
            );
            System.out.print("Choose your option : ");
            String choose = input.nextLine();

            if (choose.equals("1")) {
                createAccount(input);
            }
            if (choose.equals("2")) {
                readInformation(input);
            }
            if (choose.equals("3")) {
                updateInformation(input);
            }
            if (choose.equals("4")) {
                deleteInformation(input);
            }
            if (choose.equals("5")) {
                break;
            }
        }
    }

    public void getAccessAsCashOfficer(Scanner input) {
        while (true) {
            System.out.println("1. View an Account"
                    + "\n2. Debit" + "\n3. Credit" + "\n4. Back"
            );
            System.out.print("Choose your option : ");
            String choose = input.nextLine();

            
            if (choose.equals("1")) {
                readInformation(input);
            }
            
            if (choose.equals("2")) {
                debit(input);
            }
            if (choose.equals("3")) {
                credit(input);
            }
            
            if (choose.equals("4")) {
                break;
            }
        }
    }

    public void getAccessAsManager(Scanner input) {
        while (true) {
            System.out.println("1. Create an Account."
                    + "\n2. View an Account." + "\n3. Update anAccount" + "\n4. Delete an acccount"
                    +"\n5. Give Salary\n6. Give Bonus"+ "\n7. Back");
            System.out.print("Choose your option : ");
            String choose = input.nextLine();

            if (choose.equals("1")) {
                createAccount(input);
            }
            if (choose.equals("2")) {
                readInformation(input);
            }
            if (choose.equals("3")) {
                updateInformation(input);
            }
            if (choose.equals("4")) {
               deleteInformation(input);
            }
            if (choose.equals("5")) {
                giveSalary(input);
            }
            if (choose.equals("6")) {
//                giveBonus(input);
            }
            if (choose.equals("7")) {
                break;
            }
        }
    }
    
    
    

}
