import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static boolean isRunning;
    private static String username;
    private static String password;
    private static Scanner scanner = new Scanner(System.in); // Single scanner for entire application
    private static Customer customer = null;
    public static void main(String args[]){
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
            System.out.println("Press 2 to manage bookings.");
            System.out.println("Press 3 to show available facilities.");
            System.out.println("Press 0 to log out.");
            System.out.print("Input: ");
            userInput = scanner.nextInt();
            switch(userInput){
                case 1:
                    customer.createBooking(null, dateNtime, userInput);
                    // createBooking()
                    break;
                case 2:
                    // Manage booking
                    break;
                case 3:
                    // Show available facilities
                    break;
                case 0:
                    // log out
                    break;
                default:
                    System.out.println("Invalid Token. Try again.");

            }
        }
    }
}
