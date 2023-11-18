public interface PaymentStrategy {

	/**
	 * 
	 * @param amount
	 */
	void processPayment(double amount);

}