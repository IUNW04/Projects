/*   /*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/


// I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
// 13/02/2023
//TUTOR - Ester Bonmat
package com.mycompany.theartre;

/**
 * w19106472
 * @author mohammedimadhuddin
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
public class Theartre {

    static int[] rowLengths = {12, 16, 20};
    //R1 12SEATS,
    //R2 16SEATS,
    //R3 20SEATS,
    
    
    
    
    
    
    
    static char[][] seats = new char[3][];
    
    
    
    
    
    //will be used in print seating method
    static int middlepartation = 1;
// helps in getting for the desird format (parting space in the middle of the rows)
    
    public static void main(String[] args) {
        // call the main() to make the rpogrammego back to the menu
        System.out.println("----------------------------\n"+"Welcome to the New Theatre\n"+"----------------------------");
        //following the title the options print. case 1-0  excecutes options.
        System.out.println("Please choose from the following options:");
        System.out.println("1) Buy a ticket");
        System.out.println("2) Print seating area");
        System.out.println("3) Cancel ticket");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file");
        System.out.println("6) Load from file");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price");
        System.out.println("0) Quit");
        System.out.println("-------------------------- ");
        System.out.println(" enter option");
        Scanner sc = new Scanner(System.in); // ALLOWS USER TO PICK AN OPTION
        int choice;
        
        choice = sc.nextInt();
        //there are 3 rows in the theatre, with 12, 16, and 20 seats in each row.
        switch (choice) {

            case 1:
               
                
                if (seats[0] == null) {
                    initialiseseats();
                }
                while (choice==1) {
                    buy_ticket();
                    System.out.println("                         ");
                    main(args);


                }
                
                
            case 2:
                // Create a method  that shows/prints the seats that have been sold X, and the seats that are still available O.
                System.out.println(" SEATING AREA PRINTED");
                print_seating_area();
                System.out.println("if you would like to go back to the menu pleaase enter 'q'");
                while(choice == 2){
                    Scanner sccc = new Scanner(System.in);
                    
                    
                    main(args);
                    
                    
                    
                    
                    
                    
                    
                    
                }
                
            case 3:
                
                //Create a method called cancel_ticket that makes a seat available again. Itshould ask the user to input a row number and a seat number.
                //Check that the row and seat are correct, and that the seat is not available. change X to O (available) again
                while (choice == 3) {
                    cancel_ticket();
                    main(args);
                    
                }
                
                
                
            case 4:
                // List the 3 rows showing all the available seats
                
                show_available();
                while (choice==4) {
                    Scanner sccc = new Scanner(System.in);
                    
                    
                    
                    main(args);
                    
                    
                    
                }
            case 5:
                // save the seats data(occupied and availabe) to a file so that it can be loaded up again by the user when 6 is pressed
                while (choice==5) {
                    save();
                    main(args);
                    break;
                }
            case 6:
                // the saved seat data when option 5 was pressed should be loaded up.
                while (choice==6) {
                    load();
                    main(args);
                    break;
                }
            case 7:
                // here a method should be called where all the prices of the tickets and total price is printed
                while (choice==7) {
                    System.out.println("Option 7: Print ticket information and total price");
                    main(args);
                    break;
                }
            case 8:
                //catogorise tickets by price. return new list of Tickets with their prices arranged ascendingly (cheapest first).
                while (choice==8) {
                    System.out.println("Option 8: Sort tickets by price");
                    main(args);
                    break;
                }
            case 0:
                if (choice==0){
                    System.out.println("Thank you for using the New Theatre, have a great day!");
                    System.exit(0);
                    break;
                }
            default:
                System.out.println("invalid option, please try again");     // ANY INPUT OTHER THAN THE ONES REQUIRED FOR THE CASES 1-9 IS INVALID
                main(args);
                break;
                
        };
        
        
    }
    
    private static int retrieveuserrowinput() {

while (true) {
    

    try {
        Scanner sc = new Scanner(System.in);
        System.out.print("choose a row from (1-3):  ");
        int row = sc.nextInt();
        if (row >= 1 && row <= 3) {
         
            return row;
        }
        if ((row !=1 && row != 3 && row !=2)) {
            System.out.println("Please enter an interger between 1-3.");
            
            
        }
        else{
            System.out.println("Please enter an interger between 1-3.");
        }
        
    } catch (NumberFormatException e) {
        //if error occours it will be handled and programme will still run
        System.out.println("Please enter an interger between 1-3.");
    }
    
    
}  
    }
    
    
    private static int retrieveuserseatinput(int row) {
//after the buy_tcket method is actiavted and a row is selected the user will be able to select a seat

Scanner sc = new Scanner(System.in);
System.out.print("Enter seat number (1-" + rowLengths[row - 1] + "):  ");
int seat = sc.nextInt();
while (seat < 1 || seat > rowLengths[row - 1]) {
    System.out.println("Invalid seat number. Please try again.");
    
//print 1- whatever the seats go up to based on the row the user entered
System.out.print("enter seat between (1-" + rowLengths[row - 1] + "): ");
//1-12,
//1-16,
//1-20,
seat = sc.nextInt();
}
return seat;
    }
    
    private static void initialiseseats() {
for (int i = 0; i < 3; i++) {
    //3 rows. row 1 12seats row 2 16, row 3 20
    seats[i] = new char[rowLengths[i]];
    // call new char array and rowlength array
    for (int j = 0; j < rowLengths[i]; j++) {
        //every seat will be resembled as "O" in the beggining when none are bought
        seats[i][j] = 'O';
        //will change to "X" when bought
    }
}
    }
    private static void buy_ticket() {   //allows user to purchase a seat
        //prints seats so its easier for the user to see and undertsnad what seat theyre buying.
        
        int row = retrieveuserrowinput();
int seat = retrieveuserseatinput(row);
if (seats[row - 1][seat - 1] == 'O') {
    seats[row - 1][seat - 1] = 'X';
    System.out.println("TICKET PURCHASED");


} else {
    System.out.println("Seat already taken. Please select another seat.");

}
    }
    
    private static void cancel_ticket() {
System.out.println("Seats:");


int row = retrieveuserrowinput();
int seat = retrieveuserseatinput(row);
try{
    if (seats[row - 1][seat - 1] == 'X') {
seats[row - 1][seat - 1] = 'O';
System.out.println("TICKET CANCELED");//
//let user know weather its been cancelled or not
    }
    //seats that are available cant be canceled
    else{System.out.println(" cannot be canceled as this seat isnt purchased.");
    }
}catch(NullPointerException exception){
    System.out.println(" cannot be canceled as this seat isnt purchased.");
}
    }
    private static void show_available() {
        
        System.out.println("Enter option: 4");
        
        for (int i = 0; i < seats.length; i++) {
            // for every "O" there will be the seat number of that row to show its availability
            System.out.print("Seats available in row " + (i + 1) + ": ");
            //count up in ones
            int rowLength = rowLengths[i];
            for (int j = 1; j <= rowLength; j++) {
                //if statement within for loop so only "O" seats count
                if (seats[i] == null || seats[i].length < rowLength || seats[i][j-1] == 'O') {
                    //if a seat isnt available than it will skip the count/number
                    System.out.print(j + ", ");
                    
                }
            }
            
            System.out.println();//prints the code within show_available. showing user available seats
            //outside the loop so it only prints once
            
            
        }
    }
    
    
//case 5
    private static void save() {
        try (PrintWriter writer = new PrintWriter("seats.txt", "UTF-8")) {   //refferance https://howtodoinjava.com/java/io/java-write-to-file/

            for (char[] seat : seats) {
                for (int j = 0; j < seat.length; j++) {
                    // saving the seating data
                    writer.print(seat[j]);
             
                }
                writer.println();
            }
            System.out.println("saved");
               //no file found   // unsupported character encoding scheme. //nothing to be accessed
        } catch (FileNotFoundException | UnsupportedEncodingException |NullPointerException e) {
        //errors handled
            System.out.println("nothings been done so there's nothing to be saved");
    
        }
        
    }
    
    private static void load() {
        try (Scanner sc = new Scanner(new File("seats.txt"))) {
            //searching for the file to load from
            for (int i = 0; i < seats.length; i++) {
                if (!sc.hasNextLine()) {
                    //if scanner finds nothing to scan
                    System.err.println("Error: no more lines to read from file");
                    // if no file is the to be loaded it will let user know
                    break;
                }
                String line = sc.nextLine();
                seats[i] = line.toCharArray();
            }
            
        } catch (FileNotFoundException e) {
            //.err  writes to a file .out prints to console
            System.err.println("Error: file not found");
            
            
        }
        
    }
    
    private static void print_seating_area() {
        //displaying stage infront of seats
        System.out.println(" ******************\n\n" + " *     STAGE      *\n\n"+" ******************");
// stars to show user roughly how big the stage is
// stage finished printing. seats below
System.out.println("  ");

// seats below

if (seats[0] == null) {
    initialiseseats();       
}

for (int i = 0; i < seats.length; i++) {
    char[] rowSeats = seats[i];
    int rowLength = rowSeats.length;
    int leftSectionLength = (int) Math.ceil(rowLength / 2.0);
    int rightSectionLength = rowLength - leftSectionLength;
    int thirdRowLength = rowLengths[2];
    int spacesBefore = 0;
    
    int spaces = (thirdRowLength - rowLength) / 2;
    for (int j = 0; j < spaces; j++) {
        System.out.print(" ");
        
        
    }
    //row1seat1 matches with row2seat3 row 2sea1 matches with row3seat3
    //row1 seat 12 matches with 3rdlast seat of row2 and the last seat of row 2 lines up with 3rd last seat of row3
    for (int j = 0; j < spacesBefore; j++) {
        //spaces before the row starts to meet the format/layout requiremnts
        System.out.print(" ");
        //pyramid type format
    }
    
    for (int j = 0; j < leftSectionLength; j++) {
        // so 24 seats on each section
        System.out.print(rowSeats[j]);
        //left section and right section
        
    }

    for (int j = 0; j < middlepartation; j++) {//this var has the number for how many time " " will be shown
        //one for R1 R2 R3
        System.out.print(" ");

        
    }

    for (int j = leftSectionLength; j < rowLength; j++) {
        System.out.print(rowSeats[j]);
    }
    
    if (i == seats.length - 1) {
        
        System.out.print("\r");
        
    }
    
    System.out.println();
    
}
    }
    
    
}
