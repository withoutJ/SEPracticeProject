import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sportfacility.*;
import transaction.PayPalPayment;
import user.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static boolean isRunning;
    private static String username;
    private static String password;
    private static Scanner scanner = new Scanner(System.in); // Single scanner for entire application
    private static Customer customer;
    private static List<SportFacility> facilities = new ArrayList<>();
    
    public static void main(String args[]){
        facilities.add(new SwimmingPool(9, 20, 10));
        facilities.add(new BadmintonCourt(9, 23, 20));
        facilities.add(new BasketballCourt(9, 22, 120));
        facilities.add(new TennisCourt(9, 22, 50));
        System.out.println(facilities.size());
        isRunning = true;
        while (isRunning){
            int response = openScreen();
            if (response == 1){
                customer = AuthenticationService_Stub.register(username, password);
            }
            else if (response == 2){
                customer = AuthenticationService_Stub.login(username, password); // guessing login will use FindUser()
            }
            if (customer != null)
                mainMenu();
        }
        scanner.close(); // Close the scanner only once here
    }

    private static int openScreen(){
        customer = null;
        System.out.println("Shahbagh Sports Complex");
        System.out.println("---------------------------------------------------------");
        System.out.println("Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit");
        System.out.print("Input: ");
        int response = -1;
        while (response != 1 && response != 2 && response != 0){
            response = scanner.nextInt();
            if (response == 1){
                System.out.print("Set a username: ");
                username = scanner.next();
                System.out.print("Set a password: ");
                password = scanner.next();
            }
            else if (response == 2){
                System.out.print("Input your username: ");
                username = scanner.next();
                System.out.print("Input your password: ");
                password = scanner.next();
            }
            else if (response == 0){
                System.out.println("Thank you for using our system.");
                isRunning = false;
            }
            else{
                System.out.println("Invalid Token. Try again.");
            }
        }
        return response;
    }

    private static void mainMenu() {
        int userInput = -1;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateNtime = now.format(formatter);
        System.err.println(dateNtime);
        while (userInput != 0){
            System.out.println("Press 1 to make a booking.");
            System.out.println("Press 2 to view bookings.");
            System.out.println("Press 3 to cancel bookings.");
            System.out.println("Press 4 to show available facilities.");
            System.out.println("Press 0 to log out.");
            System.out.print("Input: ");
            userInput = scanner.nextInt();
            switch(userInput){
                case 1:
                    makeBooking();
                    break;
                case 2:
                    viewBooking();
                    int input = scanner.nextInt();
                    while (input != 0){
                        if (input != 0){
                            System.out.println("Invalid token. Try again.");
                            input = scanner.nextInt();
                        }
                    }
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    // some logic to print the facilities available
                    break;
                case 0:
                    // log out
                    break;
                default:
                    System.out.println("Invalid token. Try again.");

            }
        }
    }

    private static void makeBooking(){
        System.out.println("Choose a facility (Enter 0 to go to the main menu).");
        System.out.println("1. Swimming\n2. Badminton\n3. Basketball\n4. Tennis");
        System.out.print("Input: ");
        int facility = -1;
        boolean bookSuccessful = false;
        while (facility != 0 && !bookSuccessful){
            facility = scanner.nextInt();
            switch (facility){
                case 1: case 2: case 3: case 4:
                System.out.print("Enter date of booking (DD-MM-YYYY): ");
                String date = scanner.next();
                SportFacility chosenFacility = facilities.get(facility - 1);
                chosenFacility.showAvailableSlots(date);
                System.out.print("Enter preferred time slot (e.g. if you want to book at 20:00, type 20): ");
                int time = scanner.nextInt(); // need some method to display available time slots
                System.out.println("Select a payment method:");
                System.out.println("1) Credit Card\n2) PayPal");
                System.out.print("Input: ");
                int payment = scanner.nextInt();
                 // parameter will be changed such that PaymentStrategy is passed as strings of CC/Pl instead of an object
                bookSuccessful = customer.createBooking(facilities.get(facility - 1), date, time, new PayPalPayment());
                if (bookSuccessful){
                    System.out.println("Booking successfully create for " + date + " from " + 
                    Integer.toString(time) + ":00 to " + Integer.toString(time+1) + ":00. Go to main menu to manage your bookings.");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                }
                break;
                default:
                    System.out.println("Invalid token. Try again.");
            }
            
        }
    }

    private static void viewBooking(){
        customer.viewBookings();
        System.out.println("Enter 0 to go to the main menu.");
    }

    private static void cancelBooking(){
        boolean cancelled = true;
        System.out.println("Enter Booking ID to cancel a booking.");
        customer.viewBookings();
        String bookID = scanner.next();
        customer.cancelBooking(bookID);
        if (cancelled)
            System.out.println("Booking cancelled successfully.");
        else
            System.out.println("Booking does not exist, try again.");
    }
}
