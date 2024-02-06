/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.onlineshoppingsystem;



/**
 *
 * @author imadhuddin
 */
/** ALL References: 
* Courtenage, S. (2023) 'Abstract Class and Interfaces'[Tutorial 5] 5CS08: Object Orientated Programming: University of Westminster. 27 October
* Courtenage, S. (2023) 'Arrays and Collections'[Tutorial 7] 5CS08: Object Orientated Programming: University of Westminster. 6 November
* Courtenage, S. (2023) 'Event Listener, File Handling'[Tutorial 9] 5CS08: Object Orientated Programming: University of Westminster. 20 November
 *Bro Code. (2023) Java GUI: Full Course ☕ (FREE). 28 September. Available at: https://www.youtube.com/watch?v=Kmgo00avvEw (Accessed: 20 December 2023).
 *Courtenage, S. (2023) 'Implement GUI App'[Tutorial 8] 5CS08: Object Orientated Programming: University of Westminster. 13 November
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;


public class MainProductProject {

    public static void main(String[] args) {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager(50); 


        try {
            shoppingManager.loadProductsFromCSV(); // Load products from CSV on startup
        } catch (IOException e) {
            System.out.println("no file there to be loaded. ");
        }

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            exit = shoppingManager.Menu(); 
        }

        scanner.close();
    }
}






