/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.onlineshoppingsystem;

/**
 *
 * @author imadhuddin
 */

/**References: 
* Courtenage, S. (2023) 'Abstract Class and Interfaces'[Tutorial 5] 5CS08: Object Orientated Programming: University of Westminster. 27 October
* Courtenage, S. (2023) 'Arrays and Collections'[Tutorial 7] 5CS08: Object Orientated Programming: University of Westminster. 6 November
* Courtenage, S. (2023) 'Event Listener, File Handling'[Tutorial 9] 5CS08: Object Orientated Programming: University of Westminster. 20 November
 */

import java.util.*;
import java.io.*;

public class WestminsterShoppingManager implements ShoppingManager {

    private static ArrayList<Product> productList = new ArrayList<>();
         private ArrayList<Product> ShoppingCartProducts = new ArrayList<>();
    private static final String FILE_PATH = "products.csv";
    private static int numOfProductsInStock;
   

    public WestminsterShoppingManager(int productLimit) {
        this.numOfProductsInStock = productLimit;
        this.productList = new ArrayList<>();
    }
    
    

    

    @Override
  public void addProductToSystem(Product product) {
    String newProductId = product.getProductId();

    // Checking existing id
    for (Product existingProduct : productList) {
        if (existingProduct.getProductId().equals(newProductId)) {
            System.out.println("Product with ID " + newProductId + " already exists. Cannot add duplicate.");
            return;
        }
    }

    // adding the product if no dupe of productid r found
    if (productList.size() < numOfProductsInStock) {
        productList.add(product);
        System.out.println("Product added. Current number of products in the system: " + productList.size());
    } else {
        System.out.println("Cannot add more products. Limit reached.");
    }
}


    @Override
    public void removeProductFromSystem(String productId) {
    for (Product productToDelete : productList) { //finding the product ID which the manager enters in console by looping thru productList   
if (productToDelete.getProductId().equals(productId)) {
productList.remove(productToDelete);
            System.out.println("Product with ID " + productId + " deleted.");
            System.out.println("Products left in Sysytem " + productList.size());
            return; // Exits method goes back to menu
}

    }
System.out.println("Product with ID " + productId + " not found.");
}


    @Override
 public void printProductList() {

    Collections.sort(productList); //sorted alpahbetically by products ID alpahbetically

 System.out.println("Total number products in system: " + productList.size());
        for(int i=0; i < productList.size(); i++) {
          
            if (productList.get(i).getProductType().equals("Electronic") ) {
               
                System.out.println( "Product ID: " + productList.get(i).getProductId() + ", Product Type: Electronic" +
                        ", Product Name: " + productList.get(i).getProductName() +
                        ", Product Quantity: " + productList.get(i).getNumOfProductAvailable() + ", Price: " + productList.get(i).getProductPrice() +
                        ", Brand: " + productList.get(i).getBrand() + ", Warranty Period: " + productList.get(i).getWarrantyPeriod());
      
            }
                                    
             
            if (productList.get(i).getProductType().equals("Clothing") ) {

                System.out.println(
                        "Product ID: " +  productList.get(i).getProductId() + ", Product Type: Clothing" + ", Product Name: " + productList.get(i).getProductName()+
                        ", Product Quantity: " + productList.get(i).getNumOfProductAvailable() +  ", Price: " + productList.get(i).getProductPrice() +
                         ", Size: " +productList.get(i).getSize() + ", Colour: " + productList.get(i).getColour());
              
            }
            
           
        }
}

private static void writeProductsToCSV(List<Product> productList) throws IOException {
    // use FileWriter and BufferedWriter to write in a file
    FileWriter file = new FileWriter(FILE_PATH);
    BufferedWriter writer = new BufferedWriter(file);

    // incase theres  already data in the file, writes in a newline
    writer.newLine();

    // iterate through the arraylist
    for (Product product : productList) {

        writer.write(product.toString());
        writer.newLine();

    }
    System.out.println("saved successfully.");

    // close the streams
    writer.close();
    file.close();
}

    @Override
    public void loadProductsFromCSV() throws FileNotFoundException, IOException {
    // Declare the list to store loaded products
    ArrayList<Product> loadedProducts = new ArrayList<>();

    // Use FileReader and BufferedReader to read from a file
    FileReader file = new FileReader(FILE_PATH);
    BufferedReader reader = new BufferedReader(file);

    String line;
    int lineIndex = 0;

    while ((line = reader.readLine()) != null) { // Read one line at a time
        lineIndex++;

        // Skip empty lines
        if (line.trim().isEmpty()) {
            continue;
        }

        // Split the line by commas and trim each part
        String[] parts = Arrays.stream(line.split(","))
                .map(String::trim) //trim whitespace
                .toArray(String[]::new); //change back to arraylist of strings

      
        if (parts.length >= 7) { 
            String productId = retrievePartValue(parts, "Product ID");
            String productName = retrievePartValue(parts, "Product Name");
            
            // Check and handle empty or invalid numeric values
            int numOfProductAvailable = parseIntegerValue(retrievePartValue(parts, "Quantity Available"));
            double productPrice = parseDoubleValue(retrievePartValue(parts, "Product Price"));
            // retreving parts exclusiv to electronics 
            String brand = retrievePartValue(parts, "Brand");
            String warrantyPeriod = retrievePartValue(parts, "Warranty Period");
            String productType = retrievePartValue(parts, "Product Type");

            if (productType.equals("Electronic") && parts.length >= 7) {
             
          
                // Creating Electronic instance and adds to loadedProducts
                loadedProducts.add(new Electronics(productId, productName, numOfProductAvailable, productPrice, brand, warrantyPeriod));
            } else if (productType.equals("Clothing") && parts.length >= 7) {
                // retreving parts exclusiv to  clothing 
                String colour = retrievePartValue(parts, "Colour");
                String size = retrievePartValue(parts, "Size");
                // Creating Clothing instance and add to loadedProducts
                loadedProducts.add(new Clothing(productId, productName, numOfProductAvailable, productPrice, colour, size));
            } else {
                //debug to find  issue. if theres a problem prints the line in where the problem is
                System.out.println("Unexpected line format at index " + lineIndex + ": " + line);
            }
        } else {
                    
            System.out.println("Unexpected line format at index " + lineIndex + ": " + line);
        }
    }

    //loadedproducts added to the arraylist
    productList = loadedProducts;

    // Close the file reader
    file.close();
    reader.close();

    System.out.println("File loaded successfully");
    System.out.println(" ");
}

//mehods for parsing values where i can handle errors as the b4 id get errors for not being able to convert type
private int parseIntegerValue(String value) {
    try {
        return Integer.parseInt(value);
    } catch (NumberFormatException e) {

        return 0; 
    }
}


private double parseDoubleValue(String value) {
    try {
        return Double.parseDouble(value);
    } catch (NumberFormatException e) {
    
        return 0.0; 
    }
}
//created a method to retrieve parts successfully as the other ways i tried  i had problems with indexing and line format. parts would load successfully but would not print add or remove products to the file. this resolves my issues
private String retrievePartValue(String[] parts, String keyword) {
    // itterate over the parts nd retrieve value of specified keyword trimming any extra whitespace
    for (String part : parts) {
        if (part.contains(keyword)) {
            return part.split(":")[1].trim();
        }
    }
    return "";
}






private void openProductViewerGUI() {
        // Create an instance of GUI with the product list
        GUI gui = new GUI(productList);

        // Set the frame properties
        gui.setTitle("Product Information");
        gui.pack();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }






    
    
    

    @Override
    public boolean Menu() {
        boolean exit = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add a new product");
        System.out.println("2. Delete products");
        System.out.println("3. View the list of products");
        System.out.println("4. Save File");
        System.out.println("5. GUI");
        System.out.println("6. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Please enter 1 for Electronics or 2 for Clothing:");
                int productChoice = scanner.nextInt();
                scanner.nextLine();

                while (productChoice != 1 && productChoice != 2) {
                    System.out.println("Please enter 1 for Electronics or 2 for Clothing:");
                    productChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (productChoice == 1 || productChoice == 2) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter 1 or 2.");
                    }
                }
                System.out.println("Enter the product ID:");
                String productId = scanner.nextLine();

                System.out.println("Enter the product name:");
                String productName = scanner.nextLine();

                System.out.println("Enter the quantity available:");
                int numOfProductAvailable = scanner.nextInt();

                System.out.println("Enter the product price:");
                double productPrice = scanner.nextDouble();
                scanner.nextLine();

                switch (productChoice) {
                    case 1:
                        System.out.println("Enter the brand:");
                        String brand = scanner.nextLine();

                        System.out.println("Enter the warranty period:");
                        String warrantyPeriod = scanner.nextLine();

                        Electronics electronics = new Electronics(productId, productName, numOfProductAvailable,
                                productPrice, brand, warrantyPeriod);
                        this.addProductToSystem(electronics);
                        break;

                    case 2:
                        
            
                        System.out.println("Enter the size:");
                        String size = scanner.nextLine();

                       System.out.println("Enter the color:");
                        String color = scanner.nextLine();
                        
                        Clothing clothing = new Clothing(productId, productName, numOfProductAvailable,
                                productPrice, color, size);
                        this.addProductToSystem(clothing);
                        break;

                    default:
                        System.out.println("Invalid choice for product type.");
                        break;
                }
                break;

            case 2:
                scanner.nextLine();

                System.out.println("Please enter the ID of the product you want to delete:");
                String deleteProductID = scanner.nextLine();
                removeProductFromSystem(deleteProductID);
                break;

        case 3:
    System.out.println(" ");
    this.printProductList();
    System.out.println(" ");
    break;
            case 4:
                   try {
                writeProductsToCSV(productList);
                System.out.println("Changes saved.");
            } catch (IOException e) {
                System.out.println("Error saving products to file: " + e.getMessage());
            }
   
            break;
                

            case 5:
                this.openProductViewerGUI();
                break;
                
                
            case 6:  exit = true;
                System.out.println("EXITING......");
                break;

            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                break;
        }

        return exit;
    }


    }









