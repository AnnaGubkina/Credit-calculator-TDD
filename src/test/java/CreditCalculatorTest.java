import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class CreditCalculatorTest {

    @Test
    @DisplayName("Месячный платеж")
    void monthlyPayment() {
        CreditCalculator calc = new CreditCalculator();
        int sum = 300000;
        int year = 5;
        int overpaymentPerYear = sum / 100 * 15;
        int subResult = calc.monthlyPayment(sum, year, overpaymentPerYear);
        assertTrue("Месячный платеж  ", (sum + overpaymentPerYear * year) / (year * 12) == subResult);
    }

    @Test
    @DisplayName("Переплата за весь период")
    void refundableAmount() {
        CreditCalculator calc = new CreditCalculator();
        int sum = 500000;
        int year = 7;
        int overpaymentPerYear = sum / 100 * 15;
        int subResult = calc.refundableAmount(sum, year, overpaymentPerYear);
        assertTrue("Общая сумма возврата банку  ", sum + (overpaymentPerYear * year) == subResult);
    }

    @Test
    @DisplayName("Месячный платеж")
    void totalOverpayment() {
        CreditCalculator calc = new CreditCalculator();
        int sum = 1000000;
        int year = 8;
        int overpaymentPerYear = sum / 100 * 15;
        int subResult = calc.totalOverpayment(year, overpaymentPerYear);
        assertTrue("Общая переплата банку  ", overpaymentPerYear * year == subResult);
    }
}