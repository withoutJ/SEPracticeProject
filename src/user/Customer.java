import java.text.SimpleDateFormat;
import java.util.*;
import sportfacility.*;
import transaction.PaymentStrategy;
public class Customer extends User {

	private List<Bookings> bookingsList = new ArrayList<>();
	private Member memberType;
	private int loyaltyPoints;

	public Customer(String username, String password) {
		super(username, password);
		this.loyaltyPoints = 0;
		this.memberType = new StandardMember();

	}

	//convert date and time to string
	public static String concatenateStringAndInt(String str, int number) {
        return str + number;
    }

	public boolean createBooking(SportFacility facility, String bookingDate, int startTime, PaymentStrategy paymentStrategy) {
		
		if(facility.isBooked(concatenateStringAndInt(bookingDate, startTime))){
			facility.book(concatenateStringAndInt(bookingDate, startTime));
			return false;
		}
		else{
			//Booking is added, even though transaction might fail later on
			facility.book(concatenateStringAndInt(bookingDate, startTime));
			Bookings NewBooking = new Bookings(facility, bookingDate, startTime);
			bookingsList.add(NewBooking);
			setMemberType();
			loyaltyPoints += 10;
			System.out.println("Your booking has been made. Redirecting you to transaction...");
			NewBooking.calculatePrice(this, paymentStrategy);
			
			return true;

		}
		

		/*
		 * call the approve booking request static method over here. If it is approved,
		 * we add the new booking to the bookingsList.
		 */

		
		// check and change state of customer
		
	}

	public void viewBookings() {

		// Show Customer's Name(membershipttpe)
		System.out.println("Membership Type: " + memberType.toString());
		for (Bookings booking : bookingsList) {

			System.out.println("Booking ID: " + booking.getBookingId());
			System.out.println("Booking Date: " + booking.getBookingDate());
			System.out.println("Booking Start Time: " + booking.getStartTime());
			System.out.println();
		}
	}

	public void cancelBooking(String bookingId) {
		// Remove from the ArrayList of AllBookings stored in main
		for (Bookings booking : bookingsList) {
			if ((booking.getBookingId()).equals(bookingId)) {
				bookingsList.remove(booking);
				//remove the booking from the facility hashmap as well AND fetch the transaction object from inside the booking to call processRefund
				break;
			}

		}
		// throw exception if bookingid invalid inside else block
	}

	public double getMemberOffer() {
		// return a number from 0-1 depending on the state. Multiply this number with
		// price to get appropriate cost of customer.
		return (100 - memberType.calculate(loyaltyPoints, bookingsList.size())) / 100;
	}

	public String getMemberType() {
		// override the tostring method for member states
		return memberType.toString();
	}

	public void setMemberType() {
		if (loyaltyPoints > 10) {
			memberType = new GoldMember();
		}
	}

	public void giveRating(String comment, int rate) {
		Review review = new Review(comment, rate);
		SportFacility.writeReview(review);

	}

}