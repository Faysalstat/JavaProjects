/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Faysal
 */
public class Login {
    SalesDao sales = new SalesDao();
    ManagementDao management = new ManagementDao();
    Map<String,String> login = new HashMap();
    public void loginAsSales(Scanner input){
//        System.out.print("UserName: ");
//        String user = input.nextLine();
//        System.out.print("PassWord: ");
//        String pass = input.nextLine();
//        if (user.equals("sales") && pass.equals("1234")) {
            
        if (true) {
           sales.accessAsSales(input);
        }
  
    }
    public void loginAsManagement(Scanner input){
//        System.out.print("UserName: ");
//        String user = input.nextLine();
//        System.out.print("PassWord: ");
//        String pass = input.nextLine();
//        if (user.equals("sales") && pass.equals("1234")) {
            
        if (true) {
           management.accessAsManagement(input);
        }
  
    }
    private  void registration() {
        
    }
    private  void remove() {
        
    }
    private  void update() {
        
    }
    
    
}
