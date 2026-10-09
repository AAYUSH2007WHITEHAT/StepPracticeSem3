package week9;
import java.util.*;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double bill();
}

class Home extends Connection {
    Home(int units) {
        super(units);
    }

    double bill() {
        if (units <= 100)
            return units * 5.0;
        return 100 * 5.0 + (units - 100) * 7.0;
    }
}

class Shop extends Connection {
    Shop(int units) {
        super(units);
    }

    double bill() {
        return units * 8.0 + 100;
    }
}

class Factory extends Connection {
    Factory(int units) {
        super(units);
    }

    double bill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Connection[] connections = new Connection[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("HOME")) {
                connections[i] = new Home(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new Shop(units);
            } else {
                connections[i] = new Factory(units);
            }
        }

        for (Connection c : connections) {
            double b = c.bill();

            if (c instanceof Home)
                System.out.printf("HOME: %.2f%n", b);
            else if (c instanceof Shop)
                System.out.printf("SHOP: %.2f%n", b);
            else
                System.out.printf("FACTORY: %.2f%n", b);

            total += b;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
