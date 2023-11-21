public class Transaction {

	private PaymentStrategy paymentStrategy;
	private RefundStrategy refundStrategy;
	private double amount;

	/**
	 * 
	 * @param PaymentStrategy
	 * @param RefundStrategy
	 * @param amount
	 */
	public Transaction(PaymentStrategy paymentStrategy, RefundStrategy refundStrategy, int amount) {
		this.amount = amount;
		this.paymentStrategy = paymentStrategy;
		this.refundStrategy = refundStrategy;
	}

	/**
	 * 
	 * @param amount
	 */
	public void processPayment(double amount) {
		paymentStrategy.processPayment(amount);
	}

	public void processRefund() {
		refundStrategy.processRefund(amount);
	}

}