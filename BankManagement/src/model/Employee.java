/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Faysal
 */
public class Employee extends Account {
    private String degignation;
    private double salary;
    private String branch;

    public void setDegignation(Scanner input) {
        this.degignation = input.nextLine();
    }

    public void setSalary(Scanner input) {
        this.salary = input.nextDouble();
        input.nextLine();
    }

    public void setBranch(Scanner input) {
        this.branch = input.nextLine();
    }

    public String getDegignation() {
        return degignation;
    }

    public double getSalary() {
        return salary;
    }

    public String getBranch() {
        return branch;
    }
    
}
