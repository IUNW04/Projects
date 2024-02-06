package com.mycompany.onlineshoppingsystem;

public abstract class Product implements Comparable<Product>{
    private String productId;
    private String productName;
    private int numOfProductAvailable;
    private double productPrice;
 

    public Product(String productId, String productName, int numOfProductAvailable, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.numOfProductAvailable = numOfProductAvailable;
        this.productPrice = productPrice;
       

    
    }
 public abstract String[] getFieldNames();       //for GUI. ID, Name etc etc
 
   public abstract Object[] getFieldValues();   //the values of those fields
   
   
   
   
   
   
   public abstract String getDetails();

   
   
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumOfProductAvailable() {
        return numOfProductAvailable;
    }

    public void setNumOfProductAvailable(int numOfProductAvailable) {
        this.numOfProductAvailable = numOfProductAvailable;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    @Override
    public String toString() {
    return "Product ID: " + getProductId() +
           ", Product Name: " + getProductName() +
           ", Quantity Available: " + getNumOfProductAvailable() +
           ", Product Price: " + getProductPrice();
    }
    
    @Override
    public int compareTo(Product otherProduct) {
        // Compare products based on the product ID alphabetically
        return this.getProductId().compareTo(otherProduct.getProductId());
    }
    
    

   public abstract String getProductType();
   
   public abstract String getBrand();
   
public abstract String getWarrantyPeriod();
public abstract String getColour();
public abstract String getSize();

   
   
}



