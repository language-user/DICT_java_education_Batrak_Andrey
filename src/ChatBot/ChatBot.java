package ChatBot;

import java.util.Scanner;

public class ChatBot {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        greet("ChatBot", "2023");
        remindName();
        guessAge();
    }

    private static void greet(String bot_name, String birthYear) {
        System.out.println("Hello! My name is " + bot_name + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }
    private static void remindName() {
        String name = scanner.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }
    private static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Say me remainders of dividing your age by 3, 5 and 7.");
        int rem3 = scanner.nextInt();
        int rem5 = scanner.nextInt();
        int rem7 = scanner.nextInt();
        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }
}
