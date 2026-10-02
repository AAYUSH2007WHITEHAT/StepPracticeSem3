package week8;
import java.util.*;

interface Customer {
    double calculateBill(double amount);
}

class Student implements Customer {
    public double calculateBill(double amount) {
        return amount * 0.90;
    }
}

class Staff implements Customer {
    public double calculateBill(double amount) {
        return amount * 0.95;
    }
}

class Guest implements Customer {
    public double calculateBill(double amount) {
        return amount + 10;
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new Student();
            } else if (type.equals("STAFF")) {
                customer = new Staff();
            } else {
                customer = new Guest();
            }

            double bill = customer.calculateBill(amount);

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}