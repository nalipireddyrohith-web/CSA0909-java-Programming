public class FeeService {
    public static String validateAndPay(String registrationNo, String amountText) {
        if (registrationNo == null || registrationNo.trim().isEmpty()) return "Enter registration number.";
        if (amountText == null || amountText.trim().isEmpty()) return "Enter fee amount.";
        try {
            double amount = Double.parseDouble(amountText);
            if (amount <= 0) return "Amount must be greater than zero.";
            return "Payment successful for " + registrationNo + ". Amount: " + amount;
        } catch (NumberFormatException e) {
            return "Enter a valid numeric amount.";
        }
    }
}
