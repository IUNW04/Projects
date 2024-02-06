/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.onlineshoppingsystem;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author imadhuddin
 */


public interface ShoppingManager {
   public abstract boolean Menu();
   public abstract void addProductToSystem(Product P);
   public abstract void removeProductFromSystem(String productId);
    public abstract void printProductList();
    public abstract void loadProductsFromCSV()throws FileNotFoundException, IOException;
     
    
    
}
