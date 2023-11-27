package test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import sportfacility.*;
import user.*;
import transaction.*;

public class testCustomerClass {



	/*public double calculate(int loyaltyPoints, int bookingCount) {
		return (loyaltyPoints*0.5) + bookingCount;
	}*/
	

	@Test
	public void testCustomer_01() { //check for gold customer
		Member gold = new GoldMember();
		int loyaltyPoints = 10;
		int bookingCount = 2;
		assertEquals(7, gold.calculate(loyaltyPoints, bookingCount),0); 
	}
		@Test
	public void testCustomer_08() { //check for gold customer
		Member standard = new StandardMember();
		int loyaltyPoints = 10;
		int bookingCount = 1;
		assertEquals(1, standard.calculate(loyaltyPoints, bookingCount),0); 
	}

	@Test
	public void testCustomer_02() {
		Bookings.resetBookingID();
		Customer customer = new Customer("username", "password");
		SportFacility facility = new TennisCourt(9, 23, 40);
		PaymentStrategy payStrat = new CreditCardPayment();
		customer.createBooking(facility, "13-02-2000", 10, "CC");

		assertEquals(false, customer.createBooking(facility, "13-02-2000", 10, "CC")); 
	}

	// @Test
	// public void testCustomer_03() throws Exception { //Cancel booking successful
	// 	Bookings.resetBookingID();
	// 	// Get current date and time
	// 	LocalDateTime now = LocalDateTime.now();
	// 	// Subtract one hour from the current time
	// 	LocalDateTime oneHourBefore = now.minusHours(1);
	
	// 	// Format date and time
	// 	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	// 	String bookingDate = oneHourBefore.format(dateFormatter);
	// 	int bookingTime = oneHourBefore.getHour();
	
	// 	// Your test code
	// 	Customer customer = new Customer("username", "password");
	// 	Admin admin = new Admin("labiba","labiba");
	// 	SportFacility facility = new TennisCourt(9, 23, 40);
	// 	PaymentStrategy payStrat = new CreditCardPayment();
	
	// 	// Use dynamic values for the booking date and time
	// 	customer.createBooking(facility, bookingDate, bookingTime, "CC");

	// 	setOutput();
	// 	admin.receiveCancelRequest(customer,1); // Pass the booking ID
	// 	assertEquals("Sorry, this booking cannot be cancelled and is therefore non-refundable.\n" +
	// 		"A booking can only be cancelled 6 hours or more in advance.\n",
	// 		getOutput());
	// }
	@Test
	public void testCustomer_03() throws Exception { // Cancel booking failed
    Bookings.resetBookingID();
    // Get current date and time
    LocalDateTime now = LocalDateTime.now();
    // Subtract two hours from the current time
    LocalDateTime twoHoursBefore = now.minusHours(2);

    // Format date and time
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String bookingDate = twoHoursBefore.format(dateFormatter);
    int bookingTime = twoHoursBefore.getHour();

    // Your test code
    Customer customer = new Customer("username", "password");
    Admin admin = new Admin("labiba", "labiba");
    SportFacility facility = new TennisCourt(9, 23, 40);
    PaymentStrategy payStrat = new CreditCardPayment();
    // Use dynamic values for the booking date and time
    customer.createBooking(facility, bookingDate, bookingTime, "CC");

    setOutput();
    admin.receiveCancelRequest(customer, 1); // Pass the booking ID
    assertEquals(
        "Sorry, this booking cannot be cancelled and is therefore non-refundable.\n"
        + "A booking can only be cancelled 6 hours or more in advance.\n",
        getOutput()
    );
}
	
	@Test
	public void testCustomer_04() throws Exception { // standard   integration: Customer + Stnadard Member
		Bookings.resetBookingID();
		// for setMemberType can directly check the getMemberOffer amount
		Customer customer = new Customer("username", "password");
		SportFacility facility = new TennisCourt(9, 23, 40);
		PaymentStrategy payStrat = new CreditCardPayment();
		customer.createBooking(facility, "22-11-2023", 10, "CC");
		double offer = customer.getMemberOffer();
		assertEquals(0.99, offer, 0);
	}

	@Test
	public void testCustomer_05() { // gold
		Bookings.resetBookingID();
		// for setMemberType can directly check the getMemberOffer amount
		Customer customer = new Customer("username", "password");
		SportFacility facility = new TennisCourt(9, 23, 40);
		PaymentStrategy payStrat = new CreditCardPayment();
		customer.createBooking(facility, "22-11-2023", 10, "CC");
		customer.createBooking(facility, "22-11-2023", 15, "CC");
		double offer = customer.getMemberOffer();
		assertEquals(0.88, offer, 0);
	}

	@Test
	public void testCustomer_06() throws Exception { // Check viewbookings function
		Bookings.resetBookingID();
		setOutput();
		Customer customer = new Customer("username", "password");
		Admin admin = new Admin("labiba", "labiba");
		SportFacility facility = new TennisCourt(9, 23, 40);
		PaymentStrategy payStrat = new CreditCardPayment();

		customer.createBooking(facility, "22-11-2023", 16, "CC");
		getOutput();
		setOutput();
		customer.createBooking(facility, "22-11-2023", 10, "CC");

		// int bookingID = customer.getList().get(0).getBookingId();
		getOutput();
		setOutput();

		// admin.receiveCancelRequest(customer,2); //how pass random bookingID
		customer.viewBookings();
		String expected = "Membership Type: Gold Member\nBooking ID: 1\nBooking Date: 22-11-2023\nBooking Start Time: 16\n\nBooking ID: 2\nBooking Date: 22-11-2023\nBooking Start Time: 10\n\n";

		assertEquals(expected, getOutput());
	}
		@Test
	public void testCustomer_07() throws Exception { // Cancel booking successful
		// check for cancel successful message
		Bookings.resetBookingID();
		setOutput();
		Bookings.resetBookingID();
		Customer customer = new Customer("username", "password");
		Admin admin = new Admin("labiba", "labiba");
		SportFacility facility = new TennisCourt(9, 23, 40);
		PaymentStrategy payStrat = new CreditCardPayment();
		customer.createBooking(facility, "22-11-2023", 16, "CC");
		getOutput();
		setOutput();
		admin.receiveCancelRequest(customer, 1); // how pass random bookingID
		
		assertEquals("Booking cancelled for 22-11-2023 16\nVisa processed the refund with amount of 40.00.\n", getOutput());
	}
	


	// cancelBooking() working?
	// getMemberOffer() working?
	// setMemberType() check

	/**************************************
	 * Helper methods for output capture
	 ***************************************/
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() {
		System.setOut(oldPrintStream);
		return bos.toString();
	}

}
