package Java.week2.lab.Question1;

//package Java.week2.lab;

// Main class for Question2
public class Question2 {

    // Enum defining colors
    enum Color {
        RED("#FF0000"),
        GREEN("#00FF00"),
        BLUE("#0000FF"),
        YELLOW("#FFFF00"),
        BLACK("#000000");

        private final String colorCode; // Color code associated with each enum value

        // Constructor for Color enum
        Color(String colorCode) {
            this.colorCode = colorCode;
        }

        // Method to get the color code of the enum value
        public String getColorCode() {
            return colorCode;
        }

        // Method to print color and its corresponding color code for each enum value
        public static void printColorAndCode() {
            for (Color color : Color.values()) {
                System.out.println(color + " - Color Code: " + color.getColorCode());
            }
        }
    }

    // Main method to test the Color enum
    public static void main(String[] args) {
        Color.printColorAndCode();
    }
}
