package Java.week1.lab;

public class Question3 {
    public static void main(String[] args) {
        // initialize age
        int age = 19;

        // Implement Conditional Statements
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }

        // Implement Switch Statement
        switch (age) {
            case 12:
                System.out.println("You are a child.");
                break;
            case 19:
                System.out.println("You are a teenager.");
                break;
            case 59:
                System.out.println("You are an adult.");
                break;
            default:
                if (age >= 60) {
                    System.out.println("You are a senior citizen.");
                } else {
                    System.out.println("Invalid age.");
                }
        }

        // Use Looping Structure
        System.out.println("Numbers from 1 to 10:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Use Nested Loop
        System.out.println("Triangle Pattern:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Use Loop Control Statements
        System.out.println("Countdown from 10 to 1:");
        int countdown = 10;
        while (countdown >= 1) {
            System.out.print(countdown + " ");
            countdown--;
        }
        System.out.println();
    }
}
