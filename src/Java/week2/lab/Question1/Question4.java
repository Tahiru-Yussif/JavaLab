package Java.week2.lab.Question1;

// Main class for Question4
public class Question4 {

    // Method to divide two numbers and handle exceptions
    public static void divide(int num1, int num2) {
        try {
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            int result = num1 / num2;
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Main method to test divide() method
    public static void main(String[] args) {
        // Test case: dividing 10 by 2
        divide(10, 2);

        // Test case: dividing 8 by 0 (should throw an exception)
        divide(8, 0);
    }
}
