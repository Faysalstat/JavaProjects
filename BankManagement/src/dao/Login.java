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
public class Login {
    public  boolean login(Scanner input){
        System.out.println("Enter your ID");
        String id = input.nextLine();
        System.out.println("Enter your PIN");
        int pin = input.nextInt();
        input.nextLine();
        boolean iscoorect = isCorrect(id,pin);
        return iscoorect;
    }
    private boolean isCorrect(String id, int pin){
        if (id.equals("m") && pin==1) {
            return true;
        }
    return false;
    
    }
}
