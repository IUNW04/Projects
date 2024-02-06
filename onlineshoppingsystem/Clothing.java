/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.onlineshoppingsystem;

/**
 *
 * @author imadhuddin
 */
public class Clothing extends Product{
    private String colour;
    private String size;
    
    public Clothing(String productId, String productName, int numOfProductAvailable, double productPrice, String colour, String size) {
        super(productId, productName, numOfProductAvailable, productPrice);
        this.size = size;
        this.colour = colour;

    }
    
    public void setColour(){
        this.colour = colour;
    }
    
    public String getColour(){
        return colour;
    }
    
    public void setSize(){
    this.size=size;
    }
    
    
    public String getSize() {
        return size;
    }
    
    
    public String getProductType(){
return "Clothing";
    }
    
    public String getDetails(){
    return "Size: "+size + ", Colour: " + colour; 
    }

  
public String toString() {
    return super.toString() +
           ", Colour: " + getColour() +
           ", Size: " + getSize() + ", Product Type: "+ getProductType();
}

  @Override
    public int compareTo(Product P) {
        return this.getProductId().compareTo(P.getProductId()); 
    }
    
    @Override
    public String[] getFieldNames() {
        return new String[]{"Product ID", "Product Name", "Quantity", "Price", "details"};
    }

    @Override
    public Object[] getFieldValues() {
        return new Object[]{getProductId(), getProductName(),  getNumOfProductAvailable(), getProductPrice(), getDetails() };
    
    }

  @Override
    public String getBrand() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWarrantyPeriod() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
}



