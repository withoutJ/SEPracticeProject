package user;

import java.util.ArrayList;
import java.util.List;
import sportfacility.*;
public class Admin extends User {

	private Account Account;
	private List<Bookings> cancelRequests = new ArrayList<>();

	public Admin(String username, String password) {
		super(username, password);
	}

	// where do i add facility )):
	public void addFacility(SportFacility facility) {
		
	}

	public void removeFacility(SportFacility facility) {

	}

	public static boolean confirmBooking(Bookings booking) {
		// check for conflicting schedules
		Main.addBooking(booking);

	}

	public void receiveCancelRequest(Customer customer, String bookingId) {
		//Main will feed the booking object the customer wants to cancel here.
		//check if booking is cancellable based on the start time against system time.

		//if booking is cancellable, delete the booking from user list (the user is inside booking object)
		//else print Booking is not refundable as startime too soon with system time.
	}

	public void showCancelRequests() {

	}

	public void approveRequest(int requestID) {

	}

}