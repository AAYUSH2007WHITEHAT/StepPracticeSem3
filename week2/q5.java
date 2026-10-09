import java.util.Scanner;

public class q5 {
    static String normalizeReference(String raw) {
        String reference = raw.trim();
        int bankCodeLength = Math.min(3, reference.length());
        return reference.substring(0, bankCodeLength).toUpperCase()
                + reference.substring(bankCodeLength);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        String date = reference.substring(3, 9);
        String sequence = reference.substring(9);
        StringBuilder display = new StringBuilder();
        display.append('[').append(reference.substring(0, 3)).append("] DATE: ")
                .append(date, 0, 2).append('/')
                .append(date, 2, 4).append('/')
                .append(date, 4, 6).append(" | SEQ: ")
                .append(sequence);
        return display.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String reference = normalizeReference(scanner.nextLine());
        System.out.println(validateAndFormat(reference));
        scanner.close();
    }
}
