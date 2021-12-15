import java.util.Scanner;

public class CreditCalculator {

    public static final int PERCENT_PER_YEAR = 15;
    public static final int PERCENT = 100;
    public static final int MONTHS_OF_THE_YEAR = 12;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите желаемую сумму кредита:");
        int sum = scanner.nextInt();
        System.out.println("Введите количество лет: ");
        int year = scanner.nextInt();
        int overpaymentPerYear = overpaymentPerY(sum);

        System.out.println("Ежемесячный платеж составит: " + monthlyPayment(sum, year, overpaymentPerYear));
        System.out.println("Общая сумма возврата в банк за " + year + " лет: " + refundableAmount(sum, year, overpaymentPerYear));
        System.out.println("Сумма переплаты банку за "  + year + " лет: " + totalOverpayment( year, overpaymentPerYear));

    }

    public static int overpaymentPerY(int sum) {
        return sum/PERCENT * PERCENT_PER_YEAR;
    }

    public static int monthlyPayment(int sum, int year, int overpaymentPerYear) {
        return (sum + overpaymentPerYear * year) / (year * MONTHS_OF_THE_YEAR);
    }

    public static int refundableAmount(int sum, int year, int overpaymentPerYear) {
        return sum + (overpaymentPerYear * year);
    }

    public static int totalOverpayment( int year, int overpaymentPerYear) {
        return overpaymentPerYear * year;
    }
}
