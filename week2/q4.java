import java.util.Scanner;

public class q4 {
    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            char digit = phone.charAt(i);
            if (digit < '0' || digit > '9') {
                return "Invalid phone number";
            }
        }

        StringBuilder maskedNumber = new StringBuilder("XXXXXX");
        maskedNumber.append(phone.substring(6));
        maskedNumber.insert(6, '-');
        return maskedNumber.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(maskPhoneNumber(scanner.nextLine()));
        scanner.close();
    }
}
