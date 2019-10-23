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
public class SalesDao {

    ManagementDao manage = new ManagementDao();

    public void accessAsSales(Scanner input) {
        while (true) {
            System.out.println("1. Sale a product\n2. Exit");
            System.out.print("Choose : ");
            String choose = input.nextLine();
            if (choose.equals("1")) {

                sale(input);

            }
            if (choose.equals("1")) {

            }

        }

    }

    private void sale(Scanner input) {
        while (true) {
//            System.out.print("Product id : ");
//            String id = input.nextLine();
            manage.sold(input);
        }

    }

}
