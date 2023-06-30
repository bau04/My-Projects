import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the 2-digit lottery draw");
        System.out.println("Choose a number from 0-9");

        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();

        Random random = new Random();

        int x1 = random.nextInt(0, 9);
        int x2 = random.nextInt(0, 9);

        if (n1 == x1 && n2 == x2){
            System.out.println("\nToday's lottery result is: ");
            System.out.println("Winning number: " + x1 + " , " + x2);
            System.out.println("Your pick: " + n1 + " , " + n2);
            System.out.println("Result: You Won!!!");
        }

        if (n1 <= -1 && n2 <= -1){
            System.out.println("Error: The number you entered is below the range");
        }

        if (n1 >= 10 && n2 >= 10){
            System.out.println("Error: The number you entered is above the range");
        }

        if (n1 != x1 && n2 != x2){
            System.out.println("\nToday's lottery result is: ");
            System.out.println("Winning number: " + x1 + " , " + x2);
            System.out.println("Your pick: " + n1 + " , " + n2);
            System.out.println("Result: You lost!");
        }

        else {
            System.out.println("\nToday's lottery result is: ");
            System.out.println("Winning number: " + x1 + " , " + x2);
            System.out.println("Your pick: " + n1 + " , " + n2);
            System.out.println("Result: You lost!");
        }

    }
}
