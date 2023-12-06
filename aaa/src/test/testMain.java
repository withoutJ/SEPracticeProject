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

public class testMain {
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
        public void testMain_01() throws Exception {
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                setOutput(new ByteArrayInputStream("0\n".getBytes()), outContent);
                Main.main(new String[] {}); // Run the main method which should now use the simulated input

                String expectedOutput = "Shahbagh Sports Complex\n" +
                                "---------------------------------------------------------\n" +
                                "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\n" +
                                "Input: " +
                                "Thank you for using our system.\n";

                // Trim the captured output to avoid issues with trailing newlines
                String actualOutput = outContent.toString(); // .trim();

                // Replace all system-dependent newlines with \n for consistent comparison
                // actualOutput = actualOutput.replace(System.lineSeparator(), "\n");
                getOutput();
                assertEquals(expectedOutput, actualOutput);
        }

        @Test
        public void testMain_02() throws Exception {
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                setOutput(new ByteArrayInputStream(
                                "2\nadmin\nAstralTrapez0idB0dy\n0\n1\nAlice\npassword\n/\n0\n".getBytes()), outContent);
                Main.main(new String[] {}); // Run the main method which should now use the simulated input

                String expectedOutput = "Shahbagh Sports Complex\r\n"
                                + "---------------------------------------------------------\r\n"
                                + "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Input your username: "
                                + "Input your password: "
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Shahbagh Sports Complex\r\n"
                                + "---------------------------------------------------------\r\n"
                                + "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Set a username: "
                                + "Set a password: "
                                + "Password must not contain any spaces, and must contain at least one upper case letter, one lower case letter and a number.\r\n"
                                + "Set a username: "
                                + "Shahbagh Sports Complex\r\n"
                                + "---------------------------------------------------------\r\n"
                                + "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Thank you for using our system.";

                // Trim the captured output to avoid issues with trailing newlines
                String actualOutput = outContent.toString().trim();

                // Replace all system-dependent newlines with \n for consistent comparison
                actualOutput = actualOutput.replace(System.lineSeparator(), "\n");
                getOutput();
                expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
                actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
                assertEquals(expectedOutput, actualOutput);
        }

        @Test
        public void testMain_03() throws Exception {// 1\n1\n31-11-2021\n0\n
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                setOutput(new ByteArrayInputStream(
                                "2\nadmin\nAstralTrapez0idB0dy\n1\n1\n1\n2\n1\n3\n1\n4\n1\n5\n0\n1\nAlice\nPassword123\n1\n1\n05-12-2023\n15\nCC\n0\n0\n"
                                                .getBytes()),
                                outContent);
                Main.main(new String[] {}); // Run the main method which should now use the simulated input

                String expectedOutput = "Shahbagh Sports Complex\r\n"
                                + "---------------------------------------------------------\r\n"
                                + "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Input your username: "
                                + "Input your password: "
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Choose a facility to add.\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "5. Football\r\n" + //
                                "Input: "
                                + "A facility Swimming has been added successfully.\n"
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Choose a facility to add.\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "5. Football\r\n" + //
                                "Input: "
                                + "A facility Badminton has been added successfully.\n"
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Choose a facility to add.\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "5. Football\r\n" + //
                                "Input: "
                                + "A facility Basketball has been added successfully.\n"
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Choose a facility to add.\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "5. Football\r\n" + //
                                "Input: "
                                + "A facility Tennis has been added successfully.\n"
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Choose a facility to add.\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "5. Football\r\n" + //
                                "Input: "
                                + "A facility Football has been added successfully.\n"
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Shahbagh Sports Complex\r\n"
                                + "---------------------------------------------------------\r\n"
                                + "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Set a username: "
                                + "Set a password: "
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 5 to review any past bookings.\r\n" + //
                                "Press 6 to check facility ratings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: "
                                + "Choose a facility (Enter 0 to go to the main menu).\r\n" + //
                                "1. Swimming Pool\r\n" + //
                                "2. Badminton Court\r\n" + //
                                "3. Basketball Court\r\n" + //
                                "4. Tennis Court\r\n" + //
                                "5. Football Field\r\n" + //
                                "Input:"
                                + "Enter date of booking (DD-MM-YYYY): "
                                + "Available time slots for 05-12-2023:\r\n" + //
                                "Time slot 9:00 is available.\r\n" + //
                                "Time slot 10:00 is available.\r\n" + //
                                "Time slot 11:00 is available.\r\n" + //
                                "Time slot 12:00 is available.\r\n" + //
                                "Time slot 13:00 is available.\r\n" + //
                                "Time slot 14:00 is available.\r\n" + //
                                "Time slot 15:00 is available.\r\n" + //
                                "Time slot 16:00 is available.\r\n" + //
                                "Time slot 17:00 is available.\r\n" + //
                                "Time slot 18:00 is available.\r\n" + //
                                "Time slot 19:00 is available.\r\n" + //
                                "Enter preferred time slot (e.g. if you want to book at 20:00, type 20): "
                                + "Select a payment method:\r\n" + //
                                "1. Credit Card (Enter CC)\r\n" + //
                                "2. PayPal (Enter PL)\r\n" + //
                                "Input: "
                                + "Redirecting you to transaction...\r\n" + //
                                "Your total is: 10.0\r\n" + //
                                "Processing transaction...\r\n" + //
                                "Visa processed the payment with amount of 10.00.\r\n" + //
                                "Booking Successful for facility 05-12-2023 15\r\n" + //
                                admin.printTime()
                                +
                                "\r\n" + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 5 to review any past bookings.\r\n" + //
                                "Press 6 to check facility ratings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: "
                                + "Shahbagh Sports Complex\r\n" + //
                                "---------------------------------------------------------\r\n" + //
                                "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Thank you for using our system.";

                // Trim the captured output to avoid issues with trailing newlines
                String actualOutput = outContent.toString(); // .trim();

                // Replace all system-dependent newlines with \n for consistent comparison
                // actualOutput = actualOutput.replace(System.lineSeparator(), "\n");
                getOutput();
                expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
                actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
        }

        @Test
        public void testMain_04() throws Exception {
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                setOutput(new ByteArrayInputStream(
                                "2\nadmin\nAstralTrapez0idB0dy\n1\n1\n1\n2\n1\n3\n1\n4\n1\n5\n0\n1\nAlice\nPassword123\n1\n1\n30-12-2023\n15\nPL\n2\n0\n4\n0\n1\nBruce\nPassword123\n1\n1\n30-12-2023\n15\nCC\n0\n0\n0\n"
                                                .getBytes()),
                                outContent);
                Main.main(new String[] {}); // Run the main method which should now use the simulated input

                String expectedOutput = "Shahbagh Sports Complex\r\n"
                                + "---------------------------------------------------------\r\n"
                                + "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Input your username: "
                                + "Input your password: "
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Choose a facility to add.\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "5. Football\r\n" + //
                                "Input: "
                                + "A facility Swimming has been added successfully.\n"
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Choose a facility to add.\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "5. Football\r\n" + //
                                "Input: "
                                + "A facility Badminton has been added successfully.\n"
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Choose a facility to add.\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "5. Football\r\n" + //
                                "Input: "
                                + "A facility Basketball has been added successfully.\n"
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Choose a facility to add.\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "5. Football\r\n" + //
                                "Input: "
                                + "A facility Tennis has been added successfully.\n"
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Choose a facility to add.\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "5. Football\r\n" + //
                                "Input: "
                                + "A facility Football has been added successfully.\n"
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to add a facility.\n"
                                + "Press 2 to change system time.\n"
                                + "Press 0 to log out.\n"
                                + "Input: "
                                + "Shahbagh Sports Complex\r\n"
                                + "---------------------------------------------------------\r\n"
                                + "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Set a username: "
                                + "Set a password: "
                                + admin.printTime()
                                + "\n"
                                + "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 5 to review any past bookings.\r\n" + //
                                "Press 6 to check facility ratings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: "
                                + "Choose a facility (Enter 0 to go to the main menu).\r\n" + //
                                "1. Swimming Pool\r\n" + //
                                "2. Badminton Court\r\n" + //
                                "3. Basketball Court\r\n" + //
                                "4. Tennis Court\r\n" + //
                                "5. Football Field\r\n" + //
                                "Input: "
                                + "Enter date of booking (DD-MM-YYYY): "
                                + "Available time slots for 30-12-2023:\r\n" + //
                                "Time slot 9:00 is available.\r\n" + //
                                "Time slot 10:00 is available.\r\n" + //
                                "Time slot 11:00 is available.\r\n" + //
                                "Time slot 12:00 is available.\r\n" + //
                                "Time slot 13:00 is available.\r\n" + //
                                "Time slot 14:00 is available.\r\n" + //
                                "Time slot 15:00 is available.\r\n" + //
                                "Time slot 16:00 is available.\r\n" + //
                                "Time slot 17:00 is available.\r\n" + //
                                "Time slot 18:00 is available.\r\n" + //
                                "Time slot 19:00 is available.\r\n" + //
                                // " Time slot 20:00 is available.\r\nTime slot 21:00 is available.\r\nTime slot
                                // 22:00 is available.\r\n"
                                "Enter preferred time slot (e.g. if you want to book at 20:00, type 20): "
                                + "Select a payment method:\r\n" + //
                                "1. Credit Card (Enter CC)\r\n" + //
                                "2. PayPal (Enter PL)\r\n" + //
                                "Input: "
                                + "Redirecting you to transaction...\r\n" + //
                                "Your total is: 10.0\r\n" + //
                                "Processing transaction...\r\n" + //
                                "PayPal processed the payment with amount of 10.00.\r\n" + //
                                "Booking Successful for facility 30-12-2023 15\n" + //
                                admin.printTime()
                                +
                                "\r\n" + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 5 to review any past bookings.\r\n" + //
                                "Press 6 to check facility ratings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: "
                                + "Membership Type: Standard Member\r\n" + //
                                "Booking ID: 1\r\n" + //
                                "Booking Date: 30-12-2023\r\n" + //
                                "Booking Start Time: 15\r\n" + //
                                "\r\n" + //
                                "Enter 0 to go to the main menu.\n"
                                + admin.printTime()
                                +
                                "\r\n" + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 5 to review any past bookings.\r\n" + //
                                "Press 6 to check facility ratings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: "
                                + "Sorry, there is no record of any cancelled bookings.\n"
                                + admin.printTime()
                                +
                                "\r\n" + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 5 to review any past bookings.\r\n" + //
                                "Press 6 to check facility ratings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: "
                                + "Shahbagh Sports Complex\r\n" + //
                                "---------------------------------------------------------\r\n" + //
                                "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Set a username: "
                                + "Set a password: "
                                + admin.printTime()
                                +
                                "\r\n" + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 5 to review any past bookings.\r\n" + //
                                "Press 6 to check facility ratings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: "
                                + "Choose a facility (Enter 0 to go to the main menu).\r\n" + //
                                "1. Swimming Pool\r\n" + //
                                "2. Badminton Court\r\n" + //
                                "3. Basketball Court\r\n" + //
                                "4. Tennis Court\r\n" + //
                                "5. Football Field\r\n" + //
                                "Input: "
                                + "Enter date of booking (DD-MM-YYYY): "
                                + "Available time slots for 30-12-2023:\r\n" + //
                                "Time slot 9:00 is available.\r\n" + //
                                "Time slot 10:00 is available.\r\n" + //
                                "Time slot 11:00 is available.\r\n" + //
                                "Time slot 12:00 is available.\r\n" + //
                                "Time slot 13:00 is available.\r\n" + //
                                "Time slot 14:00 is available.\r\n" + //
                                "Time slot 16:00 is available.\r\n" + //
                                "Time slot 17:00 is available.\r\n" + //
                                "Time slot 18:00 is available.\r\n" + //
                                "Time slot 19:00 is available.\r\n"
                                + "Enter preferred time slot (e.g. if you want to book at 20:00, type 20): "
                                + "Select a payment method:\r\n" + //
                                "1. Credit Card (Enter CC)\r\n" + //
                                "2. PayPal (Enter PL)\r\n" + //
                                "Input: "
                                + "Sorry, this time slot is already booked.\r\n" + //
                                "You have been added to the waitlist, if the booker cancels their booking, you would be notified. Thanks.\r\n"
                                + //
                                "Choose a facility (Enter 0 to go to the main menu).\r\n" + //
                                "1. Swimming Pool\r\n" + //
                                "2. Badminton Court\r\n" + //
                                "3. Basketball Court\r\n" + //
                                "4. Tennis Court\r\n" + //
                                "5. Football Field\r\n"
                                + "Input: "
                                + admin.printTime()
                                +
                                "\r\n" + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 5 to review any past bookings.\r\n" + //
                                "Press 6 to check facility ratings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: "
                                + "Shahbagh Sports Complex\r\n" + //
                                "---------------------------------------------------------\r\n" + //
                                "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Thank you for using our system.";

                // Trim the captured output to avoid issues with trailing newlines
                String actualOutput = outContent.toString(); // .trim();

                // Replace all system-dependent newlines with \n for consistent comparison
                // actualOutput = actualOutput.replace(System.lineSeparator(), "\n");
                getOutput();
                expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
                actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
                assertEquals(expectedOutput, actualOutput);
        }

        @Test
        public void testMain_05() throws Exception {
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                setOutput(new ByteArrayInputStream(
                                "1\nAlice\nPassword123\n1\n1\n31-11-2023\n14\nCC\n0\n0\n".getBytes()),
                                outContent);
                Main.main(new String[] {}); // Run the main method which should now use the simulated input

                String expectedOutput = "Shahbagh Sports Complex\r\n" + //
                                "---------------------------------------------------------\r\n" + //
                                "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n" + //
                                "Input: 1\r\n" + //
                                "Set a username: Alice\r\n" + //
                                "Set a password: Password123\r\n" + //
                                dateNtime + "\r\n" + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: \r\n" + //
                                "Choose a facility (Enter 0 to go to the main menu).\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "Input: \r\n" + //
                                "Enter date of booking (DD-MM-YYYY): \r\n" + //
                                "Available time slots for 30-11-2023:\r\n" + //
                                "Time slot 9:00 is available.\r\n" + //
                                "Time slot 10:00 is available.\r\n" + //
                                "Time slot 11:00 is available.\r\n" + //
                                "Time slot 12:00 is available.\r\n" + //
                                "Time slot 13:00 is available.\r\n" + //
                                "Time slot 14:00 is available.\r\n" + //
                                "Time slot 15:00 is available.\r\n" + //
                                "Time slot 16:00 is available.\r\n" + //
                                "Time slot 17:00 is available.\r\n" + //
                                "Time slot 18:00 is available.\r\n" + //
                                "Time slot 19:00 is available.\r\n" + //
                                "Enter preferred time slot (e.g. if you want to book at 20:00, type 20): 15\r\n" + //
                                "Select a payment method:\r\n" + //
                                "1. Credit Card (Enter CC)\r\n" + //
                                "2. PayPal (Enter PL)\r\n" + //
                                "Input: \r\n" + //
                                "Redirecting you to transaction...\r\n" + //
                                "Your total is: 10.0\r\n" + //
                                "Processing transaction...\r\n" + //
                                "Visa processed the payment with amount of 10.00.\r\n" + //
                                "Booking Successful for facility 30-11-2023 15\r\n" + //
                                "Booking successfully created for 30-11-2023 from 15:00 to 16:00. Go to main menu to manage your bookings.\r\n"
                                + //
                                "------------------------------------------------------------------------------------------------------------------------------------------\r\n"
                                + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: \r\n" + //
                                "Shahbagh Sports Complex\r\n" + //
                                "---------------------------------------------------------\r\n" + //
                                "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n" + //
                                "Input: \r\n" + //
                                "Thank you for using our system.";

                // Trim the captured output to avoid issues with trailing newlines
                String actualOutput = outContent.toString(); // .trim();

                // Replace all system-dependent newlines with \n for consistent comparison
                // actualOutput = actualOutput.replace(System.lineSeparator(), "\n");
                getOutput();
                expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
                actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
                assertEquals(expectedOutput, actualOutput);
        }

        @Test
        public void testMain_06() throws Exception {
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                setOutput(new ByteArrayInputStream("1\nAlice\nPassword123\n2\n0\n0\n0\n".getBytes()),
                                outContent);
                Main.main(new String[] {}); // Run the main method which should now use the simulated input

                String expectedOutput = "Shahbagh Sports Complex\r\n" + //
                                "---------------------------------------------------------\r\n"
                                + "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Set a username: "
                                + "Set a password: "
                                + dateNtime + "\r\n" +
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: 2\r\n" + //
                                "Membership Type: Standard Member\r\n" + //
                                "You have no bookings currently.\r\n" + //
                                "Enter 0 to go to the main menu.\r\n" + //
                                "0\r\n" + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: 0\r\n" + //
                                "Shahbagh Sports Complex\r\n" + //
                                "---------------------------------------------------------\r\n" + //
                                "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n" + //
                                "Input: 0\r\n" + //
                                "Thank you for using our system.";

                // Trim the captured output to avoid issues with trailing newlines
                String actualOutput = outContent.toString(); // .trim();

                // Replace all system-dependent newlines with \n for consistent comparison
                // actualOutput = actualOutput.replace(System.lineSeparator(), "\n");
                getOutput();
                expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
                actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
                assertEquals(expectedOutput, actualOutput);
        }

        @Test
        public void testMain_07() throws Exception {
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                setOutput(new ByteArrayInputStream("1\nAlice\nPassword123\n1\n1\n31-11-2021\n0\n0\n".getBytes()),
                                outContent);
                Main.main(new String[] {}); // Run the main method which should now use the simulated input

                String expectedOutput = "Shahbagh Sports Complex\r\n"
                                + "---------------------------------------------------------\r\n"
                                + "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Set a username: "
                                + "Set a password: "
                                + dateNtime + "\r\n"
                                + "Press 1 to make a booking.\r\n"
                                + "Press 2 to view bookings.\r\n"
                                + "Press 3 to cancel bookings.\r\n"
                                + "Press 4 to check for any cancelled bookings.\r\n"
                                + "Press 0 to log out.\r\n"
                                + "Input: "
                                + "Choose a facility (Enter 0 to go to the main menu).\r\n"
                                + "1. Swimming\r\n"
                                + "2. Badminton\r\n"
                                + "3. Basketball\r\n"
                                + "4. Tennis\r\n"
                                + "Input: "
                                + "Enter date of booking (DD-MM-YYYY): \r\n"
                                + "Please Input Correct Date!\r\n"
                                + "Press 1 to make a booking.\r\n"
                                + "Press 2 to view bookings.\r\n"
                                + "Press 3 to cancel bookings.\r\n"
                                + "Press 4 to check for any cancelled bookings.\r\n"
                                + "Press 0 to log out.\r\n"
                                + "Input: "
                                + "Shahbagh Sports Complex\r\n"
                                + "---------------------------------------------------------\r\n"
                                + "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n"
                                + "Input: "
                                + "Thank you for using our system.";

                // Trim the captured output to avoid issues with trailing newlines
                String actualOutput = outContent.toString(); // .trim();

                // Replace all system-dependent newlines with \n for consistent comparison
                // actualOutput = actualOutput.replace(System.lineSeparator(), "\n");
                getOutput();
                expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
                actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
                assertEquals(expectedOutput, actualOutput);
        }

        @Test
        public void testMain_08() throws Exception {
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                setOutput(
                                new ByteArrayInputStream(
                                                "1\nAlice\nPassword123\n1\n1\n30-11-2023\n20\nPL\n1\n30-11-2023\n19\nPL\n0\n0\n"
                                                                .getBytes()),
                                outContent);
                Main.main(new String[] {}); // Run the main method which should now use the simulated input

                String expectedOutput = "Shahbagh Sports Complex\r\n" + //
                                "---------------------------------------------------------\r\n" + //
                                "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n" + //
                                "Input: 1\r\n" + //
                                "Set a username: \r\n" + //
                                "Set a password: \r\n" + dateNtime +
                                "\r\n" + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: \r\n" + //
                                "Choose a facility (Enter 0 to go to the main menu).\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "Input: \r\n" + //
                                "Enter date of booking (DD-MM-YYYY): \r\n" + //
                                "Available time slots for 30-11-2023:\r\n" + //
                                "Time slot 9:00 is available.\r\n" + //
                                "Time slot 10:00 is available.\r\n" + //
                                "Time slot 11:00 is available.\r\n" + //
                                "Time slot 12:00 is available.\r\n" + //
                                "Time slot 13:00 is available.\r\n" + //
                                "Time slot 14:00 is available.\r\n" + //
                                "Time slot 15:00 is available.\r\n" + //
                                "Time slot 16:00 is available.\r\n" + //
                                "Time slot 17:00 is available.\r\n" + //
                                "Time slot 18:00 is available.\r\n" + //
                                "Time slot 19:00 is available.\r\n" + //
                                "Enter preferred time slot (e.g. if you want to book at 20:00, type 20): \r\n" + //
                                "Select a payment method:\r\n" + //
                                "1. Credit Card (Enter CC)\r\n" + //
                                "2. PayPal (Enter PL)\r\n" + //
                                "Input: \r\n" + //
                                "Sorry, the facility is closed during this time\r\n" + //
                                "Choose a facility (Enter 0 to go to the main menu).\r\n" + //
                                "1. Swimming\r\n" + //
                                "2. Badminton\r\n" + //
                                "3. Basketball\r\n" + //
                                "4. Tennis\r\n" + //
                                "Input: \r\n" + //
                                "Enter date of booking (DD-MM-YYYY): \r\n" + //
                                "Available time slots for 30-11-2023:\r\n" + //
                                "Time slot 9:00 is available.\r\n" + //
                                "Time slot 10:00 is available.\r\n" + //
                                "Time slot 11:00 is available.\r\n" + //
                                "Time slot 12:00 is available.\r\n" + //
                                "Time slot 13:00 is available.\r\n" + //
                                "Time slot 14:00 is available.\r\n" + //
                                "Time slot 15:00 is available.\r\n" + //
                                "Time slot 16:00 is available.\r\n" + //
                                "Time slot 17:00 is available.\r\n" + //
                                "Time slot 18:00 is available.\r\n" + //
                                "Time slot 19:00 is available.\r\n" + //
                                "Enter preferred time slot (e.g. if you want to book at 20:00, type 20): \r\n" + //
                                "Select a payment method:\r\n" + //
                                "1. Credit Card (Enter CC)\r\n" + //
                                "2. PayPal (Enter PL)\r\n" + //
                                "Input: \r\n" + //
                                "Redirecting you to transaction...\r\n" + //
                                "Your total is: 10.0\r\n" + //
                                "Processing transaction...\r\n" + //
                                "PayPal processed the payment with amount of 10.00.\r\n" + //
                                "Booking Successful for facility 30-11-2023 19\r\n" + //
                                "Booking successfully created for 30-11-2023 from 19:00 to 20:00. Go to main menu to manage your bookings.\r\n"
                                + //
                                "------------------------------------------------------------------------------------------------------------------------------------------\r\n"
                                + //
                                "Press 1 to make a booking.\r\n" + //
                                "Press 2 to view bookings.\r\n" + //
                                "Press 3 to cancel bookings.\r\n" + //
                                "Press 4 to check for any cancelled bookings.\r\n" + //
                                "Press 0 to log out.\r\n" + //
                                "Input: \r\n" + //
                                "Shahbagh Sports Complex\r\n" + //
                                "---------------------------------------------------------\r\n" + //
                                "Press 1 to Sign-Up | Press 2 to Sign-In | Press 0 to exit\r\n" + //
                                "Input: \r\n" + //
                                "Thank you for using our system.";

                // Trim the captured output to avoid issues with trailing newlines
                String actualOutput = outContent.toString(); // .trim();

                // Replace all system-dependent newlines with \n for consistent comparison
                // actualOutput = actualOutput.replace(System.lineSeparator(), "\n");
                getOutput();
                expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
                actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
                assertEquals(expectedOutput, actualOutput);
        }

}
