package Java.week2.lab.Question1;

public class Question1 {

    // Superclass Shape
    static class Shape {
        // Method to calculate the area of the shape
        public double calculateArea() {
            return 0.0; // Default implementation returns 0
        }

        // Method to calculate the perimeter of the shape
        public double calculatePerimeter() {
            return 0.0; // Default implementation returns 0
        }
    }

    // Subclass Circle inheriting from Shape
    static class Circle extends Shape {
        private double radius; // Radius of the circle

        // Constructor to initialize the radius
        public Circle(double radius) {
            this.radius = radius;
        }

        // Override calculateArea() method for Circle
        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        // Override calculatePerimeter() method for Circle
        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    // Subclass Rectangle inheriting from Shape
    static class Rectangle extends Shape {
        private double width; // Width of the rectangle
        private double height; // Height of the rectangle

        // Constructor to initialize width and height
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        // Override calculateArea() method for Rectangle
        @Override
        public double calculateArea() {
            return width * height;
        }

        // Override calculatePerimeter() method for Rectangle
        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating instances of Circle and Rectangle
        Circle circle = new Circle(7);
        Rectangle rectangle = new Rectangle(6, 8);

        // Printing the area and perimeter of the circle
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

        // Printing the area and perimeter of the rectangle
        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());
    }
}
