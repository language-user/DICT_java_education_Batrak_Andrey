import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        String[] words_arr = {"java", "kotlin", "python", "javascript"};
        Random randomIntGen = new Random();
        int randomInt = randomIntGen.nextInt(words_arr.length);
        String word = words_arr[randomInt];
        StringBuilder hiddenWord = new StringBuilder(word.substring(0, 2));
        for (int i = 0; i < word.length() - 2; i++){
            hiddenWord.append('-');
        }
        System.out.println("HANGMAN");
        System.out.printf("Guess the word %s:", hiddenWord);
        Scanner userInput = new Scanner(System.in);
        String answer = userInput.nextLine();
        if (answer.equals(word)){
            System.out.println("You survived!");
        }
        else {
            System.out.println("You lost!");
        }
    }
}