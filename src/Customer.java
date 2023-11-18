public class Customer extends User {

	private List bookingList;
	private date joinDate;
	private Member memberType;
	private int loyaltyPoints;
	private Account account;

	/**
	 * 
	 * @param facility
	 * @param bookingID
	 * @param bookingDate
	 */
	public void createBooking(Facility facility, long bookingID, date bookingDate) {
		// TODO - implement Customer.createBooking
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param booking
	 */
	public void editBooking(Bookings booking) {
		// TODO - implement Customer.editBooking
		throw new UnsupportedOperationException();
	}

	public void viewBookings() {
		// TODO - implement Customer.viewBookings
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param booking
	 */
	public void cancelBooking(Bookings booking) {
		// TODO - implement Customer.cancelBooking
		throw new UnsupportedOperationException();
	}

	public Customer() {
		// TODO - implement Customer.Customer
		throw new UnsupportedOperationException();
	}

	public double getMemberOffer() {
		// TODO - implement Customer.getMemberOffer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param account
	 * @param joinDate
	 */
	public void Member(Account account, date joinDate) {
		// TODO - implement Customer.Member
		throw new UnsupportedOperationException();
	}

	public void getMemberType() {
		// TODO - implement Customer.getMemberType
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param memberType
	 */
	public void setMemberType(Member memberType) {
		this.memberType = memberType;
	}

	/**
	 * 
	 * @param comment
	 * @param rate
	 */
	public void giveRating(String comment, int rate) {
		// TODO - implement Customer.giveRating
		throw new UnsupportedOperationException();
	}

}