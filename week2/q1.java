import java.util.Scanner;

public class q1 {
    static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char character = Character.toLowerCase(text.charAt(i));
            if (character == ' ') {
                continue;
            }

            if (character == 'a' || character == 'e' || character == 'i'
                    || character == 'o' || character == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        countVowelsAndConsonants(scanner.nextLine());
        scanner.close();
    }
}
