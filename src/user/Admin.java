package user;

import java.util.ArrayList;
import java.util.List;
import sportfacility.*;
public class Admin extends User {

	private Account Account;
	private List<Bookings> cancelRequests = new ArrayList<>();

	public Admin(String username, String password, Account account) {
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

	public void receiveCancelRequest(Bookings booking) {

	}

	public void showCancelRequests() {

	}

	public void approveRequest(int requestID) {

	}

}