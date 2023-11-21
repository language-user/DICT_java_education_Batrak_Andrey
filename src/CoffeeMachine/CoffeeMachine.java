package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
//        System.out.println("Starting to make a coffee\n" +
//                "Grinding coffee beans\n" +
//                "Boiling water\n" +
//                "Mixing boiled water with crushed coffee beans\n" +
//                "Pouring coffee into the cup\n" +
//                "Pouring some milk into the cup\n" +
//                "Coffee is ready!\n");
//
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int number_cup = scanner.nextInt();
//        System.out.println( number_cup + " cups of coffee you will need:");
//        System.out.println( number_cup * 200 + " ml of water");
//        System.out.println( number_cup * 50 + " ml of milk");
//        System.out.println( number_cup * 15 + " g of coffee beans");

        int amount_cups = Math.min(Math.min(water / 200, milk / 50), beans / 15);
        int N = amount_cups - number_cup;
        if (amount_cups == number_cup) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (amount_cups > number_cup) {
            System.out.println("Yes, I can make that amount of coffee (and even " + N + " more than that)");
        } else {
            System.out.println("No, I can make only " + amount_cups + " cups of coffee");
        }

    }
}
