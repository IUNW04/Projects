/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.onlineshoppingsystem;

/**
 *
 * @author imadhuddin
 */
public class Electronics extends Product {
    private String brand;
    private String warrantyPeriod;

    public Electronics(String productId, String productName, int numOfProductAvailable, double productPrice, String brand, String warrantyPeriod) {
        super(productId, productName, numOfProductAvailable, productPrice);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

   public void setBrand(){
       this.brand=brand;
   
   }
   
   public void set_warrantyPeriod(){
this.warrantyPeriod=warrantyPeriod;
}
   
public String getBrand(){
return brand;
}


  
public String getWarrantyPeriod(){
return warrantyPeriod;
}

public String getDetails(){
return "Brand: " + brand + ", Warranty " +warrantyPeriod;
}


    public String getProductType(){
return "Electronic";

}


 public String[] getFieldNames() {
        return new String[]{"Product ID", "Product Name", "Quantity", "Price", "details"};
    }
 
 
 public Object[] getFieldValues() {
        return new Object[]{getProductId(), getProductName(),  getNumOfProductAvailable(), getProductPrice(), getDetails()};
    }
 
    @Override
    public String toString() {
    return super.toString() +
           ", Brand: " + getBrand() +
           ", Warranty Period: " + getWarrantyPeriod()+
           ", Product Type: " +getProductType();
}

   @Override
    public int compareTo(Product P) {
       return this.getProductId().compareTo(P.getProductId()); 
    } 
    
       @Override
    public String getColour() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

   
}

