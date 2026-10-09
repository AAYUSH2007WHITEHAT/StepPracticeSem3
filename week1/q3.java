import java.util.Scanner;

public class q3 {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        }
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights must have the same number of entries.");
        }

        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] <= 0 || weights[i] <= 0) {
                throw new IllegalArgumentException("Height and weight must be positive.");
            }
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("Person %d | %.2f | %.2f | %.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int count = scanner.nextInt();
        if (count <= 0) {
            System.out.println("The number of people must be positive.");
            scanner.close();
            return;
        }

        double[] heights = new double[count];
        double[] weights = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter height (m) and weight (kg) for person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            weights[i] = scanner.nextDouble();
        }
        printWellnessReport(heights, weights);
        scanner.close();
    }
}
