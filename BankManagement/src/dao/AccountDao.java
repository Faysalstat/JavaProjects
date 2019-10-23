/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Account;
import model.Employee;

/**
 *
 * @author Faysal
 */
public class AccountDao {

    static Map<String, Account> customerDataBase = new HashMap();
    Map<String, Employee> employeeDataBase = new HashMap();

    public void getAccessAsCustomer(Scanner input) {
        while (true) {
            System.out.println("1. View your Account\n2. Back");
            System.out.print("Choose your option");
            String choose = input.nextLine();

            if (choose.equals("1")) {
                readInformation(input);
            }

            if (choose.equals("2")) {
                break;
            }
        }
    }

    public void createAccount(Scanner input) {
        System.out.println("1. Add a Customer account\n2. Add an Employee");
        System.out.print("Choose your option : ");
        String choose = input.nextLine();
        if (choose.equals("1")) {
            registration(input);
        }
        if (choose.equals("2")) {
            addEmployee(input);
        }

    }

    private void registration(Scanner input) {

        Account customer = new Account();
        System.out.print("Enter a Account Number: ");
        String ac = input.nextLine();
        Account check = (Account) searchAccountByAccount(ac);
        boolean isExists = isExist(check);
        if (isExists) {
            customer.setAccount(ac);

            System.out.print("Enter your full name: ");
            customer.setName(input);

            System.out.print("Enter your NID number: ");
            customer.setNid(input);

            System.out.print("Enter your initial balance: ");
            customer.setBalance(input);

            customerDataBase.put(ac, customer);

            System.out.println("Registration Complete");
        } else {
            System.out.println("Account Already Exists!");
            registration(input);

        }
    }

    private void addEmployee(Scanner input) {
        Employee employee = new Employee();
        System.out.print("Enter a Account Number: ");
        String ac = input.nextLine();
        Account check = (Account) searchAccountByAccount(ac);
        boolean isExists = isExist(check);
        if (isExists) {
            employee.setAccount(ac);

            System.out.print("Enter your full name: ");
            employee.setName(input);

            System.out.print("Enter your designation: ");
            employee.setDegignation(input);

            System.out.print("Branch name: ");
            employee.setBranch(input);

            System.out.print("Enter your NID Number: ");
            employee.setNid(input);

            System.out.print("Enter your initial balance: ");
            employee.setBalance(input);
            Account customer = (Account) employee;
            customerDataBase.put(ac, customer);
            employeeDataBase.put(ac, employee);
            System.out.println("Registration Complete");

        } else {

            System.out.println("Account Already Exists!");
            registration(input);
        }
    }

    public void readInformation(Scanner input) {
        System.out.println("1. Account Information\n2. Employee Information");
        System.out.print("Choose your option : ");
        String choose = input.nextLine();
        if (choose.equals("1")) {
            System.out.println("Enter the Account no of your customers.");
            String acNo = input.nextLine();
            Account customer = (Account) searchAccountByAccount(acNo);
            boolean isExists = isExist(customer);
            if (isExists) {
                System.out.println("The Account does not exists");
            } else {
                displayAccount(customer);
            }
        }
        if (choose.equals("2")) {
            System.out.println("Enter the Account no of your Employee.");
            
            String acNo = input.nextLine();
            Employee employee = searchAccountByAccountofEmployee(acNo);
            boolean isExists = isExist(employee);
            if (isExists) {
                System.out.println("The Account does not exists");
            } else {
                displayEmployee(employee);
            }
        }

    }

    public void updateInformation(Scanner input) {
        System.out.println("1. Update Account Information\n2. Update Employee Information");
        System.out.print("Choose your option : ");
        String choose = input.nextLine();
        if (choose.equals("1")) {
            System.out.println("Enter the Account no of your customers.");
            String acNo = input.nextLine();
            Account customer = searchAccountByAccount(acNo);
            boolean isExists = isExist(customer);
            if (isExists) {
                System.out.println("The Account does not exists");
            } else {

                updateAccount(input, customer);
                displayAccount(customer);
            }
        }
        if (choose.equals("2")) {
            System.out.println("Enter the Account no of your customers.");
            String acNo = input.nextLine();
            Employee employee = searchAccountByAccountofEmployee(acNo);
            boolean isExists = isExist(employee);
            if (isExists) {
                System.out.println("The Account does not exists");
            } else {

                updateEmployee(input, employee);
                displayEmployee(employee);
            }
        }

    }

    private void updateAccount(Scanner input, Account account) {

        System.out.print("Update yout Name ");
        account.setName(input);
        System.out.print("Update your NID no. ");
        account.setNid(input);
        System.out.println("Information Updated");
    }

    private void updateEmployee(Scanner input, Employee employee) {

        System.out.print("Update yout Name: ");
        employee.setName(input);
        System.out.print("Update Designation: ");
        employee.setDegignation(input);
        System.out.print("Update Branch: ");
        employee.setBranch(input);
        System.out.print("Update your NID no: ");
        employee.setNid(input);
        System.out.println("Information Updated:");
    }

    public void deleteInformation(Scanner input) {
        System.out.println("Enter the Account no of your customers.");
        String acNo = input.nextLine();
        Account customer = searchAccountByAccount(acNo);
        boolean isExists = isExist(customer);
        if (isExists) {
            System.out.println("The Account does not exists");
        } else {
            customerDataBase.remove(acNo, customer);
            System.out.println("Account deleted!");
        }
    }



    private boolean isExist(Account info) {

        if (info == null) {
            return true;
        }
        return false;
    }

    private Account searchAccountByAccount(String account) {

        Account info = null;
        for (Map.Entry customer : customerDataBase.entrySet()) {
            if (customer.getKey().equals(account)) {
                info = (Account) customer.getValue();
                break;
            }
        }
        return info;
    }

    private Employee searchAccountByAccountofEmployee(String account) {

        Employee info = null;
        for (Map.Entry customer : employeeDataBase.entrySet()) {
            if (customer.getKey().equals(account)) {
                info = (Employee) customer.getValue();
                break;
            }
        }
        return info;
    }

    public void debit(Scanner input) {
        System.out.print("Enter the Account no of your customers.");
        String acNo = input.nextLine();
        Account account = searchAccountByAccount(acNo);
        System.out.print("Enter the amount debited.");
        account.setDebit(input.nextDouble());
    }

    public void credit(Scanner input) {
        System.out.print("Search by A/C no. \nEnter Account no: ");
        String acNo = input.nextLine();
        Account account = searchAccountByAccount(acNo);
        System.out.print("Enter the amount credited: ");
        account.setCredit(input.nextDouble());

    }

    public void giveSalary(Scanner input) {
        System.out.println("Give permission to debit employees salary");
        System.out.print("1. Confirm \n2.Cancel \nChoose your option : ");
        String op = input.nextLine();
        if (op.equals("1")) {
            debitSalaryToEveryEmployee();
            System.out.println("Salary credited to employees account.");
        }
        if (op.equals("2")) {
            System.out.println("Salary prosponded. Sorry for delay and thank you for your patience!");
        }

    }
    public void giveBonus(Scanner input) {
       
        

    }

    private void debitSalaryToEveryEmployee() {
        employeeDataBase.entrySet().stream().map((employee) -> (Employee) employee.getValue()).map((empDeg) -> {
            if (empDeg.getDegignation().toLowerCase().equals("cash officer")) {
                empDeg.setCredit(35000);
                Account account = searchAccountByAccount(empDeg.getAccount());
                

            }
            return empDeg;
        }).map((empDeg) -> {
            if (empDeg.getDegignation().toLowerCase().equals("account officer")) {
                empDeg.setCredit(40000);
                Account account = searchAccountByAccount(empDeg.getAccount());
                

            }
            return empDeg;
        }).map((empDeg) -> {
            if (empDeg.getDegignation().toLowerCase().equals("staff")) {
                empDeg.setCredit(15000);
                Account account = searchAccountByAccount(empDeg.getAccount());
                

            }
            return empDeg;
        }).forEachOrdered((empDeg) -> {
            displayEmployee(empDeg);
        });
    }

    private void displayAccount(Account customer) {
        System.out.println("Name: " + customer.getName() + "\nA/C no: " + customer.getAccount()
                + "\nNID: " + customer.getNid() + "\nBalance: " + customer.getBalance());
    }

    private void displayEmployee(Employee employee) {
        System.out.println("Name: " + employee.getName() + "\nA/C no: " + employee.getAccount()
                + "\nDesignation : " + employee.getDegignation() + "\nNID: " + employee.getNid() + "\nBranch :" + employee.getBranch() + "\nBalance: " + employee.getBalance());
    }
    
      public   void objectSaved() {
        try {
            ObjectOutputStream outputCustomer = new ObjectOutputStream( new FileOutputStream("C:\\Users\\Faysal\\Desktop\\javaCustomer.txt"));
            outputCustomer.writeObject(customerDataBase);
            ObjectOutputStream outputEmployee = new ObjectOutputStream( new FileOutputStream("C:\\Users\\Faysal\\Desktop\\javaEmployee.txt"));
            outputCustomer.writeObject(employeeDataBase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void objectread(){
        try {
            ObjectInputStream inputCustomer = new ObjectInputStream( new FileInputStream("C:\\Users\\Faysal\\Desktop\\javaCustomer.txt"));
             customerDataBase = (Map<String, Account>) inputCustomer.readObject();
            ObjectInputStream inputEmployee = new ObjectInputStream( new FileInputStream("C:\\Users\\Faysal\\Desktop\\javaEmployee.txt"));
             employeeDataBase = (Map<String, Employee>) inputCustomer.readObject();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
