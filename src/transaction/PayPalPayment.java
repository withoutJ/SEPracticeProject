package transaction;

import java.util.Random;

public class PayPalPayment implements PaymentStrategy {
    public boolean sendToPayPal() {
		Random rand = new Random();
		return rand.nextInt() % 2 == 0;
	}

    public boolean processPayment(double amount){
        boolean processed = sendToPayPal();
        if(processed) {
            System.out.printf("PayPal processed the payment with amount of %.2f.\n", amount);
        } else {
            System.out.println("Payment failed.");
        }
        return processed;
    }
}