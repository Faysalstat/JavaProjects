/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Product;


public class ManagementDao {
    

    static Map<String, Product> stock = new HashMap();

    public void accessAsManagement(Scanner input) {
        
        while (true) {
            System.out.println("1. Add a product\n2. Update a product(Quantity and price)"
                    + "\n3. Monthly sales Report \n4. Exit");
            String choose = input.nextLine();
            if (choose.equals("1")) {
                addProduct(input);
            }
            if (choose.equals("2")) {
                updateProduct(input);
            }
            if (choose.equals("3")) {
                salesReport();
            }
            if (choose.equals("4")) {
                break;
            }

        }
    }
    


    private void addProduct(Scanner input) {
        Product product = new Product();
        System.out.print("Product Id: ");
        String id = input.nextLine();
        product.setProductId(id);
        System.out.print("Product Name: ");
        String name = input.nextLine();
        product.setProductName(name);
        System.out.print("Cost Price: ");
        double cp = input.nextDouble();
        input.nextLine();
        product.setCostPrice(cp);
        System.out.print("Selling Price: ");
        double sp = input.nextDouble();
        input.nextLine();
        product.setSellPrice(sp);
        System.out.print("Quantity: ");
        int q = input.nextInt();
        input.nextLine();
        product.setQuantity(q);
        stock.put(id, product);
        System.out.println("Product added successfully ");

    }

    public void updateProduct(Scanner input) {
        System.out.println("Enter Product ID: ");
        String id = input.nextLine();
        Product product = searchById(id);
        boolean isExists = isExist(product);
        if (isExists) {
            System.out.println("The Product does not exists");
            updateProduct(input);
        } else {
            System.out.print("Update Information\nCost Price: ");
            double cp = input.nextDouble();
            input.nextLine();
            product.setCostPrice(cp);
            System.out.print("Selling Price: ");
            double sp = input.nextDouble();
            input.nextLine();
            product.setSellPrice(sp);
            System.out.print("Quantity: ");
            int q = input.nextInt();
            product.setQuantity(q);
            input.nextLine();
        }
    }

    private boolean isExist(Product product) {
        if (product == null) {
            return true;
        }
        return false;
    }

    private Product searchById(String id) {

        Product item = null;

        for (Map.Entry i : stock.entrySet()) {
            if (i.getKey().equals(id)) {
                item = (Product) i.getValue();
                break;
            }
        }
        return item;
    }

    public void salesReport() {
        System.out.println("ProductId   ProductName     CostPrice       SellPrice       Quantity");
        System.out.println("--------------------------------------------------------------------");
        for (Map.Entry i : stock.entrySet()) {
            Product product = (Product) i.getValue();

            System.out.println(i.getKey() + "         " + product.getProductName() + "             " + product.getCostPrice() + "          " + product.getSellPrice() + "             " + product.getQuantity() + "     ");
        }
    }

    public void productDetails(Product product) {
        System.out.println(product.getProductId() + "         " + product.getProductName() + "             " + product.getCostPrice() + "          " + product.getSellPrice() + "             " + product.getQuantity() + "     ");

    }

    public void sold(Scanner input) {
        System.out.println("Enter Product ID: ");
        String id = input.nextLine();
        Product product = searchById(id);
        if(id.equals("done")){
            return;
        }
        boolean isExists = isExist(product);
        if (isExists && !id.equals("done") ) {
            System.out.println("The Product does not exists");
            sold(input);
        }
        System.out.println("Quantity : ");
        int q = input.nextInt();
        input.nextLine();
        if ((product.getQuantity() - q )<=0) {
            System.out.println("Product is out of stock");
        } else {

            int quantityRemain = product.getQuantity();
            product.setQuantity(quantityRemain - q);
            salesReport();
        }
    }

    //==============Initial product entry=================
    public void addInitial() {
        Product product1 = new Product();
        stock.put("soap001", product1.setInitial("soap001", "Soap", 30.00, 35.00, 20));
        Product product2 = new Product();
        stock.put("detergent001", product2.setInitial("detergent001", "Detergent", 50.50, 55.00, 40));
        Product product3 = new Product();
        stock.put("biscuit001", product3.setInitial("biscuit001", "Biscuit", 18.50, 22.00, 23));
        Product product4 = new Product();
        stock.put("tea001", product4.setInitial("tea001", "Tea", 56.70, 60.00, 27));
        System.out.println("done");
    }

}
