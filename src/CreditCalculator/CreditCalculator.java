package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static int payment,loan,months;
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the loan principal");
        loan = in.nextInt();
        System.out.println("""
                What do you want to calculate?
                type "m" - for number of monthly payments,
                type "p" - for the monthly payment:""");
        String user = in.next();
        if (user.equals("m")) {
            System.out.println("Enter the monthly payment:");
            int monthPay = in.nextInt();
            if (loan % monthPay ==0){
                months = loan / monthPay;
            } else {
                months = loan / monthPay +1;
            }
            System.out.println("It will take " + months + " month to repay the loan.");
        }
        if (user.equals("p")) {
            System.out.println("Enter number of month:");
            months = in.nextInt();
            if (loan % months ==0){
                payment = loan / months;
                System.out.println("Your monthly payment = " + payment);
            }
            else {
                payment = loan / months + 1;
                int lastPayment = loan-(months-1)*payment;
                System.out.println("Your monthly payment = " + payment + " and the last payment = " + lastPayment);
            }
        }
    }

}
