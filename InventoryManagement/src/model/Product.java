/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Product {

    private String productId;
    private String productName;
    private double costPrice;
    private double sellPrice;
    private int quantity;
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //===========Initial Product==============
    public Product setInitial(String id, String Name, double cprice, double sprice, int qt) {
        Product product = new Product();
        product.productId = id;
        product.productName = Name;
        product.costPrice = cprice;
        product.sellPrice = sprice;
        product.quantity = qt;
        return product;
    }

}
