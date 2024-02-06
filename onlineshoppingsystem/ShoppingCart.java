/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.onlineshoppingsystem;

/**
 *
 * @author imadhuddin
 */
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> shoppingCartProducts;

    public ShoppingCart() {
        shoppingCartProducts = new HashMap<>();
    }

    public void addProductToCart(Product product) {
        shoppingCartProducts.merge(product, 1, Integer::sum);
    }

    public Map<Product, Integer> getShoppingCartProducts() {
        return shoppingCartProducts;
    }

    public double calculateTotalCost() {
        double totalCost = 0.00;
        for (Map.Entry<Product, Integer> entry : shoppingCartProducts.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalCost += product.getProductPrice() * quantity;
        }
        return totalCost;
    }
}

