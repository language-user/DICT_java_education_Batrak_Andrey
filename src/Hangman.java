import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        String[] words_arr = {"java", "kotlin", "python", "javascript"};
        Random randomIntGen = new Random();
        int randomInt = randomIntGen.nextInt(words_arr.length);

        String word = words_arr[randomInt];
        System.out.println("HANGMAN");
        System.out.println("Guess the word:");
        Scanner user_input = new Scanner(System.in);
        String answer = user_input.nextLine();
        if (answer.equals(word)){
            System.out.println("You survived!");
        }
        else {
            System.out.println("You lost!");
        }
    }
}