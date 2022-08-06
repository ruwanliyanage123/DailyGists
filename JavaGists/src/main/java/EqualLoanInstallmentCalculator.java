public class EqualLoanInstallmentCalculator {
    private static final int LOAN_AMOUNT = 500000;
    private static final int PERIOD_IN_MONTHS = 60;
    private static final double LOAN_RATE = 10;

    public static void main(String[] args) {
        double installment_1 = installmentCalculator(LOAN_AMOUNT, PERIOD_IN_MONTHS, LOAN_RATE, 1);
        double installment_2 = installmentCalculator(LOAN_AMOUNT, PERIOD_IN_MONTHS, LOAN_RATE, 2);
        double installment_60 = installmentCalculator(LOAN_AMOUNT, PERIOD_IN_MONTHS, LOAN_RATE, 60);
        System.out.println(installment_1);
        System.out.println(installment_2);
        System.out.println(installment_60);
    }

    /**
     * @param loanAmount        amount of the requested loan
     * @param periodInMonths    repayment period in months
     * @param loanRate          annual loan interest
     * @param installmentNumber number of the installment
     * @return installment value or the given installment number
     */
    public static double installmentCalculator(int loanAmount, int periodInMonths, double loanRate, int installmentNumber) {
        int monthlyFixedInstallment = loanAmount / periodInMonths;
        double remainedLoanAmount = loanAmount - (monthlyFixedInstallment * (installmentNumber - 1));
        double interestForYear = remainedLoanAmount * (loanRate / 100);
        double monthly = 30.0 / 365.0;
        double interestForMonth = interestForYear * monthly;
        return monthlyFixedInstallment + interestForMonth;
    }
}