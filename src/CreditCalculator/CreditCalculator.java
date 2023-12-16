package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    static double loan,loanPrincipal,monthNumber,paymentMonth,i;
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                What do you want to calculate?
                    type "n" - for number of monthly payments,
                    type "a" - for annuity monthly payment amount,
                    type "p" - for the loan principal:""");
        String user = in.next();
        if (user.equals("n")) {
            System.out.println("Enter a loan principal:");
            loanPrincipal = in.nextInt();
            System.out.println("Enter the monthly payment:");
            paymentMonth = in.nextInt();
            loanInterest();
            monthNumber = Math.log(paymentMonth/(paymentMonth-(i*loanPrincipal)))/Math.log(1+i);
            period();
        }
        if (user.equals("a")) {
            System.out.println("Enter a loan principal:");
            loanPrincipal = in.nextDouble();
            System.out.println("Enter the number of periods:");
            monthNumber= in.nextInt();
            loanInterest();
            paymentMonth = loanPrincipal*((i*Math.pow((1+i),monthNumber))/(Math.pow((1+i),monthNumber)-1));
            System.out.printf("Your monthly payment = %.0f", paymentMonth);
        }
        if (user.equals("p")) {
            System.out.println("Enter the annuity payment:");
            paymentMonth = in.nextDouble();
            System.out.println("Enter the number of periods:");
            monthNumber= in.nextInt();
            loanInterest();
            loanPrincipal=paymentMonth/((i*Math.pow((1+i),monthNumber))/(Math.pow((1+i),monthNumber)-1));
            System.out.printf("Your loan principal = %.0f", loanPrincipal);
        }
    }
    public static void loanInterest(){
        System.out.println("Enter a loan interest:");
        loan = in.nextDouble();
        i =  (loan/(12*100));
    }
    public static void period(){
        int period = (int) Math.round(monthNumber);
        int year = (period / 12);
        int month = (period % 12);

        if (year>0 & month >0){
            System.out.println("It will take " + year + " years and " + month + " month to repay this loan");
        } else if(year == 0){
            System.out.println("It will take " + month + " month to repay this loan");
        } else {
            System.out.println("It will take " + year + " years to repay this loan");
        }
    }
}