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
		
		LocalTime currentTime = LocalTime.now();
        // Convert the system time to an integer representation
        int systemTimeAsInteger = currentTime.getHour() * 100 + currentTime.getMinute();

		if(((customer.getBookingStartTime())*100)-systemTimeAsInteger)>=600){
			customer.cancelBooking(bookingID);
		}
		//if booking is cancellable, delete the booking from user list (the user is inside booking object)
		//else print Booking is not refundable as startime too soon with system time.
		else{
			System.out.println("Sorry, this booking cannot be cancelled and is therefore is non-refundable. '\n' A booking can only be cancelled 6 hours or more in advanced")
		}
	}

	public void showCancelRequests() {

	}

	public void approveRequest(int requestID) {

	}

}