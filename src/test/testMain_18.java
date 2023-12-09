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

public class testMain_18 {
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
public void testMain_18() throws Exception {
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	setOutput(new ByteArrayInputStream(
			"2\nadmin\nAstralTrapez0idB0dy\n1\n1\n1\n2\n1\n3\n1\n4\n1\n5\n0\n1\nalice\nPassword123\n1\n1\n07-12-2023\n19\nCC\n3\n1\n0\n0\n0\n"
					.getBytes()),
			outContent);
	Main.main(new String[] {}); // Run the main method which should now use the simulated input

	String expectedOutput = "Shahbagh Sports Complex\n"
			+ "---------------------------------------------------------\n"
			+ "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\n" + "Input: " + "Input your username: "
			+ "Input your password: " + admin.printTime() + "\n" + "Press 1 to add a facility.\n"
			+ "Press 2 to change system time.\n" + "Press 0 to log out.\n" + "Input: "
			+ "Choose a facility to add.\n" + "1. Swimming\n" + "2. Badminton\n" + "3. Basketball\n" + "4. Tennis\n"
			+ "5. Football\n" + "Input: " + "A facility Swimming has been added successfully.\n" + admin.printTime()
			+ "\n" + "Press 1 to add a facility.\n" + "Press 2 to change system time.\n" + "Press 0 to log out.\n"
			+ "Input: " + "Choose a facility to add.\n" + "1. Swimming\n" + "2. Badminton\n" + "3. Basketball\n"
			+ "4. Tennis\n" + "5. Football\n" + "Input: " + "A facility Badminton has been added successfully.\n"
			+ admin.printTime() + "\n" + "Press 1 to add a facility.\n" + "Press 2 to change system time.\n"
			+ "Press 0 to log out.\n" + "Input: " + "Choose a facility to add.\n" + "1. Swimming\n"
			+ "2. Badminton\n" + "3. Basketball\n" + "4. Tennis\n" + "5. Football\n" + "Input: "
			+ "A facility Basketball has been added successfully.\n" + admin.printTime() + "\n"
			+ "Press 1 to add a facility.\n" + "Press 2 to change system time.\n" + "Press 0 to log out.\n"
			+ "Input: " + "Choose a facility to add.\n" + "1. Swimming\n" + "2. Badminton\n" + "3. Basketball\n"
			+ "4. Tennis\n" + "5. Football\n" + "Input: " + "A facility Tennis has been added successfully.\n"
			+ admin.printTime() + "\n" + "Press 1 to add a facility.\n" + "Press 2 to change system time.\n"
			+ "Press 0 to log out.\n" + "Input: " + "Choose a facility to add.\n" + "1. Swimming\n"
			+ "2. Badminton\n" + "3. Basketball\n" + "4. Tennis\n" + "5. Football\n" + "Input: "
			+ "A facility Football has been added successfully.\n" + admin.printTime() + "\n"
			+ "Press 1 to add a facility.\n" + "Press 2 to change system time.\n" + "Press 0 to log out.\n"
			+ "Input: " + "Shahbagh Sports Complex\n"
			+ "---------------------------------------------------------\n"
			+ "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\n" + "Input: " + "Set a username: "
			+ "Set a password: " + admin.printTime() + "\n" + "Press 1 to make a booking.\n"
			+ "Press 2 to view bookings.\n" + "Press 3 to cancel bookings.\n"
			+ "Press 4 to check for any cancelled bookings.\n" + "Press 5 to review any past bookings.\n"
			+ "Press 6 to check facility ratings.\n" + "Press 0 to log out.\n" + "Input: "
			+ "Choose a facility (Enter 0 to go to the main menu).\n" + "1. Swimming Pool\n"
			+ "2. Badminton Court\n" + "3. Basketball Court\n" + "4. Tennis Court\n" + "5. Football Field\n"
			+ "Input: " + "Enter date of booking (DD-MM-YYYY): " + "Date is in the past. Try again.\n"
			+ admin.printTime() + "\n" + "Press 1 to make a booking.\n" + "Press 2 to view bookings.\n"
			+ "Press 3 to cancel bookings.\n" + "Press 4 to check for any cancelled bookings.\n"
			+ "Press 5 to review any past bookings.\n" + "Press 6 to check facility ratings.\n"
			+ "Press 0 to log out.\n" + "Input: " + "Invalid Token. Try again.\n" + admin.printTime() + "\n"
			+ "Press 1 to make a booking.\n" + "Press 2 to view bookings.\n" + "Press 3 to cancel bookings.\n"
			+ "Press 4 to check for any cancelled bookings.\n" + "Press 5 to review any past bookings.\n"
			+ "Press 6 to check facility ratings.\n" + "Press 0 to log out.\n" + "Input: "
			+ "Input is not a number. Try again.\n" + admin.printTime() + "\n" + "Press 1 to make a booking.\n"
			+ "Press 2 to view bookings.\n" + "Press 3 to cancel bookings.\n"
			+ "Press 4 to check for any cancelled bookings.\n" + "Press 5 to review any past bookings.\n"
			+ "Press 6 to check facility ratings.\n" + "Press 0 to log out.\n" + "Input: " + "\n"
			+ "Enter Booking ID to cancel a booking.\n" + "Enter 0 to go to the main menu.\n"
			+ "Membership Type: Standard Member\n" + "You have no bookings currently. \n" + "Input: "
			+ "Booking does not exist. Try again.\n" + "Enter Booking ID to cancel a booking.\n"
			+ "Enter 0 to go to the main menu.\n" + "Membership Type: Standard Member\n"
			+ "You have no bookings currently. \n" + "Input: " + admin.printTime() + "\n"
			+ "Press 1 to make a booking.\n" + "Press 2 to view bookings.\n" + "Press 3 to cancel bookings.\n"
			+ "Press 4 to check for any cancelled bookings.\n" + "Press 5 to review any past bookings.\n"
			+ "Press 6 to check facility ratings.\n" + "Press 0 to log out.\n" + "Input: "
			+ "Shahbagh Sports Complex\n" + "---------------------------------------------------------\n"
			+ "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\n" + "Input: "
			+ "Thank you for using our system.\n"

	// + ""
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
