import java.util.*;

public class ValueChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value;

        while (true) {
            System.out.print("Enter a value between 3 and 6 (inclusive): ");
            value = sc.nextInt();

            if (value >= 3 && value <= 6) {
                System.out.println("Success! You entered a valid value: " + value);
                break;
            } else {
                System.out.println("Error: Invalid value. Please try again.");
            }
        }

        sc.close();
    }
}
