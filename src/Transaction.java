public class Transaction {

	private PaymentStragey paymentStrategy;
	private RefundStrategy refundStrategy;
	private double amount;

	/**
	 * 
	 * @param PaymentStrategy
	 * @param RefundStrategy
	 * @param amount
	 */
	public Transaction(int PaymentStrategy, int RefundStrategy, int amount) {
		// TODO - implement Transaction.Transaction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param amount
	 */
	public void processPayment(double amount) {
		// TODO - implement Transaction.processPayment
		throw new UnsupportedOperationException();
	}

	public void processRefund() {
		// TODO - implement Transaction.processRefund
		throw new UnsupportedOperationException();
	}

}