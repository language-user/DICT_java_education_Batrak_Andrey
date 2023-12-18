package CreditCalculator;


public class CreditCalculator {
    static double loan, loanPrincipal, monthNumber, paymentMonth, i, paymentDiff;
    static int over = 0;

    public static void main(String[] args) {
        String type = System.getProperty("type");
        String interest = System.getProperty("interest");
        String periods = System.getProperty("periods");
        String principal = System.getProperty("principal");
        String payment = System.getProperty("payment");

        if (type != null) {
            if (type.equals("annuity")) {
                if(principal != null && payment != null && interest != null){
                    paymentMonth =  Double.parseDouble(payment);
                    loanPrincipal = Double.parseDouble(principal);
                    loan = Double.parseDouble(interest);
                    i =  (loan/(12*100));
                    monthNumber = Math.log(paymentMonth/(paymentMonth-(i*loanPrincipal)))/Math.log(1+i);
                    int period = (int) Math.round(monthNumber),year = (period / 12),month = (period % 12);

                    if (year>0 & month >0){
                        System.out.println("It will take " + year + " years and " + month + " month to repay this loan");
                    }
                    else if(year == 0){
                        System.out.println("It will take "+ month + " month to repay this loan");
                    }
                    else {
                        System.out.println("It will take "+ year + " years to repay this loan");
                    }
                }

                else if (periods != null && payment != null && interest != null) {
                    monthNumber = Double.parseDouble(periods);
                    paymentMonth  =  Double.parseDouble(payment);
                    loan  =  Double.parseDouble(interest);
                    i =  (loan/(12*100));

                    loanPrincipal=paymentMonth/((i*Math.pow((1+i),monthNumber))/(Math.pow((1+i),monthNumber)-1));
                    System.out.printf("Your loan principal = %.0f", loanPrincipal);
                }

                else if (principal != null && periods != null && interest != null){
                    loanPrincipal = Double.parseDouble(principal);
                    monthNumber = Double.parseDouble(periods);
                    loan  =  Double.parseDouble(interest);
                    i =  (loan/(12*100));

                    paymentMonth = loanPrincipal*((i*Math.pow((1+i),monthNumber))/(Math.pow((1+i),monthNumber)-1));
                    System.out.printf("Your monthly payment = %.0f", paymentMonth);
                }else {
                    System.out.println("Incorrect parameters.");
                    System.exit(0);
                }
            }else if (type.equals("diff")) {
                if (principal == null || periods == null || interest == null) {
                    System.out.println("Incorrect parameters!!!");
                    System.exit(0);
                }
                monthNumber = Double.parseDouble(periods);
                loanPrincipal = Double.parseDouble(principal);
                loan = Double.parseDouble(interest);
                i = (loan / (12 * 100));
                for (int m = 1; m <= monthNumber; m++) {
                    paymentDiff = loanPrincipal / monthNumber + i * (loanPrincipal - ((loanPrincipal * (m - 1)) / (monthNumber)));
                    paymentDiff = Math.round(paymentDiff);
                    over = (int) (over + (paymentDiff - (loanPrincipal / monthNumber)));
                    System.out.println("Month " + m + ": payment is " + paymentDiff);
                }
                System.out.println("Overpayment = " + over);
            } else {
                System.out.println("Incorrect parameters!!!");
                System.exit(0);
            }
        } else {
            System.out.println("Incorrect parameters!!!");
            System.exit(0);
        }
    }
}