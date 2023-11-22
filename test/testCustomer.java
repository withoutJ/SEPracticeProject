package test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import sportfacility.*;
import user.*;
import org.junit.After;
import org.junit.Before;

public class testCustomer {

    @Test
    public void testReview_01() { //take test case from Afzal for createBooking valid
        setOutput();
        User customer = new Customer("username", "password");
        SportFacility facility = new TennisCourt(9,23,40);
        PaymentStrategy payStrat = new CreditCardPayment();
        customer.createBooking(facility,"13-02-2000", 10, payStrat);

        assertEquals("Booking Successful for facility 13-02-2000 10'\n'Redirecting you to transaction...",getOutput()); //consult labiba, too many print statements here
    }


@Test
public void testReview_02() { //same test case but createBooking invalid
    setOutput();
    User customer = new Customer("username", "password");
    SportFacility facility = new TennisCourt(9,23,40);
    PaymentStrategy payStrat = new CreditCardPayment();
    customer.createBooking(facility,"22-11-2023", 10, payStrat);
    getOutput();
    setOutput();
    customer.createBooking(facility,"22-11-2023", 10, payStrat);
    assertEquals( "Sorry, this time slot is already booked.",getOutput());
	}

@Test
public void testReview_03() { //how to test the view booking in junit?
    setOutput();
    User customer = new Customer("username", "password");
    SportFacility facility = new TennisCourt(9,23,40);
    PaymentStrategy payStrat = new CreditCardPayment();
    customer.createBooking(facility,"22-11-2023", 10, payStrat);
    customer.viewBookings();
    assertEquals( ".",getOutput()); //we can test if the booking prints but bookingID is random, consult labiba
	
}
@Test
public void testReview_04() { //Cancel booking successful
    //check for cancel successful message
    setOutput();
    User customer = new Customer("username", "password");
    User admin= new Admin("labiba","labiba");
    SportFacility facility = new TennisCourt(9,23,40);
    PaymentStrategy payStrat = new CreditCardPayment();
    customer.createBooking(facility,"22-11-2023", 10, payStrat);
    admin.receiveCancelRequest(customer, ); //how pass random bookingID

}
@Test
public void testReview_05() { //standard
    //for setMemberType can directly check the getMemberOffer amount
    User customer = new Customer("username", "password");
    SportFacility facility = new TennisCourt(9,23,40);
    PaymentStrategy payStrat = new CreditCardPayment();
    customer.createBooking(facility,"22-11-2023", 10, payStrat);
    double offer= customer.getMemberOffer();
    assertEquals(0.99,offer);
}
@Test
public void testReview_05() { //gold
    //for setMemberType can directly check the getMemberOffer amount
    User customer = new Customer("username", "password");
    SportFacility facility = new TennisCourt(9,23,40);
    PaymentStrategy payStrat = new CreditCardPayment();
    customer.createBooking(facility,"22-11-2023", 10, payStrat);
    customer.createBooking(facility,"22-11-2023", 15, payStrat);
    double offer= customer.getMemberOffer();
    assertEquals(0.88,offer);
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

