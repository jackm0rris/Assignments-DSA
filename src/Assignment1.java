import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDays = 0;
        boolean isValid = false;

        System.out.print("Enter the number of days: ");

        while (!isValid) {
            try {
                numberOfDays = scanner.nextInt();
                if (numberOfDays > 0) {
                    isValid = true;
                } else {
                    System.out.println("Error: The number of days must be greater than zero.");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        double[] temperatures = new double[numberOfDays];

        for (int day = 0; day < numberOfDays; day++) {
            isValid = false;
            while (!isValid) {
                try {
                    System.out.print("Enter the temperature for day " + (day + 1) + ": ");
                    temperatures[day] = scanner.nextDouble();
                    isValid = true;
                } catch (Exception e) {
                    System.out.println("Error: Please enter a valid number.");
                    scanner.nextLine();
                }
            }
        }

        double totalTemperature = 0;
        for (double temp : temperatures) {
            totalTemperature += temp;
        }
        double averageTemperature = totalTemperature / numberOfDays;
        System.out.printf("\nThe average temperature is: %.2f\n", averageTemperature);

        int aboveAverageCount = 0;
        for (double temp : temperatures) {
            if (temp > averageTemperature) {
                aboveAverageCount++;
            }
        }
        System.out.println("Number of days above average: " + aboveAverageCount);

        scanner.close();
    }
}

