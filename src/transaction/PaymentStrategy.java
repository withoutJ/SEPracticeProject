package transaction;
public interface PaymentStrategy {

	/**
	 * 
	 * @param amount
	 */
	boolean processPayment(double amount);

}