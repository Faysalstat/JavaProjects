/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Faysal
 */
public class Account implements Serializable{
    private String name;
    private String account;
    private String nid;
    private String opendate;
    private double balance;
//    private double debit;
//    private double credit;

    public void setName(Scanner input) {
        this.name = input.nextLine();
    }

    public String setAccount(String account) {
        this.account = account;
        return account;
    }

    public void setNid(Scanner input) {
        this.nid = input.nextLine();
    }

    public void setOpendate(Scanner input) {
        this.opendate = input.nextLine();
    }

    public void setBalance(Scanner input) {
        this.balance = input.nextDouble();
        input.nextLine();
    }

    public void setDebit(double debit) {
        if (debit<0) {
            System.out.println("You have insufficient balance!");
            return;
        }
        this.balance = this.balance - debit;
        System.out.println(debit + " taka is debited from your account.");
        System.out.println("Your new balance is "+ balance);
    }

    public void setCredit(double credit) {
        this.balance = this.balance + credit;
        System.out.println(credit + " taka is credited to your account.");
        System.out.println("Your new balance is "+ balance);
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getNid() {
        return nid;
    }

    public String getOpendate() {
        return opendate;
    }

    public double getBalance() {
        return balance;
    }

    
}
