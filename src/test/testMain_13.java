package test;

import main.Main;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import sportfacility.*;
import user.Admin;

public class testMain_13 {
	// private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final InputStream originalIn = System.in;

	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String dateNtime = now.format(formatter);

	Admin admin = Admin.getInstance();

	public void setOutput(ByteArrayInputStream testIn, ByteArrayOutputStream outContent) {
		// Set up the output stream to capture the output
		System.setOut(new PrintStream(outContent));
		// Set up the input stream to simulate user input
		System.setIn(testIn);
	}

	public void getOutput() {
		// Restore the original output and input streams
		System.setOut(originalOut);
		System.setIn(originalIn);
	}

  
    @Test
    public void testMain_13() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        setOutput(new ByteArrayInputStream("2\nadmin\n1\n1\nadmin\nAstralTrapez0idB0dy\n1\n1\n1\n2\n1\n3\n1\n4\n1\n5\n0\n1\nalice\npassword\nalice\nPassword123\n0\n2\nalice\naa\nalice\nPassword123\n2\n0\n3\n0\n4\n0\n5\n0\ngood\n4\n6\n1\n1\n01-01-2022\n1\n1\n01-01-2024\n21\ncc\n1\n1\n10-12-2023\n10\nPL\n1\n2\n10-12-2024\n20\nCC\n1\n2\n10-12-2024\n20\nCC\n0\n3\n2\n3\n2\n0\n5\n1\ngood\n3\n0\n0\n".getBytes()), outContent);
        Main.main(new String[] {}); // Run the main method which should now use the simulated input

        String expectedOutput = "Shahbagh Sports Complex\n"
        		+ "---------------------------------------------------------\n"
        		+ "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\n"
        		+ "Input: "
        		+ "Input your username: "
        		+ "Input your password: "
        		+ "Password incorrect. Please try again.\n"
        		+ "Input your username: "
        		+ "Account does not exist.\n"
        		+ "Input your username: "
        		+ "Input your password: "
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to add a facility.\n"
        		+ "Press 2 to change system time.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Choose a facility to add.\n"
        		+ "1. Swimming\n"
        		+ "2. Badminton\n"
        		+ "3. Basketball\n"
        		+ "4. Tennis\n"
        		+ "5. Football\n"
        		+ "Input: "
        		+ "A facility Swimming has been added successfully.\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to add a facility.\n"
        		+ "Press 2 to change system time.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Choose a facility to add.\n"
        		+ "1. Swimming\n"
        		+ "2. Badminton\n"
        		+ "3. Basketball\n"
        		+ "4. Tennis\n"
        		+ "5. Football\n"
        		+ "Input: "
        		+ "A facility Badminton has been added successfully.\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to add a facility.\n"
        		+ "Press 2 to change system time.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Choose a facility to add.\n"
        		+ "1. Swimming\n"
        		+ "2. Badminton\n"
        		+ "3. Basketball\n"
        		+ "4. Tennis\n"
        		+ "5. Football\n"
        		+ "Input: "
        		+ "A facility Basketball has been added successfully.\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to add a facility.\n"
        		+ "Press 2 to change system time.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Choose a facility to add.\n"
        		+ "1. Swimming\n"
        		+ "2. Badminton\n"
        		+ "3. Basketball\n"
        		+ "4. Tennis\n"
        		+ "5. Football\n"
        		+ "Input: "
        		+ "A facility Tennis has been added successfully.\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to add a facility.\n"
        		+ "Press 2 to change system time.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Choose a facility to add.\n"
        		+ "1. Swimming\n"
        		+ "2. Badminton\n"
        		+ "3. Basketball\n"
        		+ "4. Tennis\n"
        		+ "5. Football\n"
        		+ "Input: "
        		+ "A facility Football has been added successfully.\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to add a facility.\n"
        		+ "Press 2 to change system time.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Shahbagh Sports Complex\n"
        		+ "---------------------------------------------------------\n"
        		+ "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\n"
        		+ "Input: "
        		+ "Set a username: "
        		+ "Set a password: "
        		+ "Password must not contain any spaces, and must contain at least one upper case letter, one lower case letter and a number.\n"
        		+ "Set a username: "
        		+ "Set a password: "
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Shahbagh Sports Complex\n"
        		+ "---------------------------------------------------------\n"
        		+ "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\n"
        		+ "Input: "
        		+ "Input your username: "
        		+ "Input your password: "
        		+ "Password incorrect. Please try again.\n"
        		+ "Input your username: "
        		+ "Input your password: "
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Membership Type: Standard Member\n"
        		+ "You have no bookings currently. \n"
        		+ "Enter 0 to go to the main menu.\n"
        		+ ""
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "\n"
        		+ "Enter Booking ID to cancel a booking.\n"
        		+ "Enter 0 to go to the main menu.\n"
        		+ "Membership Type: Standard Member\n"
        		+ "You have no bookings currently. \n"
        		+ "Input: "
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Sorry, there is no record of any cancelled bookings.\n"
        		+ "Enter 0 to go back to main menu.\n"
        		+ ""
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Membership Type: Standard Member\n"
        		+ "Input booking ID to review a booking: "
        		+ "Enter comment: "
        		+ "Enter rating (a number between 1-5): "
        		+ "Thank you for your feedback.\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Swimming Pool: \n"
        		+ "\n"
        		+ "Badminton Court: \n"
        		+ "\n"
        		+ "Basketball Court: \n"
        		+ "\n"
        		+ "Tennis Court: \n"
        		+ "\n"
        		+ "Football Field: \n"
        		+ "\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Choose a facility (Enter 0 to go to the main menu).\n"
        		+ "1. Swimming Pool\n"
        		+ "2. Badminton Court\n"
        		+ "3. Basketball Court\n"
        		+ "4. Tennis Court\n"
        		+ "5. Football Field\n"
        		+ "Input: "
        		+ "Enter date of booking (DD-MM-YYYY): "
        		+ "Date is in the past. Try again.\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Choose a facility (Enter 0 to go to the main menu).\n"
        		+ "1. Swimming Pool\n"
        		+ "2. Badminton Court\n"
        		+ "3. Basketball Court\n"
        		+ "4. Tennis Court\n"
        		+ "5. Football Field\n"
        		+ "Input: "
        		+ "Enter date of booking (DD-MM-YYYY): "
        		+ "Available time slots for 01-01-2024:\n"
        		+ "Time slot 9:00 is available.\n"
        		+ "Time slot 10:00 is available.\n"
        		+ "Time slot 11:00 is available.\n"
        		+ "Time slot 12:00 is available.\n"
        		+ "Time slot 13:00 is available.\n"
        		+ "Time slot 14:00 is available.\n"
        		+ "Time slot 15:00 is available.\n"
        		+ "Time slot 16:00 is available.\n"
        		+ "Time slot 17:00 is available.\n"
        		+ "Time slot 18:00 is available.\n"
        		+ "Time slot 19:00 is available.\n"
        		+ "Enter preferred time slot (e.g. if you want to book at 20:00, type 20): "
        		+ "Select a payment method:\n"
        		+ "1. Credit Card (Enter CC)\n"
        		+ "2. PayPal (Enter PL)\n"
        		+ "Input: "
        		+ "Payment method does not exist. Enter CC for Credit Card payment, or PL for payment via PayPal.\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Choose a facility (Enter 0 to go to the main menu).\n"
        		+ "1. Swimming Pool\n"
        		+ "2. Badminton Court\n"
        		+ "3. Basketball Court\n"
        		+ "4. Tennis Court\n"
        		+ "5. Football Field\n"
        		+ "Input: "
        		+ "Enter date of booking (DD-MM-YYYY): "
        		+ "Available time slots for 10-12-2023:\n"
        		+ "Time slot 9:00 is available.\n"
        		+ "Time slot 10:00 is available.\n"
        		+ "Time slot 11:00 is available.\n"
        		+ "Time slot 12:00 is available.\n"
        		+ "Time slot 13:00 is available.\n"
        		+ "Time slot 14:00 is available.\n"
        		+ "Time slot 15:00 is available.\n"
        		+ "Time slot 16:00 is available.\n"
        		+ "Time slot 17:00 is available.\n"
        		+ "Time slot 18:00 is available.\n"
        		+ "Time slot 19:00 is available.\n"
        		+ "Enter preferred time slot (e.g. if you want to book at 20:00, type 20): "
        		+ "Select a payment method:\n"
        		+ "1. Credit Card (Enter CC)\n"
        		+ "2. PayPal (Enter PL)\n"
        		+ "Input: "
        		+ "Redirecting you to transaction...\n"
        		+ "Your total is: 10.0\n"
        		+ "Processing transaction...\n"
        		+ "PayPal processed the payment with amount of 10.00.\n"
        		+ "Booking Successful for facility 10-12-2023 10\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Choose a facility (Enter 0 to go to the main menu).\n"
        		+ "1. Swimming Pool\n"
        		+ "2. Badminton Court\n"
        		+ "3. Basketball Court\n"
        		+ "4. Tennis Court\n"
        		+ "5. Football Field\n"
        		+ "Input: "
        		+ "Enter date of booking (DD-MM-YYYY): "
        		+ "Available time slots for 10-12-2024:\n"
        		+ "Time slot 9:00 is available.\n"
        		+ "Time slot 10:00 is available.\n"
        		+ "Time slot 11:00 is available.\n"
        		+ "Time slot 12:00 is available.\n"
        		+ "Time slot 13:00 is available.\n"
        		+ "Time slot 14:00 is available.\n"
        		+ "Time slot 15:00 is available.\n"
        		+ "Time slot 16:00 is available.\n"
        		+ "Time slot 17:00 is available.\n"
        		+ "Time slot 18:00 is available.\n"
        		+ "Time slot 19:00 is available.\n"
        		+ "Time slot 20:00 is available.\n"
        		+ "Time slot 21:00 is available.\n"
        		+ "Time slot 22:00 is available.\n"
        		+ "Enter preferred time slot (e.g. if you want to book at 20:00, type 20): "
        		+ "Select a payment method:\n"
        		+ "1. Credit Card (Enter CC)\n"
        		+ "2. PayPal (Enter PL)\n"
        		+ "Input: "
        		+ "Redirecting you to transaction...\n"
        		+ "Your total is: 19.8\n"
        		+ "Processing transaction...\n"
        		+ "Visa processed the payment with amount of 19.80.\n"
        		+ "Booking Successful for facility 10-12-2024 20\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Choose a facility (Enter 0 to go to the main menu).\n"
        		+ "1. Swimming Pool\n"
        		+ "2. Badminton Court\n"
        		+ "3. Basketball Court\n"
        		+ "4. Tennis Court\n"
        		+ "5. Football Field\n"
        		+ "Input: "
        		+ "Enter date of booking (DD-MM-YYYY): "
        		+ "Available time slots for 10-12-2024:\n"
        		+ "Time slot 9:00 is available.\n"
        		+ "Time slot 10:00 is available.\n"
        		+ "Time slot 11:00 is available.\n"
        		+ "Time slot 12:00 is available.\n"
        		+ "Time slot 13:00 is available.\n"
        		+ "Time slot 14:00 is available.\n"
        		+ "Time slot 15:00 is available.\n"
        		+ "Time slot 16:00 is available.\n"
        		+ "Time slot 17:00 is available.\n"
        		+ "Time slot 18:00 is available.\n"
        		+ "Time slot 19:00 is available.\n"
        		+ "Time slot 21:00 is available.\n"
        		+ "Time slot 22:00 is available.\n"
        		+ "Enter preferred time slot (e.g. if you want to book at 20:00, type 20): "
        		+ "Select a payment method:\n"
        		+ "1. Credit Card (Enter CC)\n"
        		+ "2. PayPal (Enter PL)\n"
        		+ "Input: "
        		+ "Sorry, this time slot is already booked.\n"
        		+ "You have been added to the waitlist, if the booker cancels their booking, you would be notified. Thanks.\n"
        		+ "Choose a facility (Enter 0 to go to the main menu).\n"
        		+ "1. Swimming Pool\n"
        		+ "2. Badminton Court\n"
        		+ "3. Basketball Court\n"
        		+ "4. Tennis Court\n"
        		+ "5. Football Field\n"
        		+ "Input: "
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "\n"
        		+ "Enter Booking ID to cancel a booking.\n"
        		+ "Enter 0 to go to the main menu.\n"
        		+ "Membership Type: Gold Member\n"
        		+ "Booking ID: 1\n"
        		+ "Booking Date: 10-12-2023\n"
        		+ "Booking Start Time: 10\n"
        		+ "Facility: Swimming Pool\n"
        		+ "Booking ID: 2\n"
        		+ "Booking Date: 10-12-2024\n"
        		+ "Booking Start Time: 20\n"
        		+ "Facility: Badminton Court\n"
        		+ "Input: "
        		+ "Booking cancelled for 10-12-2024 20\n"
        		+ "Visa processed the refund with amount of 19.80.\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "\n"
        		+ "Enter Booking ID to cancel a booking.\n"
        		+ "Enter 0 to go to the main menu.\n"
        		+ "Membership Type: Gold Member\n"
        		+ "Booking ID: 1\n"
        		+ "Booking Date: 10-12-2023\n"
        		+ "Booking Start Time: 10\n"
        		+ "Facility: Swimming Pool\n"
        		+ "Input: "
        		+ "Booking does not exist. Try again.\n"
        		+ "Enter Booking ID to cancel a booking.\n"
        		+ "Enter 0 to go to the main menu.\n"
        		+ "Membership Type: Gold Member\n"
        		+ "Booking ID: 1\n"
        		+ "Booking Date: 10-12-2023\n"
        		+ "Booking Start Time: 10\n"
        		+ "Facility: Swimming Pool\n"
        		+ "Input: "
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Membership Type: Gold Member\n"
        		+ "Input booking ID to review a booking: "
        		+ "Enter comment: "
        		+ "Enter rating (a number between 1-5): "
        		+ "Thank you for your feedback.\n"
        		+ admin.printTime()
        		+ "\n"
        		+ "Press 1 to make a booking.\n"
        		+ "Press 2 to view bookings.\n"
        		+ "Press 3 to cancel bookings.\n"
        		+ "Press 4 to check for any cancelled bookings.\n"
        		+ "Press 5 to review any past bookings.\n"
        		+ "Press 6 to check facility ratings.\n"
        		+ "Press 0 to log out.\n"
        		+ "Input: "
        		+ "Shahbagh Sports Complex\n"
        		+ "---------------------------------------------------------\n"
        		+ "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\n"
        		+ "Input: "
        		+ "Thank you for using our system.\n" 
                ;

// Trim the captured output to avoid issues with trailing newlines
String actualOutput = outContent.toString(); // .trim();

// Replace all system-dependent newlines with \n for consistent comparison
// actualOutput = actualOutput.replace(System.lineSeparator(), "\n");
getOutput();
expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
    }



}