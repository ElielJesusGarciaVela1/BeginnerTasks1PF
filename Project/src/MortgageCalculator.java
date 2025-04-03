import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        Scanner scanner = new Scanner (System.in);
        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = scanner.nextDouble();
        double monthlyInterestRate= annualInterestRate / MONTHS_IN_YEAR / PERCENTAGE;

        System.out.print("Period (Years): ");
        int period = scanner.nextInt();
        period *= MONTHS_IN_YEAR;

        double mortgage = principal * (monthlyInterestRate*(Math.pow((1 + monthlyInterestRate),period))/(Math.pow((1 + monthlyInterestRate),period)-1));

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(mortgage);
        System.out.print("Mortgage: " + result);
    }
}