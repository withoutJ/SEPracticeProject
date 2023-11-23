package transaction;

import java.util.Random;

public class PayPalRefund implements RefundStrategy {
    public boolean sendToPayPal() {
		Random rand = new Random();
		return rand.nextInt() % 2 == 0;
	}

    public boolean processRefund(double amount){
        boolean processed = sendToPayPal();
        if(processed) {
            System.out.printf("PayPal processed the refund with amount of %.2f.\n", amount);
        } else {
            System.out.println("Refund failed.");
        }
        return processed;
    }
}