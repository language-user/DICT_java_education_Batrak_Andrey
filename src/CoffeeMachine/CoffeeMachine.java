package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!\n");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int number_cup = scanner.nextInt();
        System.out.println( number_cup + " cups of coffee you will need:");
        System.out.println( number_cup * 200 + " ml of water");
        System.out.println( number_cup * 50 + " ml of milk");
        System.out.println( number_cup * 15 + " g of coffee beans");

    }
}


