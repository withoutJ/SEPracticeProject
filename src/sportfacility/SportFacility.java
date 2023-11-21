package sportfacility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SportFacility {
	

	private Map<String, Boolean> timeTable;
	private int closingHours;
	private int openingHours;
	// private DatabaseController DBController;
	private List<Review> allReviews;

	public SportFacility(int openingHours, int closingHours){
		this.openingHours = openingHours;
		this.closingHours = closingHours;
		this.timeTable = new HashMap<>();
		this.allReviews = new ArrayList<>();
	}

	public void book(String dateHour) {
		//13-02-2000 13
		String[] parts = dateHour.split(" ");
		int hour = Integer.parseInt(parts[1]);


		if (hour >= openingHours) {
			if (hour < closingHours) {
				if (timeTable.containsKey(dateHour) && timeTable.get(dateHour)) {
					System.out.println("Sorry, this time slot is already booked.");
					return;
				}
				timeTable.put(dateHour, true);
				System.out.println("Booking Successful for facility " + dateHour);
			} else {
				System.out.println("Sorry, the facility is closed during this time");
			}
		} else {
			System.out.println("Sorry, the facility is not open at this time");
		}
		
	}


	public void cancelBooking(String dateHour) {
		if (!timeTable.containsKey(dateHour)) {
			System.out.println("No booking found for " + dateHour + ". Unable to cancel.");
			return;
		}
	
		if (!timeTable.get(dateHour)) {
			System.out.println("The time slot for " + dateHour + " is already free.");
			return;
		}
	
		timeTable.put(dateHour, false);
		System.out.println("Booking cancelled for " + dateHour);
	}

	public void addReview(Review review) {
        allReviews.add(review);
    }

	public List<Review> getAllReviews() {
        return new ArrayList<>(allReviews); // Return a copy to prevent external modification
    }

}