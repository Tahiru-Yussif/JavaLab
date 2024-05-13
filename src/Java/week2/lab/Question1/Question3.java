package Java.week2.lab.Question1;

// Main class for Question3
public class Question3 {

    // Abstract class Vehicle
    abstract static class Vehicle {
        // Attributes
        protected String make;
        protected String model;
        protected int year;

        // Constructor
        public Vehicle(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        // Abstract method to accelerate the vehicle
        abstract void accelerate();

        // Method to print vehicle details and acceleration behavior
        public void printDetails() {
            System.out.println("Vehicle: " + year + " " + make + " " + model);
            System.out.print("Acceleration behavior: ");
            accelerate();
            System.out.println();
        }
    }

    // Subclass Car inheriting from Vehicle
    static class Car extends Vehicle {
        // Constructor for Car
        public Car(String make, String model, int year) {
            super(make, model, year);
        }

        // Implementation of accelerate method for Car
        @Override
        void accelerate() {
            System.out.println("Accelerating like a car...");
        }
    }

    // Subclass Bike inheriting from Vehicle
    static class Bike extends Vehicle {
        // Constructor for Bike
        public Bike(String make, String model, int year) {
            super(make, model, year);
        }

        // Implementation of accelerate method for Bike
        @Override
        void accelerate() {
            System.out.println("Accelerating like a bike...");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating instances of Car and Bike
        Car car = new Car("Toyota", "BENZ", 2017);
        Bike bike = new Bike("Honda", "YAK", 2023);

        // Printing details of Car and Bike
        car.printDetails();
        bike.printDetails();
    }
}
