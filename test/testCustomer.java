package test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import sportfacility.*;
import user.*

public class testCustomer {

    @Test
    public void testReview_01() { //take test case from Afzal for createBooking valid
        User customer = new Customer("username", "password");
        SportFacility facility = new TennisCourt();
        PaymentStrategy payStrat = new PaymentStrategy();


        assertEquals( "Great facility!",review.getComment());
    }


@Test
public void testReview_02() { //same test case but createBooking invalid
    String expectedComment = "Great facility!";
    int expectedRate = 4;

    Review review = new Review(expectedComment, expectedRate);

    assertEquals( 4,review.getRate());
	}

@Test
public void testReview_03() { //how to test the view booking in junit?
    Review review = new Review("Test comment", 3); // Initialize with a valid rate

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    review.setRate(6); // Set an invalid rate

    String consoleOutput = outputStream.toString().replaceAll("\\s+", "");
    System.setOut(System.out); // Reset the System.out to its original stream

    String expectedOutput = "Rating must be between 1 and 5.\n".replaceAll("\\s+", "");

    assertEquals(expectedOutput, consoleOutput);
}
//cancelBooking() working?
//getMemberOffer() working? 
//setMemberType() check


}

