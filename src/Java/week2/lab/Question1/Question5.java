package Java.week2.lab.Question1;

import java.util.InputMismatchException;
import java.util.Scanner;

// Main class for Question5
public class Question5 {

    // Area class to calculate the area of a rectangle
    static class Area {
        private double length; // Length of the rectangle
        private double breadth; // Breadth of the rectangle

        // Constructor to initialize length and breadth
        public Area(double length, double breadth) {
            this.length = length;
            this.breadth = breadth;
        }

        // Method to calculate and return the area of the rectangle
        public double returnArea() {
            return length * breadth;
        }
    }

    // Main method to handle user input and calculate area
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter length and breadth
        double length = 0;
        double breadth = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter length of the rectangle: ");
                length = scanner.nextDouble();

                System.out.print("Enter breadth of the rectangle: ");
                breadth = scanner.nextDouble();

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        // Create an object of the Area class
        Area rectangle = new Area(length, breadth);

        // Calculate and print the area of the rectangle
        System.out.println("Area of the rectangle: " + rectangle.returnArea());

        // Close the scanner
        scanner.close();
    }
}
