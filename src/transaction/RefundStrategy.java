package transaction;
public interface RefundStrategy {

	/**
	 * 
	 * @param amount
	 */
	public boolean processRefund(double amount);

}