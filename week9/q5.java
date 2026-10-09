package week9;
import java.util.Scanner;

abstract class Library {
    String title;
    int late;

    Library(String title, int late) {
        this.title = title;
        this.late = late;
    }

    abstract double calculateFine();
}

class Book extends Library{

    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return late * 2;
    }
}

class DVD extends Library {

    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        double fine = late * 5;

        if (fine > 50) {
            fine = 50;
        }

        return fine;
    }
}

class Magazine extends Library {

    Magazine(String title, int late) {
        super(title, late);
    }

    double calculateFine() {
        return late * 1;
    }
}

public class q5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            Library item;

            if (type.equals("BOOK")) {
                item = new Book(title, daysLate);
            }
            else if (type.equals("DVD")) {
                item = new DVD(title, daysLate);
            }
            else {
                item = new Magazine(title, daysLate);
            }

            double fine = item.calculateFine();

            System.out.printf("%s: %.2f%n", title, fine);

            total = total + fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);

        sc.close();
    }
}