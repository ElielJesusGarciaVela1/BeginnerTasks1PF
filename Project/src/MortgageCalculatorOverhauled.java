import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculatorOverhauled {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        int principal = 0;
        float annualInterestRate = 0;
        float monthlyInterestRate = 0;
        int numberOfPayments = 0;
        byte period = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 0.01 && annualInterestRate <= 30) {
                monthlyInterestRate= annualInterestRate / MONTHS_IN_YEAR / PERCENTAGE;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }
        while (true) {
            System.out.print("Period: ");
            period = scanner.nextByte();
            if (period >=1 && period <= 30) {
                numberOfPayments = period * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        double mortgage = principal * (monthlyInterestRate*(Math.pow((1 + monthlyInterestRate),period))/(Math.pow((1 + monthlyInterestRate),period)-1));

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(mortgage);
        System.out.print("Mortgage: " + result);
    }
}