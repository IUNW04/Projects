/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.onlineshoppingsystem;

/**
 *
 * @author imadhuddin
 */
 //Courtenage, S. (2023) 'Implement GUI App'[Tutorial 8] 5CS08: Object Orientated Programming: University of Westminster. 13 November
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ProductTableModel1 extends AbstractTableModel {

    private String[] columnNames = {"Product ID", "Product Name", "Available Quantity", "Product Price", "Details"};
    private ArrayList<Product> productList;

    public ProductTableModel1(ArrayList<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        Product product = productList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                temp = product.getProductId();
                break;
            case 1:
                temp = product.getProductName();
                break;
            case 2:
                temp = product.getNumOfProductAvailable();
                break;
            case 3:
                temp = product.getProductPrice();
                break;
         
        }

        return temp;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
}

