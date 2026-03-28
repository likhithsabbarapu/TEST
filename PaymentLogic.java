import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaymentLogic {

    public static void main(String[] args) {
        // 1. Setup our test data
        BigDecimal amount = new BigDecimal("100.00");
        String method = "CREDIT_CARD";

        // 2. Run the logic
        BigDecimal finalPrice = calculateTotal(amount, method);

        // 3. Print the result
        System.out.println("Original: " + amount);
        System.out.println("With Fees (" + method + "): " + finalPrice);
    }

    // THIS IS THE LOGIC PART TO PRACTICE
    public static BigDecimal calculateTotal(BigDecimal base, String type) {
        if ("CREDIT_CARD".equals(type)) {
            BigDecimal fee = base.multiply(new BigDecimal("0.025")); // 2.5% fee
            return base.add(fee).setScale(2, RoundingMode.HALF_UP);
        }
        return base;
    }
}