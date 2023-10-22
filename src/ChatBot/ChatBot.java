package ChatBot;

import java.util.Scanner;

public class ChatBot {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        greet("ChatBot", "2023");

    }

    private static void greet(String bot_name, String birthYear) {
        System.out.println("Hello! My name is " + bot_name + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }

}
