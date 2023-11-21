package user;
import java.util.*;
import sportfacility.*;
public class Bookings {

	private SportFacility SportFacility;
	private String bookingID;
	private String bookingDate;
	private int startTime;
	private int endTime;
	private User user;
	private Transaction transaction;

	// starttime = 1400 end time 1500 end = start + 100
	public Bookings(SportFacility SportFacility, String bookingDate, int startTime) {
		this.SportFacility = SportFacility;
		this.bookingDate = bookingDate;
		this.startTime = startTime;
		this.endTime = startTime + 100;
		bookingID = generateBookingId(); // check this
	}

	private String generateBookingId() {
		UUID randomUUID = UUID.randomUUID();
		String bookingId = randomUUID.toString().replaceAll("-", "");
		return bookingId;
	}

	public void calculatePrice(Customer customer) {
		// check customer state, assign 0.9 price if gold
		double payWithDiscount = customer.getMemberOffer(); // discount returns a number from 0-1
		double amount = (SportFacility.getBookingFee()) * payWithDiscount;

		// call transaction class instance and call the processPayment method
		// transaction = new Transaction(endTime, startTime, endTime);
	}

	public String getBookingId() {
		return bookingID;
	}

	public String getBookingDate() {
		return bookingDate.toString();
	}

	public int getStartTime() {
		return startTime;
	}

}