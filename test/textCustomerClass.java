package test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import sportfacility.*;
import user.*;
import org.junit.After;
import org.junit.Before;
import transaction.*;

public class textCustomerClass {
	    @Test
	    public void testReview_01() {
	        Customer customer = new Customer("username", "password");
	        SportFacility facility = new TennisCourt(9,23,40);
	        PaymentStrategy payStrat = new CreditCardPayment();
	        customer.createBooking(facility,"13-02-2000", 10, "CC");
	        
	        assertEquals(false,customer.createBooking(facility,"13-02-2000", 10, "CC")); //consult labiba, too many print statements here
	    }
		
//		@Test
//		public void testReview_03() { //how to test the view booking in junit?
//		    setOutput();
//		    User customer = new Customer("username", "password");
//		    SportFacility facility = new TennisCourt(9,23,40);
//		    PaymentStrategy payStrat = new CreditCardPayment();
//		    customer.createBooking(facility,"22-11-2023", 10, "CC");
//		    customer.viewBookings();
//		    assertEquals( ".",getOutput()); //we can test if the booking prints but bookingID is random, consult labiba
//			
//		}
		@Test
		public void testReview_04() throws Exception { //Cancel booking successful
		    //check for cancel successful message
		    
		    Customer customer = new Customer("username", "password");
		    Admin admin= new Admin("labiba","labiba");
		    SportFacility facility = new TennisCourt(9,23,40);
		    PaymentStrategy payStrat = new CreditCardPayment();
		    customer.createBooking(facility,"22-11-2023", 10, "CC");
		    String bookingID = customer.getList().get(0).getBookingId();
		    setOutput();
		    admin.receiveCancelRequest(customer,bookingID) ; //how pass random bookingID
		    assertEquals("Booking cancelled for \n 22-11-2023 10", getOutput());
		}
		
		@Test
		public void testReview_05() throws Exception { //standard
		    //for setMemberType can directly check the getMemberOffer amount
		    Customer customer = new Customer("username", "password");
		    SportFacility facility = new TennisCourt(9,23,40);
		    PaymentStrategy payStrat = new CreditCardPayment();
		    customer.createBooking(facility,"22-11-2023", 10, "CC");
		    double offer= customer.getMemberOffer();
		    assertEquals(0.99,offer,0);
		}
		@Test
		public void testReview_06() { //gold
		    //for setMemberType can directly check the getMemberOffer amount
		    Customer customer = new Customer("username", "password");
		    SportFacility facility = new TennisCourt(9,23,40);
		    PaymentStrategy payStrat = new CreditCardPayment();
		    customer.createBooking(facility,"22-11-2023", 10, "CC");
		    customer.createBooking(facility,"22-11-2023", 15, "CC");
		    double offer= customer.getMemberOffer();
		    assertEquals(0.88,offer,0);
	}

	//cancelBooking() working?
	//getMemberOffer() working? 
	//setMemberType() check


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