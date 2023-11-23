package transaction;

import java.util.Random;

public class CreditCardPayment implements PaymentStrategy {
    public boolean sendToVisa() {
		Random rand = new Random();
		return rand.nextInt() % 2 == 0;
	}

    public boolean processPayment(double amount){
        boolean processed = sendToVisa();
        if(processed) {
            System.out.printf("Visa processed the payment with amount of %.2f.\n", amount);
        } else {
            System.out.println("Payment failed.");
        }
        return processed;
    }
}