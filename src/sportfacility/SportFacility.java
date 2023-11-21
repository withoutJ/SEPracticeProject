package sportfacility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SportFacility {
	private int bookingFee;
	private Map<String, Boolean> timeTable;
	private int closingHours;
	private int openingHours;
	// private DatabaseController DBController;
	private List<Review> allReviews;

	public SportFacility(int openingHours, int closingHours, int bookingFee){
		this.openingHours = openingHours;
		this.closingHours = closingHours;
		this.timeTable = new HashMap<>();
		this.allReviews = new ArrayList<>();
		this.bookingFee = bookingFee;
	}

	public void book(String dateHour) {
		//13-02-2000 13
		String[] parts = dateHour.split(" ");
		int hour = Integer.parseInt(parts[1]);


		if (hour >= openingHours) {
			if (hour < closingHours) {
				if (timeTable.containsKey(dateHour) && timeTable.get(dateHour)) {
					System.out.print("Sorry, this time slot is already booked.\n");
					return;
				}
				timeTable.put(dateHour, true);
				System.out.print("Booking Successful for facility " + dateHour +"\n");
			} else {
				System.out.print("Sorry, the facility is closed during this time\n");
			}
		} else {
			System.out.print("Sorry, the facility is not open at this time\n");
		}
		
	}


	public void cancelBooking(String dateHour) {
		if (!timeTable.containsKey(dateHour)) {
			System.out.print("No booking found for " + dateHour + ". Unable to cancel.\n");
			return;
		}
	
		if (!timeTable.get(dateHour)) {
			System.out.print("The time slot for " + dateHour + " is already free.\n");
			return;
		}
	
		timeTable.put(dateHour, false);
		System.out.print("Booking cancelled for \n" + dateHour);
	}

	public void addReview(Review review) {
        allReviews.add(review);
    }

	public List<Review> getAllReviews() {
        return new ArrayList<>(allReviews); // Return a copy to prevent external modification
    }

	public int getBookingFee(){
		return this.bookingFee;
	}
}