package week9;
import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTime extends Staff {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double pay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours, rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double pay() {
        if (hours <= 40)
            return hours * rate;
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() {
        return stipend;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Staff[] staff = new Staff[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("FULLTIME")) {
                staff[i] = new FullTime(name, sc.nextDouble());
            } else if (type.equals("HOURLY")) {
                staff[i] = new Hourly(name,
                    sc.nextDouble(), sc.nextDouble());
            } else {
                staff[i] = new Intern(name, sc.nextDouble());
            }
        }

        for (Staff s : staff) {
            double p = s.pay();
            System.out.printf("%s: %.2f%n", s.name, p);
            total += p;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}