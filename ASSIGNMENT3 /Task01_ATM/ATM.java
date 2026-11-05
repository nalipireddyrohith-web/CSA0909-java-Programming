import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) { super(message); }
}

public class ATM {
    static double balance = 1000.0;

    static void withdraw(String account, double amount) throws InsufficientBalanceException {
        if (amount < 0) throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        if (amount > balance) throw new InsufficientBalanceException("Insufficient balance");
        balance -= amount;
        System.out.println("Withdrawal successful for account: " + account);
        System.out.printf("Amount: %.2f%nBalance: %.2f%n", amount, balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter account number: ");
            String account = sc.nextLine();
            System.out.print("Enter withdrawal amount: ");
            double amount = Double.parseDouble(sc.nextLine());
            withdraw(account, amount);
        } catch (NumberFormatException e) {
            System.out.println("Input error: Please enter a valid numeric amount.");
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println("Transaction error: " + e.getMessage());
        } finally {
            System.out.println("ATM session closed.");
            sc.close();
        }
    }
}
