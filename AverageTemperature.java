import java.util.*;

public class AverageTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] temperatures = new double[7];
        double sum = 0;

        for (int i = 0; i < 7; i++) {
            System.out.print("Enter the temperature for day " + (i + 1) + ": ");
            temperatures[i] = sc.nextDouble();
            sum += temperatures[i];
        }

        double average = sum / 7;

     
        System.out.println("The average temperature for the week is: " + average + " degrees.");

        sc.close();
    }
}
