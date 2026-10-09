import java.util.Scanner;

public class q2 {
    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        return text.charAt(left) == text.charAt(right)
                && isPalindromeRecursive(text, left + 1, right - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] characters = text.toCharArray();
        for (int left = 0, right = characters.length - 1; left < right; left++, right--) {
            char temporary = characters[left];
            characters[left] = characters[right];
            characters[right] = temporary;
        }
        return text.equals(new String(characters));
    }

    private static String describe(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println("Iterative: " + describe(isPalindromeIterative(text))
                + " | Recursive: " + describe(isPalindromeRecursive(text))
                + " | Array Reversal: " + describe(isPalindromeArrayReversal(text)));
        scanner.close();
    }
}
