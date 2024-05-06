package Java.week1.lab;

public class Question2 {
    public static void main(String[] args) {
        // invoking the printNameDetails method
        printNameDetails("Yussif", "Tahiru");
    }
        public static void printNameDetails(String firstName, String lastName) {
            // Concatenate firstName and lastName to create fullName
            String fullName = firstName + " " + lastName;

            // Calculate the lengths of firstName and lastName
            int firstNameLength = firstName.length();
            int lastNameLength = lastName.length();

            // Print name details
            System.out.println("Hello, my name is " + fullName + ". There are " + firstNameLength + " letters in my first name and " + lastNameLength + " letters in my last name.");
        }
    }
