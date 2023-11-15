import java.util.*;

public class Hangman {
    private static int lives=8;

    public static void main(String[] args) {
        String[] words_arr = {"java", "kotlin", "python", "javascript"};
        String word = generateWord(words_arr);
        StringBuilder hiddenWord = hiddenWordGen(word);
        StringBuilder chosenLetters = new StringBuilder();
        System.out.println("HANGMAN");

        while (true) {
            if (lives == 0) {
                System.out.println("You lost!");
                break;
            } else {
                if (hiddenWord.indexOf("-") != -1) {
                    System.out.printf("Guess the word %s:", hiddenWord);
                    Scanner userInput = new Scanner(System.in);
                    String answer = userInput.nextLine();
                    if (checker(answer, chosenLetters)) {
                        chosenLetters.append(answer);
                        if (!word.contains(answer)) {
                            System.out.println("The letter doesn't appear in word");
                            --lives;
                        } else {
                            updateHiddenWord(hiddenWord, answer, word);
                        }
                    }
                } else {
                    System.out.println(hiddenWord);
                    System.out.println("You win!");
                    break;
                }
            }
        }
    }

    public static String generateWord(String[] words_arr) {
        Random randomIntGen = new Random();
        int randomInt = randomIntGen.nextInt(words_arr.length);
        return words_arr[randomInt];
    }

    public static StringBuilder hiddenWordGen(String word) {
        StringBuilder hiddenWord = new StringBuilder();
        hiddenWord.append("-".repeat(word.length()));
        return hiddenWord;
    }

    public static void updateHiddenWord(StringBuilder hiddenWord, String answer, String word) {
        int index = 0;
        while (index >= 0) {
            index = word.indexOf(answer, index);
            if (index >= 0) {
                hiddenWord.setCharAt(index, answer.charAt(0));
                ++index;
            }
        }
    }
    public static Boolean checker(String answer, StringBuilder chosen_letters) {
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        if (answer.length() != 1) {
            System.out.println("You should enter one letter");
            return false;
        }
        else if (!letters.contains(answer)){
            System.out.println("You should enter only english lowercase letters!");
            return false;
        }
        else if (chosen_letters.indexOf(answer) != -1){
            System.out.println("No improvements");
            --lives;
            return false;
        }
        else {
            return true;
        }
    }
}