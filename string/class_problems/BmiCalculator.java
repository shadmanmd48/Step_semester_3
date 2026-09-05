public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        int n = heights.length;

        System.out.println("========================== CORPORATE WELLNESS REPORT ==========================");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            double height = heights[i];
            double weight = weights[i];

            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.1f | %-10.2f | %-12s%n",
                    (i + 1), height, weight, bmi, status);
        }
        System.out.println("===============================================================================");
    }

    public static void main(String[] args) {
        double[] heights = {
            1.75, 1.60, 1.82, 1.68, 1.55,
            1.70, 1.78, 1.62, 1.85, 1.72
        };

        double[] weights = {
            70.0, 90.0, 68.5, 82.0, 43.0,
            65.0, 95.5, 52.0, 78.0, 88.0
        };

        for (int i = 0; i < 2; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %d - Height: %.2f m, Weight: %.0f kg BMI: %.2f | Status: %s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
        System.out.println();

        printWellnessReport(heights, weights);
    }
}
