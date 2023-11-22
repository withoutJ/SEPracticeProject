package user;
public class GoldMember implements Member {

	public double calculate(int loyaltyPoints, int bookingCount) {
		return (loyaltyPoints*0.5) + bookingCount;
	}

}