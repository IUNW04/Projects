/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.onlineshoppingsystem;

/**
 *
 * @author imadhuddin
 */
//referances: 
//Bro Code. (2023) Java GUI: Full Course ☕ (FREE). 28 September. Available at: https://www.youtube.com/watch?v=Kmgo00avvEw (Accessed: 20 December 2023).
 //Courtenage, S. (2023) 'Implement GUI App'[Tutorial 8] 5CS08: Object Orientated Programming: University of Westminster. 13 November
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class GUI extends JFrame {

    private JComboBox<String> productTypeComboBox;
    private JTable productTable;
    private DefaultTableModel tableModel;
    private ArrayList<Product> productList;
    private JButton addToCartButton;
    private ShoppingCart shoppingCart;
    private JLabel totalCostLabel;
    private JList<String> productDetailsList;

    public GUI(ArrayList<Product> productList) {
        this.productList = productList;
        this.shoppingCart = new ShoppingCart();

        
        JPanel topPanel = new JPanel(new BorderLayout());

        //  panel for selecting the type of product dropdown
        JPanel productTypePanel = new JPanel();
        productTypePanel.add(new JLabel("Select Product Type: "));

        String[] productTypes = {"All", "Electronic", "Clothing"};
        productTypeComboBox = new JComboBox<>(productTypes);
        productTypeComboBox.addActionListener(e -> updateProductTable());
        productTypePanel.add(productTypeComboBox);

        
        topPanel.add(productTypePanel, BorderLayout.CENTER);

       
        JButton shoppingCartButton = new JButton("Shopping Cart");
        shoppingCartButton.addActionListener(e -> openShoppingCartWindow());

        
        topPanel.add(shoppingCartButton, BorderLayout.EAST);

        setTitle("Product Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        productTable = new JTable(tableModel);
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productTable.setGridColor(Color.BLACK);  
        productTable.setShowGrid(true);          
        productTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    Product selectedProduct = productList.get(selectedRow);
                    updateProductDetails(selectedProduct);
                }
            }
        });

        addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(e -> addToCart());

        totalCostLabel = new JLabel("Total Cost: £" + shoppingCart.calculateTotalCost());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        buttonPanel.add(addToCartButton);

        productDetailsList = new JList<>();
        JScrollPane detailsScrollPane = new JScrollPane(productDetailsList);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(detailsScrollPane, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(productTable), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        populateTable();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateProductTable() {
        String selectedProductType = (String) productTypeComboBox.getSelectedItem();
        ArrayList<Product> filteredList = filterProductsByType(selectedProductType);
        populateTable(filteredList);
    }

    public void populateTable() {
        populateTable(productList);
    }

    public void populateTable(ArrayList<Product> filteredList) {
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);

        if (!filteredList.isEmpty()) {
            String[] columnNames = filteredList.get(0).getFieldNames(); //the different informaton fields for the product
            for (String columnName : columnNames) { //itterating thru columnNames and retrieving the names of the collumns
                tableModel.addColumn(columnName);
            }

            for (Product product : filteredList) {
                Object[] rowData = product.getFieldValues();
                tableModel.addRow(rowData);
            }
        }

        tableModel.fireTableDataChanged();
    }

    private ArrayList<Product> filterProductsByType(String productType) {
        if ("All".equals(productType)) {
            return productList;
        } else {
            ArrayList<Product> filteredList = new ArrayList<>();
            for (Product product : productList) {
                if (productType.equals(product.getProductType())) {
                    filteredList.add(product);
                }
            }
            return filteredList;
        }
    }

    private void updateProductDetails(Product selectedProduct) {
        DefaultListModel<String> detailsListModel = new DefaultListModel<>();
        detailsListModel.addElement("ID: " + String.valueOf(selectedProduct.getProductId()));
        detailsListModel.addElement("Type: " + selectedProduct.getProductType());

        // Displaying the details 
        String[] detailNames = selectedProduct.getFieldNames();
        Object[] detailValues = selectedProduct.getFieldValues();

        for (int i = 0; i < detailNames.length; i++) {
            if (!detailNames[i].equalsIgnoreCase("price")) {
                String detailValue = String.valueOf(detailValues[i]);
                detailsListModel.addElement(detailNames[i] + ": " + detailValue);
            }
        }

        productDetailsList.setModel(detailsListModel);
    }

    private void addToCart() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            Product selectedProduct = productList.get(selectedRow);
            shoppingCart.addProductToCart(selectedProduct);
           
        }
    }



    private void openShoppingCartWindow() {
        //new Frame shopping cart window
        JFrame shoppingCartFrame = new JFrame("Shopping Cart");
        shoppingCartFrame.setLayout(new BorderLayout());

        //  jtextarea displayin product quantity and price
        JTextArea shoppingCartTextArea = new JTextArea();
        shoppingCartTextArea.setEditable(false);
        shoppingCartFrame.add(new JScrollPane(shoppingCartTextArea), BorderLayout.CENTER);

        // shoppingCartDetails shown in the jtextarea
        String shoppingCartDetails = generateShoppingCartDetails();
        shoppingCartTextArea.setText(shoppingCartDetails);

     
        shoppingCartFrame.setSize(400, 300);
        shoppingCartFrame.setLocationRelativeTo(this); 
        shoppingCartFrame.setVisible(true);
    }

private String generateShoppingCartDetails() {
    StringBuilder details = new StringBuilder();
    details.append(String.format("%-40s%-15s%-10s\n", "Product", "Quantity", "Price"));

    for (Map.Entry<Product, Integer> entry : shoppingCart.getShoppingCartProducts().entrySet()) {
        Product product = entry.getKey();
        int quantity = entry.getValue();
        double price = product.getProductPrice();

        details.append(String.format("%-45s%-20d£%-10.2f\n", product.getProductName(), quantity, price));
    }

    
    details.append(String.format("\n%-40s%-15s£%-10.2f", "Total Cost:", "", shoppingCart.calculateTotalCost()));

    return details.toString();
}

}